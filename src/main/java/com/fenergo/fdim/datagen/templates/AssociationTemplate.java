package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.EntityType;

public class AssociationTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1136"};
	public static String[] externalReferenceId = new String[]{"1"};
	public static String[] entityName = new String[]{"1"};
	public static String[] associatedEntity = new String[]{"1"};	
	public static String[] relationship = new String[]{"1"};	
	public static String[] roleStatus = new String[]{"1"};	
	public static String[] associationStatus = new String[]{"1"};	
	public static String[] associationName = new String[]{"1"};	
	public static String[] registeredState = new String[]{"1"};	
	public static String[] registeredCountry = new String[]{"1"};
	
	public static EntityType getEntityType(){
		return EntityType.ASSOCIATION;
	}
}
