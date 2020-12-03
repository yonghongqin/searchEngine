package com.amdocs.optima.searchEngine.model.docs;

import java.util.List;
import java.util.Objects;

public class APSSSubCase {
	
	private String id;                    
	private String entityType;              
	private String releaseNumber;       
	private String productLine;                      
	private String year;
	private String noteType;

	private String details;
	private List<APSSLineDisplayObject> lineDisplayList;
	
	public List<APSSLineDisplayObject> getLineDisplayList() {
		return lineDisplayList;
	}
	public void setLineDisplayList(List<APSSLineDisplayObject> lineDisplayList) {
		this.lineDisplayList = lineDisplayList;
	}
	
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getReleaseNumber() {
		return releaseNumber;
	}
	public void setReleaseNumber(String releaseNumber) {
		this.releaseNumber = releaseNumber;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==this) return true;
		if(!(obj instanceof APSSSubCase)) return false;
		
		APSSSubCase subCase=(APSSSubCase)obj;
		return subCase.id.equals(id);

	}
	
	@Override
	public int hashCode(){
		return Objects.hash(id);
	}
}
