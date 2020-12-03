/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.model.webtrac;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author QINY
 */
@Entity
@Table(name = "JOURNAL")
@NamedQueries({
    @NamedQuery(name = "Journal.findAll", query = "SELECT j FROM Journal j")})
public class Journal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JournalPK journalPK;
    @Column(name = "CALLID",insertable=false, updatable=false)
    private String callid;
    @Column(name = "TRACKER")
    private String tracker;
    @Column(name = "ENTRYDATE")
    private String entrydate;
    @Column(name = "ENTRYTIME")
    private String entrytime;
    @Lob
    @Column(name = "ENTRYTEXT")
    private String entrytext;
    @Column(name = "JOURNALTYPE")
    private String journaltype;
    @Column(name = "DTLASTMOD")
    private Long dtlastmod;

    public Journal() {
    }

    public Journal(JournalPK journalPK) {
        this.journalPK = journalPK;
    }

    public Journal(String callid, long heatseq) {
        this.journalPK = new JournalPK(callid, heatseq);
    }

    public JournalPK getJournalPK() {
        return journalPK;
    }

    public void setJournalPK(JournalPK journalPK) {
        this.journalPK = journalPK;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }
    
    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    public String getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(String entrydate) {
        this.entrydate = entrydate;
    }

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime;
    }

    public String getEntrytext() {
        return entrytext;
    }

    public void setEntrytext(String entrytext) {
        this.entrytext = entrytext;
    }

    public String getJournaltype() {
        return journaltype;
    }

    public void setJournaltype(String journaltype) {
        this.journaltype = journaltype;
    }

    public Long getDtlastmod() {
        return dtlastmod;
    }

    public void setDtlastmod(Long dtlastmod) {
        this.dtlastmod = dtlastmod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (journalPK != null ? journalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Journal)) {
            return false;
        }
        Journal other = (Journal) object;
        if ((this.journalPK == null && other.journalPK != null) || (this.journalPK != null && !this.journalPK.equals(other.journalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kenan.tss.webmanager.model.webtrac.Journal[ journalPK=" + journalPK + " ]";
    }
    
}
