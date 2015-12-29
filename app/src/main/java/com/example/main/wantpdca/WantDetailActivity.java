package com.example.main.wantpdca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.main.wantpdca.db.WantDatabaseHelper;
import com.example.main.wantpdca.db.entity.WantEntity;
import com.example.main.wantpdca.util.PdcaUtil;

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

        //wantIdに紐付いたwantエンティティを取得する。
        wantDetailEntity = wantDatabaseHelper.getWantById(wantEntity.getWantId());

        //wantTitleのテキストビューのオブジェクトを取得
        TextView wantTitle = (TextView) findViewById(R.id.wantDeatilScreen);

        //wantTitleのテキストビューに値を設定
        wantTitle.setText(wantDetailEntity.getWantText());
        PdcaUtil.show(getApplicationContext(), String.valueOf(wantDetailEntity.getWantId()));
        //entity.setWantId(wantDetailEntity.getWantId());


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


        //wantMotivateBtn画面ボタンの押下処理
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
