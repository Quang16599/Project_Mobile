package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import goodman.gm.p_mobile.Model.BinhLuan;
import goodman.gm.p_mobile.R;

public class BinhLuan_Adapter extends RecyclerView.Adapter<BinhLuan_Adapter.ViewHolder> {
    private Context context;
    int layout;
    List<BinhLuan> binhLuanModelList;

    public BinhLuan_Adapter(Context context, int layout, List<BinhLuan> binhLuanModelList) {
        this.context = context;
        this.layout = layout;
        this.binhLuanModelList = binhLuanModelList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        TextView txtTieuDeBinhLuan, txtNoiDungBinhLuan, txtSoDiem;


        public ViewHolder(View itemView) {
            super(itemView);


            txtTieuDeBinhLuan = itemView.findViewById(R.id.tvTieuDeBinhLuan);
            txtNoiDungBinhLuan = (TextView) itemView.findViewById(R.id.tvNoiDungBinhLuan);
            txtSoDiem = (TextView) itemView.findViewById(R.id.tvDiemBinhLuan);
            img = itemView.findViewById(R.id.imgBinhLuan);
        }
    }

    @Override
    public BinhLuan_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BinhLuan_Adapter.ViewHolder holder, int position) {
        BinhLuan binhLuan = binhLuanModelList.get(position);

        holder.txtTieuDeBinhLuan.setText(binhLuan.getmTieuDe());
        holder.txtNoiDungBinhLuan.setText(binhLuan.getmNoiDung());
        holder.txtSoDiem.setText(binhLuan.getmChamDiem());

    }

    @Override
    public int getItemCount() {
        int soBinhLuan = binhLuanModelList.size();
        if (soBinhLuan > 0 && soBinhLuan > 5) {
            return 5;
        } else {
            return binhLuanModelList.size();
        }
    }
}



