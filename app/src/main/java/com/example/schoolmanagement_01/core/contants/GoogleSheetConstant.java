package com.example.schoolmanagement_01.core.contants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleSheetConstant {
    public static final String END_POINT_URL = "https://script.google.com/macros/s/AKfycbxMtl4t8350ojJJSz69NbIj0NipzexwHMJy2KlNpNJHx--9gjD7xDwnuWlAhLhYeFc/exec";
    /**
     * action
     */
    public static final String ACTION_SAVE_REPORT = "SAVE_REPORT";
    public static final String ACTION_SAVE_POINT = "SAVE_POINT";


    public static final Integer STATUS_SUCCESS = 200;

    public static final Integer STATUS_FAIL = 500;

    public static final Integer STATUS_PASSWORD_FAIL = 201;

    public static final Integer STATUS_USER_FAIL = 202;


    public static final String FLAG_IS_LOGIN = "1";

    public static final String FLAG_NONE_LOGIN = "0";
        public static final String ROLE_CO_DO = "1";

    public static final String ROLE_TONG_PHU_TRACH = "2";

    public static final String ROLE_GIAO_VIEN= "3";


    public static final List<String> listRole = new ArrayList<String>(){{
        add(ROLE_CO_DO);
        add(ROLE_TONG_PHU_TRACH);
        add(ROLE_GIAO_VIEN);
//        add(ROLE_CAN_BO_LOP);
//        add(ROLE_TONG_PHU_TRACH);
    }};

    public static final Map<Integer, String> mapResponseStatus = new HashMap<Integer, String >(){{
       put(STATUS_SUCCESS, "Thành công");
       put(STATUS_FAIL, "Thất bại");
       put(STATUS_PASSWORD_FAIL, "Sai mật khẩu");
       put(STATUS_USER_FAIL, "Tài khoản không tồn tại");
    }};


}
