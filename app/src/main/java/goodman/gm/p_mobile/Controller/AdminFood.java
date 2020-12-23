package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Adapter.AdminFood_Adapter;
import goodman.gm.p_mobile.Adapter.AdminUser_Adapter;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class AdminFood extends AppCompatActivity {

    ListView listView;
    AdminFood_Adapter adapter;
    List<QuanAn> list_quanan;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("quanans");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_food);

        init();
        LoadData();
    }

    private void LoadData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot value : snapshot.getChildren()) {

                    QuanAn quanAn = new QuanAn();
                    quanAn.setmTenQuanAn(value.child("tenquanan").getValue().toString());
                    quanAn.setmDiaChiQuan(value.child("diachi").getValue().toString());
                    quanAn.setmGioDongCua(value.child("giodongcua").getValue().toString());
                    quanAn.setmGioMoCua(value.child("giomocua").getValue().toString());
                    quanAn.setmGiaTien(value.child("giatien").getValue().toString());
                    quanAn.setmMoTaQuanAn(value.child("motaquanan").getValue().toString());
                    list_quanan.add(quanAn);
                    Log.e("abc", quanAn.toString());


                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void init() {
        listView = findViewById(R.id.listAdminFood);
        list_quanan = new ArrayList<>();
        adapter = new AdminFood_Adapter(this, R.layout.custom_listquanan, list_quanan);
        listView.setAdapter(adapter);
    }
}