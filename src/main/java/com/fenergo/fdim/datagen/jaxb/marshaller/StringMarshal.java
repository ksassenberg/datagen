package com.fenergo.fdim.datagen.jaxb.marshaller;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.fenergo.fdim.datagen.config.Config;


public class StringMarshal<T>
{   
    private StringWriter xmlOut;
    private Marshaller marshaller;
    private final Class<T> type;

    public StringMarshal(Class<T> type) throws JAXBException
    {
        this.type = type;
        JAXBContext context = JAXBContext.newInstance(type);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        xmlOut = new StringWriter();
    }

    public void write(T t) throws JAXBException
    {
        marshaller.marshal(new JAXBElement<T>(Config._ENTITY_QNAME, type, t), xmlOut);
    }
    
    public void clear(){
    	xmlOut.getBuffer().setLength(0);
    }
    
    public String getValue(){
    	return xmlOut.getBuffer().toString();
    }
    
    public void close() throws Exception{
    	xmlOut.close();
    }
    
}
