package goodman.gm.p_mobile.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Adapter.AnGi_Adapter;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class AnGiFragment extends Fragment {
    RecyclerView recyclerView;
    AnGi_Adapter adapter;
    List<QuanAn> list_QuanAn;
    View view;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("quanans");
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_angi,container,false);

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
        recyclerView = view.findViewById(R.id.recyclerViewAnGi);
        list_QuanAn = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AnGi_Adapter(getContext(), R.layout.custom_layout_gridview_angi,list_QuanAn);
        recyclerView.setAdapter(adapter);


    }

    private void loadData(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot value : snapshot.getChildren()) {
                    QuanAn quanAn = new QuanAn();
                    quanAn.setmMaQuanAn(value.getKey());
                    quanAn.setmDiaChiQuan(value.child("diachi").getValue().toString());
                    quanAn.setmTenQuanAn(value.child("tenquanan").getValue().toString());
                    quanAn.setmGioMoCua(value.child("giomocua").getValue().toString());
                    quanAn.setmGioDongCua(value.child("giodongcua").getValue().toString());
                    quanAn.setmHinhAnh(value.child("hinhanh").getValue().toString());
                    quanAn.setmGiaoHang((Boolean) value.child("giaohang").getValue());
                    quanAn.setmHinhAnhQuanAn(value.child("hinhanhquanan").getValue().toString());
                    quanAn.setmGiaTien(value.child("giatien").getValue().toString());
                    quanAn.setmMoTaQuanAn(value.child("motaquanan").getValue().toString());


                    list_QuanAn.add(quanAn);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
