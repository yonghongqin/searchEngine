package com.amdocs.optima.searchEngine.base.utils;
public class DocumentEntry
{
    private String id;
    private String body;

    public DocumentEntry () { }
    public DocumentEntry (DocumentEntry entry)
    {
        this.setId(entry.getId());
        this.setBody(entry.getBody());
    }

    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }

    public String getBody() { return this.body; }
    public void setBody(String body) { this.body = body; }
}
