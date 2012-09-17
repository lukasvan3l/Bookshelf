package utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import play.Logger;
import play.libs.XML;

public class XMLUtils {
    /**
     * Loads string as xmldocument from:
     * http://stackoverflow.com/questions/33262
     * /how-do-i-load-an-org-w3c-dom-document-from-xml-in-a-string
     * 
     * @param xml
     * @return
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static org.w3c.dom.Document loadXMLFrom(String xml)
            throws org.xml.sax.SAXException {
        if (xml == null || xml.isEmpty())
            return null;

        try
        {
            Document doc = loadXMLFrom(new java.io.ByteArrayInputStream(xml.getBytes()));
            if (doc == null)
                throw new Exception("LoadXmlFrom returned null");
            return doc;
        } catch (Exception ex)
        {
            Logger.fatal("Unable to parse xml. Msg: " + ex.getMessage() + ", Xml: " + xml);
            throw new SAXException();
        }
    }

    private static Document loadXMLFrom(java.io.InputStream is)
            throws SAXException, java.io.IOException,
            ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(is);
        is.close();
        return doc;
    }
    
}


