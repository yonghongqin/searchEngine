package com.amdocs.optima.searchEngine.dto;

import com.amdocs.optima.searchEngine.base.utils.EmailMessageEntry;



public class EmailMessageView extends EmailMessageEntry implements Comparable {
	private int depth = 0;
	private boolean selected = false;
        private String blank=null;

    public String getBlank() {
        return blank;
    }

    public void setBlank(String blank) {
        this.blank = blank;
    }
	
	public EmailMessageView ()
	{
		super(false);
	}
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public int compareTo(Object o1) {
		EmailMessageView other = (EmailMessageView)o1;
		return this.getIndex().compareTo(other.getIndex());
	}	

}
