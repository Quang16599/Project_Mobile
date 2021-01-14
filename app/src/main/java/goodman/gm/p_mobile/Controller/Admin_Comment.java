package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Adapter.Admin_Comment_Adapter;
import goodman.gm.p_mobile.Model.BinhLuan;
import goodman.gm.p_mobile.R;

public class Admin_Comment extends AppCompatActivity {
    ProgressBar progressBarAdminCommnent;
    ListView listView;
    Admin_Comment_Adapter adapter;
    List<BinhLuan> lstBinhLuan;
    BinhLuan binhLuan;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("binhluans");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_comment);
        init();
        loadData();
    }

    private void loadData() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot valueBinhLuan : snapshot.getChildren()) {
                    binhLuan = valueBinhLuan.getValue(BinhLuan.class);
//                    binhLuan.setMaQuanAn(valueBinhLuan.getKey());
                    // lay ds bluan cua quan an
//                    DataSnapshot dataSnapshotBinhLuan = snapshot.child("binhluans").child(valueBinhLuan.getKey());
//                    for (DataSnapshot valueBluan : dataSnapshotBinhLuan.getChildren()) {
//                        binhLuan = valueBluan.getValue(BinhLuan.class);
//
//
//                    }
                    lstBinhLuan.add(binhLuan);
                    Log.d("abc",binhLuan.toString());
                }

                progressBarAdminCommnent.setVisibility(View.GONE);
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void init() {
        progressBarAdminCommnent = findViewById(R.id.progressBarAdminComment);
        listView = findViewById(R.id.lstBinhLuan);
        lstBinhLuan = new ArrayList<>();
        adapter = new Admin_Comment_Adapter(this, R.layout.custom_listquanan, lstBinhLuan);

    }
}