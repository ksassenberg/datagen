package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.AppEntityType;

public class AssociationTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1136"};
	public static String[] externalReferenceId = new String[]{"1136"};
	public static String[] entityName = new String[]{"entityName"};
	public static String[] associatedEntity = new String[]{"associatedEntity"};	
	public static String[] relationship = new String[]{"relationship1"};	
	public static String[] roleStatus = new String[]{"roleStatus"};	
	public static String[] associationStatus = new String[]{"associationStatus"};	
	public static String[] associationName = new String[]{"associationName"};	
	public static String[] registeredState = new String[]{"registeredState"};	
	public static String[] registeredCountry = new String[]{"registeredCountry"};
	
	public static AppEntityType getEntityType(){
		return AppEntityType.ASSOCIATION;
	}
}
