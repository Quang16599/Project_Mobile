package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import goodman.gm.p_mobile.R;

public class QuenMatKhau extends AppCompatActivity {
    Button btnNext;
    TextInputEditText edtUserName;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("thanhviens");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mat_khau);

        init();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callVertifyOTP();
            }
        });
    }

    private void callVertifyOTP() {
        if (edtUserName.getText().toString().isEmpty()) {
            Toast.makeText(QuenMatKhau.this, "Please Enter values", Toast.LENGTH_SHORT).show();
        } else {
            final ProgressDialog dialog = new ProgressDialog(QuenMatKhau.this);
            dialog.setMessage("Please waiting");
            dialog.show();
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.child(edtUserName.getText().toString()).exists()) {
                        dialog.dismiss();
                        // lay du lieu
                        User user = snapshot.child(edtUserName.getText().toString()).getValue(User.class);
                        Intent intent = new Intent(QuenMatKhau.this, Vertify_OTP.class);
                        intent.putExtra("phone", user);
                        Log.d("log", user.getmPhoneNumber());
                        startActivity(intent);
                    } else {
                        Toast.makeText(QuenMatKhau.this, "User Name is not exists", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }

    }

    private void init() {
        btnNext = findViewById(R.id.btnNext);
        edtUserName = findViewById(R.id.edtUser_Name);

    }

}