package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import goodman.gm.p_mobile.R;

public class DoiMatKhau extends AppCompatActivity {
    TextInputLayout oldPass, newPass, confirmPass;
    Button btnHuy, btnDongY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        init();
        controller();
    }

    private void controller() {
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoiMatKhau.this, TrangCaNhan.class);
                startActivity(intent);
            }
        });

        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(DoiMatKhau.this, "Change Password Successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void init() {
         oldPass = findViewById(R.id.oldpassword);
         newPass = findViewById(R.id.newPassword);
         confirmPass = findViewById(R.id.confirmPassword);
         btnHuy = findViewById(R.id.btnHuy);
         btnDongY = findViewById(R.id.btnDongY);
    }

}