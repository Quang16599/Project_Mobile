package goodman.gm.p_mobile.Adapter;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import goodman.gm.p_mobile.Controller.AdminComment;
import goodman.gm.p_mobile.Model.BinhLuan;
import goodman.gm.p_mobile.R;

public class AdminComment_Adapter extends BaseAdapter {
    private AdminComment context;
    private int layout;
    private List<BinhLuan> lst_BinhLuan;

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("binhluans");

    public AdminComment_Adapter(AdminComment context, int layout, List<BinhLuan> lst_BinhLuan) {
        this.context = context;
        this.layout = layout;
        this.lst_BinhLuan = lst_BinhLuan;
    }

    @Override
    public int getCount() {
        return lst_BinhLuan.size();
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
        TextView tvMaQA;
        Button btnXoa;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.tvMaQA = convertView.findViewById(R.id.tvMaQABl);
            holder.btnXoa = convertView.findViewById(R.id.btnXoaBl);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//            BinhLuan binhLuan = lst_BinhLuan.get(position);
//            holder.tvMaQA.setText(binhLuan.getMaQuanAn());

        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context,
                        android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có muốn xóa không ?");
                builder.setCancelable(false);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // xóa trên firebase
//                        String maQuanAn = lst_BinhLuan.get(position).getMaQuanAn();
//                        deleteOnFireBase(maQuanAn);


                        // xóa trên listview
//                        context.DeleteFood(position);
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();


            }
        });

        return convertView;
    }
//
//    private void deleteOnFireBase(String maQuanAn) {
//        reference.child(maQuanAn).removeValue();
//        Toast.makeText(context, "Xóa " + maQuanAn + " Thành Công", Toast.LENGTH_SHORT).show();
//    }

}
