package com.example.schoolmanagement_01.activity.danhsachvipham;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.contants.GoogleSheetConstant;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.ResponseDTO;
import com.example.schoolmanagement_01.core.service.UltilService;
import com.example.schoolmanagement_01.core.util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportAdapter extends ArrayAdapter<ReportDTO> {

    public ReportAdapter(@NonNull Context context, int resource, @NonNull List<ReportDTO> objects) {
        super(context, resource, objects);
    }

    private class ViewHolder {
        TextView tvName;
        TextView tvRule;
        TextView tvDetele;
        //    TextView tvDeleteReport;
        TextView tvCreatedDate;
        TextView tvStt;
        ImageView imvImage;
        LinearLayout lnParent;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_report, parent, false);
            holder = new ViewHolder();

            holder.tvName = convertView.findViewById(R.id.tv_student_name_report);
            holder.tvRule = convertView.findViewById(R.id.tv_rule_name_report);
            holder.tvDetele = convertView.findViewById(R.id.tv_item_report_delete);
            holder.tvCreatedDate = convertView.findViewById(R.id.tv_created_date);
            holder.tvStt = convertView.findViewById(R.id.tv_stt);
            holder.imvImage = convertView.findViewById(R.id.imv_image_report);
            holder.lnParent = convertView.findViewById(R.id.ln_item_report);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }




        ReportDTO item = getItem(position);
        holder.tvStt.setText(position + 1 + "");

        if (getCount() == 0) {
            holder.tvName.setText("không có học sinh vi phạm");
        }
//        if (position % 2 == 0) {
//            linearLayout.setBackgroundColor(Color.parseColor("#84ffff"));
//        } else {
//            linearLayout.setBackgroundColor(Color.parseColor("#fafafa"));
//        }
        holder.tvName.setText(item.getStudentName());
//        holder.tvDeleteReport.setTag(item.getId());
        holder.tvRule.setText("(" + item.getMinusPoint() + ") " + item.getRuleName());
        if (item.getCreatedDate() == null || item.getCreatedDate().isEmpty() || item.getCreatedDate().equals("")) {

        } else {
            holder.tvCreatedDate.setText(item.getCreatedDate());
        }
        if ((item.getPathImage() == null || item.getPathImage().isEmpty() || item.getPathImage().equals(""))) {

            holder.imvImage.setVisibility(View.GONE);
        } else {
            holder.imvImage.setImageBitmap(UltilService.StringToBitMap(item.getPathImage()));
        }

        holder.tvDetele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, GoogleSheetConstant.END_POINT_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ResponseDTO responseDTO = ObjectMapperUtils.stringToDTO(response, ResponseDTO.class);

                        if (responseDTO.getStatus().equals(GoogleSheetConstant.STATUS_SUCCESS)) {
                            Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                            holder.lnParent.setVisibility(View.GONE);
                            ReportActivity.listReportDTO.remove(item);
                            notifyDataSetChanged();
                        } else {
                            Toast.makeText(getContext(), "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Bạn chưa bật kết nối Internet ?", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("action", "DELETE_REPORT_BY_ID");
                        params.put("id", String.valueOf(getItem(position).getId()));
                        return params;
                    }
                };

                RetryPolicy retryPolicy = new DefaultRetryPolicy(
                        50000,
                        0,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                stringRequest.setRetryPolicy(retryPolicy);
                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(stringRequest);
            }
        });
        return convertView;
    }
}
