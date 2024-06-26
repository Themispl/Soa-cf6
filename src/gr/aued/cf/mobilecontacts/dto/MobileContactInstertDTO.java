package gr.aued.cf.mobilecontacts.dto;

import gr.aued.cf.mobilecontacts.model.UserDitails;

public class MobileContactInstertDTO extends BaseDTO{
    private UserDitailsInsertDTO userDetailsInsertDTO;
    private String phoneNumber;
    public MobileContactInstertDTO(){}

    public MobileContactInstertDTO(long id,UserDitailsInsertDTO userDetailsInsertDTO, String phoneNumber) {
        this.setId(id);
        this.userDetailsInsertDTO = userDetailsInsertDTO;
        this.phoneNumber = phoneNumber;
    }

    public UserDitailsInsertDTO getUserDetailsInsertDTO() {
        return userDetailsInsertDTO;
    }

    public void setUserDetailsInsertDTO(UserDitailsInsertDTO userDetailsInsertDTO) {
        this.userDetailsInsertDTO = userDetailsInsertDTO;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
