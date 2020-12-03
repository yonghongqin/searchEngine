
package com.amdocs.optima.searchEngine.model.docs;

import java.util.Set;

/**
 *
 * @author QINY
 */
public class APSSSolution {

    private String solutionId;
    private String status;
    private String solutionType;
    private String creationDate;
    private String lastUpdateDate;
    private String solutionTitle;
    private String productLine;
    Set<APSSLineDisplayObject> noteTypeDescs;

    public Set<APSSLineDisplayObject> getNoteTypeDescs() {
        return noteTypeDescs;
    }

    public void setNoteTypeDescs(Set<APSSLineDisplayObject> noteTypeDescs) {
        this.noteTypeDescs = noteTypeDescs;
    }
    private String resolutionType;
    private Set<String> associatedCasesId;
    private Set<String> associatedCRId;

    public String getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(String solutionId) {
        this.solutionId = solutionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSolutionType() {
        return solutionType;
    }

    public void setSolutionType(String solutionType) {
        this.solutionType = solutionType;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getSolutionTitle() {
        return solutionTitle;
    }

    public void setSolutionTitle(String solutionTitle) {
        this.solutionTitle = solutionTitle;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

   
    public String getResolutionType() {
        return resolutionType;
    }

    public void setResolutionType(String resolutionType) {
        this.resolutionType = resolutionType;
    }

    public Set<String> getAssociatedCasesId() {
        return associatedCasesId;
    }

    public void setAssociatedCasesId(Set<String> associatedCasesId) {
        this.associatedCasesId = associatedCasesId;
    }

    public Set<String> getAssociatedCRId() {
        return associatedCRId;
    }

    public void setAssociatedCRId(Set<String> associatedCRId) {
        this.associatedCRId = associatedCRId;
    }

}
