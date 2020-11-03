package goodman.gm.p_mobile.Model;

public class NhanVien {
    private int mMaNV;
    private String mTenNV;
    private String mMatKhau;
    private String mGioiTinh;
    private String mNgaySinh;
    private int mCMND;


    public NhanVien(){

    }

    public NhanVien(int mMaNV, String mTenNV, String mMatKhau, String mGioiTinh, String mNgaySinh, int mCMND) {
        this.mMaNV = mMaNV;
        this.mTenNV = mTenNV;
        this.mMatKhau = mMatKhau;
        this.mGioiTinh = mGioiTinh;
        this.mNgaySinh = mNgaySinh;
        this.mCMND = mCMND;
    }

    public int getmMaNV() {
        return mMaNV;
    }

    public void setmMaNV(int mMaNV) {
        this.mMaNV = mMaNV;
    }

    public String getmTenNV() {
        return mTenNV;
    }

    public void setmTenNV(String mTenNV) {
        this.mTenNV = mTenNV;
    }

    public String getmMatKhau() {
        return mMatKhau;
    }

    public void setmMatKhau(String mMatKhau) {
        this.mMatKhau = mMatKhau;
    }

    public String getmGioiTinh() {
        return mGioiTinh;
    }

    public void setmGioiTinh(String mGioiTinh) {
        this.mGioiTinh = mGioiTinh;
    }

    public String getmNgaySinh() {
        return mNgaySinh;
    }

    public void setmNgaySinh(String mNgaySinh) {
        this.mNgaySinh = mNgaySinh;
    }

    public int getmCMND() {
        return mCMND;
    }

    public void setmCMND(int mCMND) {
        this.mCMND = mCMND;
    }
}
