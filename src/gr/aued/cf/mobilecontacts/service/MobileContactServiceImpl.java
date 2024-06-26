package gr.aued.cf.mobilecontacts.service;

import gr.aued.cf.mobilecontacts.dao.IMobileContactDAO;
import gr.aued.cf.mobilecontacts.dto.MobileContactInstertDTO;
import gr.aued.cf.mobilecontacts.dto.MobileContactUpdateDTO;
import gr.aued.cf.mobilecontacts.dto.UserDetailsUpdateDTO;
import gr.aued.cf.mobilecontacts.dto.UserDitailsInsertDTO;
import gr.aued.cf.mobilecontacts.model.MobileContact;
import gr.aued.cf.mobilecontacts.model.UserDitails;
import gr.aued.cf.mobilecontacts.service.exeptions.ContactNotFoundExeption;
import gr.aued.cf.mobilecontacts.service.exeptions.PhoneNumberAlreadyExistsExeption;
import gr.aued.cf.mobilecontacts.service.exeptions.UserIdAlreadyExistsExeption;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;

public class MobileContactServiceImpl  implements IMobileContactService{
    private  final IMobileContactDAO dao;

    public MobileContactServiceImpl(IMobileContactDAO dao){
        this.dao = dao;

    }
    @Override
    public MobileContact insertMobileContact(MobileContactInstertDTO dto) throws PhoneNumberAlreadyExistsExeption, UserIdAlreadyExistsExeption {
        MobileContact mobileContact;
        try{
            mobileContact =  mapFormMobileContactInsertDTO(dto);

            if(dao.phoneNumberExists(mobileContact.getPhoneNumber())){
                throw new PhoneNumberAlreadyExistsExeption(mobileContact);
            }

            if (dao.userIdExists(mobileContact.getId())){
                throw new UserIdAlreadyExistsExeption(mobileContact);
            }
            return dao.insert(mobileContact);

        }catch (PhoneNumberAlreadyExistsExeption | UserIdAlreadyExistsExeption e){
            e.printStackTrace();
            throw  e;
        }
    }
    private MobileContact mapFormMobileContactInsertDTO(MobileContactInstertDTO dto){
        return new MobileContact(dto.getId(), mapUserdetailsFromInsertDTO(dto.getUserDetailsInsertDTO()), dto.getPhoneNumber());
    }
    private UserDitails mapUserdetailsFromInsertDTO(UserDitailsInsertDTO dto){
        return new UserDitails(dto.getId(), dto.getFirstname(), dto.getLastname());
    }
    private MobileContact mapFormMobileContactUpdateDTO(MobileContactUpdateDTO dto){
        return new MobileContact(dto.getId(), mapUserdetailsFromUpdateDTO(dto.getUserDetailsUpdateDTO()), dto.getPhoneNumber());
    }
    private UserDitails mapUserdetailsFromUpdateDTO(UserDetailsUpdateDTO dto){
        return new UserDitails(dto.getId(), dto.getFirstname(), dto.getLastname());
    }

    @Override
    public MobileContact updateMobileContact(long id, MobileContactUpdateDTO newdto)
            throws PhoneNumberAlreadyExistsExeption, UserIdAlreadyExistsExeption, ConcurrentModificationException {
        MobileContact mobileContact;
        try{
            mobileContact =  mapFormMobileContactUpdateDTO(newdto);

            if (!dao.userIdExists(id)) {

                throw new ContactNotFoundExeption(id);
            }

            MobileContact oldcontacr =dao.get(id);
            if(dao.phoneNumberExists(mobileContact.getPhoneNumber()) && (!oldcontacr.getPhoneNumber().equals(newdto.getPhoneNumber()))){
                throw new PhoneNumberAlreadyExistsExeption(mobileContact);
            }

            if (dao.userIdExists(mobileContact.getId()) && (oldcontacr.getId() != (newdto.getId()))){
                throw new UserIdAlreadyExistsExeption(mobileContact);
            }
            return dao.update(id,mobileContact);

        }catch (PhoneNumberAlreadyExistsExeption | UserIdAlreadyExistsExeption e){
            e.printStackTrace();
            throw  e;
        } catch (ContactNotFoundExeption e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteMobileContactById(long id) throws ContactNotFoundExeption {
        try {
            if (!dao.userIdExists(id)) {

                throw new ContactNotFoundExeption(id);
            }
            dao.delete(id);
        }catch (ContactNotFoundExeption e){
            throw e;
        }
    }

    @Override
    public void deleteMobileContactByPhoneNumber(String phoneNumber) throws ContactNotFoundExeption {
        try {
            if (!dao.phoneNumberExists(phoneNumber)) {

                throw new ContactNotFoundExeption(phoneNumber);
            }
            dao.delete(Long.parseLong(phoneNumber));
        }catch (ContactNotFoundExeption e){
            throw e;
        }
    }

    @Override
    public MobileContact getMobileContactById(long id) throws ContactNotFoundExeption {
        MobileContact mobileContact;
        try {
            mobileContact = dao.get(id);
            if (mobileContact == null){
                throw new ContactNotFoundExeption(id);
            }
            return mobileContact;

        }catch (ContactNotFoundExeption e){
            throw e;
        }
    }

    @Override
    public MobileContact getMobileContactByPhoneNumber(String phoneNumber) throws ContactNotFoundExeption {
        MobileContact mobileContact;
        try {
            mobileContact = dao.get(phoneNumber);
            if (mobileContact == null){
                throw new ContactNotFoundExeption(phoneNumber);
            }
            return mobileContact;

        }catch (ContactNotFoundExeption e){
            throw e;
        }
    }

    @Override
    public List<MobileContact> getAllMobileContacts() {
        return dao.getAll(); //Collections.unmodifiableList(dao.getAll());
    }
}
