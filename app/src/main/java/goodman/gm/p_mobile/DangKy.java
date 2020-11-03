package goodman.gm.p_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class DangKy extends AppCompatActivity {

    EditText edtTenDn, edtMatKhau, edtNgaySinh, edtCMND;
    Button btnThoat, btnDongY;
    RadioGroup radioGroup;
    RadioButton rdNam, rdNu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        // khởi tạo
        Init();

    }



    private void Init() {
        edtTenDn = findViewById(R.id.edtTenDN);
        edtMatKhau = findViewById(R.id.edtMK);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtCMND = findViewById(R.id.edtCMND);

        radioGroup = findViewById(R.id.radiogroup);
        rdNam = findViewById(R.id.rdNam);
        rdNu  = findViewById(R.id.rdNu);

        btnDongY = findViewById(R.id.btnDongY);
        btnThoat = findViewById(R.id.btnThoat);
    }
}