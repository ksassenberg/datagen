package com.fenergo.fdim.datagen.templates;

import com.fenergo.fdim.datagen.config.EntityTemplate;
import com.fenergo.fdim.datagen.config.EntityType;

public class RelationshipTemplate implements EntityTemplate{
	public static String[] referenceKey = new String[]{"1199"};
	public static String[] externalReferenceId = new String[]{"1"};	
	public static String[] relationshipID = new String[]{"1"};
	public static String[] userID = new String[]{"1"};
	public static String[] relationshipType = new String[]{"1"};
	public static String[] status = new String[]{"1"};
	public static String[] division = new String[]{"1"};
	public static String[] businessUnit = new String[]{"1"};
	public static String[] title = new String[]{"1"};
	public static String[] emailAddress = new String[]{"1"};
	public static String[] firstName = new String[]{"1"};
	public static String[] lastName = new String[]{"1"};
	public static String[] workPhone = new String[]{"1"};
	public static String[] mobilePhone = new String[]{"1"};
	public static String[] homePhone = new String[]{"1"};
	public static String[] isPrimaryRelationship = new String[]{"1"};
	
	public static EntityType getEntityType(){
		return EntityType.RELATIONSHIP;
	}
}
