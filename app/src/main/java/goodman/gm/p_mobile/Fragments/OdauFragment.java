package goodman.gm.p_mobile.Fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Adapter.ODau_Adapter;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class OdauFragment extends Fragment {
    ProgressBar progressBarODau;
    RecyclerView recyclerView;
    ODau_Adapter adapter;
    List<QuanAn> list_QuanAn;
    View view;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("quanans");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_odau, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        init();
        loadData();

    }

    private void init() {
        progressBarODau = view.findViewById(R.id.progressBarODau);
        recyclerView = view.findViewById(R.id.recyclerViewODau);
        list_QuanAn = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ODau_Adapter(R.layout.custom_layout_recyclerview_odau, list_QuanAn);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    private void loadData(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot value : snapshot.getChildren()) {
                    QuanAn quanAn = new QuanAn();
                    quanAn.setmDiaChiQuan(value.child("diachi").getValue().toString());
                    quanAn.setmTenQuanAn(value.child("tenquanan").getValue().toString());
                    quanAn.setmGioMoCua(value.child("giomocua").getValue().toString());
                    quanAn.setmGioDongCua(value.child("giodongcua").getValue().toString());
                    quanAn.setmHinhAnh(value.child("hinhanh").getValue().toString());
                    quanAn.setmGiaoHang((Boolean) value.child("giaohang").getValue());
                    quanAn.setmHinhAnhQuanAn(value.child("hinhanhquanan").getValue().toString());


//                    Log.d("kiemtra", quanAn.getmDiaChiQuan());

                    list_QuanAn.add(quanAn);
                }
                progressBarODau.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}


