package com.fenergo.fdim.datagen.tasks;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.config.EntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.AbstractBaseInputEntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.ObjectFactory;
import com.fenergo.fdim.datagen.jaxb.marshaller.StreamingMarshal;

public class CreateEntityTask {

	private static long rootBatchSize = 100;
	
	private Config config = null;
	private StreamingMarshal<AbstractBaseInputEntityType> sm = null; 
	private ObjectFactory factory = null;
	private EntityType entityType = null;
	private AbstractBaseInputEntityType parent = null;
	private EntityType[] children = null;
	
	public static CreateEntityTask create(Config config, EntityType et, AbstractBaseInputEntityType parent, EntityType[] children){
		return new CreateEntityTask(config, et, parent, children);
	}
	
	private CreateEntityTask(Config config, EntityType et, AbstractBaseInputEntityType parent, EntityType[] children){
		this.config = config;
		this.sm = config.getSm(); 
		this.factory = config.getFactory();
		this.entityType = et;
		this.parent = parent;
		this.children = children;
	}
	
	public void start() throws Exception{
    	
    		if (entityType.isRoot()){
    			createRootEntites();
    		}else{
    			createChildEntites();
    		}
    		
	}
	
	public void createRootEntites() throws Exception{
    	
    	AbstractBaseInputEntityType abiet = (AbstractBaseInputEntityType)factory.getClass().getMethod("create"+entityType.getType(), (Class<?>[])null).invoke(factory, (Object[])null);
    	Long num = (Long)config.getClass().getMethod("getNum"+entityType.getType(), (Class<?>[])null).invoke(config, (Object[])null);
    	
    	Class<?> entity_class = Class.forName((String)entityType.getImplemetation());
    	
    	Map<String, String[]> template = config.getTemplates().get(entityType.getType());
    	Map<String, String> setters = config.getSetters().get(entityType.getType());
    	Set<String> attributes = config.getSetters().get(entityType.getType()).keySet();
    
    	for(long i = 0L; i < num; i++){
    		
    		if (entityType.isRoot() && ((i % rootBatchSize) == 0)){
    			System.out.println("-->" + entityType.getType() + ": " + Math.round(i/((double)num)*10000.0)/100.0 + "% Processed...");
    		}
    		
    		for(String attr: attributes){
    			
    			if (attr.equalsIgnoreCase("referenceKey")){
    				abiet.setReferenceKey(entityType.getCode() + template.get("referenceKey")[0] + i);
    			}else if (attr.equalsIgnoreCase("externalReferenceId")){
    				entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, entityType.getCode() + template.get("referenceKey")[0] + i);
    			}else{
    				entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, (String)template.get(attr)[0]);
    			}
    		}
    		
	    	sm.write(abiet);
	    	
	    	if (children!=null && children.length > 0){
		    	for(EntityType child: Arrays.asList(children)){
		    		CreateEntityTask.create(config, child, abiet, null).start();
		    	}
	    	}
	    	
    	}

	}
	
	public void createChildEntites() throws Exception{
    	
    	AbstractBaseInputEntityType abiet = (AbstractBaseInputEntityType)factory.getClass().getMethod("create"+entityType.getType(), (Class<?>[])null).invoke(factory, (Object[])null);
    	Long num = (Long)config.getClass().getMethod("getNum"+entityType.getType(), (Class<?>[])null).invoke(config, (Object[])null);
    	
    	Class<?> entity_class = Class.forName((String)entityType.getImplemetation());
    	
    	Map<String, String[]> template = config.getTemplates().get(entityType.getType());
    	Map<String, String> setters = config.getSetters().get(entityType.getType());
    	Set<String> attributes = config.getSetters().get(entityType.getType()).keySet();
    
    	for(long i = 0L; i < num; i++){
    		
    		for(String attr: attributes){
    			
    			if (attr.equalsIgnoreCase("referenceKey")){
    					abiet.setReferenceKey(parent.getReferenceKey());
    			}else if (attr.equalsIgnoreCase("externalReferenceId")){
    				entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, parent.getReferenceKey() + entityType.getCode() + i);
    			}else{
    				entity_class.getMethod(setters.get(attr), String.class).invoke(abiet, (String)template.get(attr)[0]);
    			}
    		}
    		
	    	sm.write(abiet);
	    	
    	}

	}

}
