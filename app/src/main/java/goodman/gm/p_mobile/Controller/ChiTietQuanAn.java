package goodman.gm.p_mobile.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class ChiTietQuanAn extends AppCompatActivity {
    ImageView imgView;
    TextView tvThoiGianHoatDong, tvTrangThaiHoatDong, tvTenQuanAn, tvDiem, tvDiaChi, tvMoTa, tvGiaTien, tvTieuDe;
    QuanAn quanAn;

//    RecyclerView recyclerViewBinhLuan;
//    BinhLuan_Adapter adapter;
//    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("binhluans");
//    List<BinhLuan> lstBinhLuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_quan_an);

        Init();


    }


    private void Init() {
        imgView = findViewById(R.id.imageView);
        tvThoiGianHoatDong = findViewById(R.id.tvGioHoatDong);
        tvTrangThaiHoatDong = findViewById(R.id.tvTrangThai);
        tvTenQuanAn = findViewById(R.id.tvTenQuanAn);
//        tvDiem = findViewById(R.id.tvDiem);
        tvDiaChi = findViewById(R.id.tvDiaChi);
        tvMoTa = findViewById(R.id.tvMoTa);
        tvGiaTien = findViewById(R.id.tvGiaTien);
        tvTieuDe = findViewById(R.id.tvTieuDe);
//        recyclerViewBinhLuan = findViewById(R.id.recyclerViewBinhLuan);

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
        tvTieuDe.setText(quanAn.getmTenQuanAn());
        SetTrangThai();


//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerViewBinhLuan.setLayoutManager(layoutManager);


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