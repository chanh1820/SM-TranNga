package com.example.schoolmanagement_01.core.dto;

public class ReportDTO {

    private Integer id;

    private String week;

    private String classRoom;

    private String ruleName;

    private String ruleCode;

    private String collectionCode;

    private String ruleNameMore;

    private String studentName;

    private Integer minusPoint;

    private String pathImage;

    private String createdDate;

    public ReportDTO() {}

    public ReportDTO(Integer id, String week, String classRoom, String ruleName, String studentName,String ruleCode, String ruleNameMore, Integer minusPoint, String pathImage, String createdDate) {
        this.id = id;
        this.week = week;
        this.classRoom = classRoom;
        this.ruleName = ruleName;
        this.ruleCode = ruleCode;
        this.ruleNameMore = ruleNameMore;
        this.studentName = studentName;
        this.minusPoint = minusPoint;
        this.pathImage = pathImage;
        this.createdDate = createdDate;
    }

    public ReportDTO(String ruleCode, String studentName, Integer minusPoint, String ruleNameMore) {
        this.ruleCode = ruleCode;
        this.ruleNameMore = ruleNameMore;
        this.studentName = studentName;
        this.minusPoint = minusPoint;
    }

    public String getCollectionCode() {
        return collectionCode;
    }

    public void setCollectionCode(String collectionCode) {
        this.collectionCode = collectionCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getMinusPoint() {
        return minusPoint;
    }

    public void setMinusPoint(Integer minusPoint) {
        this.minusPoint = minusPoint;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getRuleNameMore() {
        return ruleNameMore;
    }

    public void setRuleNameMore(String ruleNameMore) {
        this.ruleNameMore = ruleNameMore;
    }
}
