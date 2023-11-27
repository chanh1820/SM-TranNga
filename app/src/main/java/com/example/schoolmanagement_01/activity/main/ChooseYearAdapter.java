package com.example.schoolmanagement_01.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schoolmanagement_01.R;

import java.util.List;

public class ChooseYearAdapter extends BaseAdapter {
    Context context;
    List<String> listYear;

    public ChooseYearAdapter(Context context, List<String> listWeek) {
        this.context = context;
        this.listYear = listWeek;

    }

    @Override
    public int getCount() {
        return listYear != null ? listYear.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_spinner_2, viewGroup, false);
        TextView txtName = rootView.findViewById(R.id.tv_student_year);
        txtName.setText(listYear.get(i));

        return rootView;
    }
}
