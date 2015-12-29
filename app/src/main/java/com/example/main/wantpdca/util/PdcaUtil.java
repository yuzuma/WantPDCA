package com.example.main.wantpdca.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by main on 2015/12/28.
 */
public class PdcaUtil {

    public static void show(Context context,String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
