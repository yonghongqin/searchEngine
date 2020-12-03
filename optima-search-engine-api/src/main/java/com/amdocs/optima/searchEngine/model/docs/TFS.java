package com.amdocs.optima.searchEngine.model.docs;

import java.util.List;

public class TFS {
       
    String id ;
    String title;
    String description;
    String assignTo;
    String teamProject;
    String reason;
    String State;
    
    String testPath;
    String activatedDate;
    String issue;
    String exitCriteria;
    String rank;
    String relatedWorkItems;
    String rejectionReason;
    String reproSteps;
    String account;
    String qARequired;

    public String getqARequired() {
        return qARequired;
    }

    public void setqARequired(String qARequired) {
        this.qARequired = qARequired;
    }
    String status;
    String bugType;
    String foundAt;
    String areaId;
    String areaPath;
    String workItemType;
    
    List<String> history;
    List<Link> links;

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getWorkItemType() {
        return workItemType;
    }

    public void setWorkItemType(String workItemType) {
        this.workItemType = workItemType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getTeamProject() {
        return teamProject;
    }

    public void setTeamProject(String teamProject) {
        this.teamProject = teamProject;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String Reason) {
        this.reason = Reason;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getTestPath() {
        return testPath;
    }

    public void setTestPath(String testPath) {
        this.testPath = testPath;
    }

    public String getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(String activatedDate) {
        this.activatedDate = activatedDate;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getExitCriteria() {
        return exitCriteria;
    }

    public void setExitCriteria(String exitCriteria) {
        this.exitCriteria = exitCriteria;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRelatedWorkItems() {
        return relatedWorkItems;
    }

    public void setRelatedWorkItems(String relatedWorkItems) {
        this.relatedWorkItems = relatedWorkItems;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getReproSteps() {
        return reproSteps;
    }

    public void setReproSteps(String reproSteps) {
        this.reproSteps = reproSteps;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBugType() {
        return bugType;
    }

    public void setBugType(String bugType) {
        this.bugType = bugType;
    }

    public String getFoundAt() {
        return foundAt;
    }

    public void setFoundAt(String foundAt) {
        this.foundAt = foundAt;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaPath() {
        return areaPath;
    }

    public void setAreaPath(String AreaPath) {
        this.areaPath = AreaPath;
    }
 
    
}
