package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import goodman.gm.p_mobile.Model.ChiNhanhQuanAn;
import goodman.gm.p_mobile.R;

public class GanToi_Adapter  extends BaseAdapter {

    private int layout;
    private List<ChiNhanhQuanAn> list_ChiNhanh;

    public GanToi_Adapter(int layout, List<ChiNhanhQuanAn> list_ChiNhanh) {
        this.layout = layout;
        this.list_ChiNhanh = list_ChiNhanh;
    }

    @Override
    public int getCount() {
        return list_ChiNhanh.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView khoangcach,ten,diachi;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null){
            view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.khoangcach = view.findViewById(R.id.khoangcach);
            holder.ten = view.findViewById(R.id.textViewTen);
            holder.diachi = view.findViewById(R.id.textViewDiaChi);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        ChiNhanhQuanAn chiNhanhQuanAn = list_ChiNhanh.get(position);
        holder.khoangcach.setText(String.valueOf(chiNhanhQuanAn.getmKhoangCach()));
        holder.diachi.setText(chiNhanhQuanAn.getmDiaChi());

        return view;
    }
}
