package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import goodman.gm.p_mobile.R;

public class SetNewPassword extends AppCompatActivity {
    private EditText newPassWord, confirmPassWord;
    private String userName;
    private Button btnUpdate;
    private SharedPreferences sharedPreferences;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference("thanhviens");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);

        init();
//        loadData();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!confirmPassWord.getText().toString().equals(newPassWord.getText().toString())) {
                    Toast.makeText(SetNewPassword.this, "Xác nhận mật khẩu sai", Toast.LENGTH_SHORT).show();
                }
                reference.child(userName).child("mPassword").setValue(newPassWord.getText().toString().trim());
                Toast.makeText(SetNewPassword.this, "Update mật khẩu thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                finish();
//                if (newPassWord.getEditText().getText().toString().isEmpty()
//                        || confirmPassWord.getEditText().getText().toString().isEmpty()) {
//                    Toast.makeText(SetNewPassword.this, "Không được để trống", Toast.LENGTH_SHORT).show();
//                } else if (!validatePass()) {
//                    return;
//                } else if (!confirmPassWord.getEditText().getText().toString().equals(newPassWord.getEditText().getText().toString())) {
//                    Toast.makeText(SetNewPassword.this, "Xác nhận mật khẩu sai", Toast.LENGTH_SHORT).show();
//                } else {
//                    reference.child(userName).child("mPassword").setValue(newPassWord.getEditText().getText().toString().trim());
//                    Toast.makeText(SetNewPassword.this, "Update mật khẩu thành công", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), DangNhap.class);
//                    startActivity(intent);
//                }
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
        btnUpdate = findViewById(R.id.btnUpdate);

        sharedPreferences = getSharedPreferences("UserName", Context.MODE_PRIVATE);
        userName = sharedPreferences.getString("username", "2");


    }

    private boolean validatePass() {
        String val = newPassWord.getText().toString().trim();

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