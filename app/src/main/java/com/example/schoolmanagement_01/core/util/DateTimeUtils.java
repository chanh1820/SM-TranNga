package com.example.schoolmanagement_01.core.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

    public static final SimpleDateFormat sdfDate1 = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat sdfDate2 = new SimpleDateFormat("dd/MM/yy");

    public static final SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");


    public static Integer convertTimeToInteger(Long time){
        StringBuilder stringDate = new StringBuilder();
        String[] array = sdfDate1.format(time).split("-");
        for (int i = 0; i < array.length; i++) {
            stringDate.append(array[i]);
        }
        return Integer.parseInt(stringDate.toString());
    }

    public static Boolean isValidDate(String date, String startTime, String endTime){
        boolean result = false;
        try {
            Date formattedDate = sdfDate2.parse(date);
            Date formattedStartTime = sdfTime.parse(startTime);
            Date formattedEndTime = sdfTime.parse(endTime);

            Date currentDate = new Date();

            if (currentDate.getDate() == formattedDate.getDate() && currentDate.getMonth() == formattedDate.getMonth() && currentDate.getYear() == formattedDate.getYear()) {
                if(currentDate.getHours() >= formattedStartTime.getHours() && currentDate.getHours() <= formattedEndTime.getHours()){
//                    if(currentDate.getMinutes() >= formattedStartTime.getMinutes() && currentDate.getMinutes() <= formattedEndTime.getMinutes()){
                        result = true;
//                    }else Log.e("log", "3") ;
                }else {
                    Log.e("log", "2") ;
                }
            }else {
                Log.e("log", "1") ;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}
