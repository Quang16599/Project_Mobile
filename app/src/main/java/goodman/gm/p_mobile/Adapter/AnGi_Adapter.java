package goodman.gm.p_mobile.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class AnGi_Adapter extends RecyclerView.Adapter<AnGi_Adapter.ViewHolder> {
    private int layout;
    private List<QuanAn> list_QuanAn;

    public AnGi_Adapter(int layout, List<QuanAn> list_QuanAn) {
        this.layout = layout;
        this.list_QuanAn = list_QuanAn;
    }

    @NonNull
    @Override
    public AnGi_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnGi_Adapter.ViewHolder holder, int position) {

        QuanAn quanAn = list_QuanAn.get(position);
        holder.tvTenQuanAnAngi.setText(quanAn.getmTenQuanAn());
        Picasso.get().load(quanAn.getmHinhAnh()).into(holder.hinhQuanAnAngi);


    }

    @Override
    public int getItemCount() {
        return list_QuanAn.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenQuanAnAngi;
        ImageView hinhQuanAnAngi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenQuanAnAngi = itemView.findViewById(R.id.tvTenQuanAnAnGi);
            hinhQuanAnAngi = itemView.findViewById(R.id.HinhQuanAnAnGi);


        }
    }
}
