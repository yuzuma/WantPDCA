package com.example.main.wantpdca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.main.wantpdca.db.WantDatabaseHelper;
import com.example.main.wantpdca.db.entity.WantEntity;

import org.apache.commons.lang.StringUtils;

public class WantAddActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private long insertFlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_add);

       //登録ボタンを押下した時の処理。
        findViewById(R.id.wantAddBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WantEntity entity = new WantEntity();
                WantDatabaseHelper helper = new WantDatabaseHelper(getApplicationContext());

                //入力された文字列を取得する。
                EditText wantAddEditText = (EditText) findViewById(R.id.wantAddText);
                String wantAddText = wantAddEditText.getText().toString();
                if (StringUtils.isBlank(wantAddText)) {
                    showText("何か入力して下さい。");
                    return;
                }

                entity.setWantText(wantAddText);
                if (helper.insert(entity) > 0) {
                    showText("登録できました。");
                } else {
                    showText("登録できませんでした");
                }
            }
        });

        //wantList一覧に遷移する。
        Button btnWantAdd = (Button) findViewById(R.id.wantListBtn);
        btnWantAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(WantAddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showText(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }
}
