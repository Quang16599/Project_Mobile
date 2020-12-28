package goodman.gm.p_mobile.Controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Adapter.AdminFood_Adapter;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class AdminFood extends AppCompatActivity {
    ProgressBar progressBarAdminFood;
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
        reference.orderByValue().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list_quanan.clear();

                for (DataSnapshot value : snapshot.getChildren()) {

                    QuanAn quanAn = new QuanAn();
                    quanAn.setmMaQuanAn(value.getKey());
                    quanAn.setmTenQuanAn(value.child("tenquanan").getValue().toString());
                    quanAn.setmDiaChiQuan(value.child("diachi").getValue().toString());
                    quanAn.setmGioDongCua(value.child("giodongcua").getValue().toString());
                    quanAn.setmGioMoCua(value.child("giomocua").getValue().toString());
                    quanAn.setmGiaTien(value.child("giatien").getValue().toString());
                    quanAn.setmMoTaQuanAn(value.child("motaquanan").getValue().toString());

                    list_quanan.add(quanAn);
//                    Log.e("abc", quanAn.getmMaQuanAn());

                }
                progressBarAdminFood.setVisibility(View.GONE);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void init() {
        progressBarAdminFood = findViewById(R.id.progressBarAdminFood);
        listView = findViewById(R.id.listAdminFood);
        list_quanan = new ArrayList<>();
        adapter = new AdminFood_Adapter(this, R.layout.custom_listquanan, list_quanan);


    }


    public void DeleteFood(final int position) {
        list_quanan.remove(position);
        adapter.notifyDataSetChanged();
    }


}