package gr.aued.cf.mobilecontacts.model;

import java.util.Objects;

public class UserDitails extends AbstractEntity implements IdentifiableEntity{
    private String firstname;
    private String lastname;

    public UserDitails(){

    }

    public UserDitails(long id,String firstname, String lastname) {
        setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public UserDitails(UserDitails userDitails){
        this.firstname = userDitails.getFirstname();
        this.lastname = userDitails.getLastname();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "UserDitails{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDitails that)) return false;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }
}
