package com.fenergo.fdim.datagen.jaxb.marshaller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;

import com.fenergo.fdim.datagen.jaxb.config.ConfigurationType;

public class ConfigurationManager {
	
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

    public ConfigurationManager(String package_name) throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance(package_name);
        
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        unmarshaller = context.createUnmarshaller();
        
    }

    public ConfigurationType read(InputStream stream) throws JAXBException, IOException
    {
        return ((JAXBElement<ConfigurationType>)unmarshaller.unmarshal(stream)).getValue();
    }
    
    public void write(String filename, ConfigurationType config) throws JAXBException, IOException
    {
        marshaller.marshal(config, new FileOutputStream(filename));
    }
}
