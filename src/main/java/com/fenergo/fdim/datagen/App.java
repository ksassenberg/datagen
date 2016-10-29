package com.fenergo.fdim.datagen;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.EntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.AbstractBaseInputEntityType;
import com.fenergo.fdim.datagen.jaxb.dminput.ObjectFactory;
import com.fenergo.fdim.datagen.jaxb.marshaller.StreamingMarshal;

/**
 * Hello world!
 *
 */
public class App 
{
	private static long rootBatchSize = 100;
	
    public static void main(String[] args) throws Exception
    {
    	
    	ObjectFactory factory = new ObjectFactory();
    	Config config = new Config();
    	StreamingMarshal<AbstractBaseInputEntityType> sm = new StreamingMarshal<>(AbstractBaseInputEntityType.class);
    	
    	config.loadArguments(args);
    	loadTemplates(config);
    	
    	sm.open(config.getFilename());
    	
    	createEntities(config, sm, factory, EntityType.LEGAL_ENTITY, null, 
    			new EntityType[]{EntityType.ADDRESS, EntityType.CONTACT, EntityType.ASSOCIATION, EntityType.RELATIONSHIP});
    	createEntities(config, sm, factory, EntityType.USER, null, null);
    	createEntities(config, sm, factory, EntityType.LOOKUP, null, null);
    	
    	sm.close();
    	
    }
    
    private static void createEntities(Config config, StreamingMarshal<AbstractBaseInputEntityType> sm, ObjectFactory factory, EntityType et, AbstractBaseInputEntityType parent, EntityType[] children) throws Exception{
    	
    	AbstractBaseInputEntityType abiet = (AbstractBaseInputEntityType)factory.getClass().getMethod("create"+et.getType(), (Class<?>[])null).invoke(factory, (Object[])null);
    	Long num = (Long)config.getClass().getMethod("getNum"+et.getType()+"s", (Class<?>[])null).invoke(config, (Object[])null);
    	
    	Class<?> cl = Class.forName((String)et.getImplemetation());
    	
    	Map<String, String[]> template = config.getTemplates().get(et.getType());
    	Set<String> attributes = template.keySet();
    	Map<String, String> setters = new HashMap<>();
    	
    	for(String attr: attributes){
    		setters.put(attr, "set" + attr.substring(0, 1).toUpperCase() + attr.substring(1));
		}
    
    	for(long i = 0L; i < num; i++){
    		
    		if (et.isRoot() && ((i % rootBatchSize) == 0)){
    			System.out.println("-->" + et.getType() + ": " + Math.round(i/((double)num)*10000.0)/100.0 + "% Processed...");
    		}
    		
    		for(String attr: attributes){
    			
    			if (attr.equalsIgnoreCase("referenceKey")){
    				if (parent==null){
    					abiet.setReferenceKey(et.getCode() + template.get("referenceKey")[0] + i);
    				}else{
    					abiet.setReferenceKey(parent.getReferenceKey());
    				}
    			}else if (attr.equalsIgnoreCase("externalReferenceId")){
    				if (parent==null){
    					cl.getMethod(setters.get(attr), String.class).invoke(abiet, et.getCode() + template.get("referenceKey")[0] + i);
    				}else{
    					cl.getMethod(setters.get(attr), String.class).invoke(abiet, parent.getReferenceKey() + et.getCode() + i);
    				}
    			}else{
    				cl.getMethod(setters.get(attr), String.class).invoke(abiet, (String)template.get(attr)[0]);
    			}
    		}
    		
	    	sm.write(abiet);
	    	
	    	if (children!=null && children.length > 0){
		    	for(EntityType child: Arrays.asList(children)){
		    		createEntities(config, sm, factory, child, abiet, null);
		    	}
	    	}
	    	
    	}
    }
    
    private static void loadTemplates(Config config) throws Exception{
    	
    	Reflections reflections = new Reflections(Config.TEMPLATES_PACKAGE);
    	Set<Class<? extends EntityTemplate>> templates = reflections.getSubTypesOf(EntityTemplate.class);
    	
    	for(Class<?> template: templates){
    		config.getTemplates().put(((EntityType)(template.getMethod("getEntityType", (Class<?>[])null).invoke(null, (Object[])null))).getType(), 
    							loadTemplate(template));
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
}
