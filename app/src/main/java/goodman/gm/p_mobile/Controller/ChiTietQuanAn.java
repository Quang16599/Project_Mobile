package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Adapter.BinhLuan_Adapter;
import goodman.gm.p_mobile.Adapter.ODau_Adapter;
import goodman.gm.p_mobile.Model.BinhLuan;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class ChiTietQuanAn extends AppCompatActivity {
    ImageView imgView;
    TextView tvThoiGianHoatDong, tvTrangThaiHoatDong, tvTenQuanAn, tvDiem, tvDiaChi,tvMoTa,tvGiaTien;
    QuanAn quanAn;

    RecyclerView recyclerViewBinhLuan;
    BinhLuan_Adapter binhLuan_adapter;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("binhluans");
    List<BinhLuan> lstBinhLuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_quan_an);

        Init();
//        loadData();


    }

//    private void loadData() {
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot value : snapshot.getChildren()) {
//                    BinhLuan binhLuan = new BinhLuan();
//                    binhLuan.setmChamDiem(value.child("chamdiem").getValue().toString());
//                    binhLuan.setmLuotThich(value.child("luotthich").getValue().toString());
//                    binhLuan.setmNoiDung(value.child("noidung").getValue().toString());
//                    binhLuan.setmTieuDe(value.child("tieude").getValue().toString());
//
//
//                    lstBinhLuan.add(binhLuan);
//                }
//
//                binhLuan_adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }

    private void Init() {
        imgView  = findViewById(R.id.imageView);
        tvThoiGianHoatDong = findViewById(R.id.tvGioHoatDong);
        tvTrangThaiHoatDong = findViewById(R.id.tvTrangThai);
        tvTenQuanAn = findViewById(R.id.tvTenQuanAn);
//        tvDiem = findViewById(R.id.tvDiem);
        tvDiaChi = findViewById(R.id.tvDiaChi);
        tvMoTa = findViewById(R.id.tvMoTa);
        tvGiaTien = findViewById(R.id.tvGiaTien);
//        lstBinhLuan = new ArrayList<>();
//        recyclerViewBinhLuan = findViewById(R.id.recyclerViewBinhLuan);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerViewBinhLuan.setLayoutManager(layoutManager);
//        binhLuan_adapter = new BinhLuan_Adapter(R.layout.custom_layout_recyclerview_odau, lstBinhLuan);
//        recyclerViewBinhLuan.setAdapter(binhLuan_adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        quanAn = (QuanAn) intent.getSerializableExtra("quanans");

        Picasso.get().load(quanAn.getmHinhAnhQuanAn()).into(imgView);
        tvTenQuanAn.setText(quanAn.getmTenQuanAn());
        tvDiaChi.setText(quanAn.getmDiaChiQuan());
        tvThoiGianHoatDong.setText(quanAn.getmGioMoCua() + " " + quanAn.getmGioDongCua());
        tvMoTa.setText(quanAn.getmMoTaQuanAn());
        tvGiaTien.setText(quanAn.getmGiaTien());



    }
}