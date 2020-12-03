package com.amdocs.optima.searchEngine.model.docs;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class APSSLineDisplayObject {
	private String firstLine;                    
	private String remainingText;
	private String tabTitle;  
	public String getTabTitle() {
		return tabTitle;
	}
	public void setTabTitle(String tabTitle) {
		this.tabTitle = tabTitle;
	}
	public String getFirstLine() {
		return firstLine;
	}
	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}
	public String getRemainingText() {
		return remainingText;
	}
	public void setRemainingText(String remainingText) {
		this.remainingText = remainingText;
	} 
	
	@Override
	public String toString(){
		return "firstLine="+firstLine+" remaingLine="+remainingText +" tableTile="+tabTitle;
	}
        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof APSSLineDisplayObject)){
                return false;
            }
            if(obj==this) return true;
            
            APSSLineDisplayObject displyObj=(APSSLineDisplayObject)obj;
            
            return new EqualsBuilder().append(firstLine, displyObj.getFirstLine())
                    .isEquals();
        }
        
        @Override
        public int hashCode(){
            return new HashCodeBuilder(17,31)
                    .append(firstLine)
                    .toHashCode();
                    
        }
}
