package goodman.gm.p_mobile.Model;

public class BanAn {
    private int mMaBan;
    private String mTenBan;
    private String mTinhTrang;

    public BanAn(){

    }

    public BanAn(int mMaBan, String mTenBan, String mTinhTrang) {
        this.mMaBan = mMaBan;
        this.mTenBan = mTenBan;
        this.mTinhTrang = mTinhTrang;
    }

    public int getmMaBan() {
        return mMaBan;
    }

    public void setmMaBan(int mMaBan) {
        this.mMaBan = mMaBan;
    }

    public String getmTenBan() {
        return mTenBan;
    }

    public void setmTenBan(String mTenBan) {
        this.mTenBan = mTenBan;
    }

    public String getmTinhTrang() {
        return mTinhTrang;
    }

    public void setmTinhTrang(String mTinhTrang) {
        this.mTinhTrang = mTinhTrang;
    }
}
