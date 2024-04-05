package abschluss.ano.ipa.ipavorbereitung.domain.basicdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basic-data")
public class BasicdataRestController {

    private final BasicdataServiceImplementation serviceImplementation;

    @Autowired
    public BasicdataRestController(BasicdataServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Basicdata>> getAll() {
        List<Basicdata> basicdata = serviceImplementation.getAllBasicData();
        return new ResponseEntity<>(basicdata, HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Basicdata> getBasicDataById(@PathVariable String id) {
        Basicdata basicdata = serviceImplementation.getBasicDataById(id);
        return new ResponseEntity<>(basicdata, HttpStatus.OK);
    }
}
