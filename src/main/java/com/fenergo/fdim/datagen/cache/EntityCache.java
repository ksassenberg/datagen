package com.fenergo.fdim.datagen.cache;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import com.fenergo.fdim.datagen.config.AppEntityType;
import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.jaxb.config.AbstractEntityType;
import com.fenergo.fdim.datagen.jaxb.config.ChildEntityType;
import com.fenergo.fdim.datagen.jaxb.config.ConfigurationType;
import com.fenergo.fdim.datagen.jaxb.config.ListOfChildEntityType;
import com.fenergo.fdim.datagen.jaxb.config.ListOfRootEntityType;
import com.fenergo.fdim.datagen.jaxb.config.RootEntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.AbstractBaseInputEntityType;
import com.fenergo.fdim.datagen.jaxb.marshaller.StringMarshal;

public class EntityCache {

	private Config config = null;
	private Map<String, List<String>> cache = null;
	
	public static EntityCache create(Config config){
		return new EntityCache(config);
	}
	
	private EntityCache(Config config){
		this.config = config;
		this.cache = new HashMap<String, List<String>>();
	}
	
	public void initialize() throws Exception{
    	
		ConfigurationType ct = config.getConfigType();
		ListOfRootEntityType loret = ct.getRootEntities();
    	List<RootEntityType> lroe = loret.getRootEntity();
    	for (RootEntityType ret: lroe){
    		this.cache.put(AppEntityType.fromValue(ret.getType().value()).getType(), generate(ret));
			ListOfChildEntityType locet = ret.getChildEntities();
    		if (locet!=null){
		    	List<ChildEntityType> lcet = locet.getChildEntity();
		    	for (ChildEntityType cet: lcet){
		    		if (!this.cache.containsKey(AppEntityType.fromValue(cet.getType().value()).getType())){
		    			this.cache.put(AppEntityType.fromValue(cet.getType().value()).getType(), generate(cet));
		    		}
		    	}
    		}
    	}
	}

	private List<String> generate(AbstractEntityType aet) throws Exception{

		
		AppEntityType entityType = AppEntityType.fromValue(aet.getType().value());
    	AbstractBaseInputEntityType abiet = (AbstractBaseInputEntityType)config.getConstructors().get(entityType.getType()).invoke(config.getFactory(), (Object[])null);
    	StringMarshal<AbstractBaseInputEntityType> sm = new StringMarshal<>(AbstractBaseInputEntityType.class);
    	Long num = aet.getCacheSize();
    	
    	Map<String, String[]> template = config.getTemplates().get(entityType.getType());
    	Map<String, Method> setters = config.getSetters().get(entityType.getType());
    	Set<String> attributes = setters.keySet();
    	
    	ArrayList<String> entities = new ArrayList<>();
    
    	for(long i = 0L; i < num; i++){
    		
    		
    		for(String attr: attributes){
    			setters.get(attr).invoke(abiet, getRandomValue(template.get(attr)));
    		}
    		
	    	sm.write(abiet);
	    	entities.add(sm.getValue().replaceAll(Config.EXCESS_NAMESPACE, ""));
	    	sm.clear();
    	}
    	
    	sm.close();

		return entities;
	}
	
	
	
	public List<String> getEntityCache(AppEntityType et){
		return this.cache.get(et.getType());
	}
	
	public Map<String, List<String>> getCache(){
		return this.cache;
	}
	
	private String getRandomValue(String[] values){
		int size = values.length;
		return values[ThreadLocalRandom.current().nextInt(0, size)];
	}

}
