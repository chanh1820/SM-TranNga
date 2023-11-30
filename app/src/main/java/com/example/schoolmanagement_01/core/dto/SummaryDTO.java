package com.example.schoolmanagement_01.core.dto;

public class SummaryDTO {

    private String classRoom;

    //resource

    private String daoDuc;

    private String hocTap ;

    private String neNep ;

    private String Khac ;

    private String diemCong ;

    private String SDB ;
    private String tongDiem ;

    private Integer hang;

    public SummaryDTO() {
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getDaoDuc() {
        return daoDuc;
    }

    public void setDaoDuc(String daoDuc) {
        this.daoDuc = daoDuc;
    }

    public String getHocTap() {
        return hocTap;
    }

    public void setHocTap(String hocTap) {
        this.hocTap = hocTap;
    }

    public String getNeNep() {
        return neNep;
    }

    public void setNeNep(String neNep) {
        this.neNep = neNep;
    }

    public String getKhac() {
        return Khac;
    }

    public void setKhac(String khac) {
        Khac = khac;
    }

    public String getSDB() {
        return SDB;
    }

    public void setSDB(String SDB) {
        this.SDB = SDB;
    }

    public String getDiemCong() {
        return diemCong;
    }

    public void setDiemCong(String diemCong) {
        this.diemCong = diemCong;
    }

    public String getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(String tongDiem) {
        this.tongDiem = tongDiem;
    }

    public Integer getHang() {
        return hang;
    }

    public void setHang(Integer hang) {
        this.hang = hang;
    }
}
