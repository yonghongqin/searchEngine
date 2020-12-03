/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.model.ddts;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author QINY
 */
@Entity
@Table(name = "defects")
@NamedQueries({
    @NamedQuery(name = "Defects.findAll", query = "SELECT d FROM Defects d")})
public class Defects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ACTION")
    private String action;
    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "ADDRESS3")
    private String address3;
    @Column(name = "ADDRESS4")
    private String address4;
    @Column(name = "ANALYZED_BY")
    private String analyzedBy;
    @Column(name = "APPENDIX")
    private String appendix;
    @Column(name = "APPROVAL_NEEDBY")
    @Temporal(TemporalType.DATE)
    private Date approvalNeedby;
    @Column(name = "APPROVAL_NEW_ON")
    @Temporal(TemporalType.DATE)
    private Date approvalNewOn;
    @Column(name = "APPROVER_ID")
    private String approverId;
    @Column(name = "ASSESSMENT")
    private String assessment;
    @Column(name = "ASSIGNED_ON")
    @Temporal(TemporalType.DATE)
    private Date assignedOn;
    @Column(name = "ASSIGNED_ON_WTIME")
    private String assignedOnWtime;
    @Column(name = "BRANCH")
    private String branch;
    @Column(name = "C1EMAIL")
    private String c1email;
    @Column(name = "C1MS")
    private String c1ms;
    @Column(name = "C1OTHER1")
    private String c1other1;
    @Column(name = "C1OTHER2")
    private String c1other2;
    @Column(name = "C1PHONE")
    private String c1phone;
    @Column(name = "C2EMAIL")
    private String c2email;
    @Column(name = "C2MS")
    private String c2ms;
    @Column(name = "C2OTHER1")
    private String c2other1;
    @Column(name = "C2OTHER2")
    private String c2other2;
    @Column(name = "C2PHONE")
    private String c2phone;
    @Column(name = "C3EMAIL")
    private String c3email;
    @Column(name = "C3MS")
    private String c3ms;
    @Column(name = "C3OTHER1")
    private String c3other1;
    @Column(name = "C3OTHER2")
    private String c3other2;
    @Column(name = "C3PHONE")
    private String c3phone;
    @Column(name = "C4EMAIL")
    private String c4email;
    @Column(name = "C4MS")
    private String c4ms;
    @Column(name = "C4OTHER1")
    private String c4other1;
    @Column(name = "C4OTHER2")
    private String c4other2;
    @Column(name = "C4PHONE")
    private String c4phone;
    @Column(name = "CPHONE")
    private String cphone;
    @Column(name = "CEMAIL")
    private String cemail;
    @Column(name = "CMS")
    private String cms;
    @Column(name = "COTHER1")
    private String cother1;
    @Column(name = "COTHER2")
    private String cother2;
    @Column(name = "CALL_TIME")
    private String callTime;
    @Column(name = "CALL_TYPE")
    private String callType;
    @Column(name = "CALL_RESULT")
    private String callResult;
    @Column(name = "CALL")
    private String call;
    @Column(name = "CHILDREN")
    private String children;
    @Column(name = "CLASS")
    private String class1;
    @Column(name = "CLONED_FROM")
    private String clonedFrom;
    @Column(name = "CLONED_TO")
    private String clonedTo;
    @Column(name = "CLOSED_ON")
    @Temporal(TemporalType.DATE)
    private Date closedOn;
    @Column(name = "CODE_REVIEW")
    private String codeReview;
    @Column(name = "CODING_QUEUE")
    private String codingQueue;
    @Column(name = "COMMITTED_FOR")
    @Temporal(TemporalType.DATE)
    private Date committedFor;
    @Column(name = "COMMITTED")
    private String committed;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "CONTACT1")
    private String contact1;
    @Column(name = "CONTACT2")
    private String contact2;
    @Column(name = "CONTACT3")
    private String contact3;
    @Column(name = "CONTACT4")
    private String contact4;
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "CORE_CHANGE")
    private String coreChange;
    @Column(name = "CUSTOMER")
    private String customer;
    @Column(name = "CUST_NUM")
    private String custNum;
    @Column(name = "DATE_NEEDBY")
    @Temporal(TemporalType.DATE)
    private Date dateNeedby;
    @Column(name = "DATE_REQUESTED_BY")
    @Temporal(TemporalType.DATE)
    private Date dateRequestedBy;
    @Column(name = "DBMS")
    private String dbms;
    @Column(name = "DDTS_MAIL_FROM")
    private String ddtsMailFrom;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "DESIGNER")
    private String designer;
    @Column(name = "DESIGN_ONE")
    private String designOne;
    @Column(name = "DESIGN_TWO")
    private String designTwo;
    @Column(name = "DESIGN_THREE")
    private String designThree;
    @Column(name = "DESIGN_FOUR")
    private String designFour;
    @Column(name = "DESIGN_FIVE")
    private String designFive;
    @Column(name = "DESIGN_SIX")
    private String designSix;
    @Column(name = "DEVELOPMENT_ONE")
    private String developmentOne;
    @Column(name = "DEVELOPMENT_TWO")
    private String developmentTwo;
    @Column(name = "DEVELOPMENT_THREE")
    private String developmentThree;
    @Column(name = "DEVELOPMENT_FOUR")
    private String developmentFour;
    @Column(name = "DEVELOPMENT_FIVE")
    private String developmentFive;
    @Column(name = "DEVELOPMENT_SIX")
    private String developmentSix;
    @Column(name = "DEV_ESTIMATE_ONE")
    private String devEstimateOne;
    @Column(name = "DEV_ESTIMATE_TWO")
    private String devEstimateTwo;
    @Column(name = "DEV_ESTIMATE_THREE")
    private String devEstimateThree;
    @Column(name = "DEV_ESTIMATE_FOUR")
    private String devEstimateFour;
    @Column(name = "DEV_ESTIMATE_FIVE")
    private String devEstimateFive;
    @Column(name = "DEV_ESTIMATE_SIX")
    private String devEstimateSix;
    @Column(name = "DEV_STATUS_ONE")
    private String devStatusOne;
    @Column(name = "DEV_STATUS_TWO")
    private String devStatusTwo;
    @Column(name = "DEV_STATUS_THREE")
    private String devStatusThree;
    @Column(name = "DEV_STATUS_FOUR")
    private String devStatusFour;
    @Column(name = "DEV_STATUS_FIVE")
    private String devStatusFive;
    @Column(name = "DEV_STATUS_SIX")
    private String devStatusSix;
    @Column(name = "DOC_CHANGE")
    private String docChange;
    @Column(name = "DOCUMENT")
    private String document;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Column(name = "DUPLICATE_OF")
    private String duplicateOf;
    @Column(name = "DUPLICATE_ON")
    @Temporal(TemporalType.DATE)
    private Date duplicateOn;
    @Column(name = "DUPLICATE_ON_WTIME")
    private String duplicateOnWtime;
    @Column(name = "ELEARNING_COURSE")
    private String elearningCourse;
    @Column(name = "ENCLOSURE_COUNT")
    private String enclosureCount;
    @Column(name = "ENGINEER")
    private String engineer;
    @Column(name = "ENGINEER_ONE")
    private String engineerOne;
    @Column(name = "ENGINEER_TWO")
    private String engineerTwo;
    @Column(name = "ENGINEER_THREE")
    private String engineerThree;
    @Column(name = "ENGINEER_FOUR")
    private String engineerFour;
    @Column(name = "ENGINEER_FIVE")
    private String engineerFive;
    @Column(name = "ENGINEER_SIX")
    private String engineerSix;
    @Column(name = "ENHANCE_ON")
    @Temporal(TemporalType.DATE)
    private Date enhanceOn;
    @Column(name = "ENHANCEMENT")
    private String enhancement;
    @Column(name = "ESTIMATED_ON")
    @Temporal(TemporalType.DATE)
    private Date estimatedOn;
    @Column(name = "EST_FIX_DATE")
    @Temporal(TemporalType.DATE)
    private Date estFixDate;
    @Column(name = "EST_FIX_HOURS")
    private String estFixHours;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "FIX_HOURS")
    private String fixHours;
    @Column(name = "FORMAT")
    private String format;
    @Column(name = "FORWARDED_FROM")
    private String forwardedFrom;
    @Column(name = "FORWARDED_ON")
    @Temporal(TemporalType.DATE)
    private Date forwardedOn;
    @Column(name = "FORWARDED_ON_WTIME")
    private String forwardedOnWtime;
    @Column(name = "FORWARDED_TO")
    private String forwardedTo;
    @Column(name = "GROUP_ONE")
    private String groupOne;
    @Column(name = "GROUP_TWO")
    private String groupTwo;
    @Column(name = "GROUP_THREE")
    private String groupThree;
    @Column(name = "GROUP_FOUR")
    private String groupFour;
    @Column(name = "GROUP_FIVE")
    private String groupFive;
    @Column(name = "GROUP_SIX")
    private String groupSix;
    @Column(name = "HARDWARE")
    private String hardware;
    @Column(name = "HEADLINE")
    private String headline;
    @Column(name = "HOW_FOUND")
    private String howFound;
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTIFIER")
    private String identifier;
    @Column(name = "IMPLEMENT_APP_ON")
    @Temporal(TemporalType.DATE)
    private Date implementAppOn;
    @Column(name = "INCLUDE_IN_METRICS")
    private String includeInMetrics;
    @Column(name = "INDUSTRY")
    private String industry;
    @Column(name = "IN_DEVELOPMENT_ON")
    @Temporal(TemporalType.DATE)
    private Date inDevelopmentOn;
    @Column(name = "INIT_FILE")
    private String initFile;
    @Column(name = "INSTRUCTOR_GUIDE")
    private String instructorGuide;
    @Column(name = "INTO_TEST_DATE")
    @Temporal(TemporalType.DATE)
    private Date intoTestDate;
    @Column(name = "JOB_AID")
    private String jobAid;
    @Column(name = "KSCCONTACT")
    private String ksccontact;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.DATE)
    private Date lastMod;
    @Column(name = "LINE")
    private String line;
    @Column(name = "MODULE")
    private String module;
    @Column(name = "MODULE_ONE")
    private String moduleOne;
    @Column(name = "MODULE_TWO")
    private String moduleTwo;
    @Column(name = "MODULE_THREE")
    private String moduleThree;
    @Column(name = "MODULE_FOUR")
    private String moduleFour;
    @Column(name = "MODULE_FIVE")
    private String moduleFive;
    @Column(name = "MODULE_SIX")
    private String moduleSix;
    @Column(name = "NEED_FIX_BY")
    private String needFixBy;
    @Column(name = "NEEDED_WHEN")
    private String neededWhen;
    @Column(name = "NEW_LAST_MOD")
    private String newLastMod;
    @Column(name = "NEW_ON")
    @Temporal(TemporalType.DATE)
    private Date newOn;
    @Column(name = "NEW_ON_WTIME")
    private String newOnWtime;
    @Column(name = "NON_CALL_TIME")
    private String nonCallTime;
    @Column(name = "OLD_IDENTIFIER")
    private String oldIdentifier;
    @Column(name = "OS_VERSION")
    private String osVersion;
    @Column(name = "OPENED_ON")
    @Temporal(TemporalType.DATE)
    private Date openedOn;
    @Column(name = "OPENED_ON_WTIME")
    private String openedOnWtime;
    @Column(name = "ORIGIN")
    private String origin;
    @Column(name = "OTHER")
    private String other;
    @Column(name = "PARAGRAPH")
    private String paragraph;
    @Column(name = "PARENTS")
    private String parents;
    @Column(name = "PARTICIPANT_GUIDE")
    private String participantGuide;
    @Column(name = "PATCH")
    private String patch;
    @Column(name = "PATCH_NAME")
    private String patchName;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "POSTPONED_ON")
    @Temporal(TemporalType.DATE)
    private Date postponedOn;
    @Column(name = "POSTPONED_ON_WTIME")
    private String postponedOnWtime;
    @Column(name = "POWERPOINT_SLIDE")
    private String powerpointSlide;
    @Column(name = "PRE_POST_TEST")
    private String prePostTest;
    @Column(name = "PRIORITY")
    private String priority;
    @Column(name = "PROBLEM_TYPE")
    private String problemType;
    @Column(name = "PRODUCT")
    private String product;
    @Column(name = "PROJECT")
    private String project;
    @Column(name = "READ_ME_FILE")
    private String readMeFile;
    @Column(name = "READY_FOR_TEST_NEEDBY")
    @Temporal(TemporalType.DATE)
    private Date readyForTestNeedby;
    @Column(name = "READY_FOR_TEST_ON")
    @Temporal(TemporalType.DATE)
    private Date readyForTestOn;
    @Column(name = "READY_FOR_TEST_ON_WTIME")
    private String readyForTestOnWtime;
    @Column(name = "REGIONAL")
    private String regional;
    @Column(name = "REJECTED_ON")
    @Temporal(TemporalType.DATE)
    private Date rejectedOn;
    @Column(name = "REQUEST")
    private String request;
    @Column(name = "RESOLVED_IN")
    private String resolvedIn;
    @Column(name = "RETURNED_ON")
    private String returnedOn;
    @Column(name = "RETURNED_ON_WTIME")
    private String returnedOnWtime;
    @Column(name = "REL_NEEDBY")
    @Temporal(TemporalType.DATE)
    private Date relNeedby;
    @Column(name = "RE_OPENED_ON")
    @Temporal(TemporalType.DATE)
    private Date reOpenedOn;
    @Column(name = "RE_OPENED_ON_WTIME")
    private String reOpenedOnWtime;
    @Column(name = "REQUEST_TYPE")
    private String requestType;
    @Column(name = "RESOLUTION")
    private String resolution;
    @Column(name = "RESOLVED_ON")
    @Temporal(TemporalType.DATE)
    private Date resolvedOn;
    @Column(name = "RESOLVED_ON_DATE")
    @Temporal(TemporalType.DATE)
    private Date resolvedOnDate;
    @Column(name = "RESOLVED_ON_WTIME")
    private String resolvedOnWtime;
    @Column(name = "RESOLVER_ID")
    private String resolverId;
    @Column(name = "RETURN_PATH")
    private String returnPath;
    @Column(name = "ROOT_CAUSE")
    private String rootCause;
    @Column(name = "SCHED_APPROVED_ON")
    @Temporal(TemporalType.DATE)
    private Date schedApprovedOn;
    @Column(name = "SCRIPT")
    private String script;
    @Column(name = "SECTION")
    private String section;
    @Column(name = "SEVERITY")
    private String severity;
    @Column(name = "SHOWSTOPPER")
    private String showstopper;
    @Column(name = "SMILE_SHEET")
    private String smileSheet;
    @Column(name = "SOFTWARE")
    private String software;
    @Column(name = "SPONSOR")
    private String sponsor;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SUBMITTED_ON")
    @Temporal(TemporalType.DATE)
    private Date submittedOn;
    @Column(name = "SUBMITTER_ID")
    private String submitterId;
    @Column(name = "SUBMITTER_NAME")
    private String submitterName;
    @Column(name = "SUBMITTER_PATH")
    private String submitterPath;
    @Column(name = "SUPPORT_EXP")
    @Temporal(TemporalType.DATE)
    private Date supportExp;
    @Column(name = "TASK_NUM")
    private String taskNum;
    @Column(name = "TASK_OWNER")
    private String taskOwner;
    @Column(name = "TEMP_RES_ID")
    private String tempResId;
    @Column(name = "TEMP_RES_ON")
    @Temporal(TemporalType.DATE)
    private Date tempResOn;
    @Column(name = "TEMP_RESOLUTION")
    private String tempResolution;
    @Column(name = "TESTER")
    private String tester;
    @Column(name = "TRACKER")
    private String tracker;
    @Column(name = "TRIAGE_ON")
    @Temporal(TemporalType.DATE)
    private Date triageOn;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "VERIFIED_ON")
    @Temporal(TemporalType.DATE)
    private Date verifiedOn;
    @Column(name = "VERIFIED_ON_WTIME")
    private String verifiedOnWtime;
    @Column(name = "VERIFIER_ID")
    private String verifierId;
    @Column(name = "VERSION")
    private String version;
    @Column(name = "VERSIONS_AFFECTED")
    private String versionsAffected;
    @Column(name = "VERSIONS_FIXED")
    private String versionsFixed;
    @Column(name = "VERSIONS_TESTED")
    private String versionsTested;
    @Column(name = "DDTS_VIEW")
    private String ddtsView;
    @Column(name = "WAITING_ESTIMATE_ON")
    @Temporal(TemporalType.DATE)
    private Date waitingEstimateOn;
    @Column(name = "WHEN_CAUSED")
    private String whenCaused;
    @Column(name = "WHEN_FIXED")
    private String whenFixed;
    @Column(name = "WHEN_FOUND")
    private String whenFound;
    @Column(name = "WORD")
    private String word;
    @Column(name = "WORK_EST")
    private String workEst;
    @Column(name = "WORK_QUEUE")
    private String workQueue;

    public Defects() {
    }

    public Defects(String identifier) {
        this.identifier = identifier;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAnalyzedBy() {
        return analyzedBy;
    }

    public void setAnalyzedBy(String analyzedBy) {
        this.analyzedBy = analyzedBy;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public Date getApprovalNeedby() {
        return approvalNeedby;
    }

    public void setApprovalNeedby(Date approvalNeedby) {
        this.approvalNeedby = approvalNeedby;
    }

    public Date getApprovalNewOn() {
        return approvalNewOn;
    }

    public void setApprovalNewOn(Date approvalNewOn) {
        this.approvalNewOn = approvalNewOn;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public Date getAssignedOn() {
        return assignedOn;
    }

    public void setAssignedOn(Date assignedOn) {
        this.assignedOn = assignedOn;
    }

    public String getAssignedOnWtime() {
        return assignedOnWtime;
    }

    public void setAssignedOnWtime(String assignedOnWtime) {
        this.assignedOnWtime = assignedOnWtime;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getC1email() {
        return c1email;
    }

    public void setC1email(String c1email) {
        this.c1email = c1email;
    }

    public String getC1ms() {
        return c1ms;
    }

    public void setC1ms(String c1ms) {
        this.c1ms = c1ms;
    }

    public String getC1other1() {
        return c1other1;
    }

    public void setC1other1(String c1other1) {
        this.c1other1 = c1other1;
    }

    public String getC1other2() {
        return c1other2;
    }

    public void setC1other2(String c1other2) {
        this.c1other2 = c1other2;
    }

    public String getC1phone() {
        return c1phone;
    }

    public void setC1phone(String c1phone) {
        this.c1phone = c1phone;
    }

    public String getC2email() {
        return c2email;
    }

    public void setC2email(String c2email) {
        this.c2email = c2email;
    }

    public String getC2ms() {
        return c2ms;
    }

    public void setC2ms(String c2ms) {
        this.c2ms = c2ms;
    }

    public String getC2other1() {
        return c2other1;
    }

    public void setC2other1(String c2other1) {
        this.c2other1 = c2other1;
    }

    public String getC2other2() {
        return c2other2;
    }

    public void setC2other2(String c2other2) {
        this.c2other2 = c2other2;
    }

    public String getC2phone() {
        return c2phone;
    }

    public void setC2phone(String c2phone) {
        this.c2phone = c2phone;
    }

    public String getC3email() {
        return c3email;
    }

    public void setC3email(String c3email) {
        this.c3email = c3email;
    }

    public String getC3ms() {
        return c3ms;
    }

    public void setC3ms(String c3ms) {
        this.c3ms = c3ms;
    }

    public String getC3other1() {
        return c3other1;
    }

    public void setC3other1(String c3other1) {
        this.c3other1 = c3other1;
    }

    public String getC3other2() {
        return c3other2;
    }

    public void setC3other2(String c3other2) {
        this.c3other2 = c3other2;
    }

    public String getC3phone() {
        return c3phone;
    }

    public void setC3phone(String c3phone) {
        this.c3phone = c3phone;
    }

    public String getC4email() {
        return c4email;
    }

    public void setC4email(String c4email) {
        this.c4email = c4email;
    }

    public String getC4ms() {
        return c4ms;
    }

    public void setC4ms(String c4ms) {
        this.c4ms = c4ms;
    }

    public String getC4other1() {
        return c4other1;
    }

    public void setC4other1(String c4other1) {
        this.c4other1 = c4other1;
    }

    public String getC4other2() {
        return c4other2;
    }

    public void setC4other2(String c4other2) {
        this.c4other2 = c4other2;
    }

    public String getC4phone() {
        return c4phone;
    }

    public void setC4phone(String c4phone) {
        this.c4phone = c4phone;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCms() {
        return cms;
    }

    public void setCms(String cms) {
        this.cms = cms;
    }

    public String getCother1() {
        return cother1;
    }

    public void setCother1(String cother1) {
        this.cother1 = cother1;
    }

    public String getCother2() {
        return cother2;
    }

    public void setCother2(String cother2) {
        this.cother2 = cother2;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCallResult() {
        return callResult;
    }

    public void setCallResult(String callResult) {
        this.callResult = callResult;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClonedFrom() {
        return clonedFrom;
    }

    public void setClonedFrom(String clonedFrom) {
        this.clonedFrom = clonedFrom;
    }

    public String getClonedTo() {
        return clonedTo;
    }

    public void setClonedTo(String clonedTo) {
        this.clonedTo = clonedTo;
    }

    public Date getClosedOn() {
        return closedOn;
    }

    public void setClosedOn(Date closedOn) {
        this.closedOn = closedOn;
    }

    public String getCodeReview() {
        return codeReview;
    }

    public void setCodeReview(String codeReview) {
        this.codeReview = codeReview;
    }

    public String getCodingQueue() {
        return codingQueue;
    }

    public void setCodingQueue(String codingQueue) {
        this.codingQueue = codingQueue;
    }

    public Date getCommittedFor() {
        return committedFor;
    }

    public void setCommittedFor(Date committedFor) {
        this.committedFor = committedFor;
    }

    public String getCommitted() {
        return committed;
    }

    public void setCommitted(String committed) {
        this.committed = committed;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getContact3() {
        return contact3;
    }

    public void setContact3(String contact3) {
        this.contact3 = contact3;
    }

    public String getContact4() {
        return contact4;
    }

    public void setContact4(String contact4) {
        this.contact4 = contact4;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCoreChange() {
        return coreChange;
    }

    public void setCoreChange(String coreChange) {
        this.coreChange = coreChange;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustNum() {
        return custNum;
    }

    public void setCustNum(String custNum) {
        this.custNum = custNum;
    }

    public Date getDateNeedby() {
        return dateNeedby;
    }

    public void setDateNeedby(Date dateNeedby) {
        this.dateNeedby = dateNeedby;
    }

    public Date getDateRequestedBy() {
        return dateRequestedBy;
    }

    public void setDateRequestedBy(Date dateRequestedBy) {
        this.dateRequestedBy = dateRequestedBy;
    }

    public String getDbms() {
        return dbms;
    }

    public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    public String getDdtsMailFrom() {
        return ddtsMailFrom;
    }

    public void setDdtsMailFrom(String ddtsMailFrom) {
        this.ddtsMailFrom = ddtsMailFrom;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getDesignOne() {
        return designOne;
    }

    public void setDesignOne(String designOne) {
        this.designOne = designOne;
    }

    public String getDesignTwo() {
        return designTwo;
    }

    public void setDesignTwo(String designTwo) {
        this.designTwo = designTwo;
    }

    public String getDesignThree() {
        return designThree;
    }

    public void setDesignThree(String designThree) {
        this.designThree = designThree;
    }

    public String getDesignFour() {
        return designFour;
    }

    public void setDesignFour(String designFour) {
        this.designFour = designFour;
    }

    public String getDesignFive() {
        return designFive;
    }

    public void setDesignFive(String designFive) {
        this.designFive = designFive;
    }

    public String getDesignSix() {
        return designSix;
    }

    public void setDesignSix(String designSix) {
        this.designSix = designSix;
    }

    public String getDevelopmentOne() {
        return developmentOne;
    }

    public void setDevelopmentOne(String developmentOne) {
        this.developmentOne = developmentOne;
    }

    public String getDevelopmentTwo() {
        return developmentTwo;
    }

    public void setDevelopmentTwo(String developmentTwo) {
        this.developmentTwo = developmentTwo;
    }

    public String getDevelopmentThree() {
        return developmentThree;
    }

    public void setDevelopmentThree(String developmentThree) {
        this.developmentThree = developmentThree;
    }

    public String getDevelopmentFour() {
        return developmentFour;
    }

    public void setDevelopmentFour(String developmentFour) {
        this.developmentFour = developmentFour;
    }

    public String getDevelopmentFive() {
        return developmentFive;
    }

    public void setDevelopmentFive(String developmentFive) {
        this.developmentFive = developmentFive;
    }

    public String getDevelopmentSix() {
        return developmentSix;
    }

    public void setDevelopmentSix(String developmentSix) {
        this.developmentSix = developmentSix;
    }

    public String getDevEstimateOne() {
        return devEstimateOne;
    }

    public void setDevEstimateOne(String devEstimateOne) {
        this.devEstimateOne = devEstimateOne;
    }

    public String getDevEstimateTwo() {
        return devEstimateTwo;
    }

    public void setDevEstimateTwo(String devEstimateTwo) {
        this.devEstimateTwo = devEstimateTwo;
    }

    public String getDevEstimateThree() {
        return devEstimateThree;
    }

    public void setDevEstimateThree(String devEstimateThree) {
        this.devEstimateThree = devEstimateThree;
    }

    public String getDevEstimateFour() {
        return devEstimateFour;
    }

    public void setDevEstimateFour(String devEstimateFour) {
        this.devEstimateFour = devEstimateFour;
    }

    public String getDevEstimateFive() {
        return devEstimateFive;
    }

    public void setDevEstimateFive(String devEstimateFive) {
        this.devEstimateFive = devEstimateFive;
    }

    public String getDevEstimateSix() {
        return devEstimateSix;
    }

    public void setDevEstimateSix(String devEstimateSix) {
        this.devEstimateSix = devEstimateSix;
    }

    public String getDevStatusOne() {
        return devStatusOne;
    }

    public void setDevStatusOne(String devStatusOne) {
        this.devStatusOne = devStatusOne;
    }

    public String getDevStatusTwo() {
        return devStatusTwo;
    }

    public void setDevStatusTwo(String devStatusTwo) {
        this.devStatusTwo = devStatusTwo;
    }

    public String getDevStatusThree() {
        return devStatusThree;
    }

    public void setDevStatusThree(String devStatusThree) {
        this.devStatusThree = devStatusThree;
    }

    public String getDevStatusFour() {
        return devStatusFour;
    }

    public void setDevStatusFour(String devStatusFour) {
        this.devStatusFour = devStatusFour;
    }

    public String getDevStatusFive() {
        return devStatusFive;
    }

    public void setDevStatusFive(String devStatusFive) {
        this.devStatusFive = devStatusFive;
    }

    public String getDevStatusSix() {
        return devStatusSix;
    }

    public void setDevStatusSix(String devStatusSix) {
        this.devStatusSix = devStatusSix;
    }

    public String getDocChange() {
        return docChange;
    }

    public void setDocChange(String docChange) {
        this.docChange = docChange;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDuplicateOf() {
        return duplicateOf;
    }

    public void setDuplicateOf(String duplicateOf) {
        this.duplicateOf = duplicateOf;
    }

    public Date getDuplicateOn() {
        return duplicateOn;
    }

    public void setDuplicateOn(Date duplicateOn) {
        this.duplicateOn = duplicateOn;
    }

    public String getDuplicateOnWtime() {
        return duplicateOnWtime;
    }

    public void setDuplicateOnWtime(String duplicateOnWtime) {
        this.duplicateOnWtime = duplicateOnWtime;
    }

    public String getElearningCourse() {
        return elearningCourse;
    }

    public void setElearningCourse(String elearningCourse) {
        this.elearningCourse = elearningCourse;
    }

    public String getEnclosureCount() {
        return enclosureCount;
    }

    public void setEnclosureCount(String enclosureCount) {
        this.enclosureCount = enclosureCount;
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public String getEngineerOne() {
        return engineerOne;
    }

    public void setEngineerOne(String engineerOne) {
        this.engineerOne = engineerOne;
    }

    public String getEngineerTwo() {
        return engineerTwo;
    }

    public void setEngineerTwo(String engineerTwo) {
        this.engineerTwo = engineerTwo;
    }

    public String getEngineerThree() {
        return engineerThree;
    }

    public void setEngineerThree(String engineerThree) {
        this.engineerThree = engineerThree;
    }

    public String getEngineerFour() {
        return engineerFour;
    }

    public void setEngineerFour(String engineerFour) {
        this.engineerFour = engineerFour;
    }

    public String getEngineerFive() {
        return engineerFive;
    }

    public void setEngineerFive(String engineerFive) {
        this.engineerFive = engineerFive;
    }

    public String getEngineerSix() {
        return engineerSix;
    }

    public void setEngineerSix(String engineerSix) {
        this.engineerSix = engineerSix;
    }

    public Date getEnhanceOn() {
        return enhanceOn;
    }

    public void setEnhanceOn(Date enhanceOn) {
        this.enhanceOn = enhanceOn;
    }

    public String getEnhancement() {
        return enhancement;
    }

    public void setEnhancement(String enhancement) {
        this.enhancement = enhancement;
    }

    public Date getEstimatedOn() {
        return estimatedOn;
    }

    public void setEstimatedOn(Date estimatedOn) {
        this.estimatedOn = estimatedOn;
    }

    public Date getEstFixDate() {
        return estFixDate;
    }

    public void setEstFixDate(Date estFixDate) {
        this.estFixDate = estFixDate;
    }

    public String getEstFixHours() {
        return estFixHours;
    }

    public void setEstFixHours(String estFixHours) {
        this.estFixHours = estFixHours;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFixHours() {
        return fixHours;
    }

    public void setFixHours(String fixHours) {
        this.fixHours = fixHours;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getForwardedFrom() {
        return forwardedFrom;
    }

    public void setForwardedFrom(String forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
    }

    public Date getForwardedOn() {
        return forwardedOn;
    }

    public void setForwardedOn(Date forwardedOn) {
        this.forwardedOn = forwardedOn;
    }

    public String getForwardedOnWtime() {
        return forwardedOnWtime;
    }

    public void setForwardedOnWtime(String forwardedOnWtime) {
        this.forwardedOnWtime = forwardedOnWtime;
    }

    public String getForwardedTo() {
        return forwardedTo;
    }

    public void setForwardedTo(String forwardedTo) {
        this.forwardedTo = forwardedTo;
    }

    public String getGroupOne() {
        return groupOne;
    }

    public void setGroupOne(String groupOne) {
        this.groupOne = groupOne;
    }

    public String getGroupTwo() {
        return groupTwo;
    }

    public void setGroupTwo(String groupTwo) {
        this.groupTwo = groupTwo;
    }

    public String getGroupThree() {
        return groupThree;
    }

    public void setGroupThree(String groupThree) {
        this.groupThree = groupThree;
    }

    public String getGroupFour() {
        return groupFour;
    }

    public void setGroupFour(String groupFour) {
        this.groupFour = groupFour;
    }

    public String getGroupFive() {
        return groupFive;
    }

    public void setGroupFive(String groupFive) {
        this.groupFive = groupFive;
    }

    public String getGroupSix() {
        return groupSix;
    }

    public void setGroupSix(String groupSix) {
        this.groupSix = groupSix;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getHowFound() {
        return howFound;
    }

    public void setHowFound(String howFound) {
        this.howFound = howFound;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getImplementAppOn() {
        return implementAppOn;
    }

    public void setImplementAppOn(Date implementAppOn) {
        this.implementAppOn = implementAppOn;
    }

    public String getIncludeInMetrics() {
        return includeInMetrics;
    }

    public void setIncludeInMetrics(String includeInMetrics) {
        this.includeInMetrics = includeInMetrics;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Date getInDevelopmentOn() {
        return inDevelopmentOn;
    }

    public void setInDevelopmentOn(Date inDevelopmentOn) {
        this.inDevelopmentOn = inDevelopmentOn;
    }

    public String getInitFile() {
        return initFile;
    }

    public void setInitFile(String initFile) {
        this.initFile = initFile;
    }

    public String getInstructorGuide() {
        return instructorGuide;
    }

    public void setInstructorGuide(String instructorGuide) {
        this.instructorGuide = instructorGuide;
    }

    public Date getIntoTestDate() {
        return intoTestDate;
    }

    public void setIntoTestDate(Date intoTestDate) {
        this.intoTestDate = intoTestDate;
    }

    public String getJobAid() {
        return jobAid;
    }

    public void setJobAid(String jobAid) {
        this.jobAid = jobAid;
    }

    public String getKsccontact() {
        return ksccontact;
    }

    public void setKsccontact(String ksccontact) {
        this.ksccontact = ksccontact;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModuleOne() {
        return moduleOne;
    }

    public void setModuleOne(String moduleOne) {
        this.moduleOne = moduleOne;
    }

    public String getModuleTwo() {
        return moduleTwo;
    }

    public void setModuleTwo(String moduleTwo) {
        this.moduleTwo = moduleTwo;
    }

    public String getModuleThree() {
        return moduleThree;
    }

    public void setModuleThree(String moduleThree) {
        this.moduleThree = moduleThree;
    }

    public String getModuleFour() {
        return moduleFour;
    }

    public void setModuleFour(String moduleFour) {
        this.moduleFour = moduleFour;
    }

    public String getModuleFive() {
        return moduleFive;
    }

    public void setModuleFive(String moduleFive) {
        this.moduleFive = moduleFive;
    }

    public String getModuleSix() {
        return moduleSix;
    }

    public void setModuleSix(String moduleSix) {
        this.moduleSix = moduleSix;
    }

    public String getNeedFixBy() {
        return needFixBy;
    }

    public void setNeedFixBy(String needFixBy) {
        this.needFixBy = needFixBy;
    }

    public String getNeededWhen() {
        return neededWhen;
    }

    public void setNeededWhen(String neededWhen) {
        this.neededWhen = neededWhen;
    }

    public String getNewLastMod() {
        return newLastMod;
    }

    public void setNewLastMod(String newLastMod) {
        this.newLastMod = newLastMod;
    }

    public Date getNewOn() {
        return newOn;
    }

    public void setNewOn(Date newOn) {
        this.newOn = newOn;
    }

    public String getNewOnWtime() {
        return newOnWtime;
    }

    public void setNewOnWtime(String newOnWtime) {
        this.newOnWtime = newOnWtime;
    }

    public String getNonCallTime() {
        return nonCallTime;
    }

    public void setNonCallTime(String nonCallTime) {
        this.nonCallTime = nonCallTime;
    }

    public String getOldIdentifier() {
        return oldIdentifier;
    }

    public void setOldIdentifier(String oldIdentifier) {
        this.oldIdentifier = oldIdentifier;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public Date getOpenedOn() {
        return openedOn;
    }

    public void setOpenedOn(Date openedOn) {
        this.openedOn = openedOn;
    }

    public String getOpenedOnWtime() {
        return openedOnWtime;
    }

    public void setOpenedOnWtime(String openedOnWtime) {
        this.openedOnWtime = openedOnWtime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getParticipantGuide() {
        return participantGuide;
    }

    public void setParticipantGuide(String participantGuide) {
        this.participantGuide = participantGuide;
    }

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public String getPatchName() {
        return patchName;
    }

    public void setPatchName(String patchName) {
        this.patchName = patchName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getPostponedOn() {
        return postponedOn;
    }

    public void setPostponedOn(Date postponedOn) {
        this.postponedOn = postponedOn;
    }

    public String getPostponedOnWtime() {
        return postponedOnWtime;
    }

    public void setPostponedOnWtime(String postponedOnWtime) {
        this.postponedOnWtime = postponedOnWtime;
    }

    public String getPowerpointSlide() {
        return powerpointSlide;
    }

    public void setPowerpointSlide(String powerpointSlide) {
        this.powerpointSlide = powerpointSlide;
    }

    public String getPrePostTest() {
        return prePostTest;
    }

    public void setPrePostTest(String prePostTest) {
        this.prePostTest = prePostTest;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getReadMeFile() {
        return readMeFile;
    }

    public void setReadMeFile(String readMeFile) {
        this.readMeFile = readMeFile;
    }

    public Date getReadyForTestNeedby() {
        return readyForTestNeedby;
    }

    public void setReadyForTestNeedby(Date readyForTestNeedby) {
        this.readyForTestNeedby = readyForTestNeedby;
    }

    public Date getReadyForTestOn() {
        return readyForTestOn;
    }

    public void setReadyForTestOn(Date readyForTestOn) {
        this.readyForTestOn = readyForTestOn;
    }

    public String getReadyForTestOnWtime() {
        return readyForTestOnWtime;
    }

    public void setReadyForTestOnWtime(String readyForTestOnWtime) {
        this.readyForTestOnWtime = readyForTestOnWtime;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public Date getRejectedOn() {
        return rejectedOn;
    }

    public void setRejectedOn(Date rejectedOn) {
        this.rejectedOn = rejectedOn;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResolvedIn() {
        return resolvedIn;
    }

    public void setResolvedIn(String resolvedIn) {
        this.resolvedIn = resolvedIn;
    }

    public String getReturnedOn() {
        return returnedOn;
    }

    public void setReturnedOn(String returnedOn) {
        this.returnedOn = returnedOn;
    }

    public String getReturnedOnWtime() {
        return returnedOnWtime;
    }

    public void setReturnedOnWtime(String returnedOnWtime) {
        this.returnedOnWtime = returnedOnWtime;
    }

    public Date getRelNeedby() {
        return relNeedby;
    }

    public void setRelNeedby(Date relNeedby) {
        this.relNeedby = relNeedby;
    }

    public Date getReOpenedOn() {
        return reOpenedOn;
    }

    public void setReOpenedOn(Date reOpenedOn) {
        this.reOpenedOn = reOpenedOn;
    }

    public String getReOpenedOnWtime() {
        return reOpenedOnWtime;
    }

    public void setReOpenedOnWtime(String reOpenedOnWtime) {
        this.reOpenedOnWtime = reOpenedOnWtime;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Date getResolvedOn() {
        return resolvedOn;
    }

    public void setResolvedOn(Date resolvedOn) {
        this.resolvedOn = resolvedOn;
    }

    public Date getResolvedOnDate() {
        return resolvedOnDate;
    }

    public void setResolvedOnDate(Date resolvedOnDate) {
        this.resolvedOnDate = resolvedOnDate;
    }

    public String getResolvedOnWtime() {
        return resolvedOnWtime;
    }

    public void setResolvedOnWtime(String resolvedOnWtime) {
        this.resolvedOnWtime = resolvedOnWtime;
    }

    public String getResolverId() {
        return resolverId;
    }

    public void setResolverId(String resolverId) {
        this.resolverId = resolverId;
    }

    public String getReturnPath() {
        return returnPath;
    }

    public void setReturnPath(String returnPath) {
        this.returnPath = returnPath;
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

    public Date getSchedApprovedOn() {
        return schedApprovedOn;
    }

    public void setSchedApprovedOn(Date schedApprovedOn) {
        this.schedApprovedOn = schedApprovedOn;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getShowstopper() {
        return showstopper;
    }

    public void setShowstopper(String showstopper) {
        this.showstopper = showstopper;
    }

    public String getSmileSheet() {
        return smileSheet;
    }

    public void setSmileSheet(String smileSheet) {
        this.smileSheet = smileSheet;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public String getSubmitterPath() {
        return submitterPath;
    }

    public void setSubmitterPath(String submitterPath) {
        this.submitterPath = submitterPath;
    }

    public Date getSupportExp() {
        return supportExp;
    }

    public void setSupportExp(Date supportExp) {
        this.supportExp = supportExp;
    }

    public String getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(String taskNum) {
        this.taskNum = taskNum;
    }

    public String getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(String taskOwner) {
        this.taskOwner = taskOwner;
    }

    public String getTempResId() {
        return tempResId;
    }

    public void setTempResId(String tempResId) {
        this.tempResId = tempResId;
    }

    public Date getTempResOn() {
        return tempResOn;
    }

    public void setTempResOn(Date tempResOn) {
        this.tempResOn = tempResOn;
    }

    public String getTempResolution() {
        return tempResolution;
    }

    public void setTempResolution(String tempResolution) {
        this.tempResolution = tempResolution;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    public Date getTriageOn() {
        return triageOn;
    }

    public void setTriageOn(Date triageOn) {
        this.triageOn = triageOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getVerifiedOn() {
        return verifiedOn;
    }

    public void setVerifiedOn(Date verifiedOn) {
        this.verifiedOn = verifiedOn;
    }

    public String getVerifiedOnWtime() {
        return verifiedOnWtime;
    }

    public void setVerifiedOnWtime(String verifiedOnWtime) {
        this.verifiedOnWtime = verifiedOnWtime;
    }

    public String getVerifierId() {
        return verifierId;
    }

    public void setVerifierId(String verifierId) {
        this.verifierId = verifierId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionsAffected() {
        return versionsAffected;
    }

    public void setVersionsAffected(String versionsAffected) {
        this.versionsAffected = versionsAffected;
    }

    public String getVersionsFixed() {
        return versionsFixed;
    }

    public void setVersionsFixed(String versionsFixed) {
        this.versionsFixed = versionsFixed;
    }

    public String getVersionsTested() {
        return versionsTested;
    }

    public void setVersionsTested(String versionsTested) {
        this.versionsTested = versionsTested;
    }

    public String getDdtsView() {
        return ddtsView;
    }

    public void setDdtsView(String ddtsView) {
        this.ddtsView = ddtsView;
    }

    public Date getWaitingEstimateOn() {
        return waitingEstimateOn;
    }

    public void setWaitingEstimateOn(Date waitingEstimateOn) {
        this.waitingEstimateOn = waitingEstimateOn;
    }

    public String getWhenCaused() {
        return whenCaused;
    }

    public void setWhenCaused(String whenCaused) {
        this.whenCaused = whenCaused;
    }

    public String getWhenFixed() {
        return whenFixed;
    }

    public void setWhenFixed(String whenFixed) {
        this.whenFixed = whenFixed;
    }

    public String getWhenFound() {
        return whenFound;
    }

    public void setWhenFound(String whenFound) {
        this.whenFound = whenFound;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWorkEst() {
        return workEst;
    }

    public void setWorkEst(String workEst) {
        this.workEst = workEst;
    }

    public String getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(String workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identifier != null ? identifier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Defects)) {
            return false;
        }
        Defects other = (Defects) object;
        if ((this.identifier == null && other.identifier != null) || (this.identifier != null && !this.identifier.equals(other.identifier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amdocs.optima.searchEngine.model.ddts.Defects[ identifier=" + identifier + " ]";
    }
    
}
