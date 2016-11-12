//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.30 at 10:19:05 PM GMT 
//


package com.fenergo.fdim.datagen.jaxb.config;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.reflections.Reflections;

import com.fenergo.fdim.datagen.config.Config;
import com.fenergo.fdim.datagen.config.EntityTemplate;


/**
 * <p>Java class for AbstractEntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractEntityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://com.fenergo.fdim/ConfigEnums}EntityType"/>
 *         &lt;element name="occurences" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="cachesize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractEntityType", propOrder = {
    "type",
    "occurences",
    "cacheSize"
})
@XmlSeeAlso({
    RootEntityType.class,
    ChildEntityType.class
})
public abstract class AbstractEntityType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EntityType type;
    @XmlElement(name = "occurences", required = true)
    protected long occurences;
    @XmlElement(name = "cache_size", required = true)
    protected long cacheSize;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setType(EntityType value) {
        this.type = value;
    }

    /**
     * Gets the value of the occurences property.
     * 
     */
    public long getOccurences() {
        return occurences;
    }

    /**
     * Sets the value of the occurences property.
     * 
     */
    public void setOccurences(long value) {
        this.occurences = value;
    }
    
    public long getCacheSize() {
        return cacheSize;
    }

    /**
     * Sets the value of the cache size property.
     * 
     */
    public void setCacheSize(long value) {
        this.cacheSize = value;
    }
    

}
