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
        if (!(o instanceof MobileContact that)) return false;
        return Objects.equals(userDetails, that.userDetails) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDetails, phoneNumber);
    }
}
