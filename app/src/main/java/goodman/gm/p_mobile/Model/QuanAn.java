package goodman.gm.p_mobile.Model;


import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import goodman.gm.p_mobile.Interface.ODauInterface;

public class QuanAn {
    private String mMaQuanAn;
    private boolean mGiaoHang;
    private String mGioDongCua;
    private String mGioMoCua;
    private long mLuotThich;
    private String mTenQuanAn;
    private List<String> mTienIch;
    private String mVideoGioiThieu;
    private List<String> mHinhAnhQuanAn;

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    public QuanAn() {
    }

    public QuanAn(String mMaQuanAn, boolean mGiaoHang, String mGioDongCua, String mGioMoCua, long mLuotThich, String mTenQuanAn, List<String> mTienIch, String mVideoGioiThieu, List<String> mHinhAnhQuanAn) {
        this.mMaQuanAn = mMaQuanAn;
        this.mGiaoHang = mGiaoHang;
        this.mGioDongCua = mGioDongCua;
        this.mGioMoCua = mGioMoCua;
        this.mLuotThich = mLuotThich;
        this.mTenQuanAn = mTenQuanAn;
        this.mTienIch = mTienIch;
        this.mVideoGioiThieu = mVideoGioiThieu;
        this.mHinhAnhQuanAn = mHinhAnhQuanAn;
    }

    public String getmMaQuanAn() {
        return mMaQuanAn;
    }

    public void setmMaQuanAn(String mMaQuanAn) {
        this.mMaQuanAn = mMaQuanAn;
    }

    public boolean ismGiaoHang() {
        return mGiaoHang;
    }

    public void setmGiaoHang(boolean mGiaoHang) {
        this.mGiaoHang = mGiaoHang;
    }

    public String getmGioDongCua() {
        return mGioDongCua;
    }

    public void setmGioDongCua(String mGioDongCua) {
        this.mGioDongCua = mGioDongCua;
    }

    public String getmGioMoCua() {
        return mGioMoCua;
    }

    public void setmGioMoCua(String mGioMoCua) {
        this.mGioMoCua = mGioMoCua;
    }

    public long getmLuotThich() {
        return mLuotThich;
    }

    public void setmLuotThich(long mLuotThich) {
        this.mLuotThich = mLuotThich;
    }

    public String getmTenQuanAn() {
        return mTenQuanAn;
    }

    public void setmTenQuanAn(String mTenQuanAn) {
        this.mTenQuanAn = mTenQuanAn;
    }

    public List<String> getmTienIch() {
        return mTienIch;
    }

    public void setmTienIch(List<String> mTienIch) {
        this.mTienIch = mTienIch;
    }

    public String getmVideoGioiThieu() {
        return mVideoGioiThieu;
    }

    public void setmVideoGioiThieu(String mVideoGioiThieu) {
        this.mVideoGioiThieu = mVideoGioiThieu;
    }

    public List<String> getmHinhAnhQuanAn() {
        return mHinhAnhQuanAn;
    }

    public void setmHinhAnhQuanAn(List<String> mHinhAnhQuanAn) {
        this.mHinhAnhQuanAn = mHinhAnhQuanAn;
    }

    public void getDanhSachQuanAn(final ODauInterface oDauInterface){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot dataSnapshotQuanAn = snapshot.child("quanans");

                for (DataSnapshot valueQuanAn:dataSnapshotQuanAn.getChildren()){
                    QuanAn quanAn = new QuanAn();
                    quanAn.setmMaQuanAn(valueQuanAn.child("maquanan").getKey().toString());
                    quanAn.setmGiaoHang((Boolean) valueQuanAn.child("giaohang").getValue());
                    quanAn.setmGioDongCua(valueQuanAn.child("giodongcua").getValue().toString());
                    quanAn.setmGioMoCua(valueQuanAn.child("giomocua").getValue().toString());
                    quanAn.setmTenQuanAn(valueQuanAn.child("tenquanan").getValue().toString());

                    DataSnapshot dataSnapshotHinhQuanAn = snapshot.child("hinhanhquanans").child(valueQuanAn.getKey());

                    List<String> list_HinhAnh = new ArrayList<>();

                    for (DataSnapshot valueHinhAnh : dataSnapshotHinhQuanAn.getChildren()){
                        list_HinhAnh.add(valueHinhAnh.getValue(String.class));
                    }

                    quanAn.setmHinhAnhQuanAn(list_HinhAnh);
                    oDauInterface.getDanhSachQuanAn(quanAn);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }) ;
    }
}
