package com.example.schoolmanagement_01.core.dto;

public class ReportDTO {

    private Integer id;

    private String week;

    private String classRoom;

    private String ruleName;

    private String collectionCode;

    private String ruleNameMore;

    private String studentName;

    private Integer minusPoint;

    private String pathImage;

    private String createdDate;

    private String groupCode;

    public ReportDTO() {}


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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
