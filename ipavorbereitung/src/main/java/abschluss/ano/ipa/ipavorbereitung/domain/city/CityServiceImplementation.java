package abschluss.ano.ipa.ipavorbereitung.domain.city;

import abschluss.ano.ipa.ipavorbereitung.config.error.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static abschluss.ano.ipa.ipavorbereitung.utils.Constants.NO_SUCH_ELEMENT_ERROR_MSG;
import static abschluss.ano.ipa.ipavorbereitung.utils.Constants.SUCH_ELEMENT_ALREADY_EXISTS_ERROR_MSG;

@Service
public class CityServiceImplementation {

    private final CityRepository repository;

    @Autowired
    public CityServiceImplementation(CityRepository repository) {
        this.repository = repository;
    }

    public City createCity(City city) {
        if (repository.existsByPostalCode(city.getPostalCode())) {
            throw new BadRequestException.BadRequestExceptions(
                    String.format(SUCH_ELEMENT_ALREADY_EXISTS_ERROR_MSG, city.getPostalCode()));
        } else {
            return repository.save(city);
        }
    }

    public String updateCity(String id, City city) throws Exception {
        if (repository.existsById(id)) {
            repository.findById(id)
                    .map(city1 -> {
                        city1.setName(city.getName());
                        city1.setPostalCode(city.getPostalCode());
                        if (repository.existsByPostalCode(city1.getPostalCode())) {
                            throw new BadRequestException.BadRequestExceptions("Postal Code already exists");
                        } else {
                            repository.save(city1);
                        }
                        return "City updating";
                    }).orElseThrow(() -> new Exception("City not found - " + city));
            return "City is updated";
        } else {
            throw new BadRequestException.BadRequestExceptions("City ID doesnt exists");
        }
    }


    public City getCityById(String uuid) {
        Optional<City> city = repository.findById(uuid);

        if (city.isPresent()) {
            return city.get();
        } else {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, uuid));
        }
    }

    public List<City> getAllCities() {
        if (repository.findAll().isEmpty()) {
            throw new NoSuchElementException("No City found in the database");
        }
        return repository.findAll();
    }

    public String deleteCityById(String uuid) {
        if (!repository.existsById(uuid)) {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, uuid));
        }
        repository.deleteById(uuid);
        return String.format("Deleted City by id %s successfully", uuid);
    }

    public void deleteAllCities() {
        repository.deleteAll();
    }
}
