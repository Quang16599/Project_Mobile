package goodman.gm.p_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import goodman.gm.p_mobile.Model.User;


public class DangKy extends AppCompatActivity {

    TextInputLayout edtFullName, edtUserName, edtEmail, edtPhone, edtPassWord;
    Button btnBack, btnDangKy;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        // khởi tạo
        Init();


        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(!validateName() || ! )
                reference = FirebaseDatabase.getInstance().getReference();


                String fullname = edtFullName.getEditText().getText().toString();
                String username = edtUserName.getEditText().getText().toString();
                String password = edtPassWord.getEditText().getText().toString();
                String email = edtEmail.getEditText().getText().toString();
                String phone = edtPhone.getEditText().getText().toString();

                User user = new User(fullname, username, password, email, phone);

                reference.child("Users").push().setValue(user);
                Toast.makeText(DangKy.this, "dsada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateName() {
        String val = edtFullName.getEditText().getText().toString();

        if (val.isEmpty()) {
            edtFullName.setError("Field cannot be empty");
            return false;
        } else {
            edtFullName.setError(null);
            return true;
        }
    }

    private boolean validateUser() {
        String val = edtUserName.getEditText().getText().toString();
        String noWhiteSpace = " (?=\\S+$)";

        if (val.isEmpty()) {
            edtUserName.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15) {
            edtUserName.setError("username is too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            edtUserName.setError("White Space are not allowed");
            return false;
        } else {
            edtUserName.setError(null);
            return true;
        }
    }

    private boolean validatePass() {
        String val = edtPassWord.getEditText().getText().toString();
        String passwordVal = "^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[$@$!%*#?&])[A-Za-z\\\\d$@$!%*#?&]{8,}$";

        if (val.isEmpty()) {
            edtPassWord.setError("Field cannot be empty");
            return false;
        } else if(!val.matches(passwordVal)) {
            edtPassWord.setError("Password is too weak");
            return false;
        }else {
            edtPassWord.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = edtEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            edtEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            edtEmail.setError("Invalid email address");
            return false;
        } else {
            edtEmail.setError(null);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = edtPhone.getEditText().getText().toString();
        String regexStr = "^[0-9]$";

        if (val.length() < 10 || val.length() > 13 || val.matches(regexStr) == false) {
            edtPhone.setError("Wrong phone number");
            return false;
        } else {
            edtPhone.setError(null);
            return true;
        }
    }


    private void Init() {
        edtFullName = findViewById(R.id.edtFullName);
        edtUserName = findViewById(R.id.edtUserName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassWord = findViewById(R.id.edtPassWord);
        btnBack = findViewById(R.id.btnBack);
        btnDangKy = findViewById(R.id.btnDangKy);
    }




}