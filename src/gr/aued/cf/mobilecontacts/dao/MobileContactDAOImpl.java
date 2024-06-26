package gr.aued.cf.mobilecontacts.dao;

import gr.aued.cf.mobilecontacts.model.MobileContact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MobileContactDAOImpl  implements IMobileContactDAO{

    private final  static List<MobileContact> contacts = new ArrayList<>();
    @Override
    public MobileContact insert(MobileContact mobileContact) {
        contacts.add(mobileContact);
        return  mobileContact;
    }

    @Override
    public MobileContact update(long id, MobileContact mobileContact) {
        Optional<MobileContact> optionalMobileContact = contacts
                .stream()
                .filter(mb -> mb.getId() == id)
                .findFirst();
        MobileContact mb = optionalMobileContact.orElse(null);
        if(mb == null) return null;

        MobileContact mobileContactToReturn = new MobileContact(mb);
        mb.setId(mobileContact.getId());
        mb.setUserDetails(mobileContact.getUserDetails());
        mb.setPhoneNumber(mobileContact.getPhoneNumber());
        return mobileContactToReturn;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public MobileContact get(long id) {
        return null;
    }

    @Override
    public List<MobileContact> getAll() {
        return null;
    }

    @Override
    public MobileContact get(String phoneNumber) {
        return null;
    }

    @Override
    public boolean phoneNumberExists(String phoneNumber) {
        return false;
    }

    @Override
    public boolean userIdExists(long id) {
        return false;
    }
}
