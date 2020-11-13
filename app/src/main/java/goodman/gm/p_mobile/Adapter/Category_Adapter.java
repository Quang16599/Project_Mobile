package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import goodman.gm.p_mobile.Model.Category;
import goodman.gm.p_mobile.R;

public class Category_Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Category> list_category;

    public Category_Adapter(Context context, int layout, List<Category> list_category) {
        this.context = context;
        this.layout = layout;
        this.list_category = list_category;
    }


    @Override
    public int getCount() {
        return list_category.size();
    }

    @Override
    public Object getItem(int position) {
        return list_category.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class viewHolder {
        ImageView imageView ;
        TextView textView,textView1;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        viewHolder holder;
        if( view == null){
            view = LayoutInflater.from(context).inflate(layout,parent,false);
            holder = new viewHolder();
            holder.imageView = view.findViewById(R.id.image);
            holder.textView  = view.findViewById(R.id.textview);
            holder.textView1  = view.findViewById(R.id.textview1);
            view.setTag(holder);
        }else {
            holder = (viewHolder) view.getTag();
        }
        Category category = list_category.get(position);

        Picasso.get().load(category.getmImage()).into(holder.imageView);
        holder.textView.setText(category.getmName());
        holder.textView1.setText(category.getmPrice());

        return view;
    }
}
