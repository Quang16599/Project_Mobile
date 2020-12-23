package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import goodman.gm.p_mobile.Model.DiaChi;
import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class AdminChiTietNear extends AppCompatActivity {
    TextView tvNearTenQuan, tvNearDiaChi, tvNearLong, tvNearLati;
    Button btnNearUpdate, btnNearBack;
    DiaChi diachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_chi_tiet_near);
        init();
        btnNearBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminChiTietNear.this, AdminNear.class);
                startActivity(intent);

            }
        });
    }


    private void init() {
        tvNearTenQuan = findViewById(R.id.tvNearTenQuan);
        tvNearDiaChi = findViewById(R.id.tvNearDiaChi);
        tvNearLong = findViewById(R.id.tvNearLong);
        tvNearLati = findViewById(R.id.tvNearLati);
        btnNearUpdate = findViewById(R.id.btnNearUpdate);
        btnNearBack = findViewById(R.id.btnNearBack);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        diachi = (DiaChi) intent.getSerializableExtra("adminNear");
        tvNearTenQuan.setText(diachi.getmTenQuanAn());
        tvNearDiaChi.setText(diachi.getmDiaChi());
        tvNearLong.setText(Double.valueOf(diachi.getmLongitue()).toString());
        tvNearLati.setText(Double.valueOf(diachi.getmLatitue()).toString());


    }
}