package com.fenergo.fdim.datagen.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.fenergo.fdim.datagen.cache.EntityCache;
import com.fenergo.fdim.datagen.config.AppEntityType;
import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.jaxb.dminput.AbstractBaseInputEntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.ObjectFactory;

public class CreateEntityTask {

	private static long rootBatchSize = 100;
	
	private Config config = null;
	private ObjectFactory factory = null;
	private AppEntityType entityType = null;
	private AbstractBaseInputEntityType parent = null;
	private AppEntityType[] children = null;
	private EntityCache ec = null;
	
	private String REGEX1 = "ReferenceKey=\"[^\"]+\"";
	private String REGEX2 = "ExternalReferenceId=\"[^\"]+\"";
	
	public static CreateEntityTask create(Config config, AppEntityType et, AbstractBaseInputEntityType parent, AppEntityType[] children, 
	    	EntityCache ec){
		return new CreateEntityTask(config, et, parent, children, ec);
	}
	
	private CreateEntityTask(Config config, AppEntityType et, AbstractBaseInputEntityType parent, AppEntityType[] children, EntityCache ec){
		this.config = config;
		this.factory = config.getFactory();
		this.entityType = et;
		this.parent = parent;
		this.children = children;
		this.ec = ec;
	}
	
	public List<String> start() throws Exception{
    	
    		if (entityType.isRoot()){
    			return createRootEntites();
    		}else{
    			return createChildEntites();
    		}
    		
	}
	
	
	public List<String> createRootEntites() throws Exception{
    	
    	AbstractBaseInputEntityType abiet = (AbstractBaseInputEntityType)config.getConstructors().get(entityType.getType()).invoke(factory, (Object[])null);
    	Long num = config.getCounters().get(entityType.getType());
    	
    	Map<String, String[]> template = config.getTemplates().get(entityType.getType());
    	String value = null;
    	String entity = null;
    	
    	List<String> localCache = ec.getEntityCache(entityType);
    	
    	List<String> entities = new ArrayList<>();
    	
    	for(long i = 0L; i < num; i++){
    		
    		if (entityType.isRoot() && ((i % rootBatchSize) == 0)){
    			System.out.println("-->" + entityType.getType() + ": " + Math.round(i/((double)num)*10000.0)/100.0 + "% Processed...");
    		}
    		
    		entity = getRandomCacheValue(localCache) + ""; // local copy
    		value = entityType.getCode() + template.get("referenceKey")[0] + i;
    		entity = entity.replaceAll(REGEX1, "ReferenceKey=\"" + value + "\"");
    		entity = entity.replaceAll(REGEX2, "ExternalReferenceId=\"" + value + "\"");
    		entities.add(entity);
    		
    		abiet.setReferenceKey(value);
	    		    	
	    	if (children!=null && children.length > 0){
		    	for(AppEntityType child: Arrays.asList(children)){
		    		entities.addAll(CreateEntityTask.create(config, child, abiet, null, ec).start());
		    	}
	    	}
	    	
    	}

    	return entities;
    	
	}
	
	public List<String> createChildEntites() throws Exception{
    	
		Long num = config.getCounters().get(entityType.getType());
    	String value = null;
    	String entity = null;
    	
    	List<String> localCache = ec.getEntityCache(entityType);
    	
    	List<String> entities = new ArrayList<>();
    
    	for(long i = 0L; i < num; i++){
    		
    		entity = getRandomCacheValue(localCache) + ""; // local copy
    		value = parent.getReferenceKey();
    		entity = entity.replaceAll(REGEX1, "ReferenceKey=\"" + value + "\"");
    		value = parent.getReferenceKey() + entityType.getCode() + i;
    		entity = entity.replaceAll(REGEX2, "ExternalReferenceId=\"" + value + "\"");
    		entities.add(entity);
	    	
    	}
    	
    	return entities;

	}
	
	private String getRandomCacheValue(List<String> values){
		int size = values.size();
		return values.get(ThreadLocalRandom.current().nextInt(0, size));
	}

}
