package com.example.schoolmanagement_01.activity.luuvipham.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.RuleDTO;

import java.util.List;

public class ChooseRuleChildAdapter extends BaseAdapter {
    private Context context;
    private List<RuleDTO> ruleDTOList;

    public ChooseRuleChildAdapter(Context context, List<RuleDTO> ruleDTOList) {
        this.context = context;
        this.ruleDTOList = ruleDTOList;
    }

    @Override
    public int getCount() {
        return ruleDTOList != null ? ruleDTOList.size() : 0;
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
                .inflate(R.layout.item_spinner, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.tv_student_name);

        txtName.setText("(" + ruleDTOList.get(i).getMinusPoint()+ ") " + ruleDTOList.get(i).getRuleName());

        return rootView;
    }
}
