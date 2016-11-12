package com.fenergo.fdim.datagen.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.reflections.Reflections;

import com.fenergo.fdim.datagen.jaxb.config.ChildEntityType;
import com.fenergo.fdim.datagen.jaxb.config.ConfigurationType;
import com.fenergo.fdim.datagen.jaxb.config.ListOfChildEntityType;
import com.fenergo.fdim.datagen.jaxb.config.ListOfRootEntityType;
import com.fenergo.fdim.datagen.jaxb.config.RootEntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.ObjectFactory;
import com.fenergo.fdim.datagen.jaxb.marshaller.ConfigurationManager;

public class Config {
	public static final String XSI_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema-instance";
    public static final String XSI_NAMESPACE_PREFIX = "xsi";
    public static final String TEMPLATES_PACKAGE = "com.fenergo.fdim.datagen.templates";
    public static final String CONFIG_ENTITY_PACKAGE = "com.fenergo.fdim.datagen.jaxb.config";
    public static final String WRAPPER_ELEMENT = "fenergoInput";
    public final static QName _ENTITY_QNAME = new QName(XMLConstants.NULL_NS_URI, "entity");
    
    public static final int BUFFER_SIZE = 8192;
    
    public final static String EXCESS_NAMESPACE = "xmlns:" + Config.XSI_NAMESPACE_PREFIX + "=\\\"" + Config.XSI_NAMESPACE_URI.replaceAll("/", "\\\\/") + "\\\"";
    
    private final static String CONFIG_FILE_ARG_NAME = "configfile";
    private final static String ARG_SEPARATOR = "-"; 
    
    private Map<String, Map<String, String[]>> templates = new HashMap<>();
    private Map<String, Map<String, Method>> setters = new HashMap<>();
    private Map<String, Method> constructors = new HashMap<>();
    private Map<String, Long> counters = new HashMap<>();
    
    private ObjectFactory factory = null;
	
    private ConfigurationType config;
    private String filename;
    private Long batchSize;
    private Long numLegalEntity;
    private Long numUser;
    private Long numLookup;
    private Long numAddress;
    private Long numContact;
    private Long numAssociation;
    private Long numRelationship;
    
    public Config() throws JAXBException, IOException{
    	factory = new ObjectFactory();
    }
    
    public Config(String[] args) throws JAXBException, IOException{
    	this();
    	loadArguments(args);
    }
    
    public void loadArguments(String[] args) throws JAXBException, IOException{
    	if (args!=null && args.length > 0){
    		FileInputStream stream = new FileInputStream(new File(getconfigFilenameFromArgs(args)));
	    	readConfigFile(stream);
    	}else{
    		readConfigFile();
    	}
    	
    }
    
    private String getconfigFilenameFromArgs(String[] args){
    	
    	String configFilename = null;
    	String argstr = String.join(" ", Arrays.asList(args));
    	List<String> nameValuePairs = Arrays.asList(argstr.split(ARG_SEPARATOR));
    	
    	for(String nameValuePair: nameValuePairs){
    		if (nameValuePair.toLowerCase().contains(CONFIG_FILE_ARG_NAME.toLowerCase())){
    			int start = nameValuePair.indexOf("=");
    			configFilename = nameValuePair.substring(start + 1).trim().replace("\"", "");
    			break;
    		}
    	}

    	return configFilename;
    }
    
    private void readConfigFile() throws JAXBException, IOException{
    	InputStream stream = this.getClass().getClassLoader().getResourceAsStream("com/fenergo/fdim/datagen/config/xml/configuration.xml");
    	readConfigFile(stream);
    }

    private void readConfigFile(InputStream stream) throws JAXBException, IOException{
    	ConfigurationManager manager = new ConfigurationManager("com.fenergo.fdim.datagen.jaxb.config");
    	
    	config = manager.read(stream);
    	
    	this.filename = config.getOutputFile();
    	this.batchSize = config.getBatchSize();
    	
    	ListOfRootEntityType loret = config.getRootEntities();
    	List<RootEntityType> lroe = loret.getRootEntity();
    	for (RootEntityType ret: lroe){
    		if (com.fenergo.fdim.datagen.config.AppEntityType.LEGAL_ENTITY.getType().equals(ret.getType().value())){
    			
    			this.numLegalEntity = ret.getOccurences();
    			
    			ListOfChildEntityType locet = ret.getChildEntities();
    	    	List<ChildEntityType> lcet = locet.getChildEntity();
    	    	for (ChildEntityType cet: lcet){
    	    		if (com.fenergo.fdim.datagen.config.AppEntityType.CONTACT.getType().equals(cet.getType().value())){
    	    			this.numContact = cet.getOccurences();
    	    		}else if (com.fenergo.fdim.datagen.config.AppEntityType.ADDRESS.getType().equals(cet.getType().value())){
    	    			this.numAddress = cet.getOccurences();
    	    		}else if (com.fenergo.fdim.datagen.config.AppEntityType.ASSOCIATION.getType().equals(cet.getType().value())){
    	    			this.numAssociation = cet.getOccurences();
    	    		}else if (com.fenergo.fdim.datagen.config.AppEntityType.RELATIONSHIP.getType().equals(cet.getType().value())){
    	    			this.numRelationship = cet.getOccurences();
    	    		}
    	    	}
    			
    		}else if (com.fenergo.fdim.datagen.config.AppEntityType.LOOKUP.getType().equals(ret.getType().value())){
    			this.numLookup = ret.getOccurences();
    		}else if (com.fenergo.fdim.datagen.config.AppEntityType.USER.getType().equals(ret.getType().value())){
    			this.numUser = ret.getOccurences();
    		}
    	}
    }
    
