package com.amdocs.optima.searchEngine.model.docs;

import java.util.List;
import java.util.Set;

public class APSS {

    private String id;
    private String entityType;
    private String releaseNumber;
    private String productLine;
    private String year;
    private Boolean isSubcase;

    public Boolean getIsSubcase() {
        return isSubcase;
    }

    public void setIsSubcase(Boolean isSubcase) {
        this.isSubcase = isSubcase;
    }
    private List<APSSLineDisplayObject> solutionList;

    public List<APSSLineDisplayObject> getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(List<APSSLineDisplayObject> solutionList) {
        this.solutionList = solutionList;
    }
    private List<String> yearOfFilter;
    private List<String> prodLinefFilter;
    private List<String> accountOfFilter;

    public List<String> getYearOfFilter() {
        return yearOfFilter;
    }

    public void setYearOfFilter(List<String> yearOfFilter) {
        this.yearOfFilter = yearOfFilter;
    }

    public List<String> getProdLinefFilter() {
        return prodLinefFilter;
    }

    public void setProdLinefFilter(List<String> prodLinefFilter) {
        this.prodLinefFilter = prodLinefFilter;
    }

    public List<String> getAccountOfFilter() {
        return accountOfFilter;
    }

    public void setAccountOfFilter(List<String> accountOfFilter) {
        this.accountOfFilter = accountOfFilter;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    private String accountName;
    private APSSLineDisplayObject caseDesc;

    private Set<APSSLineDisplayObject> noteTypeDescs;

    private APSSLineDisplayObject apssSubCase;

    private APSSLineDisplayObject apssEmail;

    private APSSLineDisplayObject phoneLog;

    private List<APSSLineDisplayObject> lineDisplayList;

    public List<APSSLineDisplayObject> getLineDisplayList() {
        return lineDisplayList;
    }

    public void setLineDisplayList(List<APSSLineDisplayObject> lineDisplayList) {
        this.lineDisplayList = lineDisplayList;
    }

    public APSSLineDisplayObject getPhoneLog() {
        return phoneLog;
    }

    public void setPhoneLog(APSSLineDisplayObject phoneLog) {
        this.phoneLog = phoneLog;
    }

    public APSSLineDisplayObject getApssSubCase() {
        return apssSubCase;
    }

    public void setApssSubCase(APSSLineDisplayObject apssSubCase) {
        this.apssSubCase = apssSubCase;
    }

    public APSSLineDisplayObject getApssEmail() {
        return apssEmail;
    }

    public void setApssEmail(APSSLineDisplayObject apssEmail) {
        this.apssEmail = apssEmail;
    }

    public APSSLineDisplayObject getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(APSSLineDisplayObject caseDesc) {
        this.caseDesc = caseDesc;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    private String actiontName;

    public Set<APSSLineDisplayObject> getNoteTypeDescs() {
        return noteTypeDescs;
    }

    public void setNoteTypeDescs(Set<APSSLineDisplayObject> noteTypeDescs) {
        this.noteTypeDescs = noteTypeDescs;
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

}
