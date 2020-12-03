package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class TrangCaNhan extends AppCompatActivity {
    TextView tvFullName, tvUserName, tvPassword, tvEmail, tvPhone;
    Button btnChangePass, btnLogOut;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ca_nhan);

        Init();
        controlButton();
        loadData();
    }


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

//    private void showDialog() {
//        final Dialog dialog = new Dialog(TrangCaNhan.this);
//        dialog.setContentView(R.layout.custom_change_password);
//
//
//        TextInputLayout oldPass = dialog.findViewById(R.id.oldpassword);
//        TextInputLayout newPass = dialog.findViewById(R.id.newPassword);
//        TextInputLayout confirmPass = dialog.findViewById(R.id.confirmPassword);
//        Button btnHuy = dialog.findViewById(R.id.btnHuy);
//        Button btnDongY = dialog.findViewById(R.id.btnDongY);
//
//
//
//
//        btnHuy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        btnDongY.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(TrangCaNhan.this, "Change Password Successfully", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
//
//
//
//        dialog.setCancelable(false);
//        dialog.show();
//    }

    private void loadData() {
        tvFullName.setText(sharedPreferences.getString("FullName", "1"));
        tvUserName.setText(sharedPreferences.getString("UserName", "1"));
        tvPassword.setText(sharedPreferences.getString("PassWord", "1"));
        tvEmail.setText(sharedPreferences.getString("Email", "1"));
        tvPhone.setText(sharedPreferences.getString("Phone", "1"));
    }
}