package com.example.schoolmanagement_01.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schoolmanagement_01.R;

import java.util.List;

public class ChooseSeesionAdapter extends BaseAdapter {

    List<String> lsData;
    Context context;

    public ChooseSeesionAdapter(List<String> lsData, Context context) {
        this.lsData = lsData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lsData.size();
    }

    @Override
    public Object getItem(int position) {
        return lsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_num_exam, parent, false);
        TextView txtName = rootView.findViewById(R.id.tv_item_session);
        txtName.setText(lsData.get(position));
        return rootView;
    }
}
