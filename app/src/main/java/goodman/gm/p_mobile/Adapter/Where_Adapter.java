package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

import goodman.gm.p_mobile.Controller.DangKy;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        QuanAn quanAn = list_QuanAn.get(position);
        holder.tvTenQuanAnODau.setText(quanAn.getmTenQuanAn());
        if(quanAn.ismGiaoHang()){
            holder.btnDatMonODau.setVisibility(View.VISIBLE);
        }
        if(quanAn.getmHinhAnhQuanAn().size() > 0){
            StorageReference storageHinhAnh = FirebaseStorage.getInstance().getReference().child(quanAn.getmHinhAnhQuanAn().get(0));
            long ONE_MEGABYTE = 1024 * 1024;
            storageHinhAnh.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    holder.hinhQuanAnODau.setImageBitmap(bitmap);
                }
            });
        }
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


