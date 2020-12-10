package goodman.gm.p_mobile.Controller;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
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

import goodman.gm.p_mobile.Adapter.AdminUser_Adapter;
import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class AdminUser extends AppCompatActivity {
    ListView listView;
    AdminUser_Adapter adapter;
    List<User> lstUser;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("thanhviens");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);
        init();
        LoadData();
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_admin_user, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    private void LoadData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot value : snapshot.getChildren()) {

                    User user = new User();
                    user.setmEmail(value.child("mEmail").getValue().toString());
                    user.setmFullName(value.child("mFullName").getValue().toString());
                    user.setmPassword(value.child("mPassword").getValue().toString());
                    user.setmPhoneNumber(value.child("mPhoneNumber").getValue().toString());
                    user.setmUserName(value.child("mUserName").getValue().toString());
                    lstUser.add(user);
//                    Log.e("abc", user.toString());


                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void init() {
        listView = findViewById(R.id.lstAdminUser);
        lstUser = new ArrayList<>();
        adapter = new AdminUser_Adapter(this, R.layout.custom_listuser, lstUser);
        listView.setAdapter(adapter);

    }
}