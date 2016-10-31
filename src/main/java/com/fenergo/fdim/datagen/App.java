package com.fenergo.fdim.datagen;

import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.config.EntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.AbstractBaseInputEntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.ObjectFactory;
import com.fenergo.fdim.datagen.jaxb.marshaller.StreamingMarshal;
import com.fenergo.fdim.datagen.tasks.CreateEntityTask;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main(String[] args) throws Exception
    {
    	
    	ObjectFactory factory = new ObjectFactory();
    	Config config = new Config(args);
    	StreamingMarshal<AbstractBaseInputEntityType> sm = new StreamingMarshal<>(AbstractBaseInputEntityType.class);
    	
    	config.loadTemplates();
    	
    	sm.open(config.getFilename());
    	
    	CreateEntityTask les = new CreateEntityTask(config, sm, factory, EntityType.LEGAL_ENTITY, null, 
    			new EntityType[]{EntityType.ADDRESS, EntityType.CONTACT, EntityType.ASSOCIATION, EntityType.RELATIONSHIP});
    	les.run();
    	CreateEntityTask users = new CreateEntityTask(config, sm, factory, EntityType.USER, null, null);
    	users.run();
    	CreateEntityTask lookups = new CreateEntityTask(config, sm, factory, EntityType.LOOKUP, null, null);
    	lookups.run();
    	
    	sm.close();
    	
    }
    
}
