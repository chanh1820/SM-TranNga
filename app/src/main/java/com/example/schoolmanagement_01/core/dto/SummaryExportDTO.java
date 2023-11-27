package com.example.schoolmanagement_01.core.dto;

public class SummaryExportDTO {

    private String classRoom;

    private String siSo;

    private String tietA;

    private String tietB;

    private String tietC;

    private String tietD;

    private String nghiHoc;

    private String diTre;

    //MTT, KDP, nề nếp
    private String ViPhamKhac;

    //KLB, KTB
    private String ViPhamKhac2;

    private String tuQuan;

    private String veSinh;

    private String phongTrao;

    private String tietHocTot;

    private String diemTru;

    private String tongDiem;

    private String xepHang;

    public SummaryExportDTO() {
    }

    public SummaryExportDTO(String classRoom,String siSo, String tietA, String tietB, String tietC, String tietD, String nghiHoc, String diTre, String viPhamKhac, String viPhamKhac2, String tuQuan, String veSinh, String phongTrao, String tietHocTot, String diemTru, String tongDiem, String xepHang) {
        this.classRoom = classRoom;
        this.siSo = siSo;
        this.tietA = tietA;
        this.tietB = tietB;
        this.tietC = tietC;
        this.tietD = tietD;
        this.nghiHoc = nghiHoc;
        this.diTre = diTre;
        this.ViPhamKhac = viPhamKhac;
        this.ViPhamKhac2 = viPhamKhac2;
        this.tuQuan = tuQuan;
        this.veSinh = veSinh;
        this.phongTrao = phongTrao;
        this.tietHocTot = tietHocTot;
        this.diemTru = diemTru;
        this.tongDiem = tongDiem;
        this.xepHang = xepHang;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getSiSo() {
        return siSo;
    }

    public void setSiSo(String siSo) {
        this.siSo = siSo;
    }

    public String getTietA() {
        return tietA;
    }

    public void setTietA(String tietA) {
        this.tietA = tietA;
    }

    public String getTietB() {
        return tietB;
    }

    public void setTietB(String tietB) {
        this.tietB = tietB;
    }

    public String getTietC() {
        return tietC;
    }

    public void setTietC(String tietC) {
        this.tietC = tietC;
    }

    public String getTietD() {
        return tietD;
    }

    public void setTietD(String tietD) {
        this.tietD = tietD;
    }

    public String getNghiHoc() {
        return nghiHoc;
    }

    public void setNghiHoc(String nghiHoc) {
        this.nghiHoc = nghiHoc;
    }

    public String getDiTre() {
        return diTre;
    }

    public void setDiTre(String diTre) {
        this.diTre = diTre;
    }

    public String getViPhamKhac() {
        return ViPhamKhac;
    }

    public void setViPhamKhac(String viPhamKhac) {
        ViPhamKhac = viPhamKhac;
    }

    public String getViPhamKhac2() {
        return ViPhamKhac2;
    }

    public void setViPhamKhac2(String viPhamKhac2) {
        ViPhamKhac2 = viPhamKhac2;
    }

    public String getTuQuan() {
        return tuQuan;
    }

    public void setTuQuan(String tuQuan) {
        this.tuQuan = tuQuan;
    }

    public String getVeSinh() {
        return veSinh;
    }

    public void setVeSinh(String veSinh) {
        this.veSinh = veSinh;
    }

    public String getPhongTrao() {
        return phongTrao;
    }

    public void setPhongTrao(String phongTrao) {
        this.phongTrao = phongTrao;
    }

    public String getTietHocTot() {
        return tietHocTot;
    }

    public void setTietHocTot(String tietHocTot) {
        this.tietHocTot = tietHocTot;
    }

    public String getDiemTru() {
        return diemTru;
    }

    public void setDiemTru(String diemTru) {
        this.diemTru = diemTru;
    }

    public String getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(String tongDiem) {
        this.tongDiem = tongDiem;
    }

    public String getXepHang() {
        return xepHang;
    }

    public void setXepHang(String xepHang) {
        this.xepHang = xepHang;
    }
}
