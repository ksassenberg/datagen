package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.EntityType;

public class ContactTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1136"};
	public static String[] externalReferenceId = new String[]{"1140"};
	public static String[] businessTitle = new String[]{"businessTitle"};
	public static String[] status = new String[]{"status"};
	public static String[] contactType = new String[]{"contactType"};
	public static String[] title = new String[]{"Mr"};
	public static String[] emailAddress = new String[]{"emailAddress"};
	public static String[] firstName = new String[]{"Logan"};
	public static String[] lastName = new String[]{"Runs"};
	public static String[] phoneNumberWork = new String[]{"6556565"};
	public static String[] phoneNumberMobile = new String[]{"35345535"};
	public static String[] phoneNumberHome = new String[]{"3535345545"};
	public static String[] fax = new String[]{"3535345545"};
	public static String[] isPrimaryContact = new String[]{"true"};
	
	public static EntityType getEntityType(){
		return EntityType.CONTACT;
	}
}
