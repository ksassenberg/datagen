package com.fenergo.fdim.datagen;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fenergo.fdim.datagen.cache.EntityCache;
import com.fenergo.fdim.datagen.config.AppEntityType;
import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.tasks.CreateEntityTask;
public class App 
{
	
    public static void main(String[] args) throws Exception
    {
    	Config config = new Config(args);
    	
    	config.loadTemplates();
    	
    	
    	EntityCache ec = EntityCache.create(config);
    	ec.initialize();
    
    	List<String> records = new ArrayList<>();
        try{
        	
            records.add("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            records.add("<" + Config.WRAPPER_ELEMENT + " " + "xmlns:" + Config.XSI_NAMESPACE_PREFIX + "=\"" + Config.XSI_NAMESPACE_URI + "\">");
            
            records.addAll(CreateEntityTask.create(config, AppEntityType.LEGAL_ENTITY, null, 
        			new AppEntityType[]{AppEntityType.ADDRESS, AppEntityType.CONTACT, AppEntityType.ASSOCIATION, AppEntityType.RELATIONSHIP}, ec).start());
            
            records.addAll(CreateEntityTask.create(config, AppEntityType.USER, null, null, ec).start());
            
            records.addAll(CreateEntityTask.create(config, AppEntityType.LOOKUP, null, null, ec).start());
            
            records.add("</" + Config.WRAPPER_ELEMENT + "\">");
            
            Files.write(Paths.get(config.getFilename()), records);
            
        }finally{}
    	
    }
    
}
