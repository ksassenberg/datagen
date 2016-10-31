package com.fenergo.fdim.datagen.tasks;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBException;

import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.config.EntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.AbstractBaseInputEntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.ObjectFactory;
import com.fenergo.fdim.datagen.jaxb.marshaller.XMLStringMarshal;

public class CreateEntityTask implements Runnable {

	private static long rootBatchSize = 100;
	
	private Config config = null;
	private XMLStringMarshal<AbstractBaseInputEntityType> xsm = null; 
	private ObjectFactory factory = null;
	private EntityType entityType = null;
	private AbstractBaseInputEntityType parent = null;
	private EntityType[] children = null;
	private StringBuilder results = null;
	
	public CreateEntityTask(Config config, ObjectFactory factory, EntityType et, AbstractBaseInputEntityType parent, EntityType[] children) throws JAXBException{
		this.config = config;
		this.xsm = new XMLStringMarshal<>(AbstractBaseInputEntityType.class); 
		this.factory = factory;
		this.entityType = et;
		this.parent = parent;
		this.children = children;
		this.results = new StringBuilder();
	}
	
	
	@Override
	public void run() {
		try{
			createRootEntities();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void createRootEntities() throws Exception{
    	
    	AbstractBaseInputEntityType abiet = (AbstractBaseInputEntityType)factory.getClass().getMethod("create"+entityType.getType(), (Class<?>[])null).invoke(factory, (Object[])null);
    	Long num = (Long)config.getClass().getMethod("getNum"+entityType.getType(), (Class<?>[])null).invoke(config, (Object[])null);
    	long num_blocks = (num % config.getBatchSize()) == 0?num/config.getBatchSize():(num/config.getBatchSize())+1;
    	
    	Class<?> entity_class = Class.forName((String)entityType.getImplemetation());
    	
    	Map<String, String[]> template = config.getTemplates().get(entityType.getType());
    	Map<String, String> setters = config.getSetters().get(entityType.getType());
    	Set<String> attributes = config.getSetters().get(entityType.getType()).keySet();
    
    	for(long i = 0L; i < num; i++){
    		
    		if ((i % rootBatchSize) == 0){
    			System.out.println("-->" + entityType.getType() + ": " + Math.round(i/((double)num)*10000.0)/100.0 + "% Processed...");
    		}
    		
    		for(String attr: attributes){
    			
    			if (attr.equalsIgnoreCase("referenceKey")){
    				if (parent==null){
    					abiet.setReferenceKey(entityType.getCode() + template.get("referenceKey")[0] + i);
    				}else{
    					abiet.setReferenceKey(parent.getReferenceKey());
    				}
    			}else if (attr.equalsIgnoreCase("externalReferenceId")){
    				if (parent==null){
    					entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, entityType.getCode() + template.get("referenceKey")[0] + i);
    				}else{
    					entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, parent.getReferenceKey() + entityType.getCode() + i);
    				}
    			}else{
    				entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, (String)template.get(attr)[0]);
    			}
    		}
    		
    		results.append(xsm.write(abiet));
	    	
	    	if (children!=null && children.length > 0){
		    	for(EntityType child: Arrays.asList(children)){
		    		CreateEntityTask cet = new CreateEntityTask(config, factory, child, abiet, null);
		    		cet.createChildEntities();
		    		results.append(cet.getResults());
		    	}
	    	}
	    	
    	}

	}
	
	private void createChildEntities() throws Exception{
    	
    	AbstractBaseInputEntityType abiet = (AbstractBaseInputEntityType)factory.getClass().getMethod("create"+entityType.getType(), (Class<?>[])null).invoke(factory, (Object[])null);
    	Long num = (Long)config.getClass().getMethod("getNum"+entityType.getType(), (Class<?>[])null).invoke(config, (Object[])null);
    	
    	Class<?> entity_class = Class.forName((String)entityType.getImplemetation());
    	
    	Map<String, String[]> template = config.getTemplates().get(entityType.getType());
    	Map<String, String> setters = config.getSetters().get(entityType.getType());
    	Set<String> attributes = config.getSetters().get(entityType.getType()).keySet();
    	
    	for(long i = 0L; i < num; i++){
    		
    		for(String attr: attributes){
    			
    			if (attr.equalsIgnoreCase("referenceKey")){
    				if (parent==null){
    					abiet.setReferenceKey(entityType.getCode() + template.get("referenceKey")[0] + i);
    				}else{
    					abiet.setReferenceKey(parent.getReferenceKey());
    				}
    			}else if (attr.equalsIgnoreCase("externalReferenceId")){
    				if (parent==null){
    					entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, entityType.getCode() + template.get("referenceKey")[0] + i);
    				}else{
    					entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, parent.getReferenceKey() + entityType.getCode() + i);
    				}
    			}else{
    				entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, (String)template.get(attr)[0]);
    			}
    		}
    		
	    	results.append(xsm.write(abiet));
	    	
    	}

	}
	
	public String getResults(){
		return results.toString();
	}

}
