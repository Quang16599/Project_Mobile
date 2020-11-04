package goodman.gm.p_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import goodman.gm.p_mobile.Model.User;


public class DangKy extends AppCompatActivity {

    TextInputLayout edtFullName, edtUserName, edtEmail, edtPhone,edtPass;
    Button btnBack, btnDangKy;
    FirebaseDatabase rootNode;
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
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");


                String name = edtFullName.getEditText().getText().toString();
                String username = edtUserName.getEditText().getText().toString();
                String email = edtEmail.getEditText().getText().toString();
                String phone = edtPhone.getEditText().getText().toString();
                String pass = edtPass.getEditText().getText().toString();

                User data = new User(name,username,pass,email,phone);


                reference.setValue(data);
            }
        });
    }



    private void Init() {
        edtFullName = findViewById(R.id.edtFullName);
        edtUserName = findViewById(R.id.edtUserName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtPass = findViewById(R.id.edtPass);
        btnBack = findViewById(R.id.btnBack);
        btnDangKy = findViewById(R.id.btnDangKy);
    }
}