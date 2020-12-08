package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class SetNewPassword extends AppCompatActivity {
    TextInputLayout newPhone, confirmPhone;
    Button btnUpdate;
    User user;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("thanhviens");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);

        init();
        loadData();
        updateUser();
    }

    private void loadData() {
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("data");
        Log.d("user", user.getmFullName());

    }



    private void updateUser() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                reference.child(user.getmUserName()).child(user.getmPhoneNumber()).setValue(newPhone);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void init() {
        newPhone  = findViewById(R.id.NewPassword);
        confirmPhone = findViewById(R.id.ConfirmPassword);
    }
    private boolean validatePass() {
        String val = user.getmPassword();

        String passwordVal = "^" +
                "(?=.*[A-Za-z])" +                //  bất kì kí tự nào
                "(?=.*[!@#$%^&*=])" +             //  ít nhất 1 kí tự đặc biệt
                "(?=\\S+$)" +                     //  không có khoảng trắng
                ".{4,}" +                         //  ít nhất có 4 kí tự
                "$";

        if (val.isEmpty()) {
            newPhone.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            newPhone.setError("Please add special characters ");
            return false;
        } else {
            newPhone.setError(null);
            return true;
        }
    }
}