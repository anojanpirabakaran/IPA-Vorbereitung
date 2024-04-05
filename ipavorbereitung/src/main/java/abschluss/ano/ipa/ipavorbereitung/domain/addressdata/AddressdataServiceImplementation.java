package abschluss.ano.ipa.ipavorbereitung.domain.addressdata;


import abschluss.ano.ipa.ipavorbereitung.config.error.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static abschluss.ano.ipa.ipavorbereitung.utils.Constants.NO_SUCH_ELEMENT_ERROR_MSG;

@Service
public class AddressdataServiceImplementation {

    private final AddressdataRepository addressdataRepository;

    @Autowired
    public AddressdataServiceImplementation(AddressdataRepository addressdataRepository) {
        this.addressdataRepository = addressdataRepository;
    }


    public Addressdata createAddressData(Addressdata addressdata) {
        return addressdataRepository.save(addressdata);
    }

    public Addressdata getAddressDataById(String uuid) {
        Optional<Addressdata> addressData = addressdataRepository.findById(uuid);

        if (addressData.isPresent()) {
            return addressData.get();
        } else {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, uuid));
        }
    }

    public List<Addressdata> getAllAddressData() {
        if (addressdataRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("No City found in the database");
        }
        return addressdataRepository.findAll();
    }

    public String deleteAddressDataById(String uuid) {
        if (!addressdataRepository.existsById(uuid)) {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, uuid));
        }
        addressdataRepository.deleteById(uuid);
        return String.format("Deleted City by id %s successfully", uuid);
    }

    public void deleteAllAddressData() {
        addressdataRepository.deleteAll();
    }

    public String updateAddressData(String id, Addressdata addressdata) throws Exception {
        if (addressdataRepository.existsById(id)) {
            addressdataRepository.findById(id)
                    .map(addressData1 -> {
                        addressData1.setStreetName(addressdata.getStreetName());
                        addressData1.setStreetNumber(addressdata.getStreetNumber());
                        addressData1.setCity(addressdata.getCity());
                        addressdataRepository.save(addressData1);
                        return "City updating";
                    }).orElseThrow(() -> new Exception("Addressdata not found - " + addressdata));
            return "Addressdata is updated";
        } else {
            throw new BadRequestException.BadRequestExceptions("Addressdata ID doesnt exists");
        }
    }
}
