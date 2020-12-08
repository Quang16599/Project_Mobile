package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class SetNewPassword extends AppCompatActivity {
    TextInputLayout newPassWord, confirmPassWord;
    String userName;
    Button btnUpdate;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("thanhviens");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);

        init();

        loadData();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });

    }

    private void loadData() {
        Intent intent = getIntent();
        userName = intent.getStringExtra("username");

    }


    private void updateUser() {
        if (newPassWord.getEditText().getText().toString().isEmpty()
                ||confirmPassWord.getEditText().getText().toString().isEmpty()) {
            Toast.makeText(SetNewPassword.this, "Không được để trống", Toast.LENGTH_SHORT).show();
        }
        if(!validatePass()){
            return;
        }
        if(!confirmPassWord.getEditText().getText().toString().equals(newPassWord.getEditText().getText().toString())){
            Toast.makeText(this, "Xác nhận mật khẩu sai", Toast.LENGTH_SHORT).show();
        }

        reference.child(userName).child("mPassword").setValue(newPassWord.getEditText().getText().toString().trim());
        Toast.makeText(this, "Update mật khẩu thành công", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(SetNewPassword.this, DangNhap.class);
        startActivity(intent);
        finish();
    }

    private void init() {
        newPassWord = findViewById(R.id.NewPassword);
        confirmPassWord = findViewById(R.id.ConfirmPassword);
        btnUpdate = findViewById(R.id.btnUpdate);

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