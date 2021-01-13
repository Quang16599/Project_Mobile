package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import goodman.gm.p_mobile.Model.BinhLuan;
import goodman.gm.p_mobile.Model.Blog;
import goodman.gm.p_mobile.Model.ChonHinh;
import goodman.gm.p_mobile.R;

public class HinhBinhLuan_Adapter extends RecyclerView.Adapter<HinhBinhLuan_Adapter.ViewHolderHinhBinhLuan> {

    Context context;
    int resource;
    List<ChonHinh> listHinh;

    public HinhBinhLuan_Adapter(Context context, int resource, List<ChonHinh> listHinh) {
        this.context = context;
        this.resource = resource;
        this.listHinh = listHinh;
    }

    public class ViewHolderHinhBinhLuan extends RecyclerView.ViewHolder {
        ImageView imageHinhBinhLuan;

        public ViewHolderHinhBinhLuan(View itemView) {
            super(itemView);

            imageHinhBinhLuan = itemView.findViewById(R.id.imageBinhLuan);
        }
    }

    @Override
    public HinhBinhLuan_Adapter.ViewHolderHinhBinhLuan onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        ViewHolderHinhBinhLuan viewHolderHinhBinhLuan = new ViewHolderHinhBinhLuan(view);

        return viewHolderHinhBinhLuan;
    }

    @Override
    public void onBindViewHolder(final HinhBinhLuan_Adapter.ViewHolderHinhBinhLuan holder, final int position) {
        final ChonHinh chonHinhBinhLuan = listHinh.get(position);
        Uri uri = Uri.parse(chonHinhBinhLuan.getDuongdan());
        holder.imageHinhBinhLuan.setImageURI(uri);


    }

    @Override
    public int getItemCount() {
        return listHinh.size();

    }


}