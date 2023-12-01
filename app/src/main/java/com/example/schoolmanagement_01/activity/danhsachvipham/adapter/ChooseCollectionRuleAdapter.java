package com.example.schoolmanagement_01.activity.danhsachvipham.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.RuleCollectionDTO;

import java.util.List;

public class ChooseCollectionRuleAdapter extends BaseAdapter {
    private Context context;
    private List<RuleCollectionDTO> list;

    public ChooseCollectionRuleAdapter(Context context, List<RuleCollectionDTO> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
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
        RuleCollectionDTO item = list.get(i);
        TextView txtName = rootView.findViewById(R.id.tv_student_name);
        txtName.setText(item.getName());
        rootView.setTag(item);
        return rootView;
    }
}
