package gr.aued.cf.mobilecontacts.model;

import java.util.Objects;

public class MobileContact extends AbstractEntity implements IdentifiableEntity{

   private UserDitails userDetails;
   public String phoneNumber;

   public MobileContact(){

   }


    public MobileContact(UserDitails userDetails, String phoneNumber) {
        this.userDetails = new UserDitails(userDetails);
        this.phoneNumber = phoneNumber;
    }

    public UserDitails getUserDetails() {
        return new UserDitails(userDetails);
    }

    public void setUserDetails(UserDitails userDetails) {
        this.userDetails= new UserDitails(userDetails);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MobileContact{" +
                "userDetails=" + userDetails +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileContact that = (MobileContact) o;

        if (getUserDetails() != null ? !getUserDetails().equals(that.getUserDetails()) : that.getUserDetails() != null)
            return false;
        return getPhoneNumber() != null ? getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserDetails() != null ? getUserDetails().hashCode() : 0;
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return result;
    }
}
