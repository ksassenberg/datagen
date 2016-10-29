package com.fenergo.fdim.datagen.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

public class Config {
	public static final String XSI_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema-instance";
    public static final String XSI_NAMESPACE_PREFIX = "xsi";
    public static final String TEMPLATES_PACKAGE = "com.fenergo.fdim.datagen.templates";
    public static final String WRAPPER_ELEMENT = "fenergoInput";
    public final static QName _ENTITY_QNAME = new QName(XMLConstants.NULL_NS_URI, "entity");
    
    private Map<String, Map<String, String[]>> templates = new HashMap<>();
    private String filename;
    private Long numLegalEntitys;
    private Long numUsers;
    private Long numLookups;
    private Long numAddresss;
    private Long numContacts;
    private Long numAssociations;
    private Long numRelationships;
    
    public Config(){}
    
    public Config(String[] args){
    	loadArguments(args);
    }
    
    public void loadArguments(String[] args){
    	setFilename(args[0]);
    	setNumLegalEntitys(args[1]);
    	setNumUsers(args[2]);
    	setNumLookups(args[3]);
    	setNumAddresss(args[4]);
    	setNumContacts(args[5]);
    	setNumAssociations(args[6]);
    	setNumRelationships(args[7]);
    }
    
    public Map<String, Map<String, String[]>> getTemplates(){
    	return templates;
    }

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getNumLegalEntitys() {
		return numLegalEntitys;
	}

	public void setNumLegalEntitys(Long numLegalEntitys) {
		this.numLegalEntitys = numLegalEntitys;
	}
	
	public void setNumLegalEntitys(String numLegalEntitys) {
		this.numLegalEntitys = Long.parseLong(numLegalEntitys);
	}
	
	public Long getNumUsers() {
		return numUsers;
	}

	public void setNumUsers(Long numUsers) {
		this.numUsers = numUsers;
	}
	
	public void setNumUsers(String numUsers) {
		this.numUsers = Long.parseLong(numUsers);
	}
	
	public Long getNumLookups() {
		return numLookups;
	}

	public void setNumLookups(Long numLookups) {
		this.numLookups = numLookups;
	}
	
	public void setNumLookups(String numLookups) {
		this.numLookups = Long.parseLong(numLookups);
	}
	
	public Long getNumAddresss() {
		return numAddresss;
	}

	public void setNumAddresss(Long numAddresss) {
		this.numAddresss = numAddresss;
	}
	
	public void setNumAddresss(String numAddresss) {
		this.numAddresss = Long.parseLong(numAddresss);
	}
	
	public Long getNumContacts() {
		return numContacts;
	}

	public void setNumContacts(Long numContacts) {
		this.numContacts = numContacts;
	}
	
	public void setNumContacts(String numContacts) {
		this.numContacts = Long.parseLong(numContacts);
	}
	
	public Long getNumAssociations() {
		return numAssociations;
	}

	public void setNumAssociations(Long numAssociations) {
		this.numAssociations = numAssociations;
	}
	
	public void setNumAssociations(String numAssociations) {
		this.numAssociations = Long.parseLong(numAssociations);
	}
	
	public Long getNumRelationships() {
		return numRelationships;
	}

	public void setNumRelationships(Long numRelationships) {
		this.numRelationships = numRelationships;
	}
	
	public void setNumRelationships(String numRelationships) {
		this.numRelationships = Long.parseLong(numRelationships);
	}
    
}
