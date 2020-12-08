package com.amdocs.optima.searchEngine.base.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EmailMessageParser {

	private static EmailMessageParser instance = null;

	private Logger log = LoggerFactory.getLogger(EmailMessageParser.class);

	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private DateFormat simpledf;

	private EmailMessageParser() throws ParserConfigurationException{
		// Get a document builder instance
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();

		// Date formatter instance
		simpledf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
	}

	public static EmailMessageParser getInstance() throws ParserConfigurationException 
	{
		if (instance == null) {
			instance = new EmailMessageParser();
		}
		return instance;
	}

	/**
	 * Reads a specially formatted XML file which represents an e-mail message and returns
	 * an object of type EmailMessageEntry.
	 * @param messageFile This is the File object representing the file.
	 * @return an EmailMessageEntry containing the contents of the message.
	 */
	public EmailMessageEntry getEmailFromFile (File messageFile) {
		EmailMessageEntry docEntry = new EmailMessageEntry(true);
		String id = messageFile.getName().substring(0, messageFile.getName().lastIndexOf(".txt"));
		docEntry.setId(id);

		try {
			org.w3c.dom.Document doc = builder.parse(messageFile);
			doc.normalize();
			Element message = doc.getDocumentElement();
			NodeList children = message.getChildNodes();

			for (int i=0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					if ("sender".equals(child.getNodeName()) && child.getFirstChild() != null) {
						docEntry.setSender(child.getFirstChild().getNodeValue());
					} else if ("to".equals(child.getNodeName()) && child.getFirstChild() != null) {
						docEntry.setRecipient(child.getFirstChild().getNodeValue());
					} else if ("cc".equals(child.getNodeName()) && child.getFirstChild() != null) {
						docEntry.setCc(child.getFirstChild().getNodeValue());
					} else if ("subject".equals(child.getNodeName()) && child.getFirstChild() != null) {
						docEntry.setSubject(child.getFirstChild().getNodeValue());
					} else if ("date".equals(child.getNodeName()) && child.getFirstChild() != null) {
						try {
							docEntry.setDatetime(simpledf.parse(child.getFirstChild().getNodeValue()));
						} catch (ParseException pe) {
							docEntry.setDatetime(new java.util.Date());
						}
					} else if ("folder".equals(child.getNodeName()) && child.getFirstChild() != null) {
						docEntry.setFolder(child.getFirstChild().getNodeValue());
					} else if ("eid".equals(child.getNodeName()) && child.getFirstChild() != null) {
						docEntry.setEid(child.getFirstChild().getNodeValue());
					} else if ("format".equals(child.getNodeName()) && child.getFirstChild() != null) {
						docEntry.setFormat(child.getFirstChild().getNodeValue());
					} else if ("topic".equals(child.getNodeName()) && child.getFirstChild() != null) {
						docEntry.setTopic(child.getFirstChild().getNodeValue());
					} else if ("index".equals(child.getNodeName()) && child.getFirstChild() != null) {
						docEntry.setIndex(child.getFirstChild().getNodeValue());
					} else if ("body".equals(child.getNodeName()) && child.getFirstChild() != null) {
						NodeList bodychildren = child.getChildNodes();
						for (int j=0; j < bodychildren.getLength(); j++) {
							Node bodyChild = bodychildren.item(j);
							if (bodyChild.getNodeType() == Node.CDATA_SECTION_NODE) {
								docEntry.setBody(bodyChild.getNodeValue());
								break;
							}
						}
					}
				}
			}

		} catch (SAXException e) {
			log.error("getEmailFromFile", e);
		} catch (IOException e) {
			log.error("getEmailFromFile", e);
		}

		return docEntry;
	}

}
