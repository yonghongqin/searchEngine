package com.amdocs.optima.searchEngine.dto;

import java.io.Serializable;
import java.util.List;

public class StatObject implements Serializable {
	
	private static final long serialVersionUID = -1016730537255451025L;
	private List<String> monthViewList;
	private List<String> sumOfMonthViewList;
	
	private List<String> monthSearchList;
	private List<String> sumOfMonthSearchList;
	
	private List<String> searchCategoryList;
	private List<String> sumOfSearchCategoryList;
	
	private List<QueryStat> queryStatLast3MonthsList;
	private List<QueryStat> queryStatLast1MonthList;
	private List<QueryStat> queryStatLast1WeekList;
	
	
	public List<QueryStat> getQueryStatLast3MonthsList() {
		return queryStatLast3MonthsList;
	}
	public void setQueryStatLast3MonthsList(List<QueryStat> queryStatLast3MonthsList) {
		this.queryStatLast3MonthsList = queryStatLast3MonthsList;
	}
	public List<QueryStat> getQueryStatLast1MonthList() {
		return queryStatLast1MonthList;
	}
	public void setQueryStatLast1MonthList(List<QueryStat> queryStatLast1MonthList) {
		this.queryStatLast1MonthList = queryStatLast1MonthList;
	}
	public List<QueryStat> getQueryStatLast1WeekList() {
		return queryStatLast1WeekList;
	}
	public void setQueryStatLast1WeekList(List<QueryStat> queryStatLast1WeekList) {
		this.queryStatLast1WeekList = queryStatLast1WeekList;
	}
	public List<String> getSearchCategoryList() {
		return searchCategoryList;
	}
	public void setSearchCategoryList(List<String> searchCategoryList) {
		this.searchCategoryList = searchCategoryList;
	}
	public List<String> getSumOfSearchCategoryList() {
		return sumOfSearchCategoryList;
	}
	public void setSumOfSearchCategoryList(List<String> sumOfSearchCategoryList) {
		this.sumOfSearchCategoryList = sumOfSearchCategoryList;
	}
	public List<String> getMonthViewList() {
		return monthViewList;
	}
	public void setMonthViewList(List<String> monthViewList) {
		this.monthViewList = monthViewList;
	}
	public List<String> getSumOfMonthViewList() {
		return sumOfMonthViewList;
	}
	public void setSumOfMonthViewList(List<String> sumOfMonthViewList) {
		this.sumOfMonthViewList = sumOfMonthViewList;
	}
	public List<String> getMonthSearchList() {
		return monthSearchList;
	}
	public void setMonthSearchList(List<String> monthSearchList) {
		this.monthSearchList = monthSearchList;
	}
	public List<String> getSumOfMonthSearchList() {
		return sumOfMonthSearchList;
	}
	public void setSumOfMonthSearchList(List<String> sumOfMonthSearchList) {
		this.sumOfMonthSearchList = sumOfMonthSearchList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
