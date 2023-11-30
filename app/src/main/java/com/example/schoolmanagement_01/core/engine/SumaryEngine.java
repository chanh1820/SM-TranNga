package com.example.schoolmanagement_01.core.engine;

import com.example.schoolmanagement_01.core.contants.DBConstants;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;

import java.util.List;

public class SumaryEngine {

    public static SummaryDTO calculatorSummary(String classRoom, PointDTO pointDTO, List<ReportDTO> reportDTOList) {
        SummaryDTO summaryDTO = new SummaryDTO();
        summaryDTO.setClassRoom(classRoom);
        if (pointDTO == null) {
            summaryDTO.setDaoDuc("");
            summaryDTO.setHocTap("");
            summaryDTO.setNeNep("");
            summaryDTO.setKhac("");
            summaryDTO.setDiemCong("");
            summaryDTO.setSDB("");
            summaryDTO.setTongDiem("0");
            return summaryDTO;
        }
        // calculator Diem
        Integer total = DBConstants.DEFAULT_POINT_OF_WEEK;
        Integer diemDaoDuc = 0;
        Integer diemHocTap = 0;
        Integer diemNeNep = 0;
        Integer diemKhac = 0;
        Integer diemCong = 0;
        Integer diemSDB = 0;

        for (ReportDTO item : reportDTOList) {
            switch (item.getGroupCode()) {
                case DBConstants.GROUP_DAO_DUC:
                    if (item.getMinusPoint() < 0) {
                        diemDaoDuc -= Math.abs(item.getMinusPoint());
                    } else {
                        diemCong += Math.abs(item.getMinusPoint());
                    }
                    break;
                case DBConstants.GROUP_HOC_TAP:
                    if (item.getMinusPoint() < 0) {
                        diemHocTap -= Math.abs(item.getMinusPoint());
                    } else {
                        diemCong += Math.abs(item.getMinusPoint());
                    }
                    break;
                case DBConstants.GROUP_NE_NEP:
                    if (item.getMinusPoint() < 0) {
                        diemNeNep -= Math.abs(item.getMinusPoint());
                    } else {
                        diemCong += Math.abs(item.getMinusPoint());
                    }
                    break;
                case DBConstants.GROUP_KHAC:
                    if (item.getMinusPoint() < 0) {
                        diemKhac -= Math.abs(item.getMinusPoint());
                    } else {
                        diemCong += Math.abs(item.getMinusPoint());
                    }
                    break;
                case DBConstants.GROUP_DIEM_CONG:
                        diemCong += Math.abs(item.getMinusPoint());
                    break;
            }
        }
        diemSDB = pointDTO.getTietTot() * 1 + ( - pointDTO.getTietKha() * 1) + ( - pointDTO.getTietTrungBinh() * 2) + ( - pointDTO.getTietYeu() * 3);
        total = total + diemDaoDuc + diemHocTap + diemNeNep + diemKhac + diemCong + diemSDB;

        StringBuffer noiDungSBT = new StringBuffer();
        if(pointDTO.getTietTot() > 0){
            noiDungSBT.append(pointDTO.getTietTot() + "-" + "Tốt");
        }
        if(pointDTO.getTietTot() > 0){
            noiDungSBT.append("\n");
            noiDungSBT.append(pointDTO.getTietKha() + "-" + "Khá");
        }
        if(pointDTO.getTietTot() > 0){
            noiDungSBT.append("\n");
            noiDungSBT.append(pointDTO.getTietTrungBinh() + "-" + "TB");
        }
        if(pointDTO.getTietTot() > 0){
            noiDungSBT.append("\n");
            noiDungSBT.append(pointDTO.getTietYeu() + "-" + "Yếu");
        }


        summaryDTO.setDaoDuc(String.valueOf(diemDaoDuc));
        summaryDTO.setHocTap(String.valueOf(diemHocTap));
        summaryDTO.setNeNep(String.valueOf(diemNeNep));
        summaryDTO.setKhac(String.valueOf(diemKhac));
        summaryDTO.setDiemCong(String.valueOf(diemCong));
        summaryDTO.setSDB(noiDungSBT.toString());
        summaryDTO.setTongDiem(String.valueOf(total));
        return summaryDTO;
    }
}
