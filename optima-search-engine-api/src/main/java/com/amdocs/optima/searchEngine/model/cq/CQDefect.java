package com.amdocs.optima.searchEngine.model.cq;

import com.amdocs.optima.searchEngine.model.webtrac.Calllog;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "CBS_DEFECT")
public class CQDefect implements Serializable {


    @Column(name = "DBID")
    private Integer dbid;                    // DBID                      <NUMBER(10)>
    @Column(name = "IS_ACTIVE")
    private Integer isActive;                // IS_ACTIVE                 <NUMBER(10)>
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;                       // ID                        <VARCHAR2(13)>
    @Column(name = "VERSION")
    private Integer version;                 // VERSION                   <NUMBER(10)>
    @Column(name = "ANALYSIS_BY")
    private String analysisBy;               // ANALYSIS_BY               <VARCHAR2(50)>
    @Column(name = "ASSIGN_TO_FULLNAME")
    private String assignToFullname;         // ASSIGN_TO_FULLNAME        <VARCHAR2(50)>
    @Column(name = "CUSTOMER_NAME")
    private String customerName;             // CUSTOMER_NAME             <VARCHAR2(50)>
    @Column(name = "EXTERNAL_DEFECT_ID")
    private String externalDefectId;         // EXTERNAL_DEFECT_ID        <VARCHAR2(50)>
    @Column(name = "ODC_CAUSE_OF_ERROR")
    private String odcCauseOfError;          // ODC_CAUSE_OF_ERROR        <VARCHAR2(50)>
    @Column(name = "ODC_DETECTED_ON")
    private String odcDetectedOn;            // ODC_DETECTED_ON           <VARCHAR2(50)>
    @Column(name = "ODC_DETECTED_WHILE")
    private String odcDetectedWhile;         // ODC_DETECTED_WHILE        <VARCHAR2(50)>
    @Column(name = "ODC_IMPACT")
    private String odcImpact;                // ODC_IMPACT                <VARCHAR2(50)>
    @Column(name = "ODC_PROJECT_PHASE")
    private String odcProjectPhase;          // ODC_PROJECT_PHASE         <VARCHAR2(50)>
    @Column(name = "ODC_QUALIFIER")
    private String odcQualifier;             // ODC_QUALIFIER             <VARHCAR2(50)>
    @Column(name = "ODC_SUB_TARGET")
    private String odcSubTarget;             // ODC_SUB_TARGET            <VARCHAR2(50)>
    @Column(name = "ODC_TARGET")
    private String odcTarget;                // ODC_TARGET                <VARCHAR2(50)>
    @Column(name = "ODC_TARGET_AGE")
    private String odcTargetAge;             // ODC_TARGET_AGE            <VARCHAR2(50)>
    @Column(name = "ODC_TARGET_SOURCE")
    private String odcTargetSource;          // ODC_TARGET_SOURCE         <VARCHAR2(50)>
    @Column(name = "PRIORITY")
    private String priority;                 // PRIORITY                  <VARCHAR2(15)>
    @Column(name = "PRODUCT_NAME")
    private String productName;              // PRODUCT_NAME              <VARCHAR2(50)>
    @Column(name = "REOPEN_COUNT")
    private Integer reopenCount;             // REOPEN_COUNT              <NUMBER(10)>
    @Column(name = "REPRODUCIBLE")
    private String reproducible;             // REPRODUCIBLE              <VARCHAR2(15)>
    @Column(name = "SERVICE_NAME")
    private String serviceName;              // SERVICE_NAME              <VARCHAR2(50)>
    @Column(name = "SEVERITY")
    private String severity;                 // SEVERITY                  <VARCHAR2(15)>
    @Column(name = "SOLUTION_BY")
    private String solutionBy;               // SOLUTION_BY               <VARCHAR2(50)>
    @Column(name = "SUBMIT_DATE")
    private Date submitDate;                 // SUBMIT_DATE               <DATE>
    @Column(name = "TITLE")
    private String title;                    // TITLE                     <VARCHAR2(254)>
    @Column(name = "RELEASE_ID")
    private String releaseId;                // RELEASE_ID                <VARCHAR2(50)>
    @Column(name = "CBS_MODULE")
    private String cbsModule;                // CBS_MODULE                <VARCHAR2(75)>
    @Lob
    @Column(name = "ANALYSIS_DESCRIPTION")
    private String analysisDescription;      // ANALYSIS_DESCRIPTION      <CLOB>
    @Lob
    @Column(name = "ANALYSIS_MODULES")
    private String analysisModules;          // ANALYSIS_MODULES          <CLOB>
    @Lob
    @Column(name = "BEHAVIOR_OPTIONS")
    private String behaviorOptions;          // BEHAVIOR_OPTIONS          <CLOB>
    @Column(name = "DESCRIPTION")
    private String description;              // DESCRIPTION               <CLOB>
    @Lob
    @Column(name = "EFFECT_ON_SERVICE")
    private String effectOnService;          // EFFECT_ON_SERVICE         <CLOB>
    @Lob
    @Column(name = "EXTERNAL_DEFECT_LINK")
    private String externalDefectLink;       // EXTERNAL_DEFECT_LINK      <CLOB>
    @Lob
    @Column(name = "HISTORY_OF_CHANGES")
    private String historyOfChanges;         // HISTORY_OF_CHANGES        <CLOB>
    @Lob
    @Column(name = "LG_ATTACHMENTS")
    private String largeAttachments;         // LG_ATTACHMENTS            <CLOB>
    @Lob
    @Column(name = "NOTES_ENTRY")
    private String notesEntry;               // NOTES_ENTRY               <CLOB>
    @Lob
    @Column(name = "NOTES_LOG")
    private String notesLog;                 // NOTES_LOG                 <CLOB>
    @Lob
    @Column(name = "NOTIFY")
    private String notify;                   // NOTIFY                    <CLOB>
    @Lob
    @Column(name = "REPRODUCE_REQUEST_DETAILS")
    private String reproduceRequestDetails;  // REPRODUCE_REQUEST_DETAILS <CLOB>
    @Lob
    @Column(name = "RETEST_INSTRUCTIONS")
    private String retestInstructions;       // RETEST_INSTRUCTIONS       <CLOB>
    @Lob
    @Column(name = "SETUP_COMMENTS")
    private String setupComments;            // SETUP_COMMENTS            <CLOB>
    @Lob
    @Column(name = "SETUP_TEST_ENVIRONMENTS")
    private String setupTestEnvironments;    // SETUP_TEST_ENVIRONMENTS   <CLOB>
    @Lob
    @Column(name = "SOLUTION_DESCRIPTION")
    private String solutionDescription;      // SOLUTION_DESCRIPTION      <CLOB>
    @Column(name = "TESTINFO_ACTION")
    private String testinfoAction;           // TESTINFO_ACTION           <CLOB>
    @Lob
    @Column(name = "TESTINFO_EXPECTED_RESULTS")
    private String testinfoExpectedResults;  // TESTINFO_EXPECTED_RESULTS <CLOB>
    @Lob
    @Column(name = "TESTINFO_RESULT")
    private String testinfoResult;           // TESTINFO_RESULT           <CLOB>
    @Lob
    @Column(name = "VERIFY_FAIL_DESCRIPTION")
    private String verifyFailDescription;    // VERIFY_FAIL_DESCRIPTION   <CLOB>
    @Column(name = "SUBMITTED_FIRST_DATE")
    private Date submittedFirstDate;         // SUBMITTED_FIRST_DATE      <DATE>
    @Column(name = "SUBMITTED_LAST_DATE")
    private Date submittedLastDate;          // SUBMITTED_LAST_DATE       <DATE>
    @Column(name = "WAITING4SOL_FIRST_DATE")
    private Date waiting4solFirstDate;       // WAITING4SOL_FIRST_DATE    <DATE>
    @Column(name = "WAITING4SOL_LAST_DATE")
    private Date waiting4solLastDate;        // WAITING4SOL_LAST_DATE     <DATE>
    @Column(name = "DONE_FIRST_DATE")
    private Date doneFirstDate;              // DONE_FIRST_DATE           <DATE>
    @Column(name = "DONE_LAST_DATE")
    private Date doneLastDate;               // DONE_LAST_DATE            <DATE>
    @Column(name = "READY4PKG_FIRST_DATE")
    private Date ready4pkgFirstDate;         // READY4PKG_FIRST_DATE      <DATE>
    @Column(name = "READY4PKG_LAST_DATE")
    private Date ready4pkgLastDate;          // READY4PKG_LAST_DATE       <DATE>
    @Column(name = "POSTPONED_FIRST_DATE")
    private Date postponedFirstDate;         // POSTPONED_FIRST_DATE      <DATE>
    @Column(name = "POSTPONED_LAST_DATE")
    private Date postponedLastDate;          // POSTPONED_LAST_DATE       <DATE>
    @Column(name = "CRM")
    @Lob
    private String crm;                      // CRM                       <CLOB>
    @Lob
    @Column(name = "RELEASE_HISTORY")
    private String releaseHistory;           // RELEASE_HISTORY           <CLOB>

