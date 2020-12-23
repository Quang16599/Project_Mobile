package goodman.gm.p_mobile.Controller;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

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
    ListView listView;
    AdminNear_Adapter adapter;
    List<DiaChi> lstDiachi;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("gantois");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_near);

        init();
        loadData();
    }

    private void loadData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot value : snapshot.getChildren()) {

                    DiaChi diaChi = new DiaChi();
                    diaChi.setmLongitue((Double) value.child("longitude").getValue());
                    diaChi.setmLatitue((Double) value.child("latitude").getValue());
                    diaChi.setmDiaChi(value.child("diachi").getValue().toString());
                    diaChi.setmTenQuanAn(value.child("tenquanan").getValue().toString());
                    Log.e("abc", diaChi.toString());
                    lstDiachi.add(diaChi);

                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void init() {
        listView = findViewById(R.id.lstNear);
        lstDiachi = new ArrayList<>();
        adapter = new AdminNear_Adapter(AdminNear.this, R.layout.custom_listnear, lstDiachi);

    }
}