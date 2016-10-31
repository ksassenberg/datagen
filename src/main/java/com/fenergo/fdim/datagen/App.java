package com.fenergo.fdim.datagen;

import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.config.EntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.ObjectFactory;
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
    	config.loadTemplates();
    	
    	FileWriter writer = new FileWriter(new File(config.getFilename()));
    	
    	ExecutorService executor = Executors.newFixedThreadPool(Config.ROOT_THREAD_POOL_SIZE);
    	
    	CreateEntityTask les = new CreateEntityTask(config, factory, EntityType.LEGAL_ENTITY, null, 
    			new EntityType[]{EntityType.ADDRESS, EntityType.CONTACT, EntityType.ASSOCIATION, EntityType.RELATIONSHIP});
    	executor.execute(les);
    	CreateEntityTask users = new CreateEntityTask(config, factory, EntityType.USER, null, null);
    	executor.execute(users);
    	CreateEntityTask lookups = new CreateEntityTask(config, factory, EntityType.LOOKUP, null, null);
    	executor.execute(lookups);
    	
        executor.shutdown();
        while (!executor.isTerminated()) {
        	Thread.sleep(1000);
        }
        
        writer.write(les.getResults());
        writer.flush();
        writer.write(users.getResults());
        writer.flush();
        writer.write(lookups.getResults());
        writer.flush();
        
        writer.close();
        
        System.out.println("Finished all threads");
    	
    }
    
}
