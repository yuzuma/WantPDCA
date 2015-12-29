package com.example.main.wantpdca;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.main.wantpdca.db.ActDatabaseHelper;
import com.example.main.wantpdca.db.WantDatabaseHelper;
import com.example.main.wantpdca.db.entity.ActEntity;
import com.example.main.wantpdca.db.entity.WantEntity;
import com.example.main.wantpdca.util.PdcaUtil;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class ActAddActivity extends Activity {

    WantEntity wantDetailEntity;

    //wantDetail画面へ遷移するための値設定。
    WantEntity wantEntity;

    private ImageView imageView;

    //Actテーブルに保存するためのエンティティ
    ActEntity actEntity = new ActEntity();

    int requestCode =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_add);

        wantEntity = new WantEntity();

        //MainActivityから、wantEntityオブジェクトの値を受け取る。
        wantDetailEntity = (WantEntity)getIntent().getSerializableExtra("wantDetailEntity");

        //PdcaUtil.show(getApplicationContext(), String.valueOf(wantDetailEntity.getWantId()));

        //wantDetail画面へ渡す時のwantIdを設定する
        wantEntity.setWantId(wantDetailEntity.getWantId());

        findViewById(R.id.actImageAddBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, requestCode);
            }
        });

        //登録ボタンを押下した時の処理。
        findViewById(R.id.actAddBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Actテーブルに保存するためのインスタンス


                ActDatabaseHelper helper = new ActDatabaseHelper(getApplicationContext());

                //入力された文字列を取得する。
                EditText actAddEditTitle = (EditText) findViewById(R.id.actAddTitle);

                //入力された日付を取得する
                DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);


                String actAddText = actAddEditTitle.getText().toString();
                if (StringUtils.isBlank(actAddText)) {
                    PdcaUtil.show(getApplicationContext(),"何か入力して下さい。");
                    return;
                }

                Calendar calendar = Calendar.getInstance();
                calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                actEntity.setActDeadLine(calendar.getTimeInMillis());
                actEntity.setWantId(wantDetailEntity.getWantId());
                actEntity.setActTitle(actAddText);

                if (helper.insert(actEntity) > 0) {
                    PdcaUtil.show(getApplicationContext(), "登録できました。");
                } else {
                    PdcaUtil.show(getApplicationContext(), "登録できませんでした。");
                }

            }
        });

        //wantDetailBtnボタンの押下処理
        Button wantListBtn = (Button) findViewById(R.id.wantDetailBtn);
        wantListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(ActAddActivity.this, WantDetailActivity.class);
                intent.putExtra("wantEntity", wantEntity);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        PdcaUtil.show(getApplicationContext(), String.valueOf(requestCode));

        if (requestCode == 1) {
            //Uriを取得する。
            Uri photoUri = data.getData();

            //Actテーブルに登録するための画像のURIをセットする。
            actEntity.setActImage(photoUri.toString());
            PdcaUtil.show(getApplicationContext(), photoUri.toString());

            ContentResolver cr = getContentResolver();
            try {
                Bitmap image = MediaStore.Images.Media.getBitmap(cr, photoUri);
                imageView = (ImageView)findViewById(R.id.imageView);
                imageView.setImageBitmap(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
