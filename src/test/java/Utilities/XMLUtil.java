package Utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class XMLUtil extends Environment_Config{
    private String filePath;
    public static XMLUtil xmlobj;
    public static String xmlfilename;

    public void setXMLFileName(String filePath1)
    {
        this.filePath = filePath1;
    }


    public void CreateXML(String filePath1)
    {
        Date timeStamp = new Date();

        try
        {
            setXMLFileName(filePath1);

            //define an empty document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;

            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element testdataElement=doc.createElement("RUNDATA");
            doc.appendChild(testdataElement);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer;
            try {
                transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.METHOD,"xml");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(filePath1));
                transformer.transform(source, result);
            } catch (TransformerException e) {
                e.printStackTrace();
            }
            System.out.println("Run Data XML File Created at: " + filePath1);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }


    public void saveData(String elementName, String elementValue)
    {
        try
        {
            //define an empty document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
            try
            {
                boolean found;
                found = false;
                doc = builder.parse(filePath);
                Element root = doc.getDocumentElement();

                NodeList list = root.getChildNodes();

                for (int i = 0; i < list.getLength(); i++)
                {
                    Node node = list.item(i);

                    if (elementName.equals(node.getNodeName())) {
                        node.setTextContent(elementValue);
                        found = true;
                        break;
                    }
                }

                if (found == false)
                {
                    Element newElement = doc.createElement(elementName);
                    newElement.appendChild(doc.createTextNode(elementValue));
                    root.appendChild(newElement);
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer;
                try
                {
                    transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(filePath);
                    transformer.transform(source, result);
                } catch (TransformerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("element '" + elementName + "' added/updated with value '" + elementValue + "' to Run Data XML");
            } catch (SAXException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




    public String retrieveData(String elementName)
    {
        String RetrievedValue = null;
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
            try
            {
                doc = builder.parse(filePath);
                Node root = doc.getFirstChild();
                Boolean found;
                found=false;

                NodeList list = root.getChildNodes();
                for (int i = 0; i < list.getLength(); i++)
                {
                    Node node = list.item(i);
                    if (elementName.equals(node.getNodeName()))
                    {
                        RetrievedValue = node.getTextContent();
                        found=true;
                        System.out.println("Retrieved value of element '"+elementName+"' is :"+RetrievedValue);
                    }
                }

                if (found==false)
                    System.out.println("element '"+elementName+"' NOT Found in the Run Data XML");

            } catch (SAXException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return RetrievedValue;
    }


    public void removeData(String elementName)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;

            try
            {
                doc = builder.parse(filePath);
                Node root = doc.getFirstChild();
                Boolean found;
                found=false;

                NodeList list = root.getChildNodes();
                for (int i = 0; i < list.getLength(); i++)
                {
                    Node node = list.item(i);
                    if (elementName.equals(node.getNodeName())) {
                        root.removeChild(node);
                        found=true;
                        System.out.println("element '"+elementName+"' Removed from Run Data XML");
                    }
                }

                if (found==false)
                    System.out.println("element '"+elementName+"' NOT Found in the Run Data XML");

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer;
                try {
                    transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(filePath);
                    transformer.transform(source, result);

                } catch (TransformerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            } catch (SAXException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
