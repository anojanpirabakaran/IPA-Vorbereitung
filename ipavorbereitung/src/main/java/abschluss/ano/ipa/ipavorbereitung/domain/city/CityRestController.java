package abschluss.ano.ipa.ipavorbereitung.domain.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityRestController {

    private final CityServiceImplementation serviceImplementation;

    @Autowired
    public CityRestController(CityServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = serviceImplementation.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<City> getCityByID(@PathVariable String id) {
        City city = serviceImplementation.getCityById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
