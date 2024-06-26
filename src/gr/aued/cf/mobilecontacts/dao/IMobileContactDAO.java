package gr.aued.cf.mobilecontacts.dao;

import gr.aued.cf.mobilecontacts.model.MobileContact;

import java.util.List;

public interface IMobileContactDAO {
    MobileContact insert(MobileContact mobileContact);
    MobileContact update(long id, MobileContact mobileContact);
    void delete(long id);

    MobileContact get(long id);

    List<MobileContact> getAll();

    MobileContact get(String phoneNumber);
     boolean phoneNumberExists(String phoneNumber);
     boolean userIdExists(long id);

}


