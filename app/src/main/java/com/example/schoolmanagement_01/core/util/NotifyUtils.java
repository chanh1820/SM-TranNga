package com.example.schoolmanagement_01.core.util;

import android.content.Context;
import android.widget.Toast;

public class NotifyUtils {

    public static final void defaultNotify(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
