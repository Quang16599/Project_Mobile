package goodman.gm.p_mobile.Controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class TrangCaNhan extends AppCompatActivity {
    TextView tvFullName, tvUserName, tvPassword, tvEmail, tvPhone;
    Button btnChangePass, btnLogOut;
    SharedPreferences sharedPreferences;
    String passWord, fullName, email, phoneNumber, userName;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ca_nhan);

        Init();
        controlButton();
        loadData();
        sendData();

    }

//    private void loadDataChange() {
//        Intent intent = getIntent();
//        user = (User) intent.getSerializableExtra("change");
//
//        tvFullName.setText(user.getmFullName());
//        tvEmail.setText(user.getmEmail());
//        tvPassword.setText(user.getmPassword());
//        tvPhone.setText(user.getmPhoneNumber());
//        tvUserName.setText(user.getmUserName());
//
//
//    }


    private void Init() {
        tvFullName = findViewById(R.id.FullName);
        tvUserName = findViewById(R.id.userName);
        tvPassword = findViewById(R.id.password);
        tvEmail = findViewById(R.id.email);
        tvPhone = findViewById(R.id.phoneNumber);
        btnChangePass = findViewById(R.id.btnChangPass);
        btnLogOut = findViewById(R.id.btnLogOut);
        sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
    }

    private void controlButton() {
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangCaNhan.this, DoiMatKhau.class);
                User user = new User(fullName, userName, passWord, email, phoneNumber);
                intent.putExtra("send", user);
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TrangCaNhan.this);
                builder.setMessage("Bạn muốn đăng xuất ?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(TrangCaNhan.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setCancelable(false);
                builder.show();

            }
        });
    }


    private void loadData() {
        tvFullName.setText(sharedPreferences.getString("FullName", "1"));
        tvUserName.setText(sharedPreferences.getString("UserName", "1"));
        tvPassword.setText(sharedPreferences.getString("PassWord", "1"));
        tvEmail.setText(sharedPreferences.getString("Email", "1"));
        tvPhone.setText(sharedPreferences.getString("Phone", "1"));
    }

    private void sendData() {
        fullName = tvFullName.getText().toString();
        email = tvEmail.getText().toString();
        phoneNumber = tvPhone.getText().toString();
        userName = tvUserName.getText().toString();
        passWord = tvPassword.getText().toString();


    }
}