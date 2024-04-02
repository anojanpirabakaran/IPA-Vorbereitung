package abschluss.ano.ipa.ipavorbereitung.domain.contactdata;

import abschluss.ano.ipa.ipavorbereitung.config.error.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static abschluss.ano.ipa.ipavorbereitung.utils.Constants.*;

@Service
public class ContactdataServiceImplementation {

    private final ContactdataRepository contactdataRepository;

    @Autowired
    public ContactdataServiceImplementation(ContactdataRepository contactdataRepository) {
        this.contactdataRepository = contactdataRepository;
    }

    public Contactdata createContactData(Contactdata contactdata) {
        if (contactdataRepository.existsByEmail(contactdata.getEmail())) {
            throw new BadRequestException.BadRequestExceptions(EMAIL_ALREADY_EXISTS_ERROR_MSG);
        }

        if (contactdataRepository.existsByPhoneNumber(contactdata.getPhoneNumber())) {
            throw new BadRequestException.BadRequestExceptions(PHONE_NUMBER_ALREADY_EXISTS_ERROR_MSG);
        }
        return contactdataRepository.save(contactdata);
    }

    public String updateContactData(String id, Contactdata contactdata) throws Exception {
        if (contactdataRepository.existsById(id)) {
            contactdataRepository.findById(id)
                    .map(contactdata1 -> {
                        contactdata1.setEmail(contactdata.getEmail());
                        contactdata1.setPhoneNumber(contactdata.getPhoneNumber());
                        if (contactdataRepository.existsByEmail(contactdata.getEmail())) {
                            throw new BadRequestException.BadRequestExceptions(EMAIL_ALREADY_EXISTS_ERROR_MSG);
                        } else if (contactdataRepository.existsByPhoneNumber(contactdata.getPhoneNumber())) {
                            throw new BadRequestException.BadRequestExceptions(PHONE_NUMBER_ALREADY_EXISTS_ERROR_MSG);
                        } else {
                            contactdataRepository.save(contactdata);
                        }

                        return CONTACT_DATA_UPDATING;
                    }).orElseThrow(() -> new Exception(CONTACT_DATA_NOT_FOUND_MSG));
            return CONTACT_DATA_UPDATING;
        } else {
            throw new BadRequestException.BadRequestExceptions(NO_SUCH_ELEMENT_ERROR_MSG);
        }
    }


    public Contactdata getContactDataById(String uuid) {
        Optional<Contactdata> contactdata = contactdataRepository.findById(uuid);

        if (contactdata.isPresent()) {
            return contactdata.get();
        } else {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, uuid));
        }
    }


    public List<Contactdata> getAllContactDatas() {
        if (contactdataRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("No Contact Data found in the database");
        }
        return contactdataRepository.findAll();
    }

    public String deleteContactDataById(String uuid) {
        if (!contactdataRepository.existsById(uuid)) {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, uuid));
        }
        contactdataRepository.deleteById(uuid);
        return String.format("Deleted Contact Data by id %s successfully", uuid);
    }

    public void deleteAllCities() {
        contactdataRepository.deleteAll();
    }

}
