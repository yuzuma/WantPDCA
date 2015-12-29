package com.example.main.wantpdca.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.main.wantpdca.R;
import com.example.main.wantpdca.db.entity.WantEntity;

import java.util.List;

/**
 * Created by main on 2015/12/23.
 */
public class WantListAdapter extends ArrayAdapter<WantEntity> {

    public static final String TAG = WantListAdapter.class.getSimpleName();
    public WantListAdapter(Context context, List<WantEntity> listEntity)  {
        super(context, R.layout.wantlist_layout,R.id.wantTitle, listEntity);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = super.getView(position, convertView, parent);
        TextView wantTitle = (TextView) view.findViewById(R.id.wantTitle);

        WantEntity wantEntity = getItem(position);

        wantTitle.setText(wantEntity.getWantText());

        return view;

    }
}
