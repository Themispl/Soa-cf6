package gr.aued.cf.mobilecontacts.service;

import gr.aued.cf.mobilecontacts.dto.MobileContactInstertDTO;
import gr.aued.cf.mobilecontacts.model.MobileContact;

public interface IMobileContactService {
    MobileContact insertMobileContact(MobileContactInstertDTO dto);
}
