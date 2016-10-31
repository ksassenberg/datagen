//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.30 at 10:19:05 PM GMT 
//


package com.fenergo.fdim.datagen.jaxb.config;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fenergo.fdim.datagen.jaxb.config package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Configuration_QNAME = new QName("http://com.fenergo.fdim/Configuration", "Configuration");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fenergo.fdim.datagen.jaxb.config
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfigurationType }
     * 
     */
    public ConfigurationType createConfigurationType() {
        return new ConfigurationType();
    }

    /**
     * Create an instance of {@link RootEntityType }
     * 
     */
    public RootEntityType createRootEntityType() {
        return new RootEntityType();
    }

    /**
     * Create an instance of {@link ChildEntityType }
     * 
     */
    public ChildEntityType createChildEntityType() {
        return new ChildEntityType();
    }

    /**
     * Create an instance of {@link ListOfChildEntityType }
     * 
     */
    public ListOfChildEntityType createListOfChildEntityType() {
        return new ListOfChildEntityType();
    }

    /**
     * Create an instance of {@link ListOfRootEntityType }
     * 
     */
    public ListOfRootEntityType createListOfRootEntityType() {
        return new ListOfRootEntityType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfigurationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.fenergo.fdim/Configuration", name = "Configuration")
    public JAXBElement<ConfigurationType> createConfiguration(ConfigurationType value) {
        return new JAXBElement<ConfigurationType>(_Configuration_QNAME, ConfigurationType.class, null, value);
    }

}