    public void loadTemplates() throws Exception{
    	
    	Reflections reflections = new Reflections(Config.TEMPLATES_PACKAGE);
    	Set<Class<? extends EntityTemplate>> template_classes = reflections.getSubTypesOf(EntityTemplate.class);
    	
    	AppEntityType entityType = null;
    	Class<?> entity_class = null;
    	String entityTypeValue = null;
    	Set<String> attributes = null;
    	Map<String, Method> template_setters = null;
    	Map<String, String[]> template = null;
    	
    	for(Class<?> template_class: template_classes){
    		entityType = (AppEntityType)(template_class.getMethod("getEntityType", (Class<?>[])null).invoke(null, (Object[])null));
    		entityTypeValue = entityType.getType();
    		entity_class = Class.forName((String)entityType.getImplemetation());
    		template = loadTemplate(template_class);
    		this.templates.put(entityTypeValue, template);
    		
    		template_setters = new HashMap<>();
    		attributes = template.keySet();
    		for(String attr: attributes){
    			template_setters.put(attr, entity_class.getMethod("set" + attr.substring(0, 1).toUpperCase() + attr.substring(1), String.class));
    		}
    		setters.put(entityTypeValue, template_setters);
    		constructors.put(entityTypeValue, factory.getClass().getMethod("create"+entityType.getType(), (Class<?>[])null));
    		counters.put(entityTypeValue, (Long)Config.class.getMethod("getNum"+entityType.getType(), (Class<?>[])null).invoke(this, (Object[])null));  		
    	}
    	
    }
    
    private static Map<String, String[]> loadTemplate(Class<?> c){
    	
    	Map<String, String[]> data = new HashMap<>();
    	List<Field> fields = Arrays.asList(c.getDeclaredFields());
    	
    	try{
	    	for(Field field : fields){
    	        data.put(field.getName(), (String[])field.get(null));
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	
    	return data;
    }

	public Map<String, Map<String, String[]>> getTemplates() {
		return templates;
	}

	public Map<String, Map<String, Method>> getSetters() {
		return setters;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(Long batchSize) {
		this.batchSize = batchSize;
	}

	public Long getNumLegalEntity() {
		return numLegalEntity;
	}

	public void setNumLegalEntity(Long numLegalEntity) {
		this.numLegalEntity = numLegalEntity;
	}
	
	public void setNumLegalEntity(String numLegalEntity) {
		this.numLegalEntity = Long.parseLong(numLegalEntity);
	}
	
	public Long getNumUser() {
		return numUser;
	}

	public void setNumUser(Long numUser) {
		this.numUser = numUser;
	}
	
	public void setNumUser(String numUser) {
		this.numUser = Long.parseLong(numUser);
	}
	
	public Long getNumLookup() {
		return numLookup;
	}

	public void setNumLookup(Long numLookup) {
		this.numLookup = numLookup;
	}
	
	public void setNumLookup(String numLookup) {
		this.numLookup = Long.parseLong(numLookup);
	}
	
	public Long getNumAddress() {
		return numAddress;
	}

	public void setNumAddress(Long numAddress) {
		this.numAddress = numAddress;
	}
	
	public void setNumAddress(String numAddress) {
		this.numAddress = Long.parseLong(numAddress);
	}
	
	public Long getNumContact() {
		return numContact;
	}

	public void setNumContact(Long numContact) {
		this.numContact = numContact;
	}
	
	public void setNumContact(String numContact) {
		this.numContact = Long.parseLong(numContact);
	}
	
	public Long getNumAssociation() {
		return numAssociation;
	}

	public void setNumAssociation(Long numAssociation) {
		this.numAssociation = numAssociation;
	}
	
	public void setNumAssociation(String numAssociation) {
		this.numAssociation = Long.parseLong(numAssociation);
	}
	
	public Long getNumRelationship() {
		return numRelationship;
	}

	public void setNumRelationship(Long numRelationship) {
		this.numRelationship = numRelationship;
	}
	
	public void setNumRelationship(String numRelationship) {
		this.numRelationship = Long.parseLong(numRelationship);
	}

	public ObjectFactory getFactory() {
		return factory;
	}

	public Map<String, Method> getConstructors() {
		return constructors;
	}

	public Map<String, Long> getCounters() {
		return counters;
	}
	
	public ConfigurationType getConfigType(){
		return config;
	}
    
}
