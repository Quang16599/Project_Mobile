package goodman.gm.p_mobile.Model;

public class ChiTietGoiMon {
    private int mMaGoiMon;
    private int mMaMonAn;
    private int mSoLuong;

    public ChiTietGoiMon() {

    }
    
    public ChiTietGoiMon(int mMaGoiMon, int mMaMonAn, int mSoLuong) {
        this.mMaGoiMon = mMaGoiMon;
        this.mMaMonAn = mMaMonAn;
        this.mSoLuong = mSoLuong;
    }

    public int getmMaGoiMon() {
        return mMaGoiMon;
    }

    public void setmMaGoiMon(int mMaGoiMon) {
        this.mMaGoiMon = mMaGoiMon;
    }

    public int getmMaMonAn() {
        return mMaMonAn;
    }

    public void setmMaMonAn(int mMaMonAn) {
        this.mMaMonAn = mMaMonAn;
    }

    public int getmSoLuong() {
        return mSoLuong;
    }

    public void setmSoLuong(int mSoLuong) {
        this.mSoLuong = mSoLuong;
    }
}

