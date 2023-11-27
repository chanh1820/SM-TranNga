package com.example.schoolmanagement_01.core.dto;

public class SummaryDTO {

    private String classRoom;

    //resource

    private String chuyenCan;

    private String noiQuy ;

    private String veSinh ;

    private String daoDuc ;

    private String hocTap ;

    private String SHTT ;

    private String diemCong ;

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

    public String getChuyenCan() {
        return chuyenCan;
    }

    public void setChuyenCan(String chuyenCan) {
        this.chuyenCan = chuyenCan;
    }

    public String getNoiQuy() {
        return noiQuy;
    }

    public void setNoiQuy(String noiQuy) {
        this.noiQuy = noiQuy;
    }

    public String getVeSinh() {
        return veSinh;
    }

    public void setVeSinh(String veSinh) {
        this.veSinh = veSinh;
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

    public String getSHTT() {
        return SHTT;
    }

    public void setSHTT(String SHTT) {
        this.SHTT = SHTT;
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
