package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.EntityType;

public class RelationshipTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1199"};
	public static String[] externalReferenceId = new String[]{"1199"};	
	public static String[] relationshipID = new String[]{"relationshipID"};
	public static String[] userID = new String[]{"userID"};
	public static String[] relationshipType = new String[]{"relationshipType"};
	public static String[] status = new String[]{"status"};
	public static String[] division = new String[]{"division"};
	public static String[] businessUnit = new String[]{"businessUnit"};
	public static String[] title = new String[]{"title"};
	public static String[] emailAddress = new String[]{"emailAddress"};
	public static String[] firstName = new String[]{"firstName"};
	public static String[] lastName = new String[]{"lastName"};
	public static String[] workPhone = new String[]{"workPhone"};
	public static String[] mobilePhone = new String[]{"mobilePhone"};
	public static String[] homePhone = new String[]{"homePhone"};
	public static String[] isPrimaryRelationship = new String[]{"true"};
	
	public static EntityType getEntityType(){
		return EntityType.RELATIONSHIP;
	}
}
