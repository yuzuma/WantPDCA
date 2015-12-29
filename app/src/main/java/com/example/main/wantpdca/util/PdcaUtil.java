package com.example.main.wantpdca.util;

import android.content.Context;
import android.widget.Toast;

import java.util.Objects;

/**
 * Created by main on 2015/12/28.
 */
public class PdcaUtil {

    public static void show(Context context,String string){
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}
