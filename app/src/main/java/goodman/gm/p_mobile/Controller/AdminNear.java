package goodman.gm.p_mobile.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Adapter.AdminNear_Adapter;
import goodman.gm.p_mobile.Model.DiaChi;
import goodman.gm.p_mobile.R;

public class AdminNear extends AppCompatActivity {
    ProgressBar progressBarAdminNear;
    int vitri = 0;
    ListView listView;
    AdminNear_Adapter adapter;
    List<DiaChi> lstDiachi;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("gantois");
    Button btnThemDiaChi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_near);

        init();
        loadData();
        btnThemDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminNear.this, AdminNearAdd.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lstDiachi.clear();
                for (DataSnapshot value : snapshot.getChildren()) {

                    DiaChi diaChi = new DiaChi();
                    diaChi.setmMaQuanAn(value.getKey());
                    diaChi.setmLongitue((Double) value.child("longitude").getValue());
                    diaChi.setmLatitue((Double) value.child("latitude").getValue());
                    diaChi.setmDiaChi(value.child("diachi").getValue().toString());
                    diaChi.setmTenQuanAn(value.child("tenquanan").getValue().toString());

//                    Log.e("abc", diaChi.toString());
                    lstDiachi.add(diaChi);

                }
                progressBarAdminNear.setVisibility(View.GONE);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void init() {
        progressBarAdminNear = findViewById(R.id.progressBarAdminNear);
        listView = findViewById(R.id.lstNear);
        lstDiachi = new ArrayList<>();
        adapter = new AdminNear_Adapter(AdminNear.this, R.layout.custom_listnear, lstDiachi);
        btnThemDiaChi = findViewById(R.id.btnThemDiaChiAdmin);

    }
    public void DeleteDiaChi(final int position) {
        lstDiachi.remove(position);
        adapter.notifyDataSetChanged();
    }


}