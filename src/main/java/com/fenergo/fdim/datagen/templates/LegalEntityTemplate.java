package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.EntityType;

public class LegalEntityTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1136"};
	public static String[] externalReferenceId = new String[]{"1136"};
	public static String[] legalEntityName = new String[]{"1"};
	public static String[] legalEntityType = new String[]{"1"};	
	public static String[] taxId = new String[]{"1"};
	public static String[] legalEntityRole = new String[]{"1"};
	public static String[] taxIdNumber = new String[]{"1"};
	public static String[] bankEntity = new String[]{"30000"};
	public static String[] countryOfIncorporation = new String[]{"77"};
	public static String[] addressCountry = new String[]{"1"};	
	public static String[] addressLine1 = new String[]{"1"};
	public static String[] bankJurisdiction = new String[]{"1"};
	
	public static EntityType getEntityType(){
		return EntityType.LEGAL_ENTITY;
	}
}
