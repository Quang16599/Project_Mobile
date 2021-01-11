package goodman.gm.p_mobile.Model;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.List;

public class BinhLuan {
    private String mChamDiem;
    private String mLuotThich;
    private String mNoiDung;
    private String mTieuDe;
    private String manbinhluan;
    private String tenuser;
    List<String> hinhanhBinhLuanList;


    public BinhLuan() {

    }

    public BinhLuan(String mChamDiem, String mLuotThich, String mNoiDung, String mTieuDe) {
        this.mChamDiem = mChamDiem;
        this.mLuotThich = mLuotThich;
        this.mNoiDung = mNoiDung;
        this.mTieuDe = mTieuDe;
    }
    public String getTenuser() {
        return tenuser;
    }

    public void setTenuser(String tenuser) {
        this.tenuser = tenuser;
    }


    public List<String> getHinhanhBinhLuanList() {
        return hinhanhBinhLuanList;
    }

    public void setHinhanhBinhLuanList(List<String> hinhanhList) {
        this.hinhanhBinhLuanList = hinhanhList;
    }

    public String getManbinhluan() {
        return manbinhluan;
    }

    public void setManbinhluan(String manbinhluan) {
        this.manbinhluan = manbinhluan;
    }


    public String getmChamDiem() {
        return mChamDiem;
    }

    public void setmChamDiem(String mChamDiem) {
        this.mChamDiem = mChamDiem;
    }

    public String getmLuotThich() {
        return mLuotThich;
    }

    public void setmLuotThich(String mLuotThich) {
        this.mLuotThich = mLuotThich;
    }

    public String getmNoiDung() {
        return mNoiDung;
    }

    public void setmNoiDung(String mNoiDung) {
        this.mNoiDung = mNoiDung;
    }

    public String getmTieuDe() {
        return mTieuDe;
    }

    public void setmTieuDe(String mTieuDe) {
        this.mTieuDe = mTieuDe;
    }

//    public void ThemBinhLuan(String maQuanAn, BinhLuan binhLuanModel, final List<String> listHinh) {
//        DatabaseReference nodeBinhLuan = FirebaseDatabase.getInstance().getReference().child("binhluans");
//        String mabinhluan = nodeBinhLuan.child(maQuanAn).push().getKey();
//
//        nodeBinhLuan.child(maQuanAn).child(mabinhluan).setValue(binhLuanModel).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    if (listHinh.size() > 0) {
//                        for (String valueHinh : listHinh) {
//                            Uri uri = Uri.fromFile(new File(valueHinh));
//                            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("hinhanh/" + uri.getLastPathSegment());
//                            storageReference.putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
//
//                                }
//                            });
//                        }
//                    }
//
//                }
//            }
//        });
//
//
//        if (listHinh.size() > 0) {
//            for (String valueHinh : listHinh) {
//                Uri uri = Uri.fromFile(new File(valueHinh));
//                FirebaseDatabase.getInstance().getReference().child("hinhanhbinhluans").child(mabinhluan).push().setValue(uri.getLastPathSegment());
//            }
//        }
//
//
//    }
}
