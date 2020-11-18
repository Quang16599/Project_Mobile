package goodman.gm.p_mobile.Model;

import java.util.List;

public class QuanAn {

    private boolean mGiaoHang;
    private String mGioDongCua;
    private String mGioMoCua;
    private String mHinhAnh;
    private String mTenQuanAn;
    private String mDiaChiQuan;



    public QuanAn(){

    }

    public QuanAn(boolean mGiaoHang, String mGioDongCua, String mGioMoCua, String mHinhAnh, String mTenQuanAn, String mDiaChiQuan) {
        this.mGiaoHang = mGiaoHang;
        this.mGioDongCua = mGioDongCua;
        this.mGioMoCua = mGioMoCua;
        this.mHinhAnh = mHinhAnh;
        this.mTenQuanAn = mTenQuanAn;
        this.mDiaChiQuan = mDiaChiQuan;
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

    public String getmHinhAnh() {
        return mHinhAnh;
    }

    public void setmHinhAnh(String mHinhAnh) {
        this.mHinhAnh = mHinhAnh;
    }

    public String getmTenQuanAn() {
        return mTenQuanAn;
    }

    public void setmTenQuanAn(String mTenQuanAn) {
        this.mTenQuanAn = mTenQuanAn;
    }

    public String getmDiaChiQuan() {
        return mDiaChiQuan;
    }

    public void setmDiaChiQuan(String mDiaChiQuan) {
        this.mDiaChiQuan = mDiaChiQuan;
    }
}
