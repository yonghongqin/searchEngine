/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.model.webtrac;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author QINY
 */
@Embeddable
public class JournalPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CALLID")
    private String callid;
    @Basic(optional = false)
    @Column(name = "HEATSEQ")
    private long heatseq;

    public JournalPK() {
    }

    public JournalPK(String callid, long heatseq) {
        this.callid = callid;
        this.heatseq = heatseq;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public long getHeatseq() {
        return heatseq;
    }

    public void setHeatseq(long heatseq) {
        this.heatseq = heatseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (callid != null ? callid.hashCode() : 0);
        hash += (int) heatseq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JournalPK)) {
            return false;
        }
        JournalPK other = (JournalPK) object;
        if ((this.callid == null && other.callid != null) || (this.callid != null && !this.callid.equals(other.callid))) {
            return false;
        }
        if (this.heatseq != other.heatseq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kenan.tss.webmanager.model.webtrac.JournalPK[ callid=" + callid + ", heatseq=" + heatseq + " ]";
    }
    
}
