package goodman.gm.p_mobile.Model;

public class GoiMon {
    private int mMaGoiMon;
    private int mMaBan;
    private int mMaNV;
    private String mTinhTrang;
    private String mNgayGoi;

    public GoiMon() {

    }

    public GoiMon(int mMaGoiMon, int mMaBan, int mMaNV, String mTinhTrang, String mNgayGoi) {
        this.mMaGoiMon = mMaGoiMon;
        this.mMaBan = mMaBan;
        this.mMaNV = mMaNV;
        this.mTinhTrang = mTinhTrang;
        this.mNgayGoi = mNgayGoi;
    }

    public int getmMaGoiMon() {
        return mMaGoiMon;
    }

    public void setmMaGoiMon(int mMaGoiMon) {
        this.mMaGoiMon = mMaGoiMon;
    }

    public int getmMaBan() {
        return mMaBan;
    }

    public void setmMaBan(int mMaBan) {
        this.mMaBan = mMaBan;
    }

    public int getmMaNV() {
        return mMaNV;
    }

    public void setmMaNV(int mMaNV) {
        this.mMaNV = mMaNV;
    }

    public String getmTinhTrang() {
        return mTinhTrang;
    }

    public void setmTinhTrang(String mTinhTrang) {
        this.mTinhTrang = mTinhTrang;
    }

    public String getmNgayGoi() {
        return mNgayGoi;
    }

    public void setmNgayGoi(String mNgayGoi) {
        this.mNgayGoi = mNgayGoi;
    }
}
