package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import goodman.gm.p_mobile.R;

public class SetNewPassword extends AppCompatActivity {

    private TextInputLayout newPassWord, confirmPassWord;
    private String userName;
    private Button btnUpdate;
    public SharedPreferences sharedPreferences;
    private final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("thanhviens");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);

        init();
//        loadData();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newPassWord.getEditText().getText().toString().isEmpty() ||
                        confirmPassWord.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(SetNewPassword.this, "Không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    if (!validatePass()) {
                        Toast.makeText(SetNewPassword.this, "Vui lòng nhập đúng định dạng", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!confirmPassWord.getEditText().getText().toString().equals(newPassWord.getEditText().getText().toString())) {
                            Toast.makeText(SetNewPassword.this, "Xác nhận mật khẩu sai", Toast.LENGTH_SHORT).show();
                        } else {
                            reference.child(userName).child("mPassword").setValue(newPassWord.getEditText().getText().toString());
                            Intent intent = new Intent(SetNewPassword.this, DangNhap.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(SetNewPassword.this, "Đổi thành công", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }

//    private void loadData() {
//        Intent intent = getIntent();
//        userName = intent.getStringExtra("username");
//
//    }

    private void init() {
        newPassWord = findViewById(R.id.NewPassword);
        confirmPassWord = findViewById(R.id.ConfirmPassword);
        btnUpdate = findViewById(R.id.btnUpdatePassWord);

        sharedPreferences = getSharedPreferences("UserName", Context.MODE_PRIVATE);
        userName = sharedPreferences.getString("username", "2");
    }

    private boolean validatePass() {
        String val = newPassWord.getEditText().getText().toString().trim();

        String passwordVal = "^" +
                "(?=.*[A-Za-z])" +                //  bất kì kí tự nào
                "(?=.*[!@#$%^&*=])" +             //  ít nhất 1 kí tự đặc biệt
                "(?=\\S+$)" +                     //  không có khoảng trắng
                ".{4,}" +                         //  ít nhất có 4 kí tự
                "$";

        if (val.isEmpty()) {
            newPassWord.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            newPassWord.setError("Please add special characters ");
            return false;
        } else {
            newPassWord.setError(null);
            return true;
        }
    }
}