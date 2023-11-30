package com.example.schoolmanagement_01.core.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.schoolmanagement_01.core.DBHelper;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.StudentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class GeneralDAO {

    DBHelper dbHelper;

    public GeneralDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public List<StudentDTO> findStudentByClassRoom(String classRoom) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM student_tbl as s where s.class_room = " + "'" + classRoom+ "'";
        //            SELECT * FROM student_tbl as s where s.class_room = '6A1'
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        if (cursor.getCount() != 0) {
            do {
                StudentDTO item;
                item = new StudentDTO(
                        cursor.getInt(0),//id
                        cursor.getString(1),//name
                        cursor.getString(2),// class room
                        cursor.getString(3)// image file
                );
                studentDTOList.add(item);
            } while (cursor.moveToNext());
        }
        return studentDTOList;
    }

    public void saveReport(ReportDTO reportDTO){

        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put("week",reportDTO.getWeek());
        values.put("class",reportDTO.getClassRoom());
        values.put("rule_name",reportDTO.getRuleName());
        values.put("rule_name_more",reportDTO.getRuleNameMore());
//        values.put("group_id",reportDTO.getGroupId());
        values.put("student_name",reportDTO.getStudentName());
        values.put("minus_point",reportDTO.getMinusPoint());
        values.put("path_image",reportDTO.getPathImage());
        values.put("created_date",reportDTO.getCreatedDate());

        db.insert("report_tbl", null, values);
        db.close();
    }
    public Long savePoint(PointDTO pointDTO){
        PointDTO pointDTOExisting = findPointByWeekAndClass(pointDTO.getWeek(), pointDTO.getClassRoom());
        if (pointDTOExisting!=null){
            return Long.valueOf(-1);
        }
        ObjectMapper objectMapper = new ObjectMapper();

        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("week",pointDTO.getWeek());
        values.put("class_room",pointDTO.getClassRoom());
//        values.put("point_a",pointDTO.getPointA());
//        values.put("point_b",pointDTO.getPointB());
//        values.put("point_c",pointDTO.getPointC());
//        values.put("point_d",pointDTO.getPointD());
//        values.put("good_lession",pointDTO.getGoodLession());
//        values.put("tu_quan",pointDTO.getTuQuan());

//        try {
//            values.put("bonus_point",objectMapper.writeValueAsString(pointDTO.getBonusPoint()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Long id = db.insert("point_tbl", null, values);
        db.close();
        return id;
    }

    public Cursor findReportCursorByWeekAndClass(String week, String classRoom){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM report_tbl as s where s.week = " + "'" + week +"' AND " +"s.class='"+classRoom+"'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public List<ReportDTO> findReportByWeekAndClass(String week, String classRoom){
        List<ReportDTO> reportDTOList = new ArrayList<>();
        Cursor cursor = findReportCursorByWeekAndClass(week,classRoom);
        if (cursor.getCount() != 0) {
            do {
                ReportDTO item;
//                item = new ReportDTO(
//                        cursor.getString(4),
//                        cursor.getString(5),
//                        cursor.getInt(6),
//                        cursor.getString(9));
//                reportDTOList.add(item);
            } while (cursor.moveToNext());
        }
        return reportDTOList;
    }
    public PointDTO findPointByWeekAndClass(String week, String classRoom){
        PointDTO item = new PointDTO();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM point_tbl as s where s.week = " + "'" + week +"' AND " +"s.class_room='"+classRoom+"'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }else {
            return null;
        }
        if (cursor.getCount() != 0) {
            do {
//                item = new PointDTO(
//                        cursor.getString(1),//week
//                        cursor.getString(2),//class room
//                        cursor.getInt(3),//pointA
//                        cursor.getInt(4),//pointB
//                        cursor.getInt(5),//pointC
//                        cursor.getInt(6),//pointD
//                        cursor.getInt(7),//good lession
//                        cursor.getInt(8),//tu quan
//                        cursor.getInt(9)//json bonus point
//                        );
            } while (cursor.moveToNext());
        }else {
            return null;
        }
        return item;
    }

    public void clearPointByWeekAndClass(String week, String classRoom) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "DELETE FROM point_tbl where week = " + "'" + week +"' AND " +"class_room='"+classRoom+"'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
    }

    public List<String> getClassRoomList() {
        List<String> result = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT DISTINCT(class_room) FROM student_tbl WHERE class_room NOT NULL";
        //            SELECT * FROM student_tbl as s where s.class_room = '6A1'
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        if (cursor.getCount() != 0) {
            do {
                result.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return result;
    }
}

