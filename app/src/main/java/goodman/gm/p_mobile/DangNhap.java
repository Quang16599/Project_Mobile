package goodman.gm.p_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import goodman.gm.p_mobile.Model.User;

public class DangNhap extends AppCompatActivity {

    Button btnDangKy,btnDangnhap,btnQuenMK;
    TextInputEditText edtUser,edtPass;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        // khởi tạo
        Init();


        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog dialog = new ProgressDialog(DangNhap.this);
                dialog.setMessage("Please waiting");
                dialog.show();

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // kiem tra tai khoan co ton tai trong database
                        if(dataSnapshot.child(edtUser.getText().toString()).exists()) {
                            dialog.dismiss();
                            // lay du lieu
                            User user = dataSnapshot.child(edtUser.getText().toString()).getValue(User.class);
                            if (user.getmPassword().equals(edtPass.getText().toString())) {
                                Toast.makeText(DangNhap.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(DangNhap.this, "Wrong!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(DangNhap.this, "User not exist!!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this, DangKy.class);
                startActivity(intent);
            }
        });

        btnQuenMK = findViewById(R.id.btnForgot);
        btnQuenMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void Init() {
        btnDangnhap = findViewById(R.id.btnLogin);
        btnDangKy = findViewById(R.id.btnRegiste);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);


    }
}