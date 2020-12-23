package goodman.gm.p_mobile.Controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import goodman.gm.p_mobile.R;
import androidx.fragment.app.FragmentManager;


public class TestGoogleMap extends AppCompatActivity {

    private MyMapFragment myMapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_google_map);

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        this.myMapFragment = (MyMapFragment) fragmentManager.findFragmentById(R.id.googleMap);

    }
}