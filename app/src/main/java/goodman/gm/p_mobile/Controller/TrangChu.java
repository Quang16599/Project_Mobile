package goodman.gm.p_mobile.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import goodman.gm.p_mobile.Adapter.AdapterViewPagerTrangChu;
import goodman.gm.p_mobile.Model.User;
import goodman.gm.p_mobile.R;

public class TrangChu extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    ViewPager viewPagerTrangChu;
    RadioButton rdOdau, rdAnGi;
    RadioGroup rdGroup;
    Button btnGanToi;
    ImageButton imbPerson;
    SliderLayout sliderLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        init();
        setSliderViews();

        controlButton();
        receiveData();
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.banner);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.banner2);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.banner3);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.banner4);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;

            sliderLayout.addSliderView(sliderView);
        }

    }


    private void receiveData() {
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("users");
    }

    private void controlButton() {
        imbPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChu.this, TrangCaNhan.class);
                startActivity(intent);
            }
        });
        btnGanToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChu.this, GanToi.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        viewPagerTrangChu = (ViewPager) findViewById(R.id.viewPagerTrangChu);
        rdOdau = (RadioButton) findViewById(R.id.rdOdau);
        rdAnGi = (RadioButton) findViewById(R.id.rdAnGi);
        rdGroup = (RadioGroup) findViewById(R.id.rdGroup);
        btnGanToi = findViewById(R.id.btnGanToi);
        imbPerson = findViewById(R.id.imageButtonPerson);

        AdapterViewPagerTrangChu adapterViewPagerTrangChu = new AdapterViewPagerTrangChu(getSupportFragmentManager());
        viewPagerTrangChu.setAdapter(adapterViewPagerTrangChu);
        viewPagerTrangChu.addOnPageChangeListener(this);
        rdGroup.setOnCheckedChangeListener(this);
        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
// dung de chuyen nut o dau sang an gi
        switch (position) {
            case 0:
                rdOdau.setChecked(true);
                break;
            case 1:
                rdAnGi.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rdOdau:
                viewPagerTrangChu.setCurrentItem(0);
                break;
            case R.id.rdAnGi:
                viewPagerTrangChu.setCurrentItem(1);
                break;
        }
    }
}