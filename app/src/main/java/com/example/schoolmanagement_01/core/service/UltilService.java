package com.example.schoolmanagement_01.core.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.schoolmanagement_01.core.contants.DBConstants;
import com.example.schoolmanagement_01.core.dto.CalculatorMinusMap;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class UltilService {
    public static List<ClassRoomDTO> fillClassRoomByGroupId(List<ClassRoomDTO> list, Integer groupId) {
        List<ClassRoomDTO> listParent = new ArrayList<>();
        if (list != null) {
            for (ClassRoomDTO item : list) {
                if (item.getGroup().equals(groupId)) {
                    listParent.add(item);
                }
            }
        }
        return listParent;
    }

    public static List<RuleDTO> getRules(List<RuleDTO> list, Integer parentId) {
        List<RuleDTO> listParent = new ArrayList<>();
        if (list != null) {
            for (RuleDTO ruleDTO : list) {
                if (ruleDTO.getParentId() == parentId) {
                    listParent.add(ruleDTO);
                }
            }
        }
        return listParent;
    }
    public static List<RuleDTO> getRuleById(List<RuleDTO> list, Integer id) {
        List<RuleDTO> listParent = new ArrayList<>();
        if (list != null) {
            for (RuleDTO ruleDTO : list) {
                if (ruleDTO.getId() == id) {
                    listParent.add(ruleDTO);
                }
            }
        }
        return listParent;
    }

    public static Bitmap StringToBitMap(String image) {
        try {
            byte[] encodeByte = Base64.decode(image, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] arr = baos.toByteArray();
        String result = Base64.encodeToString(arr, Base64.DEFAULT);
        return result;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //    /**
//     * @param pointDTO
//     * @return
//     */
//    public static Float calculatorDiemXepLoaiTietHoc(PointDTO pointDTO) {
//        if (Objects.isNull(pointDTO) || !(pointDTO != null)) {
//            return Float.parseFloat("0");
//        }
//        Integer a = pointDTO.getPointA();
//        Integer b = pointDTO.getPointB();
//        Integer c = pointDTO.getPointC();
//        Integer d = pointDTO.getPointD();
//        Log.e("float",(float)(a * 10 + b * 5 + c * 0 + d * (-5)) / (a + b + c + d)+"");
//        return (float)(a * 10 + b * 5 + c * 0 + d * (-5)) / (a + b + c + d);
//    }
    public static Integer calculatorDiemThiDuaForClass(List<ReportDTO> reportDTOList) {
        if (reportDTOList.isEmpty() || Objects.isNull(reportDTOList)) {
            return 50;
        }

        CalculatorMinusMap calculatorMinus;
        Integer score = 16;
        Map<Integer, CalculatorMinusMap> calculatorMinusMap = DBConstants.calculatorMinusMap;
        for (ReportDTO reportDTO : reportDTOList) {
            String ruleCode = reportDTO.getRuleCode();
            score = score - reportDTO.getMinusPoint();
        }
        return score;
    }

    public static void reverseArrayFloat(float[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            // swap the values at the left and right indices
            float temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static final String searchStudentPheBinh(List<ReportDTO> reportDTOList) {
        if (reportDTOList.isEmpty() || reportDTOList == null || reportDTOList.size() == 0) {
            return "-";
        }
        String studentPhebinh = "";
        Integer max = 0;
        Map<String, Integer> map = converListReportDTOToListStringStudent(reportDTOList);
        for (ReportDTO reportDTO : reportDTOList) {
            Integer maxTemp = map.get(reportDTO.getStudentName());
            if (maxTemp > max) {
                max = maxTemp;
            }
        }
        studentPhebinh = getKey(map, max);
        return studentPhebinh;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static final Map<String, Integer> converListReportDTOToListStringStudent(List<ReportDTO> reportDTOList) {
        Map<String, Integer> mapStudentPheBinh = new HashMap<>();
        for (ReportDTO reportDTO : reportDTOList) {
            String name = reportDTO.getStudentName();
            if (mapStudentPheBinh.containsKey(name)) {
                mapStudentPheBinh.replace(name, mapStudentPheBinh.get(name) + 1);
            } else {
                mapStudentPheBinh.put(name, 1);
            }
        }
        return mapStudentPheBinh;
    }

    public static final <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (String.valueOf(entry.getValue()).trim().equals(String.valueOf(value).trim())) {
                return (K) String.valueOf(entry.getKey()).trim();
            }
        }
        return null;
    }

    public static final boolean validateBonusPoint(String bonusName, String bonusPoint) {
        if (bonusName.isEmpty() || bonusPoint.isEmpty()) {
            return false;
        }
        if (!isNumeric(bonusPoint)) {
            return false;
        }
        return true;
    }

    public static SummaryDTO convertSummaryDTO(PointDTO pointDTO, List<ReportDTO> reportDTOList) {
        SummaryDTO summaryDTO = new SummaryDTO();
        if (pointDTO == null || reportDTOList == null) {
            summaryDTO.setChuyenCan("");
            summaryDTO.setNoiQuy("");
            summaryDTO.setVeSinh("");
            summaryDTO.setDaoDuc("");
            summaryDTO.setHocTap("");
            summaryDTO.setSHTT("");
            summaryDTO.setDiemCong("0");
            summaryDTO.setTongDiem("0");
            return summaryDTO;
        }

        Integer diemTru = 0;
        Integer diemCong = 0;
        Float tongDiem = (float) 100;

        Float totalPoint = (float) (pointDTO.getTietA() + pointDTO.getTietB() + pointDTO.getTietC());
        Float phanTramA =  pointDTO.getTietA()* 100 / totalPoint;
        diemCong += pointDTO.getDiemCong();
        summaryDTO.setDiemCong(String.valueOf(diemCong));

        List<ReportDTO> listChuyenCan = new ArrayList<>();
        List<ReportDTO> listNoiQuy = new ArrayList<>();
        List<ReportDTO> listVeSinh = new ArrayList<>();
        List<ReportDTO> listDaoDuc = new ArrayList<>();
        List<ReportDTO> listHocTap = new ArrayList<>();
        List<ReportDTO> listSHTT = new ArrayList<>();


        for (ReportDTO item : reportDTOList) {
            diemTru += item.getMinusPoint();
            switch (item.getCollectionCode()) {
                case DBConstants.COLLECTION_CHUYEN_CAN:
                    listChuyenCan.add(item);
                    break;
                case DBConstants.COLLECTION_THUC_HIEN_NOI_QUY:
                    listNoiQuy.add(item);
                    break;
                case DBConstants.COLLECTION_VE_SINH_LAO_DONG:
                    listVeSinh.add(item);
                    break;
                case DBConstants.COLLECTION_DAO_DUC:
                    listDaoDuc.add(item);
                    break;
                case DBConstants.COLLECTION_HOC_TAP:
                    listHocTap.add(item);
                    break;
                case DBConstants.COLLECTION_SHTT:
                    listSHTT.add(item);
                    break;
                default:
                    Log.e(" log", item.getCollectionCode() + " valid collection");
                    break;
            }
        }
        Map<String, Long> mapChuyenCan = listChuyenCan.stream().collect(Collectors.groupingBy(ReportDTO::getRuleCode, Collectors.counting()));
        Map<String, Long> mapNoiQuy = listNoiQuy.stream().collect(Collectors.groupingBy(ReportDTO::getRuleCode, Collectors.counting()));
        Map<String, Long> mapVeSinh = listVeSinh.stream().collect(Collectors.groupingBy(ReportDTO::getRuleCode, Collectors.counting()));
        Map<String, Long> mapHocTap = listHocTap.stream().collect(Collectors.groupingBy(ReportDTO::getRuleCode, Collectors.counting()));
        Map<String, Long> mapDaoDuc = listDaoDuc.stream().collect(Collectors.groupingBy(ReportDTO::getRuleCode, Collectors.counting()));
        Map<String, Long> mapSHTT = listSHTT.stream().collect(Collectors.groupingBy(ReportDTO::getRuleCode, Collectors.counting()));

        String chuyenCan = generateRuleInfoByMap(mapChuyenCan);
        String noiQuy = generateRuleInfoByMap(mapNoiQuy);
        String veSinh = generateRuleInfoByMap(mapVeSinh);
        String daoDuc = generateRuleInfoByMap(mapDaoDuc);
        String hocTap = generateHocTapInfoByMap(mapHocTap, pointDTO, phanTramA);
        String shtt = generateRuleInfoByMap(mapSHTT);

        summaryDTO.setChuyenCan(chuyenCan);
        summaryDTO.setNoiQuy(noiQuy);
        summaryDTO.setVeSinh(veSinh);
        summaryDTO.setDaoDuc(daoDuc);
        summaryDTO.setHocTap(hocTap);
        summaryDTO.setSHTT(shtt);

        tongDiem += diemCong + phanTramA + diemTru;
        summaryDTO.setTongDiem(String.valueOf(tongDiem));

        return summaryDTO;
    }

    public static String generateRuleInfoByMap(Map<String, Long> map) {
        StringBuilder result = new StringBuilder("");
        boolean isNoneHeader = false;
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (isNoneHeader) {
                result.append("\n");
            } else {
                isNoneHeader = true;
            }
            result.append(entry.getValue());
            result.append("-");
            result.append(DBConstants.mapRuleNameMore.get(entry.getKey()));
            result.append("(");
            result.append(DBConstants.mapRuleMinus.get(entry.getKey()) * entry.getValue());
            result.append(")");
            result.append(" ");
        }
        return result.toString();
    }

    public static String generateHocTapInfoByMap(Map<String, Long> map, PointDTO pointDTO, Float phanTramA) {

        StringBuilder result = new StringBuilder("");

        //dòng 1
        boolean isNoneHeader = false;
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (isNoneHeader) {
                result.append("\n");
            } else {
                isNoneHeader = true;
            }
            result.append(entry.getValue());
            result.append("-");
            result.append(DBConstants.mapRuleNameMore.get(entry.getKey()));
            result.append("(");
            result.append(DBConstants.mapRuleMinus.get(entry.getKey()) * entry.getValue());
            result.append(")");
            result.append(" ");
        }
        if(!map.isEmpty()){
            result.append("\n");
        }
        //dòng 2
        if (!pointDTO.getTietA().equals(0)) {
            result.append(pointDTO.getTietA() + "A");
        }
        if (!pointDTO.getTietB().equals(0)) {
            result.append(",");
            result.append(pointDTO.getTietB() + "B");
        }
        result.append(",");
        if (!pointDTO.getTietC().equals(0)) {
            result.append(pointDTO.getTietC() + "C");
        }
        //dòng 3

        Float totalPoint = (float) (pointDTO.getTietA() + pointDTO.getTietB() + pointDTO.getTietC());
        result.append("\n");
        result.append("%A: " + String.format("%.2f", phanTramA));
        return result.toString();
    }


    public static String addString(String str, String addedString) {
        if (str == null || str.isEmpty() || str.equals("0")) {
            return new String("");
        }
        return ", " + str + addedString;
    }

    public static String addString(String str, String addedString, boolean isHead) {
        if (str == null || str.isEmpty() || str.equals("0")) {
            return new String("");
        }
        if (isHead) {
            return str + addedString;
        } else {
            return ", " + str + addedString;
        }
    }


    public static Integer countRuleInReport(List<ReportDTO> list, String ruleCode) {
        Integer count = 0;
        for (ReportDTO reportDTO : list) {
            if (reportDTO.getRuleCode().equals(ruleCode)) {
                count++;
            }
        }

        return count;
    }

//    public static Integer countRuleInReport(List<ReportDTO> list, String ruleCode, Integer group){
//        Integer count = 0;
//        for (ReportDTO reportDTO: list) {
//            if(reportDTO.getGroupId() == group && reportDTO.getRuleCode().equals(ruleCode)){
//                count++;
//            }
//        }
//
//        return count;
//    }

    public static String exportNumberToString(String str) {
        if (StringUtils.isBlank(str)) {
            return "0";
        }
        return str;
    }

    public static String exportString(String str) {
        if (StringUtils.isBlank(str)) {
            return StringUtils.EMPTY;
        }
        return str;
    }

    public static String converObjectToString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String oldSerial = mapper.writeValueAsString(object);
            return oldSerial;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Drawable loadDrawableFromAssets(Context context, String path)
    {
        InputStream stream = null;
        try
        {
            stream = context.getAssets().open(path);
            return Drawable.createFromStream(stream, null);
        }
        catch (Exception ignored) {} finally
        {
            try
            {
                if(stream != null)
                {
                    stream.close();
                }
            } catch (Exception ignored) {}
        }
        return null;
    }
}
