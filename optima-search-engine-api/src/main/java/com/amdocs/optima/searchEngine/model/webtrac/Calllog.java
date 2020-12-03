/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.model.webtrac;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author QINY
 */
@Entity
public class Calllog implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "CALLID")
    private String callid;
    @Column(name = "CUSTID")
    private String custid;
    @Column(name = "CUSTTYPE")
    private String custtype;
    @Column(name = "CALLTYPE")
    private String calltype;
    @Column(name = "TRACKER")
    private String tracker;
    @Column(name = "CALLSTATUS")
    private String callstatus;
    @Column(name = "PRIORITY")
    private String priority;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CDURATION")
    private BigDecimal cduration;
    @Column(name = "CALLCOUNT")
    private BigDecimal callcount;
    @Column(name = "STOPWATCH")
    private BigDecimal stopwatch;
    @Column(name = "CLOSEDBY")
    private String closedby;
    @Column(name = "CLOSEDDATE")
    private String closeddate;
    @Column(name = "CLOSEDTIME")
    private String closedtime;
    @Column(name = "CAUSE")
    private String cause;
    @Column(name = "RECVDBY")
    private String recvdby;
    @Column(name = "RECVDDATE")
    private String recvddate;
    @Column(name = "RECVDTIME")
    private String recvdtime;
    @Column(name = "MODBY")
    private String modby;
    @Column(name = "MODDATE")
    private String moddate;
    @Column(name = "MODTIME")
    private String modtime;
    @Column(name = "DTLASTMOD")
    private Long dtlastmod;
    @Column(name = "CALLSOURCE")
    private String callsource;
    @Column(name = "QUICKCALL")
    private String quickcall;
    @Column(name = "CALLSTATUS_REASON")
    private String callstatusReason;
    @Column(name = "SEVERITY")
    private String severity;
    @Column(name = "ACTUAL_OCCURED_DATE")
    private String actualOccuredDate;
    @Column(name = "RESPOND_DATE")
    private String respondDate;
    @Column(name = "RESOLVE_DATE")
    private String resolveDate;
    @Column(name = "RESTORE_DATE")
    private String restoreDate;
    @Column(name = "ADD_TO_KB")
    private String addToKb;
    @Column(name = "WORKAROUND_EXISTS")
    private String workaroundExists;
    @Column(name = "SHORT_DESCRIPTION")
    private String shortDescription;
    @Column(name = "CURRENT_SUMMARY")
    private String currentSummary;
    @Column(name = "IS_PRODUCTION")
    private String isProduction;
    @Column(name = "IS_REGRESSION")
    private String isRegression;
    @Column(name = "ADVOCATE")
    private String advocate;
    @Column(name = "OUTAGE")
    private String outage;
    @Column(name = "PRIORITY_NAME")
    private String priorityName;
    @Column(name = "SEVERITY_NAME")
    private String severityName;
    @Column(name = "ACTUAL_OCCURRED_TIME")
    private String actualOccurredTime;
    @Column(name = "ACTUAL_OCCURRED_SEC")
    private Long actualOccurredSec;
    @Column(name = "RESPOND_TIME")
    private String respondTime;
    @Column(name = "RESPOND_DATE_SEC")
    private Long respondDateSec;
    @Column(name = "RESOLVE_TIME")
    private String resolveTime;
    @Column(name = "RESOLVE_DATE_SEC")
    private Long resolveDateSec;
    @Column(name = "RESTORE_TIME")
    private String restoreTime;
    @Column(name = "RESTORE_DATE_SEC")
    private Long restoreDateSec;
    @Column(name = "TARGET_RESOLVE_DATE")
    private String targetResolveDate;
    @Column(name = "TARGET_RESOLVE_TIME")
    private String targetResolveTime;
    @Column(name = "TARGET_RESPOND_DATE")
    private String targetRespondDate;
    @Column(name = "TARGET_RESPOND_TIME")
    private String targetRespondTime;
    @Column(name = "TARGET_RESTORE_DATE")
    private String targetRestoreDate;
    @Column(name = "TARGET_RESTORE_TIME")
    private String targetRestoreTime;
    @Column(name = "ISSUETYPE")
    private String issuetype;
    @Column(name = "IS_INTERNAL")
    private String isInternal;
    @Column(name = "SCREEN_STATUS")
    private String screenStatus;
    @Column(name = "ASGN_LOGINID")
    private String asgnLoginid;
    @Column(name = "ASGN_HEATSEQ")
    private Long asgnHeatseq;
    @Column(name = "PREVACTION")
    private String prevaction;
    @Column(name = "EXCLSURVEY")
    private String exclsurvey;
    @Column(name = "FAQ")
    private String faq;
    @Column(name = "LOCAL_DESCRIPTION")
    private String localDescription;

    private static final long serialVersionUID = 1L;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (callid != null ? callid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calllog)) {
            return false;
        }
        Calllog other = (Calllog) object;
        if ((this.callid == null && other.callid != null) || (this.callid != null && !this.callid.equals(other.callid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kenan.tss.webmanager.model.webtrac.Calllog[ id=" + callid + " ]";
    }

    public Calllog() {
    }

    public Calllog(String callid) {
        this.callid = callid;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype;
    }

    public String getCalltype() {
        return calltype;
    }

    public void setCalltype(String calltype) {
        this.calltype = calltype;
    }

    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    public String getCallstatus() {
        return callstatus;
    }

    public void setCallstatus(String callstatus) {
        this.callstatus = callstatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public BigDecimal getCduration() {
        return cduration;
    }

    public void setCduration(BigDecimal cduration) {
        this.cduration = cduration;
    }

    public BigDecimal getCallcount() {
        return callcount;
    }

    public void setCallcount(BigDecimal callcount) {
        this.callcount = callcount;
    }

    public BigDecimal getStopwatch() {
        return stopwatch;
    }

    public void setStopwatch(BigDecimal stopwatch) {
        this.stopwatch = stopwatch;
    }

    public String getClosedby() {
        return closedby;
    }

    public void setClosedby(String closedby) {
        this.closedby = closedby;
    }

    public String getCloseddate() {
        return closeddate;
    }

    public void setCloseddate(String closeddate) {
        this.closeddate = closeddate;
    }

    public String getClosedtime() {
        return closedtime;
    }

    public void setClosedtime(String closedtime) {
        this.closedtime = closedtime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getRecvdby() {
        return recvdby;
    }

    public void setRecvdby(String recvdby) {
        this.recvdby = recvdby;
    }

    public String getRecvddate() {
        return recvddate;
    }

    public void setRecvddate(String recvddate) {
        this.recvddate = recvddate;
    }

    public String getRecvdtime() {
        return recvdtime;
    }

    public void setRecvdtime(String recvdtime) {
        this.recvdtime = recvdtime;
    }

    public String getModby() {
        return modby;
    }

    public void setModby(String modby) {
        this.modby = modby;
    }

    public String getModdate() {
        return moddate;
    }

    public void setModdate(String moddate) {
        this.moddate = moddate;
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime;
    }

    public Long getDtlastmod() {
        return dtlastmod;
    }

    public void setDtlastmod(Long dtlastmod) {
        this.dtlastmod = dtlastmod;
    }

    public String getCallsource() {
        return callsource;
    }

    public void setCallsource(String callsource) {
        this.callsource = callsource;
    }

    public String getQuickcall() {
        return quickcall;
    }

    public void setQuickcall(String quickcall) {
        this.quickcall = quickcall;
    }

    public String getCallstatusReason() {
        return callstatusReason;
    }

    public void setCallstatusReason(String callstatusReason) {
        this.callstatusReason = callstatusReason;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getActualOccuredDate() {
        return actualOccuredDate;
    }

    public void setActualOccuredDate(String actualOccuredDate) {
        this.actualOccuredDate = actualOccuredDate;
    }

    public String getRespondDate() {
        return respondDate;
    }

    public void setRespondDate(String respondDate) {
        this.respondDate = respondDate;
    }

    public String getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(String resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getRestoreDate() {
        return restoreDate;
    }

    public void setRestoreDate(String restoreDate) {
        this.restoreDate = restoreDate;
    }

    public String getAddToKb() {
        return addToKb;
    }

    public void setAddToKb(String addToKb) {
        this.addToKb = addToKb;
    }

    public String getWorkaroundExists() {
        return workaroundExists;
    }

    public void setWorkaroundExists(String workaroundExists) {
        this.workaroundExists = workaroundExists;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getCurrentSummary() {
        return currentSummary;
    }

    public void setCurrentSummary(String currentSummary) {
        this.currentSummary = currentSummary;
    }

    public String getIsProduction() {
        return isProduction;
    }

    public void setIsProduction(String isProduction) {
        this.isProduction = isProduction;
    }

    public String getIsRegression() {
        return isRegression;
    }

    public void setIsRegression(String isRegression) {
        this.isRegression = isRegression;
    }

    public String getAdvocate() {
        return advocate;
    }

    public void setAdvocate(String advocate) {
        this.advocate = advocate;
    }

    public String getOutage() {
        return outage;
    }

    public void setOutage(String outage) {
        this.outage = outage;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public String getSeverityName() {
        return severityName;
    }

    public void setSeverityName(String severityName) {
        this.severityName = severityName;
    }

    public String getActualOccurredTime() {
        return actualOccurredTime;
    }

    public void setActualOccurredTime(String actualOccurredTime) {
        this.actualOccurredTime = actualOccurredTime;
    }

    public Long getActualOccurredSec() {
        return actualOccurredSec;
    }

    public void setActualOccurredSec(Long actualOccurredSec) {
        this.actualOccurredSec = actualOccurredSec;
    }

    public String getRespondTime() {
        return respondTime;
    }

    public void setRespondTime(String respondTime) {
        this.respondTime = respondTime;
    }

    public Long getRespondDateSec() {
        return respondDateSec;
    }

    public void setRespondDateSec(Long respondDateSec) {
        this.respondDateSec = respondDateSec;
    }

    public String getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(String resolveTime) {
        this.resolveTime = resolveTime;
    }

    public Long getResolveDateSec() {
        return resolveDateSec;
    }

    public void setResolveDateSec(Long resolveDateSec) {
        this.resolveDateSec = resolveDateSec;
    }

    public String getRestoreTime() {
        return restoreTime;
    }

    public void setRestoreTime(String restoreTime) {
        this.restoreTime = restoreTime;
    }

    public Long getRestoreDateSec() {
        return restoreDateSec;
    }

    public void setRestoreDateSec(Long restoreDateSec) {
        this.restoreDateSec = restoreDateSec;
    }

    public String getTargetResolveDate() {
        return targetResolveDate;
    }

    public void setTargetResolveDate(String targetResolveDate) {
        this.targetResolveDate = targetResolveDate;
    }

    public String getTargetResolveTime() {
        return targetResolveTime;
    }

    public void setTargetResolveTime(String targetResolveTime) {
        this.targetResolveTime = targetResolveTime;
    }

    public String getTargetRespondDate() {
        return targetRespondDate;
    }

    public void setTargetRespondDate(String targetRespondDate) {
        this.targetRespondDate = targetRespondDate;
    }

    public String getTargetRespondTime() {
        return targetRespondTime;
    }

    public void setTargetRespondTime(String targetRespondTime) {
        this.targetRespondTime = targetRespondTime;
    }

    public String getTargetRestoreDate() {
        return targetRestoreDate;
    }

    public void setTargetRestoreDate(String targetRestoreDate) {
        this.targetRestoreDate = targetRestoreDate;
    }

    public String getTargetRestoreTime() {
        return targetRestoreTime;
    }

    public void setTargetRestoreTime(String targetRestoreTime) {
        this.targetRestoreTime = targetRestoreTime;
    }

    public String getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(String issuetype) {
        this.issuetype = issuetype;
    }

    public String getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(String isInternal) {
        this.isInternal = isInternal;
    }

    public String getScreenStatus() {
        return screenStatus;
    }

    public void setScreenStatus(String screenStatus) {
        this.screenStatus = screenStatus;
    }

    public String getAsgnLoginid() {
        return asgnLoginid;
    }

    public void setAsgnLoginid(String asgnLoginid) {
        this.asgnLoginid = asgnLoginid;
    }

    public Long getAsgnHeatseq() {
        return asgnHeatseq;
    }

    public void setAsgnHeatseq(Long asgnHeatseq) {
        this.asgnHeatseq = asgnHeatseq;
    }

    public String getPrevaction() {
        return prevaction;
    }

    public void setPrevaction(String prevaction) {
        this.prevaction = prevaction;
    }

    public String getExclsurvey() {
        return exclsurvey;
    }

    public void setExclsurvey(String exclsurvey) {
        this.exclsurvey = exclsurvey;
    }

    public String getFaq() {
        return faq;
    }

    public void setFaq(String faq) {
        this.faq = faq;
    }

    public String getLocalDescription() {
        return localDescription;
    }

    public void setLocalDescription(String localDescription) {
        this.localDescription = localDescription;
    }

    
}
