package com.example.schoolmanagement_01.core.contants;

import android.graphics.Color;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.CalculatorMinusMap;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.dto.RuleCollectionDTO;
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
        add(new ClassRoomDTO(1, "101", "6A1", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "6A2", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "6A3", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "6A4", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "6A5", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "6A6", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "6A7", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "7B1", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "7B2", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "7B3", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "7B4", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "8C1", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "8C2", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "8C3", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "8C4", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "9D1", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "9D2", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "9D3", "", 0, Color.GREEN));
        add(new ClassRoomDTO(1, "101", "9D4", "", 0, Color.GREEN));
        //add(new ClassRoomDTO(9,"0904","9/4")) ;
    }};

    public static final List<String> listKhoi = new ArrayList<String>() {{
        add("6A1");
        add("6A2");
        add("6A3");
        add("6A4");
        add("6A5");
        add("6A6");
        add("6A7");
        add("7A1");
        add("7A2");
        add("7A3");
        add("7A4");
        add("8A1");
        add("8A2");
        add("8A3");
        add("8A4");
        add("9A1");
        add("9A2");
        add("9A3");
        add("9A4");
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

    public static final Map<String, String> COLLECTION_REPORT_MAP = new HashMap<String, String>() {{
        put(COLLECTION_DAO_DUC, "Đạo đức");
        put(COLLECTION_HOC_TAP, "Học tập");
        put(COLLECTION_NE_NEP, "Nề nếp");
        put(COLLECTION_THE_DUC, "Thể dục");
        put(COLLECTION_CHAO_CO, "Chào cờ");
        put(COLLECTION_KHAC, "Khác");
        put(COLLECTION_DIEM_CONG, "Điểm cộng");
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
        add("6A1");
        add("6A2");
        add("6A3");
        add("6A4");
        add("6A5");
        add("6A6");
        add("6A7");
        add("7B1");
        add("7B2");
        add("7B3");
        add("7B4");
        add("8C1");
        add("8C2");
        add("8C3");
        add("8C4");
        add("9D1");
        add("9D2");
        add("9D3");
        add("9D4");
    }};
    public static final List<String> listClassChieu = new ArrayList<String>() {{


    }};
    /**
     * listRuleDTO
     */
    public static final String COLLECTION_TAT_CA = "0";
    public static final String COLLECTION_DAO_DUC = "1";
    public static final String COLLECTION_HOC_TAP = "2";
    public static final String COLLECTION_NE_NEP = "3";
    public static final String COLLECTION_THE_DUC = "4";
    public static final String COLLECTION_CHAO_CO = "5";
    public static final String COLLECTION_KHAC = "6";
    public static final String COLLECTION_DIEM_CONG = "7";


    public static final String GROUP_DAO_DUC = "1";
    public static final String GROUP_HOC_TAP = "2";
    public static final String GROUP_NE_NEP = "3";
    public static final String GROUP_KHAC = "4";
    public static final String GROUP_DIEM_CONG = "5";
    public static final List<RuleCollectionDTO> RULE_COLLECTION_DTO_LIST = new ArrayList<RuleCollectionDTO>() {{
        add(new RuleCollectionDTO(0,"Tất cả", COLLECTION_TAT_CA));
        add(new RuleCollectionDTO(1,"Đạo đức", COLLECTION_DAO_DUC));
        add(new RuleCollectionDTO(2,"Học tập", COLLECTION_HOC_TAP));
        add(new RuleCollectionDTO(3,"Nề nếp", COLLECTION_NE_NEP));
        add(new RuleCollectionDTO(4,"Thể dục giữa gi", COLLECTION_THE_DUC));
        add(new RuleCollectionDTO(5,"Chào cờ", COLLECTION_CHAO_CO));
        add(new RuleCollectionDTO(6,"Khác", COLLECTION_KHAC));
        add(new RuleCollectionDTO(7,"Điểm cộng", COLLECTION_DIEM_CONG));
    }};
    public static final List<RuleDTO> listRuleDTO = new ArrayList<RuleDTO>() {{
        add(new RuleDTO(1, COLLECTION_DAO_DUC, 0, "Đạo đức", "", GROUP_DAO_DUC, 0));
        add(new RuleDTO(2, COLLECTION_DAO_DUC, 1, "Nói tục, mang các loại đồ chơi bị cấm đến trường", "", GROUP_DAO_DUC, -5));
        add(new RuleDTO(3, COLLECTION_DAO_DUC, 1, "Hút thuốc, uống rượu bia, dùng chất kích thích", "", GROUP_DAO_DUC, -5));
        add(new RuleDTO(4, COLLECTION_DAO_DUC, 1, "Đánh nhau gây mất đoàn kết nội bộ trong trường, lớp", "", GROUP_DAO_DUC, -5));
        add(new RuleDTO(5, COLLECTION_DAO_DUC, 1, "Xúc phạm bạn bè, học sinh trong trường, lớp", "", GROUP_DAO_DUC, -5));
        add(new RuleDTO(6, COLLECTION_DAO_DUC, 1, "Vô lễ với cán bộ, giáo viên, nhân viên và người lớn tuổi", "", GROUP_DAO_DUC, -5));
        add(new RuleDTO(7, COLLECTION_DAO_DUC, 1, "Ăn quà trong lớp, chơi điện tử, nhuộm tóc", "", GROUP_DAO_DUC, -5));

        add(new RuleDTO(9, COLLECTION_HOC_TAP, 0, "Học tập", "", GROUP_HOC_TAP, 0));
        add(new RuleDTO(10, COLLECTION_HOC_TAP, 9, "Không làm bài tập trước khi đến lớp.", "", GROUP_HOC_TAP, -2));
        add(new RuleDTO(11, COLLECTION_HOC_TAP, 9, "Mất trật tự, vi phạm nội qui tiết học ", "", GROUP_HOC_TAP, -2));
        add(new RuleDTO(12, COLLECTION_HOC_TAP, 9, "Thiếu đồ dùng học tập", "", GROUP_HOC_TAP, -2));
        add(new RuleDTO(13, COLLECTION_HOC_TAP, 9, "Nghỉ học không phép hoặc có phép nhưng không hợp lệ", "", GROUP_HOC_TAP, -2));

        add(new RuleDTO(14, COLLECTION_NE_NEP, 0, "Nề nếp", "", GROUP_NE_NEP, 0));
        add(new RuleDTO(15, COLLECTION_NE_NEP, 14, "Sử dụng điện thoại  khi chưa được sự cho phép của GV", "", GROUP_NE_NEP, -5));
        add(new RuleDTO(16, COLLECTION_NE_NEP, 14, "Đi học muộn (trừ thời tiết đặc biệt)", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(17, COLLECTION_NE_NEP, 14, "Trốn học, bỏ giờ, trốn truy bài", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(18, COLLECTION_NE_NEP, 14, "Đọc báo", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(19, COLLECTION_NE_NEP, 14, "Ôn các bài hát truyền thống Đội, Đoàn, quê hương", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(20, COLLECTION_NE_NEP, 14, "Tự ý ra ngoài", "", GROUP_NE_NEP, -20));
        add(new RuleDTO(21, COLLECTION_NE_NEP, 14, "Không thực hiện quy định 15 phút đầu giờ ", "", GROUP_NE_NEP, -20));
        add(new RuleDTO(22, COLLECTION_NE_NEP, 14, "Trang phục", "", GROUP_NE_NEP, -4));
        add(new RuleDTO(23, COLLECTION_NE_NEP, 14, "Nhuộm tóc màu , vẽ mõng tay, mặc quần bò rách..", "", GROUP_NE_NEP, -5));
        add(new RuleDTO(24, COLLECTION_NE_NEP, 14, "Ăn quà vặt trong lớp", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(25, COLLECTION_NE_NEP, 14, "Vệ sinh bẩn", "", GROUP_NE_NEP, -10));
        add(new RuleDTO(26, COLLECTION_NE_NEP, 14, "Vệ sinh muộn", "", GROUP_NE_NEP, -5));
        add(new RuleDTO(27, COLLECTION_NE_NEP, 14, "Ý thức giữ gìn vệ sinh chung", "", GROUP_NE_NEP, -10));
        add(new RuleDTO(28, COLLECTION_NE_NEP, 14, "Ý thức bảo vệ của công", "", GROUP_NE_NEP, -10));
        add(new RuleDTO(29, COLLECTION_NE_NEP, 14, "Không tiết kiệm điện, không đóng cửa sổ, cửa lớp khi tan học.", "", GROUP_NE_NEP, -10));

        add(new RuleDTO(30, COLLECTION_THE_DUC, 0, "Thể dục giữa giờ", "", GROUP_NE_NEP, 0));
        add(new RuleDTO(31, COLLECTION_THE_DUC, 30, "Trốn múa, thể dục, hoạt động ngoại khóa", "", GROUP_NE_NEP, -4));
        add(new RuleDTO(32, COLLECTION_THE_DUC, 30, "Không tập, tập không đúng, không đều.", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(33, COLLECTION_THE_DUC, 30, "Thiếu đạo cụ múa", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(34, COLLECTION_THE_DUC, 30, "Xếp hàng chậm, hàng cong", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(35, COLLECTION_THE_DUC, 30, "Dồn, dàn hàng chậm", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(36, COLLECTION_THE_DUC, 30, "Đứng không đúng thứ tự, không đúng lớp", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(37, COLLECTION_THE_DUC, 30, "Mất trật tự", "", GROUP_NE_NEP, -2));
        add(new RuleDTO(38, COLLECTION_THE_DUC, 30, "Giải tán trước hiệu lệnh", "", GROUP_NE_NEP, -2));

        add(new RuleDTO(39, COLLECTION_CHAO_CO, 0, "Chào cờ", "", GROUP_NE_NEP, 0));
        add(new RuleDTO(40, COLLECTION_CHAO_CO, 39, "Trốn chào cờ (có lý do đặc biệt báo đội cờ đỏ)", "", GROUP_NE_NEP, -5));
        add(new RuleDTO(41, COLLECTION_CHAO_CO, 39, "Không hát, hát nhỏ, hát xuyên tạc", "", GROUP_NE_NEP, -5));
        add(new RuleDTO(42, COLLECTION_CHAO_CO, 39, "Mất trật tự để giáo viên phê bình", "", GROUP_NE_NEP, -5));

        add(new RuleDTO(43, COLLECTION_KHAC, 0, "Khác", "", GROUP_KHAC, 0));
        add(new RuleDTO(44, COLLECTION_KHAC, 43, "Tập trung khu vực cổng trường. Để xe không đúng nơi quy định", "", GROUP_KHAC, -5));
        add(new RuleDTO(45, COLLECTION_KHAC, 43, "Vi phạm luật ATGT.", "", GROUP_KHAC, -10));
        add(new RuleDTO(46, COLLECTION_KHAC, 43, "Đi xe đạp trên sân trường", "", GROUP_KHAC, -10));
        add(new RuleDTO(47, COLLECTION_KHAC, 43, "Bảo quản số đầu bài", "", GROUP_KHAC, -10));
        add(new RuleDTO(47, COLLECTION_KHAC, 43, "Tham gia đầy đủ hoạt động các CLB", "", GROUP_KHAC, -10));
        add(new RuleDTO(48, COLLECTION_KHAC, 43, "Thiếu bài dự thi, bản kiểm điểm.", "", GROUP_KHAC, -5));
        add(new RuleDTO(49, COLLECTION_KHAC, 43, "Không đạt các chuyên hiệu theo quy định.", "", GROUP_KHAC, -5));

        add(new RuleDTO(50, COLLECTION_DIEM_CONG, 0, "Điểm cộng", "", GROUP_DIEM_CONG, 0));
        add(new RuleDTO(51, COLLECTION_DIEM_CONG, 50, "Trả bài trên 8 điểm", "", GROUP_DIEM_CONG, 2));
        add(new RuleDTO(52, COLLECTION_DAO_DUC, 50, "Nhặt và trả lại của rơi trị giá từ 50 000đ trở lên", "", GROUP_DIEM_CONG, 20));
        add(new RuleDTO(53, COLLECTION_DAO_DUC, 50, "Giúp đỡ người hoạn nạn", "", GROUP_DIEM_CONG, 20));
        add(new RuleDTO(54, COLLECTION_DAO_DUC, 50, "Tuyên dương", "", GROUP_DIEM_CONG, 20));

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
//        add("Chiều");
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

    public static final Integer DEFAULT_POINT_OF_WEEK = 500;
}
