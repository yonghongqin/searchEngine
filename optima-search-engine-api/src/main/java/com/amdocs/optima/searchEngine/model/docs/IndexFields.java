package com.amdocs.optima.searchEngine.model.docs;



public class IndexFields {

    private Integer fileId;
    private String fileName;
    private String fileContent;
    private String fileLocation;
    private String fileExtension;
    private String fileSize;
    private String fileHierarchy;
    private String fileHierarchyFirst;

    public String getFileHierarchyFirst() {
        return fileHierarchyFirst;
    }

    public void setFileHierarchyFirst(String fileHierarchyFirst) {
        this.fileHierarchyFirst = fileHierarchyFirst;
    }

    public String getFileHierarchySecond() {
        return fileHierarchySecond;
    }

    public void setFileHierarchySecond(String fileHierarchySecond) {
        this.fileHierarchySecond = fileHierarchySecond;
    }
    private String fileHierarchySecond;

    public String getFileHierarchy() {
        return fileHierarchy;
    }

    public void setFileHierarchy(String fileHierarchy) {
        this.fileHierarchy = fileHierarchy;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

}
