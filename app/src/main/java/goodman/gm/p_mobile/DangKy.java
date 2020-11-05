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

    TextInputLayout edtFullName, edtUserName, edtEmail, edtPhone,edtPass;
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
                reference = FirebaseDatabase.getInstance().getReference();

//                User a = new User("pvq","quang","123","a@gmail.com","093125");

              String fullname = edtFullName.getEditText().getText().toString();
              String username = edtUserName.getEditText().getText().toString();
              String password = edtPass.getEditText().getText().toString();
              String email    = edtEmail.getEditText().getText().toString();
              String phone    = edtPhone.getEditText().getText().toString();

              User user = new User(fullname,username,password,email,phone);

//                reference.child("User").setValue(a);
                reference.child("User").push().setValue(user);
                Toast.makeText(DangKy.this, "dsada", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void Init() {
        edtFullName = findViewById(R.id.edtFullName);
        edtUserName = findViewById(R.id.edtUserName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtPass = findViewById(R.id.edtPassWord);
        btnBack = findViewById(R.id.btnBack);
        btnDangKy = findViewById(R.id.btnDangKy);
    }
}