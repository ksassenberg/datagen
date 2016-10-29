package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.EntityType;

public class UserTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1138"};
	public static String[] externalReferenceId = new String[]{"1138"};
	public static String[] name = new String[]{"Steve Underwood"};
	public static String[] roleGroupId = new String[]{"1"};	
	public static String[] activatedDate = new String[]{"23-10-2016"};
	
	public static EntityType getEntityType(){
		return EntityType.USER;
	}
}
