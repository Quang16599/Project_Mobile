package goodman.gm.p_mobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import goodman.gm.p_mobile.Controller.AdminChiTietUser;
import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class AdminUser_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<User> lstUser;

    public AdminUser_Adapter(Context context, int layout, List<User> lstUser) {
        this.context = context;
        this.layout = layout;
        this.lstUser = lstUser;
    }


    @Override
    public int getCount() {
        return lstUser.size();
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
        TextView tvFullName, tvSdt;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvFullName = convertView.findViewById(R.id.tvTenDayDu);
            viewHolder.tvSdt = convertView.findViewById(R.id.tvSDT);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        User user = lstUser.get(position);

        viewHolder.tvSdt.setText(user.getmPhoneNumber());
        viewHolder.tvFullName.setText(user.getmFullName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AdminChiTietUser.class);
                intent.putExtra("adminUsers", lstUser.get(position));
                context.startActivity(intent);

            }
        });

        return convertView;
    }

}
