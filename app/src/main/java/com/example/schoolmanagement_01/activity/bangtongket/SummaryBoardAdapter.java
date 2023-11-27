package com.example.schoolmanagement_01.activity.bangtongket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;

import java.util.ArrayList;

public class SummaryBoardAdapter extends ArrayAdapter<SummaryDTO> {


    public SummaryBoardAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SummaryDTO> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_summary, parent, false);
        }

        TextView tvClassRoom = convertView.findViewById(R.id.tv_class_room_summary);
        TextView tvChuyenCan = convertView.findViewById(R.id.tv_chuyen_can);
        TextView tvNoiQuy = convertView.findViewById(R.id.tv_noi_quy);
        TextView tvVeSinh = convertView.findViewById(R.id.tv_ve_sinh);
        TextView tvDaoDuc = convertView.findViewById(R.id.tv_dao_duc);
        TextView tvHocTap = convertView.findViewById(R.id.tv_hoc_tap);
        TextView tvSHTT = convertView.findViewById(R.id.tv_shtt);
        TextView tvDiemCong = convertView.findViewById(R.id.tv_diem_cong);
        TextView tvTongDiem = convertView.findViewById(R.id.tv_tong_diem);
        TextView tvXepHang= convertView.findViewById(R.id.tv_xep_hang);

        SummaryDTO summaryDTO = getItem(position);
        tvClassRoom.setText(summaryDTO.getClassRoom());
        tvChuyenCan.setText(summaryDTO.getChuyenCan());
        tvNoiQuy.setText(summaryDTO.getNoiQuy());
        tvVeSinh.setText(summaryDTO.getVeSinh());
        tvDaoDuc.setText(summaryDTO.getDaoDuc());
        tvHocTap.setText(summaryDTO.getHocTap());
        tvSHTT.setText(summaryDTO.getSHTT());
        tvDiemCong.setText(summaryDTO.getDiemCong());
        tvTongDiem.setText(String.format("%.2f", Float.parseFloat(summaryDTO.getTongDiem())));
        tvXepHang.setText(String.valueOf(summaryDTO.getHang()));
        return convertView;
    }
}
