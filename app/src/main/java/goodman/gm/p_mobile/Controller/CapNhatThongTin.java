package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import goodman.gm.p_mobile.R;

public class CapNhatThongTin extends AppCompatActivity {
    EditText edtFullName, edtEmail, edtNumber;
    Button btnUp, btnBack;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat_thong_tin);
        init();
        LoadData();
        Action();
    }

    private void LoadData() {
        edtFullName.setText(sharedPreferences.getString("FullName", "1"));
        edtEmail.setText(sharedPreferences.getString("Email", "1"));
        edtNumber.setText(sharedPreferences.getString("Phone", "1"));
    }

    private void Action() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CapNhatThongTin.this, TrangCaNhan.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        edtFullName = findViewById(R.id.edtFullNameInfor);
        edtEmail = findViewById(R.id.edtNumberInfor);
        edtNumber = findViewById(R.id.edtEmailInfor);
        btnUp = findViewById(R.id.btnUpdateInfor);
        btnBack = findViewById(R.id.btnBackInfor);
        sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);


    }

}