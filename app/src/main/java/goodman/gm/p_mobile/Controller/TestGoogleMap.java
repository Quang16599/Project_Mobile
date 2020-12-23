package goodman.gm.p_mobile.Controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import goodman.gm.p_mobile.R;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class TestGoogleMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_google_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map =googleMap;
        LatLng vietNam = new LatLng(10.868392430411005, 106.78938483415821);
        map.addMarker(new MarkerOptions().position(vietNam).title("Nong Lam"));
        map.moveCamera(CameraUpdateFactory.newLatLng(vietNam));

    }
}