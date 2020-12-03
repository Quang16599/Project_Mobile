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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import goodman.gm.p_mobile.Adapter.GanToi_Adapter;
import goodman.gm.p_mobile.Model.DiaChi;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class GanToi extends AppCompatActivity {

    ListView listView;
    GanToi_Adapter adapter;
    List<DiaChi> list_DiaChi;
    SharedPreferences sharedPreferences;
    Location vitrihientai;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("gantois");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gan_toi);

        Init();
        LoadData();
    }

    private void LoadData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot value : snapshot.getChildren()){
                        DiaChi diaChi = new DiaChi();
                        diaChi.setmLongitue((Double) value.child("longitude").getValue());
                        diaChi.setmLatitue((Double) value.child("latitude").getValue());
                        diaChi.setmDiaChi(value.child("diachi").getValue().toString());
                        diaChi.setmTenQuanAn(value.child("tenquanan").getValue().toString());


                        Location location = new Location("");
                        location.setLatitude(diaChi.getmLatitue());
                        location.setLongitude(diaChi.getmLongitue());

                        double khoangcach = vitrihientai.distanceTo(location)/1000;

                        diaChi.setmKhoangCach(khoangcach);

                        list_DiaChi.add(diaChi);

                }

                Collections.sort(list_DiaChi, new Comparator<DiaChi>() {
                    @Override
                    public int compare(DiaChi d1, DiaChi d2) {
                        double a = d1.getmKhoangCach() - d2.getmKhoangCach();
                        return (int) a;
                    }
                });
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void Init() {
        list_DiaChi = new ArrayList<>();
        sharedPreferences = getSharedPreferences("ToaDo", Context.MODE_PRIVATE);
        vitrihientai = new Location("");
        vitrihientai.setLatitude(Double.parseDouble(sharedPreferences.getString("Latitude","0")));
        vitrihientai.setLongitude(Double.parseDouble(sharedPreferences.getString("Longitude","0")));
        Log.d("vitri","latitude"+vitrihientai.getLatitude()+" " +"longitude" + vitrihientai.getLongitude());
        listView = findViewById(R.id.listview);
        adapter = new GanToi_Adapter(R.layout.custom_layout_listview_gantoi,list_DiaChi);






    }
}