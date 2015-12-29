package com.example.main.wantpdca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.main.wantpdca.adapter.WantListAdapter;
import com.example.main.wantpdca.db.WantDatabaseHelper;
import com.example.main.wantpdca.db.entity.WantEntity;
import com.example.main.wantpdca.dto.SearchWantListCondition;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView wantListView;
    private WantListAdapter wantListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WantDatabaseHelper wantDatabaseHelper = new WantDatabaseHelper(this);

        SearchWantListCondition searchWantListCondition = new SearchWantListCondition();
        List<WantEntity> wantList = wantDatabaseHelper.getWantList(searchWantListCondition);

        //ListViewのセット
        wantListView = (ListView) findViewById(R.id.wantList);

        //データの追加
        wantListAdapter = new WantListAdapter(this, wantList);

        wantListView.setAdapter(wantListAdapter);


        wantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WantEntity wantEntity = (WantEntity) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, WantDetailActivity.class);
                intent.putExtra("wantEntity",wantEntity);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(), item.getWantId() + "::" +  item.getWantText(), Toast.LENGTH_SHORT)
//                        .show();
            }
        });


        //want追加画面ボタンの押下処理
        Button btnWantAdd = (Button) findViewById(R.id.wantAddBtn);
        btnWantAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Wantを登録する画面を起動
                Intent intent = new Intent(MainActivity.this,WantAddActivity.class);
                startActivity(intent);
            }
        });
    }
}
