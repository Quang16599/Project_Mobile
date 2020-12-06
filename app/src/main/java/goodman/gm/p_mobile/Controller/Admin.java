package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class Admin extends AppCompatActivity {
    ImageButton imgBack, imgUser,imgFood,imgNear,imgCom;

    DrawerLayout drawerLayout ;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        init();
        controlButton();
    }

    private void controlButton() {

        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this, AdminUser.class);
                startActivity(intent);
            }
        });
        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this, AdminFood.class);
                startActivity(intent);
            }
        });
        imgNear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this, AdminNear.class);
                startActivity(intent);
            }
        });
        imgCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this, AdminComment.class);
                startActivity(intent);
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this, TrangChu.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        imgBack = findViewById(R.id.imgBack);
        imgUser = findViewById(R.id.imgUser);
        imgFood = findViewById(R.id.imgFood);
        imgNear = findViewById(R.id.imgNear);
        imgCom = findViewById(R.id.imgComment);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
    }
}