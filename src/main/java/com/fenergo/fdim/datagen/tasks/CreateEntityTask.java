package com.fenergo.fdim.datagen.tasks;

import java.lang.reflect.Method;
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
    	
    	AbstractBaseInputEntityType abiet = (AbstractBaseInputEntityType)config.getConstructors().get(entityType.getType()).invoke(factory, (Object[])null);
    	Long num = config.getCounters().get(entityType.getType());
    	
    	Map<String, String[]> template = config.getTemplates().get(entityType.getType());
    	Map<String, Method> setters = config.getSetters().get(entityType.getType());
    	Set<String> attributes = setters.keySet();
    	String value = null;
    
    	for(long i = 0L; i < num; i++){
    		
    		if (entityType.isRoot() && ((i % rootBatchSize) == 0)){
    			System.out.println("-->" + entityType.getType() + ": " + Math.round(i/((double)num)*10000.0)/100.0 + "% Processed...");
    		}
    		
    		for(String attr: attributes){
    			
    			if (attr.equalsIgnoreCase("referenceKey") || attr.equalsIgnoreCase("externalReferenceId")){
    				value = entityType.getCode() + template.get("referenceKey")[0] + i;
    			}else{
    				value = (String)template.get(attr)[0];
    			}
    			
    			setters.get(attr).invoke(abiet, value);
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
    	
		AbstractBaseInputEntityType abiet = (AbstractBaseInputEntityType)config.getConstructors().get(entityType.getType()).invoke(factory, (Object[])null);
    	Long num = config.getCounters().get(entityType.getType());
    	
    	Map<String, String[]> template = config.getTemplates().get(entityType.getType());
    	Map<String, Method> setters = config.getSetters().get(entityType.getType());
    	Set<String> attributes = setters.keySet();
    	String value = null;
    
    	for(long i = 0L; i < num; i++){
    		
    		for(String attr: attributes){
    			
    			if (attr.equalsIgnoreCase("referenceKey")){
    				value = parent.getReferenceKey();
    			}else if (attr.equalsIgnoreCase("externalReferenceId")){
    				value = parent.getReferenceKey() + entityType.getCode() + i;
    			}else{
    				value = (String)template.get(attr)[0];
    			}
    			
    			setters.get(attr).invoke(abiet, value);
    			
    		}
    		
	    	sm.write(abiet);
	    	
    	}

	}

}
