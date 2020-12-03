package com.amdocs.optima.searchEngine.dto;

import java.io.Serializable;

public class QueryStat implements Serializable {

	private static final long serialVersionUID = 7434385250313783389L;
	private String query;
	private Integer hits;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}

}
