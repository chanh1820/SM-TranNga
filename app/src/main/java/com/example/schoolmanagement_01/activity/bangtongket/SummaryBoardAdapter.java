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
        TextView tvDaoDuc = convertView.findViewById(R.id.tv_dao_duc);
        TextView tvHoctap = convertView.findViewById(R.id.tv_hoc_tap);
        TextView tvNeNep = convertView.findViewById(R.id.tv_ne_nep);
        TextView tvKhac = convertView.findViewById(R.id.tv_khac);
        TextView tvDiemCong = convertView.findViewById(R.id.tv_diem_cong);
        TextView tvSDB = convertView.findViewById(R.id.tv_sdb);
        TextView tvTongDiem = convertView.findViewById(R.id.tv_tong_diem);
        TextView tvXepHang= convertView.findViewById(R.id.tv_xep_hang);

        SummaryDTO summaryDTO = getItem(position);
        tvClassRoom.setText(summaryDTO.getClassRoom());
        tvDaoDuc.setText(summaryDTO.getDaoDuc());
        tvHoctap.setText(summaryDTO.getHocTap());
        tvNeNep.setText(summaryDTO.getNeNep());
        tvKhac.setText(summaryDTO.getKhac());
        tvDiemCong.setText(summaryDTO.getDiemCong());
        tvSDB.setText(summaryDTO.getSDB());
        tvTongDiem.setText(summaryDTO.getTongDiem());
        tvXepHang.setText(String.valueOf(summaryDTO.getHang()));
        return convertView;
    }
}
