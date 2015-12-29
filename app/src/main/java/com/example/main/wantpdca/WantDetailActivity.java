package com.example.main.wantpdca;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.main.wantpdca.db.ActDatabaseHelper;
import com.example.main.wantpdca.db.WantDatabaseHelper;
import com.example.main.wantpdca.db.entity.ActEntity;
import com.example.main.wantpdca.db.entity.WantDeatilEntity;
import com.example.main.wantpdca.db.entity.WantEntity;
import com.example.main.wantpdca.util.PdcaUtil;

import org.w3c.dom.Text;

import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;

public class WantDetailActivity extends AppCompatActivity {

    WantEntity entity;
    WantEntity wantDetailEntity;
    WantDatabaseHelper helper;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_detail);

        //MainActivityから、wantEntityオブジェクトの値を受け取る。
        WantEntity wantEntity = (WantEntity)getIntent().getSerializableExtra("wantEntity");

        //wantテーブルを操作するインスタンスを取得する。
        WantDatabaseHelper wantDatabaseHelper = new WantDatabaseHelper(getApplicationContext());

        //wantテーブルを操作するインスタンスを取得する。
        ActDatabaseHelper actDatabaseHelper = new ActDatabaseHelper(getApplicationContext());


        //wantIdに紐付いたwantエンティティを取得する。
        wantDetailEntity = wantDatabaseHelper.getWantDetailById(wantEntity.getWantId());


        ActEntity actEntity = actDatabaseHelper.getActBywantId(wantEntity.getWantId());

        //wantTitleのテキストビューのオブジェクトを取得
        TextView wantTitle = (TextView) findViewById(R.id.wantDeatilScreen);

        //wantTitleのテキストビューに値を設定
        wantTitle.setText(wantDetailEntity.getWantText());

        TextView actTitle = (TextView) findViewById(R.id.actTitle);
        actTitle.setText(actEntity.getActTitle());

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("JST"));
        cal.setTimeInMillis(actEntity.getActDeadLine());
        String actDeadLine = cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE);
        //PdcaUtil.show(getApplicationContext(), String.valueOf(cal.get(Calendar.DATE)));
        TextView actDeadLineView = (TextView) findViewById(R.id.actDeadLine);
        actDeadLineView.setText(actDeadLine);

//        File file = new File(wantDetailEntity.getActImage());
//        if(file.exists()){
//
//            Bitmap imgBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//
//            ImageView actImage = (ImageView) findViewById(R.id.actImage);
//            actImage.setImageBitmap(imgBitmap);
//
//        }



        //wantMotivateBtn画面ボタンの押下処理
        ImageButton wantMotivateBtn = (ImageButton) findViewById(R.id.WantMotivateBtn);
        wantMotivateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(WantDetailActivity.this, WantMotivateAddActivity.class);
                intent.putExtra("wantDetailEntity", wantDetailEntity);
                startActivity(intent);
            }
        });

        //PBtn画面ボタンの押下処理
        ImageButton PBtn = (ImageButton) findViewById(R.id.PBtn);
        PBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(WantDetailActivity.this, PlanAddActivity.class);
                intent.putExtra("wantDetailEntity",wantDetailEntity);
                startActivity(intent);
            }
        });


        //wantMotivateBtn画面ボタンの押下処理
        ImageButton DBtn = (ImageButton) findViewById(R.id.DBtn);
        DBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(WantDetailActivity.this, DoAddActivity.class);
                intent.putExtra("wantDetailEntity",wantDetailEntity);
                startActivity(intent);
            }
        });


        //wantMotivateBtn画面ボタンの押下処理
        ImageButton CBtn = (ImageButton) findViewById(R.id.CBtn);
        CBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(WantDetailActivity.this, CheckAddActivity.class);
                intent.putExtra("wantDetailEntity",wantDetailEntity);
                startActivity(intent);
            }
        });


        //Aボタンの押下処理
        ImageButton ABtn = (ImageButton) findViewById(R.id.ABtn);
        ABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(WantDetailActivity.this, ActAddActivity.class);
                intent.putExtra("wantDetailEntity",wantDetailEntity);
                startActivity(intent);
            }
        });

        //wantListBtn画面ボタンの押下処理
        Button wantListBtn = (Button) findViewById(R.id.wantListBtn);
        wantListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(WantDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
