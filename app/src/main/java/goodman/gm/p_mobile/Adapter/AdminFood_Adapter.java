package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import goodman.gm.p_mobile.Controller.AdminChiTietUser;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class AdminFood_Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<QuanAn> list_quanan;

    public AdminFood_Adapter(Context context, int layout, List<QuanAn> list_quanan) {
        this.context = context;
        this.layout = layout;
        this.list_quanan = list_quanan;
    }

    @Override
    public int getCount() {
        return list_quanan.size();
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
        TextView tvTenQuanAn, tvDiaChi;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.tvTenQuanAn = convertView.findViewById(R.id.tvTenQA);
            holder.tvDiaChi = convertView.findViewById(R.id.tvDC);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        QuanAn quanAn = list_quanan.get(position);
        holder.tvTenQuanAn.setText(quanAn.getmTenQuanAn());
        holder.tvDiaChi.setText(quanAn.getmDiaChiQuan());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AdminChiTietUser.class);
                intent.putExtra("adminFoods", list_quanan.get(position));
                context.startActivity(intent);

            }
        });

        return convertView;
    }
}
