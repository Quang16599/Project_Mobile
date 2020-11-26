package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import goodman.gm.p_mobile.R;

public class TrangCaNhan extends AppCompatActivity {
    TextView tvFullName, tvUserName, tvPassword, tvEmail, tvPhone;
    Button btnChangePass, btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ca_nhan);

        Init();
    }

    private void Init() {
        tvFullName = findViewById(R.id.FullName);
        tvUserName = findViewById(R.id.userName);
        tvPassword = findViewById(R.id.password);
        tvEmail    = findViewById(R.id.email);
        tvPhone    = findViewById(R.id.phoneNumber);
        btnChangePass = findViewById(R.id.btnChangPass);
        btnLogOut     = findViewById(R.id.btnLogOut);
    }
}