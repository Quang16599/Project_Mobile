package goodman.gm.p_mobile.Model;

public class BinhLuan {
    private String mChamDiem;
    private String mLuotThich;
    private String mNoiDung;
    private String mTieuDe;

    public BinhLuan(){

    }

    public BinhLuan(String mChamDiem, String mLuotThich, String mNoiDung, String mTieuDe) {
        this.mChamDiem = mChamDiem;
        this.mLuotThich = mLuotThich;
        this.mNoiDung = mNoiDung;
        this.mTieuDe = mTieuDe;
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
}
