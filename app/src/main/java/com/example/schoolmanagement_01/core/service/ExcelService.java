package com.example.schoolmanagement_01.core.service;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;

import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelService {

    public static void requestPermission(Context context, Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }
        ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
    }

    public static String exportExcel(List<SummaryDTO> summaryDTOList, String fileName, String week) {
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + fileName + ".xls");

        String absolutePath =filePath.getAbsolutePath();

                HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("Custom Sheet");

        SummaryDTO summaryDTO;

        HSSFRow hssfTitleTuan = hssfSheet.createRow(1);
        HSSFCell hssfCellTuan = hssfTitleTuan.createCell(8);
        hssfCellTuan.setCellValue("Tuần "+ week);

//        HSSFRow hssfTitleFrom = hssfSheet.createRow(1);
//        HSSFCell hssfCellFrom = hssfTitleFrom.createCell(9);
//        hssfCellFrom.setCellValue(DBConstants.mapTuan.get(Integer.parseInt(week)));

        for (int i = -1; i < summaryDTOList.size(); i++) {
            HSSFRow hssfRow = hssfSheet.createRow(i + 5);

            if (i == -1) {
                HSSFCell hssfCell0 = hssfRow.createCell(0);
                HSSFCell hssfCell1 = hssfRow.createCell(1);
                HSSFCell hssfCell2 = hssfRow.createCell(2);
                HSSFCell hssfCell3 = hssfRow.createCell(3);
                HSSFCell hssfCell4 = hssfRow.createCell(4);
                HSSFCell hssfCell5 = hssfRow.createCell(5);
                HSSFCell hssfCell6 = hssfRow.createCell(6);
                HSSFCell hssfCell7 = hssfRow.createCell(7);
                HSSFCell hssfCell8 = hssfRow.createCell(8);

                hssfCell0.setCellValue("Lớp");
                hssfCell1.setCellValue("ĐẠO ĐỨC");
                hssfCell2.setCellValue("HỌC TẬP");
                hssfCell3.setCellValue("Nề nếp");
                hssfCell4.setCellValue("Khác");
                hssfCell5.setCellValue("Điểm Cộng");
                hssfCell6.setCellValue("Sổ đầu bài");
                hssfCell7.setCellValue("Tổng điểm");
                hssfCell8.setCellValue("Xếp hạng");
            } else {
                summaryDTO = summaryDTOList.get(i);
                HSSFCell hssfCell0 = hssfRow.createCell(0);
                HSSFCell hssfCell1 = hssfRow.createCell(1);
                HSSFCell hssfCell2 = hssfRow.createCell(2);
                HSSFCell hssfCell3 = hssfRow.createCell(3);
                HSSFCell hssfCell4 = hssfRow.createCell(4);
                HSSFCell hssfCell5 = hssfRow.createCell(5);
                HSSFCell hssfCell6 = hssfRow.createCell(6);
                HSSFCell hssfCell7 = hssfRow.createCell(7);
                HSSFCell hssfCell8 = hssfRow.createCell(8);

                hssfCell0.setCellValue(summaryDTO.getClassRoom());
                hssfCell1.setCellValue(summaryDTO.getDaoDuc());
                hssfCell2.setCellValue(summaryDTO.getHocTap());
                hssfCell3.setCellValue(summaryDTO.getNeNep());
                hssfCell4.setCellValue(summaryDTO.getKhac());
                hssfCell5.setCellValue(summaryDTO.getDiemCong());
                hssfCell6.setCellValue(summaryDTO.getSDB());
                hssfCell7.setCellValue(summaryDTO.getTongDiem());
                hssfCell8.setCellValue(summaryDTO.getHang());
            }



        }

        try {
            if (!filePath.exists()) {
                filePath.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            hssfWorkbook.write(fileOutputStream);
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return absolutePath;
    }

    public static String exportReportExcel(List<ReportDTO> reportDTOList, String fileName, String week) {
        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + fileName + ".xls");

        String absolutePath =filePath.getAbsolutePath();

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("Custom Sheet");

        ReportDTO reportDTO;

        HSSFRow hssfTitleTuan = hssfSheet.createRow(1);
        HSSFCell hssfCellTuan = hssfTitleTuan.createCell(8);
        hssfCellTuan.setCellValue("Tuần "+ week);

//        HSSFRow hssfTitleFrom = hssfSheet.createRow(1);
//        HSSFCell hssfCellFrom = hssfTitleFrom.createCell(9);
//        hssfCellFrom.setCellValue(DBConstants.mapTuan.get(Integer.parseInt(week)));

        for (int i = -1; i < reportDTOList.size(); i++) {
            HSSFRow hssfRow = hssfSheet.createRow(i + 5);

            if (i == -1) {
                HSSFCell hssfCell0 = hssfRow.createCell(0);
                HSSFCell hssfCell1 = hssfRow.createCell(1);
                HSSFCell hssfCell2 = hssfRow.createCell(2);
                HSSFCell hssfCell3 = hssfRow.createCell(3);
                HSSFCell hssfCell4 = hssfRow.createCell(4);

                hssfCell0.setCellValue("STT");
                hssfCell1.setCellValue("Tên");
                hssfCell2.setCellValue("Mục");
                hssfCell3.setCellValue("Điểm");
                hssfCell4.setCellValue("Thời dian");
            } else {
                reportDTO = reportDTOList.get(i);
                HSSFCell hssfCell0 = hssfRow.createCell(0);
                HSSFCell hssfCell1 = hssfRow.createCell(1);
                HSSFCell hssfCell2 = hssfRow.createCell(2);
                HSSFCell hssfCell3 = hssfRow.createCell(3);
                HSSFCell hssfCell4 = hssfRow.createCell(4);

                hssfCell0.setCellValue(i+1);
                hssfCell1.setCellValue(reportDTO.getStudentName());
                hssfCell2.setCellValue(reportDTO.getRuleName());
                hssfCell3.setCellValue(reportDTO.getMinusPoint());
                hssfCell4.setCellValue(reportDTO.getCreatedDate());
            }



        }

        try {
            if (!filePath.exists()) {
                filePath.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            hssfWorkbook.write(fileOutputStream);
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return absolutePath;
    }
}
