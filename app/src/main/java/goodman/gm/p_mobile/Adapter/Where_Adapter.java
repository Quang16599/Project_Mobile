package goodman.gm.p_mobile.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.List;

import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;


public class Where_Adapter extends RecyclerView.Adapter<Where_Adapter.ViewHolder> {

    private int layout;
    private List<QuanAn> list_QuanAn;

    public Where_Adapter(int layout, List<QuanAn> list_QuanAn) {
        this.layout = layout;
        this.list_QuanAn = list_QuanAn;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        QuanAn quanAn = list_QuanAn.get(position);
        holder.tvTenQuanAnODau.setText(quanAn.getmTenQuanAn());
        if (quanAn.ismGiaoHang()) {
            holder.btnDatMonODau.setVisibility(View.VISIBLE);
        }
        Picasso.get().load(quanAn.getmHinhAnh()).into(holder.hinhQuanAnODau);


    }


    @Override
    public int getItemCount() {
        return list_QuanAn.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenQuanAnODau;
        Button btnDatMonODau;
        ImageView hinhQuanAnODau;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenQuanAnODau = itemView.findViewById(R.id.tvTenQuanAnODau);
            btnDatMonODau = itemView.findViewById(R.id.btnDatMonODau);
            hinhQuanAnODau = itemView.findViewById(R.id.HinhQuanAnODau);


        }
    }

}


