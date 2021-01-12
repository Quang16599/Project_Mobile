package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.List;

import goodman.gm.p_mobile.Controller.ChiTietQuanAn;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;


public class ODau_Adapter extends RecyclerView.Adapter<ODau_Adapter.ViewHolder> {

    private Context context;
    private int layout;
    private List<QuanAn> list_QuanAn;

    public ODau_Adapter(Context context, int layout, List<QuanAn> list_QuanAn) {
        this.context = context;
        this.layout = layout;
        this.list_QuanAn = list_QuanAn;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        QuanAn quanAn = list_QuanAn.get(position);
        holder.tvTenQuanAnODau.setText(quanAn.getmTenQuanAn());
        holder.tvDiaChi.setText(quanAn.getmDiaChiQuan());
//        StorageReference storage = FirebaseStorage.getInstance().getReference().child(quanAn.getmHinhAnhQuanAn());
//        long ONE_MEGABYTE = 1024 * 1024;
//        storage.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//            @Override
//            public void onSuccess(byte[] bytes) {
//                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                holder.hinhQuanAnODau.setImageBitmap(bitmap);
//            }
//        });
        Picasso.get().load(quanAn.getmHinhAnhQuanAn()).into(holder.hinhQuanAnODau);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChiTietQuanAn.class);
                intent.putExtra("quanans", list_QuanAn.get(position));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list_QuanAn.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenQuanAnODau, tvDiaChi;

        ImageView hinhQuanAnODau;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenQuanAnODau = itemView.findViewById(R.id.tvTenQuanAnODau);
            tvDiaChi = itemView.findViewById(R.id.tvDiaChiQuanAn);
            hinhQuanAnODau = itemView.findViewById(R.id.HinhQuanAnODau);


        }
    }

}


