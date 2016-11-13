package com.fenergo.fdim.datagen.jaxb.marshaller;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.fenergo.fdim.datagen.config.Config;


public class XMLStringMarshal<T>
{   
	private Marshaller marshaller;
    private final Class<T> type;

    public XMLStringMarshal(Class<T> type) throws JAXBException
    {
        this.type = type;
        JAXBContext context = JAXBContext.newInstance(type);
        this.marshaller = context.createMarshaller();
        this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    public String write(T t) throws JAXBException
    {

    	StringWriter xmlOut = new StringWriter();
        marshaller.marshal(new JAXBElement<T>(Config._ENTITY_QNAME, type, t), xmlOut);
        return xmlOut.toString();
    }
    
}
