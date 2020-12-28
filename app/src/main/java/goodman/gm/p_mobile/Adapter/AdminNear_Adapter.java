package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import goodman.gm.p_mobile.Controller.AdminChiTietNear;
import goodman.gm.p_mobile.Controller.AdminNear;
import goodman.gm.p_mobile.Model.DiaChi;
import goodman.gm.p_mobile.R;

public class AdminNear_Adapter extends BaseAdapter {

    private AdminNear context;
    private int layout;
    private List<DiaChi> list_diachi;

    public AdminNear_Adapter(AdminNear context, int layout, List<DiaChi> list_diachi) {
        this.context = context;
        this.layout = layout;
        this.list_diachi = list_diachi;
    }

    @Override
    public int getCount() {
        return list_diachi.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        TextView adminTenQuan, adminDiaChi, adminMaQuanAn;
        Button btnXoaNear;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.adminMaQuanAn = convertView.findViewById(R.id.tvMaQANear);
            holder.adminTenQuan = convertView.findViewById(R.id.adminTenQuan);
            holder.adminDiaChi = convertView.findViewById(R.id.adminDiaChi);
            holder.btnXoaNear = convertView.findViewById(R.id.btnXoaNear);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        DiaChi diaChi = list_diachi.get(position);
        holder.adminTenQuan.setText(diaChi.getmTenQuanAn());
        holder.adminDiaChi.setText(diaChi.getmDiaChi());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AdminChiTietNear.class);
                intent.putExtra("adminNear", list_diachi.get(position));
                context.startActivity(intent);
            }
        });
        holder.btnXoaNear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogDeleteNear();
            }
        });


        return convertView;
    }
}
