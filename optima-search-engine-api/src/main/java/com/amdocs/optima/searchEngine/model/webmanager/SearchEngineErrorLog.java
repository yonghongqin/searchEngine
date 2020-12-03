/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.model.webmanager;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author QINY
 */
@Entity
@Table(name = "SEARCH_ENGINE_ERROR_LOGGING")
public class SearchEngineErrorLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GenericGenerator(name="errorLogIdGenerator", strategy="uuid")
    @GeneratedValue(generator="errorLogIdGenerator")
    private String errorLogId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SEARCH_STRING")
    private String searchString;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "ERROR_DESC")
    private String errorDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUERY_DATE")
    @Temporal(TemporalType.DATE)
    private Date queryDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TYPE")
    private short type;
    
    @Basic(optional = false)
    @Size(min = 1, max = 250)
    @Column(name = "SEESION_ID")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public SearchEngineErrorLog() {
    }

    public SearchEngineErrorLog(String errorLogId) {
        this.errorLogId = errorLogId;
    }

    public SearchEngineErrorLog(String errorLogId, String searchString, String errorDesc, Date queryDate, short type,String sessionId) {
        this.errorLogId = errorLogId;
        this.searchString = searchString;
        this.errorDesc = errorDesc;
        this.queryDate = queryDate;
        this.type = type;
        this.sessionId=sessionId;
    }

    public String getErrorLogId() {
        return errorLogId;
    }

    public void setErrorLogId(String errorLogId) {
        this.errorLogId = errorLogId;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errorLogId != null ? errorLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SearchEngineErrorLog)) {
            return false;
        }
        SearchEngineErrorLog other = (SearchEngineErrorLog) object;
        if ((this.errorLogId == null && other.errorLogId != null) || (this.errorLogId != null && !this.errorLogId.equals(other.errorLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amdocs.optima.searchEngine.model.webmanager.SearchEngineErrorLog[ errorLogId=" + errorLogId + " ]";
    }
    
}
