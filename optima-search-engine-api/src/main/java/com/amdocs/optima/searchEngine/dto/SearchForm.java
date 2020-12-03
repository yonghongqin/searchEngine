/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.dto;

import java.util.List;

/**
 *
 * @author QINY
 */
public class SearchForm {
    private String query;
    private String wiqlQuery;

    private String[] filterFirstType;
    private String[] filterSecondType;
    
    private String[] filterDocType;
    private int pg;
    private int pgsz;
    private int nextPage;
    private int prePage;
    private int lastPage;
    private int startRecords;
    private int endRecords;
    private int numToHits;
    private double elapsed;
    private int searchOption;
    private String[] filterServiceName;
    private String[] filterCbsModule;
    private String[] filterYears;
    private String[] filterProdLines;
    private String[] filterAccts;
    private String[] filterDdtsProject;
    private String[] filterDdtsVersion;
    private String[] filterDdtsModule;
    private String[] filterWorkItemType;

    public String[] getFilterWorkItemType() {
        return filterWorkItemType;
    }

    public void setFilterWorkItemType(String[] filterWorkItemType) {
        this.filterWorkItemType = filterWorkItemType;
    }

    private List<String> cbsModuleList;
    private List<String> serviceNameList;
    
    private List<String> accountList;
    private List<String> yearList;
    private List<String> productionLineList ;
    private List<String> docTypeList;
    
    private List<String> dirFirstList;
    private List<String> dirSecondList;
    
    private String subIndexDirFirst;
    private String subIndexDirSecond;

    public String getSubIndexDirFirst() {
        return subIndexDirFirst;
    }

    public void setSubIndexDirFirst(String subIndexDirFirst) {
        this.subIndexDirFirst = subIndexDirFirst;
    }

    public String getSubIndexDirSecond() {
        return subIndexDirSecond;
    }

    public void setSubIndexDirSecond(String subIndexDirSecond) {
        this.subIndexDirSecond = subIndexDirSecond;
    }
    
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
     public String getwiqlQuery() {
        return wiqlQuery;
    }

    public void setwiqlQuery(String wiqlQuery) {
        this.wiqlQuery = wiqlQuery;
    }
    
    
    public List<String> getDirFirstList() {
        return dirFirstList;
    }

    public void setDirFirstList(List<String> dirFirstList) {
        this.dirFirstList = dirFirstList;
    }

    public List<String> getDirSecondList() {
        return dirSecondList;
    }

    public void setDirSecondList(List<String> dirSecondList) {
        this.dirSecondList = dirSecondList;
    }

    public List<String> getDocTypeList() {
        return docTypeList;
    }

    public void setDocTypeList(List<String> docTypeList) {
        this.docTypeList = docTypeList;
    }

    public List<String> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<String> accountList) {
        this.accountList = accountList;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<String> getProductionLineList() {
        return productionLineList;
    }

    public void setProductionLineList(List<String> productionLineList) {
        this.productionLineList = productionLineList;
    }

    public List<String> getCbsModuleList() {
        return cbsModuleList;
    }

    public void setCbsModuleList(List<String> cbsModuleList) {
        this.cbsModuleList = cbsModuleList;
    }

    public List<String> getServiceNameList() {
        return serviceNameList;
    }

    public void setServiceNameList(List<String> serviceNameList) {
        this.serviceNameList = serviceNameList;
    }
            

    public String[] getFilterYears() {
        return filterYears;
    }

    public void setFilterYears(String[] filterYears) {
        this.filterYears = filterYears;
    }

    public String[] getFilterProdLines() {
        return filterProdLines;
    }

    public void setFilterProdLines(String[] filterProdLines) {
        this.filterProdLines = filterProdLines;
    }

    public String[] getFilterAccts() {
        return filterAccts;
    }

    public void setFilterAccts(String[] filterAccts) {
        this.filterAccts = filterAccts;
    }

    public String[] getFilterServiceName() {
        return filterServiceName;
    }

    public void setFilterServiceName(String[] filterServiceName) {
        this.filterServiceName = filterServiceName;
    }

    public String[] getFilterCbsModule() {
        return filterCbsModule;
    }

    public void setFilterCbsModule(String[] filterCbsModule) {
        this.filterCbsModule = filterCbsModule;
    }


    public int getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(int searchOption) {
        this.searchOption = searchOption;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getStartRecords() {
        return startRecords;
    }

    public void setStartRecords(int startRecords) {
        this.startRecords = startRecords;
    }

    public int getEndRecords() {
        return endRecords;
    }

    public void setEndRecords(int endRecords) {
        this.endRecords = endRecords;
    }

    public int getNumToHits() {
        return numToHits;
    }

    public void setNumToHits(int numToHits) {
        this.numToHits = numToHits;
    }

    public double getElapsed() {
        return elapsed;
    }

    public void setElapsed(double elapsed) {
        this.elapsed = elapsed;
    }
    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getPgsz() {
        return pgsz;
    }

    public void setPgsz(int pgsz) {
        this.pgsz = pgsz;
    }
    

    public String[] getFilterDocType() {
        return filterDocType;
    }

    public void setFilterDocType(String[] filterDocType) {
        this.filterDocType = filterDocType;
    }

    public String[] getFilterSecondType() {
        return filterSecondType;
    }

    public void setFilterSecondType(String[] filterSecondType) {
        this.filterSecondType = filterSecondType;
    }

    public String[] getFilterFirstType() {
        return filterFirstType;
    }

    public void setFilterFirstType(String[] filterFirstType) {
        this.filterFirstType = filterFirstType;
    }
    
   public String[] getFilterDdtsProject() {
        return filterDdtsProject;
    }

    public void setFilterDdtsProject(String[] filterDdtsProject) {
        this.filterDdtsProject = filterDdtsProject;
    }

    public String[] getFilterDdtsVersion() {
        return filterDdtsVersion;
    }

    public void setFilterDdtsVersion(String[] filterDdtsVersion) {
        this.filterDdtsVersion = filterDdtsVersion;
    }

    public String[] getFilterDdtsModule() {
        return filterDdtsModule;
    }

    public void setFilterDdtsModule(String[] filterDdtsModule) {
        this.filterDdtsModule = filterDdtsModule;
    }
    
}
