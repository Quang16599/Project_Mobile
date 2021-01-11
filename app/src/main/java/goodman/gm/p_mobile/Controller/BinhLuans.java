package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.List;

import goodman.gm.p_mobile.R;

public class BinhLuans extends AppCompatActivity {
    TextView txtTen,txtDiaChi;
    ImageButton btnChonHinh;
    List<String> lstDuongDan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binh_luan);
        init();
        XuLy();


    }

    private void init() {
        txtTen = findViewById(R.id.txtTenQuanAn);
        txtDiaChi = findViewById(R.id.txtDiaChiQuanAn);
        btnChonHinh = findViewById(R.id.btnChonHinh);

    }
    private  void XuLy(){
      btnChonHinh.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(BinhLuans.this, ChonHinhBinhLuan.class);
            startActivity(intent);
          }
      });
    };


    @Override
    protected void onStart() {
        Intent intent = getIntent();
        txtTen.setText(intent.getStringExtra("abc"));
        txtDiaChi.setText(intent.getStringExtra("abcd"));
        super.onStart();
    }
}