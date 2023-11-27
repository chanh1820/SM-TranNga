package com.example.schoolmanagement_01.core.dto;

public class PointDTO {

    private Integer id;

    private String week;

    private String classRoom;

    private Integer tietA;

    private Integer tietB;

    private Integer tietC;

    private Integer diemCong;



    public PointDTO() {
    }


    public PointDTO(String week, String classRoom, Integer tietA, Integer tietB, Integer tietC, Integer tietD, Integer tietTot, Integer tietTuQuan, Integer diemCong) {
        this.week = week;
        this.classRoom = classRoom;
        this.tietA = tietA;
        this.tietB = tietB;
        this.tietC = tietC;
        this.diemCong = diemCong;
    }

    public PointDTO(String week, String classRoom, Integer tietA, Integer tietB, Integer tietC, Integer tietD) {
        this.week = week;
        this.classRoom = classRoom;
        this.tietA = tietA;
        this.tietB = tietB;
        this.tietC = tietC;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
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

    public Integer getTietA() {
        return tietA;
    }

    public void setTietA(Integer tietA) {
        this.tietA = tietA;
    }

    public Integer getTietB() {
        return tietB;
    }

    public void setTietB(Integer tietB) {
        this.tietB = tietB;
    }

    public Integer getTietC() {
        return tietC;
    }

    public void setTietC(Integer tietC) {
        this.tietC = tietC;
    }

    public Integer getDiemCong() {
        return diemCong;
    }

    public void setDiemCong(Integer diemCong) {
        this.diemCong = diemCong;
    }
}
