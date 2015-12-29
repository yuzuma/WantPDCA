package com.example.main.wantpdca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.main.wantpdca.db.entity.WantEntity;

public class CheckAddActivity extends AppCompatActivity {

    WantEntity wantEntity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_add);

        //MainActivityから、wantEntityオブジェクトの値を受け取る。
        WantEntity wantDetailEntity = (WantEntity)getIntent().getSerializableExtra("wantDetailEntity");

        //登録ボタンを押下した時の処理。
        findViewById(R.id.checkAddBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        //wantDetailBtnボタンの押下処理
        Button wantListBtn = (Button) findViewById(R.id.wantDetailBtn);
        wantListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(CheckAddActivity.this, WantDetailActivity.class);
                intent.putExtra("wantEntity", wantEntity);
                startActivity(intent);
            }
        });
    }

}
