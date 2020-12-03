package com.amdocs.optima.searchEngine.base.utils;

public class EmailMessageEntry extends DocumentEntry
{
    private String sender;
    private String recipient;
    private String cc;
    private String subject;
    private java.util.Date datetime;
    private String folder;
    private String eid;
    private String format;
    private String topic;    // PR_CONVERSATION_TOPIC in MAPI
    private String index;    // PR_CONVERSATION_INDEX in MAPI

    public EmailMessageEntry() { this(false); }
    public EmailMessageEntry(boolean initialized) {
    	if (initialized) {
    		setBody("");
    		setSender("");
    		setRecipient("");
    		setCc("");
    		setSubject("");
    		setDatetime(new java.util.Date());
    		setFolder("");
    		setEid("");
    		setFormat("");
    		setTopic("");
    		setIndex("");
    	}
    }

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public java.util.Date getDatetime() {
		return datetime;
	}

	public void setDatetime(java.util.Date datetime) {
		this.datetime = datetime;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}
