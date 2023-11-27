package com.example.schoolmanagement_01.core.contants;

import android.graphics.Color;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.CalculatorMinusMap;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;
import com.example.schoolmanagement_01.core.dto.SettingDTO;
import com.example.schoolmanagement_01.core.dto.SummaryExportDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConstants {

    /**
     * classRoomDTOS
     */

    public static final ArrayList<ClassRoomDTO> classRoomDTOS = new ArrayList<ClassRoomDTO>() {{
        add(new ClassRoomDTO(1, "101", "10.1", "37/25", 0, Color.GREEN));
        add(new ClassRoomDTO(2, "111", "11.1", "34/18", 1, Color.BLUE));
        add(new ClassRoomDTO(3, "121", "12.1", "30/17", 2, Color.RED));
        add(new ClassRoomDTO(4, "122", "12.2", "27/9", 2, Color.RED));
        //add(new ClassRoomDTO(9,"0904","9/4")) ;
    }};

    public static final List<String> listKhoi = new ArrayList<String>() {{
        add("10");
        add("11");
        add("12");
    }};

    public static final Map<String, String> mapNumberClassRoom = new HashMap<String, String>() {{
        for (ClassRoomDTO classRoomDTO : classRoomDTOS) {
            put(classRoomDTO.getClassName(), classRoomDTO.getNumber());
        }
    }};
    public static final ArrayList<String> listClassRoom = new ArrayList<String>() {{
        for (ClassRoomDTO classRoomDTO : classRoomDTOS) {
            add(classRoomDTO.getClassName());
        }
    }};


    public static final Map<Integer, String> mapTuan = new HashMap<Integer, String>() {{
        put(1, "(Từ 05/9/2022 đến 10/9/2022)");
        put(2, "(Từ 12/9/2022 đến 17/9/2022)");
        put(3, "(Từ 19/9/2022 đến 24/9/2022)");
        put(4, "(Từ 26/9/2022 đến 01/9/2022)");
        put(5, "(Từ 03/10/2022 đến 08/10/2022)");
        put(6, "(Từ 10/10/2022 đến 15/10/2022)");
        put(7, "(Từ 17/10/2022 đến 22/10/2022)");
        put(8, "(Từ 24/10/2022 đến 29/10/2022)");
        put(9, "(Từ 31/10/2022 đến 05/11/2022)");
        put(10, "(Từ 07/11/2022 đến 12/11/2022)");
        put(11, "(Từ 14/11/2022 đến 19/11/2022)");
        put(12, "(Từ 21/11/2022 đến 26/11/2022)");
        put(13, "(Từ 28/11/2022 đến 03/12/2022)");
        put(14, "(Từ 05/12/2022 đến 10/12/2022)");
        put(15, "(Từ 12/12/2022 đến 17/12/2022)");
        put(16, "(Từ 19/12/2022 đến 24/12/2022)");
        put(17, "(Từ 26/12/2022 đến 31/12/2022)");
        put(18, "(Từ 02/01/2023 đến 07/01/2023)");
        put(19, "(Từ 09/01/2023 đến 14/01/2023)");
        put(20, "(Từ 30/01/2023 đến 04/02/2023)");
        put(21, "(Từ 06/02/2023 đến 11/02/2023)");
        put(22, "(Từ 13/02/2023 đến 18/02/2023)");
        put(23, "(Từ 20/02/2023 đến 25/02/2023)");
        put(24, "(Từ 27/02/2023 đến 04/3/2023)");
        put(25, "(Từ 06/3/2023 đến 11/3/2023)");
        put(26, "(Từ 13/3/2023 đến 18/3/2023)");
        put(27, "(Từ 20/3/2023 đến 25/3/2023)");
        put(28, "(Từ 27/3/2023 đến 01/4/2023)");
        put(29, "(Từ 03/4/2023 đến 08/4/2023)");
        put(30, "(Từ 10/4/2023 đến 15/4/2023)");
        put(31, "(Từ 17/4/2023 đến 22/4/2023)");
        put(32, "(Từ 24/4/2023 đến 29/4/2023)");
        put(33, "(Từ 01/5/2023 đến 06/5/2023)");
        put(34, "(Từ 08/5/2023 đến 13/5/2023)");
        put(35, "(Từ 15/5/2023 đến 20/5/2023)");
    }};

    public static final List<String> listClassSang = new ArrayList<String>() {{
        add("10.1");
        add("11.1");
        add("12.1");
        add("12.2");
    }};
    public static final List<String> listClassChieu = new ArrayList<String>() {{
        add("10.1");
        add("11.1");
        add("12.1");
        add("12.2");
    }};
    /**
     * listRuleDTO
     */
    public static final String COLLECTION_VI_PHAM_KHAC = "0";
    public static final String COLLECTION_CHUYEN_CAN = "1";
    public static final String COLLECTION_THUC_HIEN_NOI_QUY = "2";
    public static final String COLLECTION_VE_SINH_LAO_DONG = "3";
    public static final String COLLECTION_DAO_DUC = "4";
    public static final String COLLECTION_HOC_TAP = "5";
    public static final String COLLECTION_SHTT = "6";

    public static final List<RuleDTO> listRuleDTO = new ArrayList<RuleDTO>() {{
        add(new RuleDTO(1, "A", 0, "Hoc sinh trực", "", 0, 2));
        add(new RuleDTO(0, "A01", COLLECTION_CHUYEN_CAN, 1, "Vắng tiết 1", "", 3, -1));
        add(new RuleDTO(0, "A02", COLLECTION_CHUYEN_CAN, 1, "Vắng có phép", "", 3, -2));
        add(new RuleDTO(0, "A03", COLLECTION_CHUYEN_CAN, 1, "Vắng không phép", "", 3, -5));
        add(new RuleDTO(0, "A04", COLLECTION_THUC_HIEN_NOI_QUY, 1, "Không xếp hàng", "", 3, -5));
        add(new RuleDTO(0, "A05", COLLECTION_VE_SINH_LAO_DONG, 1, "VS sân không tốt", "", 3, -5));
        add(new RuleDTO(0, "A06", COLLECTION_VE_SINH_LAO_DONG, 1, "VS cuối buổi không tốt", "", 3, -5));
        add(new RuleDTO(0, "A07", COLLECTION_VE_SINH_LAO_DONG, 1, "Không tắt đèn, quạt cuối buổi", "", 3, -5));
        add(new RuleDTO(0, "A08", COLLECTION_VE_SINH_LAO_DONG, 1, "Xếp ghế trễ", "", 3, -2));
        add(new RuleDTO(0, "A09", COLLECTION_VE_SINH_LAO_DONG, 1, "Bỏ ghế ở sân trường", "", 3, -5));
        add(new RuleDTO(0, "A10", COLLECTION_VE_SINH_LAO_DONG, 1, "Lấy và xếp không đúng chỗ", "", 3, -10));
        add(new RuleDTO(0, "A11", COLLECTION_VI_PHAM_KHAC, 1, "Vi phạm khác", "", 3, 0));

        add(new RuleDTO(2, "B", 0, "Bảo vệ, giáo viên ghi nhận", "", 0, 4));
        add(new RuleDTO(0, "B01", COLLECTION_CHUYEN_CAN, 2, "Trễ", "Trễ", 4, -1));
        add(new RuleDTO(0, "B02", COLLECTION_THUC_HIEN_NOI_QUY, 2, "Đồng phục", "", 4, -5));
        add(new RuleDTO(0, "B03", COLLECTION_THUC_HIEN_NOI_QUY, 2, "Tóc, móng tay/chân", "", 4, -5));
        add(new RuleDTO(0, "B04", COLLECTION_THUC_HIEN_NOI_QUY, 2, "Không xếp hàng", "", 4, -5));
        add(new RuleDTO(0, "B05", COLLECTION_THUC_HIEN_NOI_QUY, 2, "Không tập TD", "", 4, -5));
        add(new RuleDTO(0, "B06", COLLECTION_THUC_HIEN_NOI_QUY, 2, "Ăn trong lớp", "", 4, -5));
        add(new RuleDTO(0, "B07", COLLECTION_THUC_HIEN_NOI_QUY, 2, "Đi xe gắn máy", "", 4, -20));
        add(new RuleDTO(0, "B08", COLLECTION_THUC_HIEN_NOI_QUY, 2, "Sử dụng ĐT", "", 4, -20));
        add(new RuleDTO(0, "B09", COLLECTION_VE_SINH_LAO_DONG, 2, "VS sân không tốt", "", 4, -5));
        add(new RuleDTO(0, "B10", COLLECTION_VE_SINH_LAO_DONG, 2, "VS cuối buổi không tốt", "", 4, -5));
        add(new RuleDTO(0, "B11", COLLECTION_VE_SINH_LAO_DONG, 2, "Không tắt đèn, quạt cuối buổi", "", 4, -5));
        add(new RuleDTO(0, "B12", COLLECTION_VE_SINH_LAO_DONG, 2, "Trễ lao động", "", 4, -2));
        add(new RuleDTO(0, "B13", COLLECTION_VE_SINH_LAO_DONG, 2, "Vắng không phép lao động", "", 4, -5));
        add(new RuleDTO(0, "B14", COLLECTION_VE_SINH_LAO_DONG, 2, "Lao động chưa tốt", "", 4, -10));
        add(new RuleDTO(0, "B15", COLLECTION_VE_SINH_LAO_DONG, 2, "Bỏ trực", "", 4, -20));
        add(new RuleDTO(0, "B16", COLLECTION_VE_SINH_LAO_DONG, 2, "Trực trễ", "", 4, -10));
        add(new RuleDTO(0, "B17", COLLECTION_VE_SINH_LAO_DONG, 2, "Tự ý bỏ về", "", 4, -10));
        add(new RuleDTO(0, "B18", COLLECTION_VE_SINH_LAO_DONG, 2, "Số lượng trực không đủ", "", 4, -5));
        add(new RuleDTO(0, "B19", COLLECTION_VE_SINH_LAO_DONG, 2, "Không hoàn thành nhiệm vụ", "", 4, -10));
        add(new RuleDTO(0, "B20", COLLECTION_VE_SINH_LAO_DONG, 2, "Xếp ghế trễ", "", 4, -2));
        add(new RuleDTO(0, "B21", COLLECTION_VE_SINH_LAO_DONG, 2, "Bỏ ghế ở sân trường", "", 4, -5));
        add(new RuleDTO(0, "B22", COLLECTION_VE_SINH_LAO_DONG, 2, "Lấy và xếp không đúng chỗ", "", 4, -10));
        add(new RuleDTO(0, "B23", COLLECTION_DAO_DUC, 2, "Chống đối", "", 4, -10));
        add(new RuleDTO(0, "B24", COLLECTION_DAO_DUC, 2, "Nói tục, chửi thề", "", 4, -10));
        add(new RuleDTO(0, "B25", COLLECTION_DAO_DUC, 2, "Hút thuốc", "", 4, -20));
        add(new RuleDTO(0, "B26", COLLECTION_DAO_DUC, 2, "Không trung thực", "", 4, -20));
        add(new RuleDTO(0, "B27", COLLECTION_DAO_DUC, 2, "Vô lễ", "", 4, -20));
        add(new RuleDTO(0, "B28", COLLECTION_HOC_TAP, 2, "Vi phạm kiểm tra ", "", 4, -5));
        add(new RuleDTO(0, "B29", COLLECTION_HOC_TAP, 2, "Mất trật tự ", "", 4, -10));
        add(new RuleDTO(0, "B30", COLLECTION_SHTT, 2, "Công trình thanh niên tốt", "", 4, 10));
        add(new RuleDTO(0, "B31", COLLECTION_SHTT, 2, "Công trình thanh niên chưa tốt", "", 4, -10));
        add(new RuleDTO(0, "B32", COLLECTION_SHTT, 2, "Phong trào đoàn tốt", "", 4, 10));
        add(new RuleDTO(0, "B33", COLLECTION_SHTT, 2, "Phong trào đoàn chưa tốt", "", 4, -10));
        add(new RuleDTO(0, "B34", COLLECTION_VI_PHAM_KHAC, 2, "Vi phạm khác", "", 3, 0));

        add(new RuleDTO(3, "C", 0, "Ban cán bộ lớp", "", 0, 5));
        add(new RuleDTO(0, "C01", COLLECTION_CHUYEN_CAN, 3, "Vắng tiết 1", "", 4, -1));
        add(new RuleDTO(0, "C02", COLLECTION_CHUYEN_CAN, 3, "Vắng có phép", "", 4, -2));
        add(new RuleDTO(0, "C03", COLLECTION_CHUYEN_CAN, 3, "Vắng không phép", "", 4, -5));
        add(new RuleDTO(0, "C04", COLLECTION_CHUYEN_CAN, 3, "Bỏ tiết", "", 4, -5));
        add(new RuleDTO(0, "C05", COLLECTION_THUC_HIEN_NOI_QUY, 3, "Đồng phục", "", 4, -5));
        add(new RuleDTO(0, "C06", COLLECTION_THUC_HIEN_NOI_QUY, 3, "Tóc, móng tay/chân", "", 4, -5));
        add(new RuleDTO(0, "C07", COLLECTION_THUC_HIEN_NOI_QUY, 3, "Không xếp hàng", "", 4, -5));
        add(new RuleDTO(0, "C08", COLLECTION_THUC_HIEN_NOI_QUY, 3, "Không tập TD", "", 4, -5));
        add(new RuleDTO(0, "C09", COLLECTION_THUC_HIEN_NOI_QUY, 3, "Ăn trong lớp", "", 4, -5));
        add(new RuleDTO(0, "C10", COLLECTION_THUC_HIEN_NOI_QUY, 3, "Đi xe gắn máy", "", 4, -20));
        add(new RuleDTO(0, "C11", COLLECTION_THUC_HIEN_NOI_QUY, 3, "Sử dụng ĐT", "", 4, -20));
        add(new RuleDTO(0, "C12", COLLECTION_VE_SINH_LAO_DONG, 3, "Trễ lao động", "", 4, -2));
        add(new RuleDTO(0, "C13", COLLECTION_VE_SINH_LAO_DONG, 3, "Vắng không phép lao động", "", 4, -5));
        add(new RuleDTO(0, "C14", COLLECTION_VE_SINH_LAO_DONG, 3, "Lao động chưa tốt", "", 4, -10));
        add(new RuleDTO(0, "C15", COLLECTION_VI_PHAM_KHAC, 3, "Vi phạm khác", "", 3, 0));

    }};
    public static final Map<String, String> mapRuleNameMore = new HashMap<String, String>() {{
        put("A01", "Vắng tiết 1");
        put("A02", "VCP");
        put("A03", "VKP");
        put("A04", "KXH");
        put("A05", "VS sân không tốt");
        put("A06", "VS cuối buổi không tốt");
        put("A07", "Không tắt đèn, quạt cuối buổi");
        put("A08", "Xếp ghế trễ");
        put("A09", "Bỏ ghế ở sân trường");
        put("A10", "Lấy và xếp không đúng chỗ");
        put("A11", "Khác");

        put("B01", "Trễ");
        put("B02", "Đồng phục");
        put("B03", "Tóc, móng tay/chân");
        put("B04", "Không xếp hàng");
        put("B05", "Không tập TD");
        put("B06", "Ăn trong lớp");
        put("B07", "Đi xe gắn máy");
        put("B08", "Sử dụng ĐT");
        put("B09", "VS sân không tốt");
        put("B10", "VS cuối buổi không tốt");
        put("B11", "Không tắt đèn, quạt cuối buổi");
        put("B12", "Trễ LĐ");
        put("B13", "VKP LĐ");
        put("B14", "LĐ chưa tốt");
        put("B15", "Bỏ trực");
        put("B16", "Trực trễ");
        put("B17", "Tự ý bỏ về");
        put("B18", "Số lượng trực không đủ");
        put("B19", "Không hoàn thành nhiệm vụ");
        put("B20", "Xếp ghế trễ");
        put("B21", "Bỏ ghế ở sân trường");
        put("B22", "Lấy và xếp không đúng chỗ");
        put("B23", "Chống đối");
        put("B24", "Nói tục, chửi thề");
        put("B25", "Hút thuốc");
        put("B26", "Không trung thực");
        put("B27", "Vô lễ");
        put("B28", "VP KT");
        put("B29", "Mất trật tự");
        put("B30", "CTTN tốt");
        put("B31", "CTTN chưa tốt");
        put("B32", "PTĐ tốt");
        put("B33", "PTĐ chưa tốt");
        put("B34", "Khác");

        put("C01", "Vắng tiết 1");
        put("C02", "VCP");
        put("C03", "VKP");
        put("C04", "Bỏ tiết");
        put("C05", "Đồng phục");
        put("C06", "Tóc, móng tay/chân");
        put("C07", "Không xếp hàng");
        put("C08", "Không tập TD");
        put("C09", "Ăn trong lớp");
        put("C10", "Đi xe gắn máy");
        put("C11", "Sử dụng ĐT");
        put("C12", "Trễ LĐ");
        put("C13", "VKP LĐ");
        put("C14", "LĐ chưa tốt");
        put("C15", "Khác");


    }};
    public static final Map<String, Integer> mapRuleMinus = new HashMap<String, Integer>() {{
        for (RuleDTO item : listRuleDTO) {
            if (item.getParentId() != 0) {
                put(item.getRuleCode(), item.getMinusPoint());
            }
        }
    }};
    /**
     * listWeek
     */
    public static final List<String> listWeek = new ArrayList<String>() {{
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
        add("6");
        add("7");
        add("8");
        add("9");
        add("10");
        add("11");
        add("12");
        add("13");
        add("14");
        add("15");
        add("16");
        add("17");
        add("18");
        add("19");
        add("20");
        add("21");
        add("22");
        add("23");
        add("24");
        add("25");
        add("26");
        add("27");
        add("28");
        add("29");
        add("30");
        add("31");
        add("32");
        add("33");
        add("34");
        add("35");
        add("36");
        add("37");
        add("38");
        add("39");
        add("40");
    }};
    public static final List<String> listYear = new ArrayList<String>() {{
        add("2023-2024");
        add("2024-2025");
        add("2025-2026");
        add("2026-2027");
        add("2027-2028");
        add("2028-2029");

    }};

    public static final Map<Integer, CalculatorMinusMap> calculatorMinusMap = new HashMap<Integer, CalculatorMinusMap>() {{
        put(2, new CalculatorMinusMap(-2, 1));
        put(3, new CalculatorMinusMap(-1, 1));

        put(5, new CalculatorMinusMap(-2, 4));
        put(6, new CalculatorMinusMap(-2, 4));
        put(7, new CalculatorMinusMap(-2, 4));

        put(9, new CalculatorMinusMap(-2, 8));
        put(10, new CalculatorMinusMap(-2, 8));
        put(11, new CalculatorMinusMap(-2, 8));
        put(12, new CalculatorMinusMap(-5, 8));
        put(13, new CalculatorMinusMap(-5, 8));
        put(14, new CalculatorMinusMap(-5, 8));
        put(15, new CalculatorMinusMap(-2, 8));

        put(17, new CalculatorMinusMap(-5, 16));
        put(18, new CalculatorMinusMap(-2, 16));
    }};

    public static final List<String> listSession = new ArrayList<String>() {{
        add("Sáng");
        add("Chiều");
    }};

    public static final SummaryExportDTO summaryExportHeader
            = new SummaryExportDTO(
            "Lớp",
            "Sĩ số",
            "Tiết A",
            "Tiết B",
            "Tiết C",
            "Tiết D",
            "Nghỉ học",
            "Đi trễ",
            "Vi phạm khác",
            "KLB, KTB",
            "Tự quản",
            "Vệ sinh",
            "Phong trào",
            "THT",
            "Điểm trừ",
            "Tổng điểm",
            "Xếp hạng"
    );
    public static final List<SettingDTO> listSettingDTO = new ArrayList<SettingDTO>() {{
        add(new SettingDTO("Đăng xuất", R.drawable.ic_baseline_logout_24));
    }};

    public static final String ASSET_PATH_LOP_11_1 = "lop11.1/";
}
