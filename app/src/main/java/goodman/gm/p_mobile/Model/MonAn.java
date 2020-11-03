package goodman.gm.p_mobile.Model;

public class MonAn {
    private int mMaMonAn;
    private int mMaLoai;
    private String mTenMonAn;
    private String mGiaTien;
    private String mHinhAnh;

    public MonAn() {

    }

    public MonAn(int mMaMonAn, int mMaLoai, String mTenMonAn, String mGiaTien, String mHinhAnh) {
        this.mMaMonAn = mMaMonAn;
        this.mMaLoai = mMaLoai;
        this.mTenMonAn = mTenMonAn;
        this.mGiaTien = mGiaTien;
        this.mHinhAnh = mHinhAnh;
    }

    public int getmMaMonAn() {
        return mMaMonAn;
    }

    public void setmMaMonAn(int mMaMonAn) {
        this.mMaMonAn = mMaMonAn;
    }

    public int getmMaLoai() {
        return mMaLoai;
    }

    public void setmMaLoai(int mMaLoai) {
        this.mMaLoai = mMaLoai;
    }

    public String getmTenMonAn() {
        return mTenMonAn;
    }

    public void setmTenMonAn(String mTenMonAn) {
        this.mTenMonAn = mTenMonAn;
    }

    public String getmGiaTien() {
        return mGiaTien;
    }

    public void setmGiaTien(String mGiaTien) {
        this.mGiaTien = mGiaTien;
    }

    public String getmHinhAnh() {
        return mHinhAnh;
    }

    public void setmHinhAnh(String mHinhAnh) {
        this.mHinhAnh = mHinhAnh;
    }
}