package abschluss.ano.ipa.ipavorbereitung.domain.addressdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address-data")
public class AddressdataRestController {


    private final AddressdataServiceImplementation addressdataServiceImplementation;

    @Autowired
    public AddressdataRestController(AddressdataServiceImplementation addressdataServiceImplementation) {
        this.addressdataServiceImplementation = addressdataServiceImplementation;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Addressdata>> getAll() {
        List<Addressdata> addressdata = addressdataServiceImplementation.getAllAddressData();
        return new ResponseEntity<>(addressdata, HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Addressdata> getAddressDataById(@PathVariable String id) {
        Addressdata addressdata = addressdataServiceImplementation.getAddressDataById(id);
        return new ResponseEntity<>(addressdata, HttpStatus.OK);
    }
}
