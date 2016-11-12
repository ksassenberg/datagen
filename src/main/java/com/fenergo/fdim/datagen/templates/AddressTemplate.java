package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.AppEntityType;

public class AddressTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1136"};
	public static String[] externalReferenceId = new String[]{"1110"};
	public static String[] addressType = new String[]{"Registered"};
	public static String[] country = new String[]{"France"};
	public static String[] line1 = new String[]{"90 BOULEVARD"};
	public static String[] line2 = new String[]{""};
	public static String[] townCity = new String[]{"PARIS"};
	public static String[] stateCounty = new String[]{""};
	public static String[] postalZipCode = new String[]{"0000"};
	
	public static AppEntityType getEntityType(){
		return AppEntityType.ADDRESS;
	}
}
