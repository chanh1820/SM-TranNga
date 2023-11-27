package com.example.schoolmanagement_01.activity.quanlytrucnhat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.StudentDTO;

import java.util.List;

public class ChooseStudentAdapter extends BaseAdapter {
    private Context context;
    private List<StudentDTO> studentDTOList;

    public ChooseStudentAdapter(Context context, List<StudentDTO> studentDTOList) {
        this.context = context;
        this.studentDTOList = studentDTOList;
    }

    @Override
    public int getCount() {
        return studentDTOList != null ? studentDTOList.size() : 0;
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

        txtName.setText(studentDTOList.get(i).getStudentName());

        return rootView;
    }
}
