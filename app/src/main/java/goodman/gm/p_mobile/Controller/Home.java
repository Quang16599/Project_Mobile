package goodman.gm.p_mobile.Controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import goodman.gm.p_mobile.Adapter.Category_Adapter;
import goodman.gm.p_mobile.Model.Category;
import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class Home extends AppCompatActivity {

    ListView listView;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Category");
    Category_Adapter adapter;
    ArrayList<Category> list_Category;
    Category category;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        listView = findViewById(R.id.listview);

        list_Category = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot item : snapshot.getChildren()){
                    category = new Category();
                    category.setmImage(item.child("image").getValue().toString());
                    category.setmName(item.child("name").getValue().toString());
                    category.setmPrice(item.child("price").getValue().toString() + " VNĐ");

                    list_Category.add(category);
                }
                adapter = new Category_Adapter(Home.this,R.layout.item_shop,list_Category);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }) ;

    }
}