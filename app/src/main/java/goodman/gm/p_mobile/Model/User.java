package goodman.gm.p_mobile.Model;

import java.io.Serializable;

public class User implements Serializable {
   public String mFullName;
   public String mUserName;
   public String mPassword;
   public String mEmail;
   public String mPhoneNumber;

    public User(){

    }

    public User(String mFullName, String mUserName, String mPassword, String mEmail, String mPhoneNumber) {
        this.mFullName = mFullName;
        this.mUserName = mUserName;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }
}
