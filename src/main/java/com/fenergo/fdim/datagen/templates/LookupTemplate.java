package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.AppEntityType;

public class LookupTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1139"};
	public static String[] tableName = new String[]{"Table1"};
	public static String[] name = new String[]{"LookupName"};
	
	public static AppEntityType getEntityType(){
		return AppEntityType.LOOKUP;
	}
}
