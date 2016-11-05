package com.fenergo.fdim.datagen;

import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.config.EntityType;
import com.fenergo.fdim.datagen.tasks.CreateEntityTask;
import com.fenergo.fdim.datagen.utils.FileUtils;


public class App 
{
	
	
    public static void main(String[] args) throws Exception
    {
    	Config config = new Config(args);
    	
    	config.loadTemplates();
    	config.start();
    	
    	CreateEntityTask.create(config, EntityType.LEGAL_ENTITY, null, 
    			new EntityType[]{EntityType.ADDRESS, EntityType.CONTACT, EntityType.ASSOCIATION, EntityType.RELATIONSHIP}).start();
    	CreateEntityTask.create(config, EntityType.USER, null, null).start();
    	CreateEntityTask.create(config, EntityType.LOOKUP, null, null).start();
    	
    	config.finish();
    	
    	FileUtils.removeExcessDeclarations(config);
    	
    }
    
}
