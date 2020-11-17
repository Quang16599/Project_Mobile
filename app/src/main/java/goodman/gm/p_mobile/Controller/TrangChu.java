package goodman.gm.p_mobile.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import goodman.gm.p_mobile.Adapter.AdapterViewPagerTrangChu;
import goodman.gm.p_mobile.R;

public class TrangChu extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    ViewPager viewPagerTrangChu;
    RadioButton rdOdau, rdAnGi;
    RadioGroup rdGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        init();
        AdapterViewPagerTrangChu adapterViewPagerTrangChu =  new AdapterViewPagerTrangChu(getSupportFragmentManager());
        viewPagerTrangChu.setAdapter(adapterViewPagerTrangChu);
        viewPagerTrangChu.addOnPageChangeListener(this);
        rdGroup.setOnCheckedChangeListener(this);
    }

    private void init() {
        viewPagerTrangChu = (ViewPager) findViewById(R.id.viewPagerTrangChu);
        rdOdau = (RadioButton) findViewById(R.id.rdOdau);
        rdAnGi = (RadioButton) findViewById(R.id.rdAnGi);
        rdGroup = (RadioGroup) findViewById(R.id.rdGroup);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
// dung de chuyen nut o dau sang an gi
     switch (position){
         case 0:
             rdOdau.setChecked(true);
             break;
         case 1 :
             rdAnGi.setChecked(true);
             break;
     }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rdOdau:
                viewPagerTrangChu.setCurrentItem(0);
                break;
            case R.id.rdAnGi:
                viewPagerTrangChu.setCurrentItem(1);
                break;
        }
    }
}