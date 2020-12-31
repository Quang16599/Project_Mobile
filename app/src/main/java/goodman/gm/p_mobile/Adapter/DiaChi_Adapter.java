package goodman.gm.p_mobile.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import goodman.gm.p_mobile.Model.DiaChi;
import goodman.gm.p_mobile.R;

public class DiaChi_Adapter extends BaseAdapter {

    private int layout;
    private List<DiaChi> list_DiaChi;

    public DiaChi_Adapter(int layout, List<DiaChi> list_DiaChi) {
        this.layout = layout;
        this.list_DiaChi = list_DiaChi;
    }

    @Override
    public int getCount() {
        return list_DiaChi.size();
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
        TextView khoangcach, ten, diachi;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.khoangcach = view.findViewById(R.id.khoangcach);
            holder.ten = view.findViewById(R.id.textViewTen);
            holder.diachi = view.findViewById(R.id.textViewDiaChi);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


        DiaChi diaChi = list_DiaChi.get(position);

        holder.diachi.setText(diaChi.getmDiaChi());
        holder.khoangcach.setText(String.format("%.1f", diaChi.getmKhoangCach()) + "km");
        holder.ten.setText(diaChi.getmTenQuanAn());

        return view;
    }
}
