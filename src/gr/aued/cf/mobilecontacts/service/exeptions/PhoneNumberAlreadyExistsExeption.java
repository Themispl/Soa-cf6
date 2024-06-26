package gr.aued.cf.mobilecontacts.service.exeptions;

import gr.aued.cf.mobilecontacts.model.MobileContact;

public class PhoneNumberAlreadyExistsExeption  extends Exception{
    private final static  long  serialVersionUID = 1L;

    public PhoneNumberAlreadyExistsExeption(MobileContact mobileContact){
        super("Mobile contact with number: "+ mobileContact.getPhoneNumber()+ " already exists!");
    }
}
