package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
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

import goodman.gm.p_mobile.Model.ChiNhanhQuanAn;
import goodman.gm.p_mobile.R;

public class GanToi extends AppCompatActivity {

    ListView listView;
    List<ChiNhanhQuanAn> list_ChiNhanh;
    SharedPreferences sharedPreferences;
    Location vitrihientai;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("gantois");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gan_toi);


        Init();
        LoadData();
        getToaDo();
    }

    private void LoadData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot value : snapshot.getChildren()){
                    ChiNhanhQuanAn chiNhanhQuanAn = new ChiNhanhQuanAn();
                    chiNhanhQuanAn.setmLatitue(Double.parseDouble(value.child("latitude").getValue().toString()));
                    chiNhanhQuanAn.setmLongitue(Double.parseDouble(value.child("longitude").getValue().toString()));
                    Location location = new Location("");
                    location.setLatitude(chiNhanhQuanAn.getmLatitue());
                    location.setLongitude(chiNhanhQuanAn.getmLongitue());

                    double khoangcach = vitrihientai.distanceTo(location);
                    Log.d("khoangcach",chiNhanhQuanAn.getmDiaChi());
                    list_ChiNhanh.add(chiNhanhQuanAn);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getToaDo() {

    }

    private void Init() {
        list_ChiNhanh = new ArrayList<>();
        sharedPreferences = getSharedPreferences("ToaDo", Context.MODE_PRIVATE);
        vitrihientai = new Location("");
        vitrihientai.setLatitude(Double.parseDouble(sharedPreferences.getString("Latitude","0")));
        vitrihientai.setLongitude(Double.parseDouble(sharedPreferences.getString("Longitude","0")));



    }
}