package goodman.gm.p_mobile.Model;

public class LoaiMon {
    private int mMaLoai;
    private String mTenLoai;
    private String mHinhAnh;

    public LoaiMon(){

    }

    public LoaiMon(int mMaLoai, String mTenLoai, String mHinhAnh) {
        this.mMaLoai = mMaLoai;
        this.mTenLoai = mTenLoai;
        this.mHinhAnh = mHinhAnh;
    }

    public int getmMaLoai() {
        return mMaLoai;
    }

    public void setmMaLoai(int mMaLoai) {
        this.mMaLoai = mMaLoai;
    }

    public String getmTenLoai() {
        return mTenLoai;
    }

    public void setmTenLoai(String mTenLoai) {
        this.mTenLoai = mTenLoai;
    }

    public String getmHinhAnh() {
        return mHinhAnh;
    }

    public void setmHinhAnh(String mHinhAnh) {
        this.mHinhAnh = mHinhAnh;
    }
}
