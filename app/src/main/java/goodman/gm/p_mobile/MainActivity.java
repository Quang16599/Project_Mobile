package goodman.gm.p_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {
        ImageView img;
        TextView txtHere,txtBack;
        Animation topAnim, bottomAnim;
        private static int SPLASH_SCREEN = 2000 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        img = findViewById(R.id.logoImage);
        txtHere = findViewById(R.id.texthere);
        txtBack = findViewById(R.id.textback);

        img.setAnimation(topAnim);
        txtHere.setAnimation(bottomAnim);
        txtBack.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, DangNhap.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img,"logo_image");
                pairs[1] = new Pair<View,String>(img,"logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);

                startActivity(intent,options.toBundle());

            }
        },SPLASH_SCREEN);

    }


}