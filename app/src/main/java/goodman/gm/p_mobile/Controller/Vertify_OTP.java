package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class Vertify_OTP extends AppCompatActivity {
    PinView pinView;
    Button btnVertify;
    String phone, codeBySystem;
    User user;
    FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertify__otp);

        init();
        loadData();

        sendVertificationCodeToUser();

        btnVertify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNextScreenFromOTP();
            }
        });

    }

    private void sendVertificationCodeToUser() {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber(phone)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codeBySystem = s;
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    String code = phoneAuthCredential.getSmsCode();
                    if (code != null) {
                        pinView.setText(code);
                        vertify(code);
                    }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(Vertify_OTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            };

    private void vertify(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem, code);
        signInUsingCredential(credential);

    }

    private void signInUsingCredential(PhoneAuthCredential credential) {


        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(Vertify_OTP.this, SetNewPassword.class);
                            intent.putExtra("data", user);
                            startActivity(intent);
                            Toast.makeText(Vertify_OTP.this, "Hoàn tất", Toast.LENGTH_SHORT).show();

                        } else {

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(Vertify_OTP.this, "Không hợp lệ. Thử lại", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                });
        auth.signOut();
    }

    private void callNextScreenFromOTP() {
        String code = pinView.getText().toString();
        if (!code.isEmpty()) {
            vertify(code);
        }else {
            pinView.requestFocus();
        }
    }

    private void init() {
        pinView = findViewById(R.id.pin_view);
        btnVertify = findViewById(R.id.btnVertify);
    }

    private void loadData() {
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("phone");
        phone = user.getmPhoneNumber().trim();
    }


}