package com.example.schoolmanagement_01.core.dto;

public class PointDTO {

    private Integer id;

    private String week;

    private String classRoom;

    private Integer tietTot;

    private Integer tietKha;

    private Integer tietTrungBinh;

    private Integer tietYeu;

    private Integer diemCong;



    public PointDTO() {
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

    public Integer getTietTot() {
        return tietTot;
    }

    public void setTietTot(Integer tietTot) {
        this.tietTot = tietTot;
    }

    public Integer getTietKha() {
        return tietKha;
    }

    public void setTietKha(Integer tietKha) {
        this.tietKha = tietKha;
    }

    public Integer getTietTrungBinh() {
        return tietTrungBinh;
    }

    public void setTietTrungBinh(Integer tietTrungBinh) {
        this.tietTrungBinh = tietTrungBinh;
    }

    public Integer getTietYeu() {
        return tietYeu;
    }

    public void setTietYeu(Integer tietYeu) {
        this.tietYeu = tietYeu;
    }

    public Integer getDiemCong() {
        return diemCong;
    }

    public void setDiemCong(Integer diemCong) {
        this.diemCong = diemCong;
    }
}
