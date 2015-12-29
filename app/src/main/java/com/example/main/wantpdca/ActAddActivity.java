package com.example.main.wantpdca;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.main.wantpdca.db.ActDatabaseHelper;
import com.example.main.wantpdca.db.WantDatabaseHelper;
import com.example.main.wantpdca.db.entity.ActEntity;
import com.example.main.wantpdca.db.entity.WantEntity;
import com.example.main.wantpdca.util.PdcaUtil;

import org.apache.commons.lang.StringUtils;

public class ActAddActivity extends Activity {

    WantEntity wantDetailEntity;

    //wantDetail画面へ遷移するための値設定。
    WantEntity wantEntity;

    //Actテーブルに保存するためのエンティティ
    ActEntity actEntity;

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
                actEntity = new ActEntity();

                ActDatabaseHelper helper = new ActDatabaseHelper(getApplicationContext());

                //入力された文字列を取得する。
                EditText actAddEditTitle = (EditText) findViewById(R.id.actAddTitle);

                String actAddText = actAddEditTitle.getText().toString();
                if (StringUtils.isBlank(actAddText)) {
                    PdcaUtil.show(getApplicationContext(),"何か入力して下さい。");
                    return;
                }

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
        PdcaUtil.show(getApplicationContext(),String.valueOf(requestCode));

        if (requestCode == 1) {
            //Uriを取得する。
            Uri photoUri = data.getData();

            PdcaUtil.show(getApplicationContext(),photoUri.toString());

        }
    }
}
