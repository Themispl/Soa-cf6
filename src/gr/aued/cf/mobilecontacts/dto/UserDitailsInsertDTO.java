package gr.aued.cf.mobilecontacts.dto;

public class UserDitailsInsertDTO  extends BaseDTO{
    private String firstname;
    private String lastname;
    public  UserDitailsInsertDTO(){}

    public UserDitailsInsertDTO(long id,String firstname, String lastname) {
        this.setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
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
}
