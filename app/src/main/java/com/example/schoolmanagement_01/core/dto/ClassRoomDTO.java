package com.example.schoolmanagement_01.core.dto;

public class ClassRoomDTO {

    private Integer id;

    private String classCode;

    private String className;

    private String number;

    private Integer group;

    private Integer color;

    public ClassRoomDTO(Integer id, String classCode, String className, String number) {
        this.id = id;
        this.classCode = classCode;
        this.className = className;
        this.number = number;
    }
    public ClassRoomDTO(Integer id, String classCode, String className, String number, Integer group) {
        this.id = id;
        this.classCode = classCode;
        this.className = className;
        this.number = number;
        this.group = group;
    }

    public ClassRoomDTO(Integer id, String classCode, String className, String number, Integer group, Integer color) {
        this.id = id;
        this.classCode = classCode;
        this.className = className;
        this.number = number;
        this.group = group;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }
}
