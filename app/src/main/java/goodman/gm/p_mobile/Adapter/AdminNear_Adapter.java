package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import goodman.gm.p_mobile.Model.DiaChi;
import goodman.gm.p_mobile.R;

public class AdminNear_Adapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DiaChi> listDiaChi;

    public AdminNear_Adapter(Context context, int layout, List<DiaChi> listDiaChi) {
        this.context = context;
        this.layout = layout;
        this.listDiaChi = listDiaChi;
    }

    @Override
    public int getCount() {
        return listDiaChi.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public  class  ViewHolder{
        TextView adminTenQuan, adminDiaChi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.adminTenQuan = convertView.findViewById(R.id.adminTenQuan);
            viewHolder.adminDiaChi = convertView.findViewById(R.id.adminDiaChi);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        DiaChi diaChi = listDiaChi.get(position);
        viewHolder.adminTenQuan.setText(diaChi.getmTenQuanAn());
        viewHolder.adminDiaChi.setText(diaChi.getmDiaChi());
        return convertView;
    }
}
