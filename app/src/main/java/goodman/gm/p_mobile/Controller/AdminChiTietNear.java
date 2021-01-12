package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import goodman.gm.p_mobile.Model.DiaChi;
import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class AdminChiTietNear extends AppCompatActivity {
    TextView tvNearTenQuan, tvNearDiaChi, tvNearLong, tvNearLati;
    Button btnNearUpdate, btnNearBack;
    DiaChi diachi;
    String maquanan;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference("gantois");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_chi_tiet_near);
        init();
        xulysukien();
//        btnNearBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AdminChiTietNear.this, AdminNear.class);
//                startActivity(intent);
//
//            }
//        });
    }

    private void xulysukien() {
        btnNearUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String tenQuan = tvNearTenQuan.getText().toString();
                        String diaChiQuan = tvNearDiaChi.getText().toString();
                        Double longtitude = Double.valueOf(tvNearLong.getText().toString());
                        Double latitude = Double.valueOf(tvNearLati.getText().toString());

                        DiaChi diaChi = new DiaChi(tenQuan, diaChiQuan, latitude, longtitude, maquanan);
                        reference.child(maquanan).setValue(diaChi);
                        Toast.makeText(AdminChiTietNear.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(AdminChiTietNear.this, AdminNear.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }


    private void init() {
        tvNearTenQuan = findViewById(R.id.tvNearTenQuan);
        tvNearDiaChi = findViewById(R.id.tvNearDiaChi);
        tvNearLong = findViewById(R.id.tvNearLong);
        tvNearLati = findViewById(R.id.tvNearLati);
        btnNearUpdate = findViewById(R.id.btnNearUpdateDone);
        btnNearBack = findViewById(R.id.btnNearBackDone);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        diachi = (DiaChi) intent.getSerializableExtra("adminNear");
        maquanan = diachi.getmMaQuanAn();
        tvNearTenQuan.setText(diachi.getmTenQuanAn());
        tvNearDiaChi.setText(diachi.getmDiaChi());
        tvNearLong.setText(Double.valueOf(diachi.getmLongitue()).toString());
        tvNearLati.setText(Double.valueOf(diachi.getmLatitue()).toString());


    }
}