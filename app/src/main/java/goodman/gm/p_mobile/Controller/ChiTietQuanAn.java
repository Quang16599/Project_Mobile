package goodman.gm.p_mobile.Controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import goodman.gm.p_mobile.Adapter.BinhLuan_Adapter;
import goodman.gm.p_mobile.Model.BinhLuan;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class ChiTietQuanAn extends AppCompatActivity {
    ImageView imgView;
    TextView tvThoiGianHoatDong, tvTrangThaiHoatDong, tvTenQuanAn, tvDiaChi, tvMoTa, tvGiaTien, tvTieuDe;
    QuanAn quanAn;
    Button btnBinhLuan;
    RecyclerView recyclerViewBinhLuan;
    BinhLuan_Adapter adapter;
    List<BinhLuan> list_BinhLuan;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_quan_an);

        Init();
//        loadData();

        btnBinhLuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietQuanAn.this, BinhLuanActivity.class);
                intent.putExtra("tqa", quanAn.getmTenQuanAn());
                intent.putExtra("dc", quanAn.getmDiaChiQuan());
                intent.putExtra("mqa", quanAn.getmMaQuanAn());
                startActivity(intent);

            }
        });

    }

//    private void loadData() {
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                DataSnapshot snapshotQuanAn = snapshot.child("quanans");
//
//                for (DataSnapshot value : snapshotQuanAn.getChildren()) {
//                    quanAn.setmMaQuanAn(value.getKey());
//
//                    DataSnapshot snapshotBinhLuan = snapshot.child("binhluans").child(quanAn.getmMaQuanAn());
//                    for (DataSnapshot valueBinhLuan : snapshotBinhLuan.getChildren()) {
//                        BinhLuan binhLuan = new BinhLuan();
////                        binhLuan.setmNoiDung(valueBinhLuan.child("noidung").getValue().toString());
////                        binhLuan.setmTieuDe(valueBinhLuan.child("tieude").getValue().toString());
////                        binhLuan.setmLuotThich(valueBinhLuan.child("luotthich").getValue().toString());
////                        binhLuan.setmChamDiem(valueBinhLuan.child("chamdiem").getValue().toString());
//
//                        list_BinhLuan.add(binhLuan);
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//    }


    private void Init() {
        imgView = findViewById(R.id.imageView);
        tvThoiGianHoatDong = findViewById(R.id.tvGioHoatDong);
        tvTrangThaiHoatDong = findViewById(R.id.tvTrangThai);
        tvTenQuanAn = findViewById(R.id.tvTenQuanAn);
        tvDiaChi = findViewById(R.id.tvDiaChi);
        tvMoTa = findViewById(R.id.tvMoTa);
        tvGiaTien = findViewById(R.id.tvGiaTien);
        tvTieuDe = findViewById(R.id.tvTieuDe);
        recyclerViewBinhLuan = findViewById(R.id.recyclerViewBinhLuan);
        btnBinhLuan = findViewById(R.id.btnBinhLuanQuanAn);

        list_BinhLuan = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        quanAn = (QuanAn) intent.getSerializableExtra("quanans");
//        StorageReference storage = FirebaseStorage.getInstance().getReference().child(quanAn.getmHinhAnhQuanAn());
//        long ONE_MEGABYTE = 1024 * 1024;
//        storage.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//            @Override
//            public void onSuccess(byte[] bytes) {
//                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
//                imgView.setImageBitmap(bitmap);
//           }
//         });
        Picasso.get().load(quanAn.getmHinhAnhQuanAn()).into(imgView);
        tvTenQuanAn.setText(quanAn.getmTenQuanAn());
        tvDiaChi.setText(quanAn.getmDiaChiQuan());
        tvThoiGianHoatDong.setText(quanAn.getmGioMoCua() + " " + quanAn.getmGioDongCua());
        tvMoTa.setText(quanAn.getmMoTaQuanAn());
        tvGiaTien.setText(quanAn.getmGiaTien());
        tvTieuDe.setText(quanAn.getmTenQuanAn());
        SetTrangThai();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewBinhLuan.setLayoutManager(layoutManager);
        adapter = new BinhLuan_Adapter(this,R.layout.custom_binhluan, list_BinhLuan);



    }

    private void SetTrangThai() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        String giohientai = dateFormat.format(calendar.getTime());
        String giomocua = quanAn.getmGioMoCua();
        String giodongcua = quanAn.getmGioDongCua();

        try {
            Date dateHienTai = dateFormat.parse(giohientai);
            Date dateMoCua = dateFormat.parse(giomocua);
            Date dateDongCua = dateFormat.parse(giodongcua);

            if (dateHienTai.after(dateMoCua) && dateHienTai.before(dateDongCua)) {
                //gio mo cua
                tvTrangThaiHoatDong.setText("Đang mở cửa");
            } else {
                //dong cua
                tvTrangThaiHoatDong.setText("Đóng cửa");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}