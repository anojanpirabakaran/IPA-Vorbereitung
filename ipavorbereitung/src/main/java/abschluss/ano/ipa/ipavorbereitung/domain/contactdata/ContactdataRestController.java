package abschluss.ano.ipa.ipavorbereitung.domain.contactdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/contact-data")
@RestController
public class ContactdataRestController {

    private final ContactdataServiceImplementation serviceImplementation;

    @Autowired
    public ContactdataRestController(ContactdataServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Contactdata>> getAll() {
        List<Contactdata> contactDatas = serviceImplementation.getAllContactDatas();
        return new ResponseEntity<>(contactDatas, HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Contactdata> getContactDataById(@PathVariable String id) {
        Contactdata contactdata = serviceImplementation.getContactDataById(id);
        return new ResponseEntity<>(contactdata, HttpStatus.OK);
    }
}
