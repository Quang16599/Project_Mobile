package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class AdminChiTietFood extends AppCompatActivity {
    TextView tvAdminTenQA, tvAdminDC, tvAdminGMC, tvAdminGDC, tvAdminGT,tvAdminMT;
    QuanAn quanAn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_chi_tiet_food);

        init();

        setData();
    }

    private void setData() {
        Intent intent = getIntent();

        quanAn = (QuanAn) intent.getSerializableExtra("adminFoods");
        tvAdminTenQA.setText(quanAn.getmTenQuanAn());
        tvAdminDC.setText(quanAn.getmDiaChiQuan());
        tvAdminGMC.setText(quanAn.getmGioMoCua());
        tvAdminGDC.setText(quanAn.getmGioDongCua());
        tvAdminGT.setText(quanAn.getmGiaTien());
        tvAdminMT.setText(quanAn.getmMoTaQuanAn());
    }

    private void init() {
        tvAdminTenQA = findViewById(R.id.tvAdminTenQA);
        tvAdminDC = findViewById(R.id.tvAdminDC);
        tvAdminGMC = findViewById(R.id.tvAdminGMC);
        tvAdminGDC = findViewById(R.id.tvAdminGDC);
        tvAdminGT = findViewById(R.id.tvAdminGT);
        tvAdminMT = findViewById(R.id.tvAdminMT);
    }
}