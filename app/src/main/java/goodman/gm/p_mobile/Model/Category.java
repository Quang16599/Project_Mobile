package goodman.gm.p_mobile.Model;

public class Category {
    private String mImage;
    private String mName;
    private String mPrice;


    public Category() {

    }

    public Category( String mImage, String mName, String mPrice) {
        this.mImage = mImage;
        this.mName = mName;
        this.mPrice = mPrice;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    @Override
    public String toString() {
        return "Category{" +
                "mImage=" + mImage +
                ", mName='" + mName + '\'' +
                ", mPrice='" + mPrice + '\'' +
                '}';
    }
}
