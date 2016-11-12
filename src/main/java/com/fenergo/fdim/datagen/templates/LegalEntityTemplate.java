package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.AppEntityType;

public class LegalEntityTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1136"};
	public static String[] externalReferenceId = new String[]{"1136"};
	public static String[] legalEntityName = new String[]{"legalEntityName"};
	public static String[] legalEntityType = new String[]{"legalEntityType"};	
	public static String[] taxId = new String[]{"taxId"};
	public static String[] legalEntityRole = new String[]{"legalEntityRole"};
	public static String[] taxIdNumber = new String[]{"taxIdNumber"};
	public static String[] bankEntity = new String[]{"30000"};
	public static String[] countryOfIncorporation = new String[]{"77"};
	public static String[] addressCountry = new String[]{"addressCountry"};	
	public static String[] addressLine1 = new String[]{"addressLine1"};
	public static String[] bankJurisdiction = new String[]{"bankJurisdiction"};
	
	public static AppEntityType getEntityType(){
		return AppEntityType.LEGAL_ENTITY;
	}
}
