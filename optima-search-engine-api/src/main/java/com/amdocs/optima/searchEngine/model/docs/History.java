/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.model.docs;

/**
 *
 * @author QINY
 */
public class History {
    
    private String changedBy;
    private String changedDate;
    private String changedContent;

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public String getChangedContent() {
        return changedContent;
    }

    public void setChangedContent(String changedContent) {
        this.changedContent = changedContent;
    }
    
}
