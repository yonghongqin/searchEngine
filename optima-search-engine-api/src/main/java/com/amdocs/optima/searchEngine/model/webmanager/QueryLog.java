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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author QINY
 */
@Entity
@Table(name = "SEARCH_ENGINE_QUERY_LOGGING")
public class QueryLog implements Serializable {

	private static final long serialVersionUID = 8541614416349048349L;
	@Id
	@GenericGenerator(name="queryLogIdGenerator", strategy="uuid")
    @GeneratedValue(generator="queryLogIdGenerator")
    @Column(name = "QUERY_LOG_ID")
    private String queryLogId;
    @Basic(optional = false)
    @Column(name = "QUERY_DATE")
    @Temporal(TemporalType.DATE)
    private Date queryDate;
    @Column(name = "QUERY")
    private String query;
    @Column(name = "SEARCH_ID")
    private String searchId;
    @Column(name = "SEARCH_TYPE")
    private String searchType;
    @Column(name = "IS_SUBCASE")
    private boolean isSubcase;
    @Column(name = "IS_SOLUTION")
    private boolean isSolution;
    @Basic(optional = false)
    @Column(name = "IS_SUCCESS")
    private Boolean isSuccess;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    
    @Column(name = "SESSION_ID")
    private String sessionId;

    @Basic(optional = false)
    @Column(name = "IS_VIEW")
    private Boolean isView;
    
    
    @Column(name = "search_Category")
    private String searchCategory;
    
    public String getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public Boolean getIsView() {
		return isView;
	}

	public void setIsView(Boolean isView) {
		this.isView = isView;
	}

	public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public QueryLog() {
    }

    public QueryLog(String queryLogId) {
        this.queryLogId = queryLogId;
    }

    public QueryLog(String queryLogId, Date queryDate, boolean isSuccess,String sessionId) {
        this.queryLogId = queryLogId;
        this.queryDate = queryDate;
        this.isSuccess = isSuccess;
        this.sessionId = sessionId;
    }

    public String getQueryLogId() {
        return queryLogId;
    }

    public void setQueryLogId(String queryLogId) {
        this.queryLogId = queryLogId;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public boolean getIsSubcase() {
        return isSubcase;
    }

    public void setIsSubcase(boolean isSubcase) {
        this.isSubcase = isSubcase;
    }

    public boolean getIsSolution() {
        return isSolution;
    }

    public void setIsSolution(boolean isSolution) {
        this.isSolution = isSolution;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (queryLogId != null ? queryLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QueryLog)) {
            return false;
        }
        QueryLog other = (QueryLog) object;
        if ((this.queryLogId == null && other.queryLogId != null) || (this.queryLogId != null && !this.queryLogId.equals(other.queryLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amdocs.optima.searchEngine.model.webmanager.SearchEngineQueryLog[ queryLogId=" + queryLogId + " ]";
    }
    
}
