package gr.aued.cf.mobilecontacts.service;

import gr.aued.cf.mobilecontacts.dto.MobileContactInstertDTO;
import gr.aued.cf.mobilecontacts.dto.MobileContactUpdateDTO;
import gr.aued.cf.mobilecontacts.model.MobileContact;
import gr.aued.cf.mobilecontacts.service.exeptions.ContactNotFoundExeption;
import gr.aued.cf.mobilecontacts.service.exeptions.PhoneNumberAlreadyExistsExeption;
import gr.aued.cf.mobilecontacts.service.exeptions.UserIdAlreadyExistsExeption;

import java.util.ConcurrentModificationException;
import java.util.List;

public interface IMobileContactService {
    MobileContact insertMobileContact(MobileContactInstertDTO dto) throws PhoneNumberAlreadyExistsExeption, UserIdAlreadyExistsExeption;

    MobileContact updateMobileContact(long id, MobileContactUpdateDTO dto)
            throws PhoneNumberAlreadyExistsExeption, UserIdAlreadyExistsExeption, ConcurrentModificationException;

    void  deleteMobileContactById(long id) throws ContactNotFoundExeption;
    void  deleteMobileContactByPhoneNumber(String phoneNumber) throws  ContactNotFoundExeption;

    MobileContact getMobileContactById(long id) throws ContactNotFoundExeption;
    MobileContact getMobileContactByPhoneNumber() throws ContactNotFoundExeption;
    List<MobileContact> getAllMobileContacts();



}
