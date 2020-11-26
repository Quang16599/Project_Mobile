package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class ChiTietQuanAn extends AppCompatActivity {
    ImageView imgView;
    TextView tvThoiGianHoatDong, tvTrangThaiHoatDong, tvTenQuanAn, tvDiem, tvDiaChi;
    QuanAn quanAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_quan_an);

        Init();


    }

    private void Init() {
        imgView  = findViewById(R.id.imageView);
        tvThoiGianHoatDong = findViewById(R.id.tvGioHoatDong);
        tvTrangThaiHoatDong = findViewById(R.id.tvTrangThai);
        tvTenQuanAn = findViewById(R.id.tvTenQuanAn);
//        tvDiem = findViewById(R.id.tvDiem);
        tvDiaChi = findViewById(R.id.tvDiaChi);
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

    }
}