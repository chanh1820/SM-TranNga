package com.example.schoolmanagement_01.activity.luuvipham.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.schoolmanagement_01.R;

import java.util.List;

public class ChooseKhoiAdapter extends BaseAdapter {
    private Context context;
    private List<String> classRoomDTOList;

    public ChooseKhoiAdapter(Context context, List<String> classRoomDTOList) {
        this.context = context;
        this.classRoomDTOList = classRoomDTOList;
    }

    @Override
    public int getCount() {
        return classRoomDTOList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_spinner, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.tv_student_name);

        txtName.setText(classRoomDTOList.get(i));

        return rootView;
    }
}
