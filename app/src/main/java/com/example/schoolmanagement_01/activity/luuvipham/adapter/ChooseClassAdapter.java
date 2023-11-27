package com.example.schoolmanagement_01.activity.luuvipham.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;

import java.util.List;

public class ChooseClassAdapter extends ArrayAdapter<ClassRoomDTO> {
    public ChooseClassAdapter(@NonNull Context context, int resource, @NonNull List<ClassRoomDTO> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_gridview_exam, parent, false);
        }
        TextView txtName = convertView.findViewById(R.id.tv_class_room_name);
        ClassRoomDTO classRoomDTO = getItem(position);
        txtName.setText(classRoomDTO.getClassName());
        txtName.setTextColor(classRoomDTO.getColor());
        return convertView;
    }
}
