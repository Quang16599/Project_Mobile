package goodman.gm.p_mobile.Controller;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Adapter.Where_Adapter;
import goodman.gm.p_mobile.Interface.ODauInterface;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class Where {
    Context context;
    QuanAn quanAn;
    Where_Adapter adapter;
    List<QuanAn> list_QuanAn;

    public Where(Context context) {
        this.context = context;
        quanAn = new QuanAn();
    }

    public void getDanhSachQuanAnController(RecyclerView recyclerView){
        list_QuanAn = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Where_Adapter(R.layout.custom_layout_recyclerview_odau,list_QuanAn);
        recyclerView.setAdapter(adapter);
        ODauInterface oDauInterface = new ODauInterface() {
            @Override
            public void getDanhSachQuanAn(QuanAn quanAn) {
                Log.d("kiemtra", quanAn.getmTenQuanAn());
                list_QuanAn.add(quanAn);
                adapter.notifyDataSetChanged();
            }
        };
        quanAn.getDanhSachQuanAn(oDauInterface);

    }


}
