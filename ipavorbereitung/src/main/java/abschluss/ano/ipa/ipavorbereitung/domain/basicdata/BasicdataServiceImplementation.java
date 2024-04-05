package abschluss.ano.ipa.ipavorbereitung.domain.basicdata;

import abschluss.ano.ipa.ipavorbereitung.config.error.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static abschluss.ano.ipa.ipavorbereitung.utils.Constants.*;

@Service
public class BasicdataServiceImplementation {

    private final BasicdataRepository basicdataRepository;

    @Autowired
    public BasicdataServiceImplementation(BasicdataRepository basicdataRepository) {
        this.basicdataRepository = basicdataRepository;
    }

    public Basicdata createBasicData(Basicdata basicdata) {
        if (basicdataRepository.existsByFirstName(basicdata.getFirstName()) && basicdataRepository.existsByLastName(basicdata.getLastName()) && basicdataRepository.existsByDateOfBirth(basicdata.getDateOfBirth())) {
            throw new BadRequestException.BadRequestExceptions(BASIC_DATA_CANNOT_BE_CREATED);
        }
        return basicdataRepository.save(basicdata);
    }

    public Basicdata getBasicDataById(String uuid) {
        Optional<Basicdata> basicdata = basicdataRepository.findById(uuid);

        if (basicdata.isPresent()) {
            return basicdata.get();
        } else {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, uuid));
        }
    }

    public List<Basicdata> getAllBasicData() {
        if (basicdataRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("No Basicdata found in the database");
        }
        return basicdataRepository.findAll();
    }

    public String deleteBasicDataById(String uuid) {
        if (!basicdataRepository.existsById(uuid)) {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, uuid));
        }
        basicdataRepository.deleteById(uuid);
        return String.format("Deleted City by id %s successfully", uuid);
    }

    public void deleteAllBasicData() {
        basicdataRepository.deleteAll();
    }

    public String updateBasicData(String id, Basicdata basicdata) throws Exception {
        if (basicdataRepository.existsById(id)) {
            basicdataRepository.findById(id)
                    .map(basicdata1 -> {
                        if (basicdataRepository.existsByFirstName(basicdata.getFirstName()) && basicdataRepository.existsByLastName(basicdata.getLastName()) && basicdataRepository.existsByDateOfBirth(basicdata.getDateOfBirth())) {
                            throw new BadRequestException.BadRequestExceptions(BASIC_DATA_CANNOT_BE_CREATED);
                        } else {
                            basicdata1.setFirstName(basicdata.getFirstName());
                            basicdata1.setLastName(basicdata.getLastName());
                            basicdata1.setSalutation(basicdata.getSalutation());
                            basicdata1.setDateOfBirth(basicdata.getDateOfBirth());
                            basicdata1.setAddressdata(basicdata.getAddressdata());
                            basicdata1.setContactdata(basicdata.getContactdata());

                            basicdataRepository.save(basicdata1);
                        }
                        return BASIC_DATA_UPDATING;
                    }).orElseThrow(() -> new Exception(BASIC_DATA_NOT_FOUND));
            return BASIC_DATA_UPDATING;
        } else {
            throw new BadRequestException.BadRequestExceptions(NO_SUCH_ELEMENT_ERROR_MSG);
        }
    }
}
