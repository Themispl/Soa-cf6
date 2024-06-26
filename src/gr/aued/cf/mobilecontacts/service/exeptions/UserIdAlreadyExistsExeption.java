package gr.aued.cf.mobilecontacts.service.exeptions;

import gr.aued.cf.mobilecontacts.model.MobileContact;

public class UserIdAlreadyExistsExeption extends Exception{
    private final static  long  serialVersionUID = 1L;
    public UserIdAlreadyExistsExeption(MobileContact mobileContact){
        super("Mobile Contact with id: "+ mobileContact.getId() + " already Exists");
    }
}
