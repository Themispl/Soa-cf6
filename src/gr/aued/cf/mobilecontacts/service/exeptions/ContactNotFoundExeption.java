package gr.aued.cf.mobilecontacts.service.exeptions;

import gr.aued.cf.mobilecontacts.model.MobileContact;

public class ContactNotFoundExeption extends Exception{
    private final static  long  serialVersionUID = 1L;

    public ContactNotFoundExeption(String phoneNumber){
        super("The contact with phone number: "+ phoneNumber + " not found");
    }

    public ContactNotFoundExeption(long id){
        super("The contact with phone id: "+ id + " not found");
    }

    public ContactNotFoundExeption(MobileContact mobileContact){
        super("The contact with phone number: "+ mobileContact.getId() + " not found" + " with number "+ mobileContact.getPhoneNumber());
    }
}
