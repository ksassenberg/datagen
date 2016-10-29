package com.fenergo.fdim.datagen.config;

public enum EntityType {
	
	LEGAL_ENTITY("LegalEntity", "com.fenergo.fdim.datagen.jaxb.templates.LegalEntityTemplate", "com.fenergo.fdim.datagen.jaxb.dminput.LegalEntity", true),
	USER("User", "com.fenergo.fdim.datagen.jaxb.templates.UserTemplate", "com.fenergo.fdim.datagen.jaxb.dminput.User", true),
	LOOKUP("Lookup", "com.fenergo.fdim.datagen.jaxb.templates.LookupTemplate", "com.fenergo.fdim.datagen.jaxb.dminput.Lookup", true),
	ADDRESS("Address", "com.fenergo.fdim.datagen.jaxb.templates.AddressTemplate", "com.fenergo.fdim.datagen.jaxb.dminput.Address", false),
	CONTACT("Contact", "com.fenergo.fdim.datagen.jaxb.templates.ContactTemplate", "com.fenergo.fdim.datagen.jaxb.dminput.Contact", false),
	ASSOCIATION("Association", "com.fenergo.fdim.datagen.jaxb.templates.AssociationTemplate", "com.fenergo.fdim.datagen.jaxb.dminput.Association", false),
	RELATIONSHIP("Relationship", "com.fenergo.fdim.datagen.jaxb.templates.RelationshipTemplate", "com.fenergo.fdim.datagen.jaxb.dminput.Relationship", false);
	
	
	private final String type;
	private final String template;
	private final String implemetation;
	private final boolean root;
	
	EntityType(String type, String template, String implementation, boolean root){
		this.type = type;
		this.template = template;
		this.implemetation = implementation;
		this.root = root;
	}
	
	public String getType(){
		return type;
	}

	public String getTemplate() {
		return template;
	}

	public String getImplemetation() {
		return implemetation;
	}
	
	public String getCode() {
		return type.toUpperCase();
	}

	public boolean isRoot() {
		return root;
	}
	
}
