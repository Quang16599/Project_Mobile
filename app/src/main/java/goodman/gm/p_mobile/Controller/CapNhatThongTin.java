package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class CapNhatThongTin extends AppCompatActivity {
    EditText edtFullName, edtEmail, edtNumber;
    Button btnUp, btnBack;
    SharedPreferences sharedPreferences;
    String tenDn, matKhau;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference("thanhviens");

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
        tenDn = sharedPreferences.getString("UserName", "1");
        matKhau = sharedPreferences.getString("PassWord", "1");
    }

    private void Action() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CapNhatThongTin.this, TrangCaNhan.class);
                startActivity(intent);
            }
        });
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String fullname = edtFullName.getText().toString();
                        String email = edtEmail.getText().toString();
                        String phone = edtNumber.getText().toString();


                        User user = new User(fullname, tenDn, matKhau, email, phone);
                        reference.child(tenDn).setValue(user);

                        Toast.makeText(CapNhatThongTin.this, "Cập nhật thành công!!! Vui lòng đăng nhập lại", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(CapNhatThongTin.this, DangNhap.class);
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
        edtFullName = findViewById(R.id.edtFullNameInfor);
        edtEmail = findViewById(R.id.edtNumberInfor);
        edtNumber = findViewById(R.id.edtEmailInfor);
        btnUp = findViewById(R.id.btnUpdateInfor);
        btnBack = findViewById(R.id.btnBackInfor);
        sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);


    }

}