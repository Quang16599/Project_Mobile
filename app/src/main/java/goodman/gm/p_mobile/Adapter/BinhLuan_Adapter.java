package goodman.gm.p_mobile.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import goodman.gm.p_mobile.Model.BinhLuan;
import goodman.gm.p_mobile.R;

public class BinhLuan_Adapter extends RecyclerView.Adapter<BinhLuan_Adapter.ViewHolder> {

    int layout;
    List<BinhLuan> binhLuanModelList;



    public BinhLuan_Adapter( int layout, List<BinhLuan> binhLuanModelList){

        this.layout = layout;
        this.binhLuanModelList = binhLuanModelList;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView txtTieuDeBinhLuan,txtNoiDungBinhLuan,txtSoDiem;


        public ViewHolder(View itemView) {
            super(itemView);


            txtTieuDeBinhLuan = (TextView) itemView.findViewById(R.id.tvTieuDeBinhLuan);
            txtNoiDungBinhLuan = (TextView) itemView.findViewById(R.id.tvNoiDungBinhLuan);
            txtSoDiem = (TextView) itemView.findViewById(R.id.tvDiemBinhLuan);

        }
    }

    @Override
    public BinhLuan_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
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
      return  binhLuanModelList.size();

    }




}
