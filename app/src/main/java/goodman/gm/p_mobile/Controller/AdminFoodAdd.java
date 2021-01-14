package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import goodman.gm.p_mobile.R;

public class AdminFoodAdd extends AppCompatActivity {
    EditText edtMaQuan,edtTenQuan, edtDiaChi, edtGioMoCua, edtGioDongCua,edtGiaTien,edtMoTa;
    Button btnThem, btnQuayLai;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference("gantois");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_food_add);

        init();
        controlButton();

    }

    private void controlButton() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void init() {
        edtMaQuan = findViewById(R.id.edtMaQuanAnFood);
        edtTenQuan = findViewById(R.id.edtTenQuanAnFood);
        edtDiaChi = findViewById(R.id.edtDiaChiFood);
        edtGioDongCua = findViewById(R.id.edtGioDongCuaFood);
        edtGioMoCua = findViewById(R.id.edtGioMoCuaFood);
        edtGiaTien = findViewById(R.id.edtGiaTienFood);
        edtMoTa = findViewById(R.id.edtMoTaFood);
        btnThem = findViewById(R.id.btnThemFood);
        btnQuayLai = findViewById(R.id.btnBackFood);

    }


}