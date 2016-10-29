//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.24 at 05:30:03 PM BST 
//


package com.fenergo.fdim.datagen.jaxb.dminput;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Registered"/>
 *     &lt;enumeration value="Correspondence"/>
 *     &lt;enumeration value="Residential"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Trading"/>
 *     &lt;enumeration value="Property"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AddressTypeEnum")
@XmlEnum
public enum AddressTypeEnum {

    @XmlEnumValue("Registered")
    REGISTERED("Registered"),
    @XmlEnumValue("Correspondence")
    CORRESPONDENCE("Correspondence"),
    @XmlEnumValue("Residential")
    RESIDENTIAL("Residential"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Trading")
    TRADING("Trading"),
    @XmlEnumValue("Property")
    PROPERTY("Property");
    private final String value;

    AddressTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AddressTypeEnum fromValue(String v) {
        for (AddressTypeEnum c: AddressTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
