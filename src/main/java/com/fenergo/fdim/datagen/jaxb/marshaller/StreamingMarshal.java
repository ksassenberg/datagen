package com.fenergo.fdim.datagen.jaxb.marshaller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.fenergo.fdim.datagen.config.Config;


public class StreamingMarshal<T>
{   
    private XMLStreamWriter xmlOut;
    private Marshaller marshaller;
    private final Class<T> type;

    public StreamingMarshal(Class<T> type) throws JAXBException
    {
        this.type = type;
        JAXBContext context = JAXBContext.newInstance(type);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    public void open(String filename) throws XMLStreamException, IOException
    {
        xmlOut = XMLOutputFactory.newFactory().createXMLStreamWriter(new FileOutputStream(filename));
        xmlOut.writeStartDocument();
        xmlOut.writeStartElement(Config.WRAPPER_ELEMENT);
        xmlOut.writeNamespace(Config.XSI_NAMESPACE_PREFIX, Config.XSI_NAMESPACE_URI);
		xmlOut.setPrefix(Config.XSI_NAMESPACE_PREFIX, Config.XSI_NAMESPACE_URI);
    }

    public void write(T t) throws JAXBException
    {
        marshaller.marshal(new JAXBElement<T>(Config._ENTITY_QNAME, type, t), xmlOut);
    }

    public void close() throws XMLStreamException
    {
        xmlOut.writeEndDocument();
        xmlOut.close();
    }
}
