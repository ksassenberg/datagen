//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.30 at 10:19:05 PM GMT 
//


package com.fenergo.fdim.datagen.jaxb.config;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LegalEntity"/>
 *     &lt;enumeration value="Lookup"/>
 *     &lt;enumeration value="User"/>
 *     &lt;enumeration value="Contact"/>
 *     &lt;enumeration value="Address"/>
 *     &lt;enumeration value="Association"/>
 *     &lt;enumeration value="Relationship"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityType", namespace = "http://com.fenergo.fdim/ConfigEnums")
@XmlEnum
public enum EntityType {

    @XmlEnumValue("LegalEntity")
    LEGAL_ENTITY("LegalEntity"),
    @XmlEnumValue("Lookup")
    LOOKUP("Lookup"),
    @XmlEnumValue("User")
    USER("User"),
    @XmlEnumValue("Contact")
    CONTACT("Contact"),
    @XmlEnumValue("Address")
    ADDRESS("Address"),
    @XmlEnumValue("Association")
    ASSOCIATION("Association"),
    @XmlEnumValue("Relationship")
    RELATIONSHIP("Relationship");
    private final String value;

    EntityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EntityType fromValue(String v) {
        for (EntityType c: EntityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