    public String getAnalysisBy() {
        return analysisBy;
    }

    public void setAnalysisBy(String analysisBy) {
        this.analysisBy = analysisBy;
    }

    public String getAnalysisDescription() {
        return analysisDescription;
    }

    public void setAnalysisDescription(String analysisDescription) {
        this.analysisDescription = analysisDescription;
    }

    public String getAnalysisModules() {
        return analysisModules;
    }

    public void setAnalysisModules(String analysisModules) {
        this.analysisModules = analysisModules;
    }

    public String getAssignToFullname() {
        return assignToFullname;
    }

    public void setAssignToFullname(String assignToFullname) {
        this.assignToFullname = assignToFullname;
    }

    public String getBehaviorOptions() {
        return behaviorOptions;
    }

    public void setBehaviorOptions(String behaviorOptions) {
        this.behaviorOptions = behaviorOptions;
    }

    public String getCbsModule() {
        return cbsModule;
    }

    public void setCbsModule(String cbsModule) {
        this.cbsModule = cbsModule;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDoneFirstDate() {
        return doneFirstDate;
    }

    public void setDoneFirstDate(Date doneFirstDate) {
        this.doneFirstDate = doneFirstDate;
    }

    public Date getDoneLastDate() {
        return doneLastDate;
    }

    public void setDoneLastDate(Date doneLastDate) {
        this.doneLastDate = doneLastDate;
    }

    public String getEffectOnService() {
        return effectOnService;
    }

    public void setEffectOnService(String effectOnService) {
        this.effectOnService = effectOnService;
    }

    public String getExternalDefectId() {
        return externalDefectId;
    }

    public void setExternalDefectId(String externalDefectId) {
        this.externalDefectId = externalDefectId;
    }

    public String getExternalDefectLink() {
        return externalDefectLink;
    }

    public void setExternalDefectLink(String externalDefectLink) {
        this.externalDefectLink = externalDefectLink;
    }

    public String getHistoryOfChanges() {
        return historyOfChanges;
    }

    public void setHistoryOfChanges(String historyOfChanges) {
        this.historyOfChanges = historyOfChanges;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getLargeAttachments() {
        return largeAttachments;
    }

    public void setLargeAttachments(String largeAttachments) {
        this.largeAttachments = largeAttachments;
    }

    public String getNotesEntry() {
        return notesEntry;
    }

    public void setNotesEntry(String notesEntry) {
        this.notesEntry = notesEntry;
    }

    public String getNotesLog() {
        return notesLog;
    }

    public void setNotesLog(String notesLog) {
        this.notesLog = notesLog;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getOdcCauseOfError() {
        return odcCauseOfError;
    }

    public void setOdcCauseOfError(String odcCauseOfError) {
        this.odcCauseOfError = odcCauseOfError;
    }

    public String getOdcDetectedOn() {
        return odcDetectedOn;
    }

    public void setOdcDetectedOn(String odcDetectedOn) {
        this.odcDetectedOn = odcDetectedOn;
    }

    public String getOdcDetectedWhile() {
        return odcDetectedWhile;
    }

    public void setOdcDetectedWhile(String odcDetectedWhile) {
        this.odcDetectedWhile = odcDetectedWhile;
    }

    public String getOdcImpact() {
        return odcImpact;
    }

    public void setOdcImpact(String odcImpact) {
        this.odcImpact = odcImpact;
    }

    public String getOdcProjectPhase() {
        return odcProjectPhase;
    }

    public void setOdcProjectPhase(String odcProjectPhase) {
        this.odcProjectPhase = odcProjectPhase;
    }

    public String getOdcQualifier() {
        return odcQualifier;
    }

    public void setOdcQualifier(String odcQualifier) {
        this.odcQualifier = odcQualifier;
    }

    public String getOdcSubTarget() {
        return odcSubTarget;
    }

    public void setOdcSubTarget(String odcSubTarget) {
        this.odcSubTarget = odcSubTarget;
    }

    public String getOdcTarget() {
        return odcTarget;
    }

    public void setOdcTarget(String odcTarget) {
        this.odcTarget = odcTarget;
    }

    public String getOdcTargetAge() {
        return odcTargetAge;
    }

    public void setOdcTargetAge(String odcTargetAge) {
        this.odcTargetAge = odcTargetAge;
    }

    public String getOdcTargetSource() {
        return odcTargetSource;
    }

    public void setOdcTargetSource(String odcTargetSource) {
        this.odcTargetSource = odcTargetSource;
    }

    public Date getPostponedFirstDate() {
        return postponedFirstDate;
    }

    public void setPostponedFirstDate(Date postponedFirstDate) {
        this.postponedFirstDate = postponedFirstDate;
    }

    public Date getPostponedLastDate() {
        return postponedLastDate;
    }

    public void setPostponedLastDate(Date postponedLastDate) {
        this.postponedLastDate = postponedLastDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getReady4pkgFirstDate() {
        return ready4pkgFirstDate;
    }

    public void setReady4pkgFirstDate(Date ready4pkgFirstDate) {
        this.ready4pkgFirstDate = ready4pkgFirstDate;
    }

    public Date getReady4pkgLastDate() {
        return ready4pkgLastDate;
    }

    public void setReady4pkgLastDate(Date ready4pkgLastDate) {
        this.ready4pkgLastDate = ready4pkgLastDate;
    }

    public String getReleaseHistory() {
        return releaseHistory;
    }

    public void setReleaseHistory(String releaseHistory) {
        this.releaseHistory = releaseHistory;
    }

    public Integer getReopenCount() {
        return reopenCount;
    }

    public void setReopenCount(Integer reopenCount) {
        this.reopenCount = reopenCount;
    }

    public String getReproduceRequestDetails() {
        return reproduceRequestDetails;
    }

    public void setReproduceRequestDetails(String reproduceRequestDetails) {
        this.reproduceRequestDetails = reproduceRequestDetails;
    }

    public String getReproducible() {
        return reproducible;
    }

    public void setReproducible(String reproducible) {
        this.reproducible = reproducible;
    }

    public String getRetestInstructions() {
        return retestInstructions;
    }

    public void setRetestInstructions(String retestInstructions) {
        this.retestInstructions = retestInstructions;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSetupComments() {
        return setupComments;
    }

    public void setSetupComments(String setupComments) {
        this.setupComments = setupComments;
    }

    public String getSetupTestEnvironments() {
        return setupTestEnvironments;
    }

    public void setSetupTestEnvironments(String setupTestEnvironments) {
        this.setupTestEnvironments = setupTestEnvironments;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getSolutionBy() {
        return solutionBy;
    }

    public void setSolutionBy(String solutionBy) {
        this.solutionBy = solutionBy;
    }

    public String getSolutionDescription() {
        return solutionDescription;
    }

    public void setSolutionDescription(String solutionDescription) {
        this.solutionDescription = solutionDescription;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getSubmittedFirstDate() {
        return submittedFirstDate;
    }

    public void setSubmittedFirstDate(Date submittedFirstDate) {
        this.submittedFirstDate = submittedFirstDate;
    }

    public Date getSubmittedLastDate() {
        return submittedLastDate;
    }

    public void setSubmittedLastDate(Date submittedLastDate) {
        this.submittedLastDate = submittedLastDate;
    }

    public String getTestinfoAction() {
        return testinfoAction;
    }

    public void setTestinfoAction(String testinfoAction) {
        this.testinfoAction = testinfoAction;
    }

    public String getTestinfoExpectedResults() {
        return testinfoExpectedResults;
    }

    public void setTestinfoExpectedResults(String testinfoExpectedResults) {
        this.testinfoExpectedResults = testinfoExpectedResults;
    }

    public String getTestinfoResult() {
        return testinfoResult;
    }

    public void setTestinfoResult(String testinfoResult) {
        this.testinfoResult = testinfoResult;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVerifyFailDescription() {
        return verifyFailDescription;
    }

    public void setVerifyFailDescription(String verifyFailDescription) {
        this.verifyFailDescription = verifyFailDescription;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getWaiting4solFirstDate() {
        return waiting4solFirstDate;
    }

    public void setWaiting4solFirstDate(Date waiting4solFirstDate) {
        this.waiting4solFirstDate = waiting4solFirstDate;
    }

    public Date getWaiting4solLastDate() {
        return waiting4solLastDate;
    }

    public void setWaiting4solLastDate(Date waiting4solLastDate) {
        this.waiting4solLastDate = waiting4solLastDate;
    }

    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }
    
    
  private static final long serialVersionUID = 11L;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Calllog)) {
            return false;
        }
        CQDefect other = (CQDefect) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kenan.tss.searchEngine.model.CQDefect[ id=" + id + " ]";
    }

}
