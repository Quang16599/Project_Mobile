package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Adapter.AdapterHienThiHinhBinhLuan;
import goodman.gm.p_mobile.Model.BinhLuan;
import goodman.gm.p_mobile.R;

public class BinhLuanActivity extends AppCompatActivity {
    TextView txtTen, txtDiaChi, tvDang;
    String maquanan;
    EditText edtTieuDe, edtNoiDung;
    ImageButton btnChonHinh;
    RecyclerView recyclerViewChonHinhBinhLuan;
    AdapterHienThiHinhBinhLuan adapter;
    SharedPreferences sharedPreferences;
    List<String> listHinhDuocChon;

    final int REQUEST_CHONHINHBINHLUAN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binh_luan);

        init();
        XuLy();


    }

    private void init() {
        txtTen = findViewById(R.id.txtTenQuanAn);
        txtDiaChi = findViewById(R.id.txtDiaChiQuanAn);
        btnChonHinh = findViewById(R.id.btnChonHinh);
        recyclerViewChonHinhBinhLuan = findViewById(R.id.recyclerChonHinhBinhLuan);
        tvDang = findViewById(R.id.txtDangBinhLuan);
        edtTieuDe = findViewById(R.id.edtTieuDeBinhLuan);
        edtNoiDung = findViewById(R.id.edtNoiDungBinhLuan);
        listHinhDuocChon = new ArrayList<>();
        sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);


    }

    private void XuLy() {
        btnChonHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BinhLuanActivity.this, ChonHinhBinhLuan.class);
                startActivityForResult(intent, REQUEST_CHONHINHBINHLUAN);
            }
        });

        tvDang.setOnClickListener(v -> {
            BinhLuan binhLuan = new BinhLuan();
            String tieude = edtTieuDe.getText().toString();
            String noidung = edtNoiDung.getText().toString();
            String tenuser = sharedPreferences.getString("UserName", "");

            Toast.makeText(BinhLuanActivity.this, "dsadjkas", Toast.LENGTH_SHORT).show();

            binhLuan.setmTieuDe(tieude);
            binhLuan.setmNoiDung(noidung);
            binhLuan.setmChamDiem("0");
            binhLuan.setmLuotThich("0");
            binhLuan.setTenuser(tenuser);

            ThemBinhLuan(maquanan, binhLuan, listHinhDuocChon);


        });
    }

    private void ThemBinhLuan(String maquanan, BinhLuan binhLuan, List<String> listHinhDuocChon) {
        DatabaseReference nodeBinhLuan = FirebaseDatabase.getInstance().getReference("binhluans");
        String mabinhluan = nodeBinhLuan.child(maquanan).push().getKey();

        nodeBinhLuan.child(maquanan).child(mabinhluan).setValue(binhLuan).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    if (listHinhDuocChon.size() > 0) {
                        for (String valueHinh : listHinhDuocChon) {
                            Uri uri = Uri.fromFile(new File(valueHinh));
                            StorageReference storageReference = FirebaseStorage.getInstance().getReference("hinhanh/" + uri.getLastPathSegment());
                            storageReference.putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                                }
                            });
                        }
                    }

                }
            }
        });


        if (listHinhDuocChon.size() > 0) {
            for (String valueHinh : listHinhDuocChon) {
                Uri uri = Uri.fromFile(new File(valueHinh));
                FirebaseDatabase.getInstance().getReference().child("hinhanhbinhluans").child(mabinhluan).push().setValue(uri.getLastPathSegment());
            }
        }


    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        txtTen.setText(intent.getStringExtra("tqa"));
        txtDiaChi.setText(intent.getStringExtra("dc"));
        maquanan = intent.getStringExtra("mqa");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CHONHINHBINHLUAN) {
            if (resultCode == RESULT_OK) {
                listHinhDuocChon = data.getStringArrayListExtra("listHinhDuocChon");
                adapter = new AdapterHienThiHinhBinhLuan(this, R.layout.custom_layout_hienthihinhbinhluan, listHinhDuocChon);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                recyclerViewChonHinhBinhLuan.setLayoutManager(layoutManager);
                recyclerViewChonHinhBinhLuan.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }

    }
}