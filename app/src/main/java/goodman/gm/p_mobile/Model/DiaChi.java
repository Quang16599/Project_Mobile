package goodman.gm.p_mobile.Model;

import java.util.List;

public class DiaChi  {
    private String mDiaChi;
    private double mLatitue;
    private double mLongitue;
    private double mKhoangCach;

    public DiaChi(){

    }

    public DiaChi(String mDiaChi, double mLatitue, double mLongitue, double mKhoangCach) {
        this.mDiaChi = mDiaChi;
        this.mLatitue = mLatitue;
        this.mLongitue = mLongitue;
        this.mKhoangCach = mKhoangCach;
    }

    public String getmDiaChi() {
        return mDiaChi;
    }

    public void setmDiaChi(String mDiaChi) {
        this.mDiaChi = mDiaChi;
    }

    public double getmLatitue() {
        return mLatitue;
    }

    public void setmLatitue(double mLatitue) {
        this.mLatitue = mLatitue;
    }

    public double getmLongitue() {
        return mLongitue;
    }

    public void setmLongitue(double mLongitue) {
        this.mLongitue = mLongitue;
    }

    public double getmKhoangCach() {
        return mKhoangCach;
    }

    public void setmKhoangCach(double mKhoangCach) {
        this.mKhoangCach = mKhoangCach;
    }
}
