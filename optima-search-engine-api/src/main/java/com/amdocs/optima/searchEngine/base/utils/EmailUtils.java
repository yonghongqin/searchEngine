/*
 * Brent Smith <brent.smith@comverse.com>
 *
 * Author: $Author$
 * Revision: $Revision$
 *
 * Copyright (C) 2006 Brent Smith 
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA*
 *
 */

package com.amdocs.optima.searchEngine.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class EmailUtils {
	
	/**
	 * @author smitten
	 *
	 * This class represents an attachment that can be sent along
	 * with e-mail messages.  It should be used in conjunction
	 * with the sendEmail() method.
	 */
	public static class Attachment {
		
		private InputStream inputStream;
		private String mimeType;
		private String fileName;
		private String contentId;
		
		public String getFileName() { return fileName; }
		public void setFileName(String fileName) { this.fileName = fileName; }
		
		public InputStream getInputStream() { return inputStream; }
		public void setInputStream(InputStream inputStream) { this.inputStream = inputStream; }
		
		public String getMimeType() { return mimeType; }
		public void setMimeType(String mimeType) { this.mimeType = mimeType; }
		
		public String getContentId() { return contentId; }
		public void setContentId(String contentId) { this.contentId = contentId; }
	}

	private static Logger log = Logger.getLogger (EmailUtils.class.getName());
	private static final String revision = "$Id$";

	/**
	 * Convenience method to send an e-mail without specifying any attachments.
	 * @param subject The subject of the e-mail message.
	 * @param from An e-mail address representing the person sending the message.
	 * @param content String with the textual content of the mail.
	 * @param mimetype The mime-type for the content (text/plain, text/html, etc...)
	 * @param to Comma separated list of recipients for the e-mail message.
	 * @param cc Comma separated list of carbon-copy recipients for the e-mail message.
	 * @param bcc Comma separated list of blind carbon-copy recipients for the e-mail message.
	 */
	public static void sendEmail (String subject, 
	                              String from, 
	                              String content, 
	                              String mimetype,
	                              String to, 
	                              String cc, 
	                              String bcc) {
		sendEmail (subject, from, content, mimetype, to, cc, bcc, null);
	}

	public static void sendEmail (String subject, 
	                              String from, 
	                              String content, 
	                              String mimetype,
	                              String to, 
	                              String cc, 
	                              String bcc,
	                              Attachment[] attachments) {
		sendEmail (subject, from, content, mimetype, to, cc, bcc, attachments, null);
	}
	
	/**
	 * 
	 * @param subject The subject of the e-mail message.
	 * @param from An e-mail address representing the person sending the message.
	 * @param content String with the textual content of the mail.
	 * @param mimetype The mime-type for the content (text/plain, text/html, etc...)
	 * @param to Comma separated list of recipients for the e-mail message.
	 * @param cc Comma separated list of carbon-copy recipients for the e-mail message.
	 * @param bcc Comma separated list of blind carbon-copy recipients for the e-mail message.
	 * @param attachments An array of <code>Attachment</code> instances to be included as
	 * attachments on the e-mail message.
	 */
	public static void sendEmail (String subject, 
	                              String from, 
	                              String content, 
	                              String mimetype,
	                              String to, 
	                              String cc, 
	                              String bcc,
	                              Attachment[] attachments,
	                              String multipartType) {

		// Perform validation: check for programmer error
		if (subject == null)
			throw new IllegalArgumentException ("The \"subject\" parameter may not be null");
		else if ((to == null  || to.length()  < 1) && 
		         (cc == null  || cc.length()  < 1) && 
		         (bcc == null || bcc.length() < 1)) {
			throw new IllegalArgumentException ("At least one of \"to\", \"cc\" or " +
			                                    "\"bcc\" must contain a recipient");
		}

		try {
			// Get a Session object
			log.debug ("Retrieving Session...");
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			Session session = (Session) envCtx.lookup("mail/Session");
			log.debug ("Successfully retrieved Session...");

			// If our corresponding logger is enabled, then set debug on the javamail session
			if (log.isDebugEnabled())
				session.setDebug(true);

			// construct the message
			Message msg = new MimeMessage(session);
			if (from != null)
				msg.setFrom(new InternetAddress(from));
			else
				msg.setFrom();


			if (to != null) 
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			if (cc != null)
				msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
			if (bcc != null)
				msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc, false));

			// Set the subject
			msg.setSubject(subject);

			// Set the date sent
			msg.setSentDate(new Date());

			// Set the content of the message
			if (attachments != null && attachments.length > 0) {
				MimeBodyPart mbp1 = new MimeBodyPart();
				mbp1.setContent(content, mimetype);
				
				Multipart multipart = (multipartType != null) ? new MimeMultipart(multipartType) : new MimeMultipart();
				multipart.addBodyPart(mbp1);
				
				// Create all the attachments
				for (int i=0; i < attachments.length; i++) {
					InputStream inputStream = attachments[i].getInputStream();
					String mimeType = attachments[i].getMimeType();
					String filename = attachments[i].getFileName();
					
					MimeBodyPart mbp2 = new MimeBodyPart();
					mbp2.setDataHandler (new DataHandler(new ByteArrayDataSource(inputStream, mimeType)));
					mbp2.setFileName (filename);
					if (attachments[i].getContentId() != null) {
						log.debug("setting content id");
						mbp2.setHeader("Content-ID", "<"+attachments[i].getContentId()+">");
						mbp2.setDisposition("inline");
					}
					log.debug("adding multipart ["+filename+"] {"+mimeType+"}");
					multipart.addBodyPart(mbp2);
				}
				msg.setContent(multipart);
				
			} else {
				msg.setContent(content, mimetype);
				//msg.setDataHandler (new DataHandler(new ByteArrayDataSource(content, mimetype)));
			}

			// Set any additional headers specified 
			msg.setHeader("X-Mailer", "Javamail: " + revision);

			// Send the message
			log.debug ("Sending Message...");
			Transport.send(msg);
			log.debug ("Successfully sent Message...");
		} catch (IOException e) {
			log.error ("Unable to send message due to IOException", e);
		} catch (NamingException e) {
			log.error ("Unable to send message due to NamingException", e);
		} catch (MessagingException e) {
			log.error ("Unable to send message due to MessageException", e);
		}

	}
}
