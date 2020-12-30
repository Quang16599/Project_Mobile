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

import goodman.gm.p_mobile.Adapter.Blog_Adapter;
import goodman.gm.p_mobile.Model.Blog;
import goodman.gm.p_mobile.Model.QuanAn;
import goodman.gm.p_mobile.R;

public class Blogs extends AppCompatActivity {
    ListView listView;
    Blog_Adapter adapter;
    List<Blog> lstBlog;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("blogs");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);
        init();
        loadData();
    }

    private void loadData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot value : snapshot.getChildren()) {

                    Blog blog = new Blog();

                    blog.setmHinhAnh(value.child("mHinhAnh").getValue().toString());
                    blog.setmNgayCapNhat(value.child("mNgayCapNhat").getValue().toString());
                    blog.setmNoiDung(value.child("mNoiDung").getValue().toString());
                    blog.setmPoint(Double.valueOf(value.child("mPoint").getValue().toString()));
                    blog.setmTieuDe(value.child("mTieuDe").getValue().toString());
                    blog.setmTenQuan(value.child("mTenQuan").getValue().toString());
                    lstBlog.add(blog);
//                    Log.e("abc", blog.toString());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void init() {
        lstBlog = new ArrayList<>();
        listView = findViewById(R.id.lstBlog);
        adapter = new Blog_Adapter(Blogs.this, R.layout.custom_blog, lstBlog);


    }
}