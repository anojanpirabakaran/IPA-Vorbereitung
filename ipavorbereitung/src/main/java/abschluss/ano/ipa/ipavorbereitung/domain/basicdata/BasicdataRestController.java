package abschluss.ano.ipa.ipavorbereitung.domain.basicdata;

import abschluss.ano.ipa.ipavorbereitung.domain.basicdata.mapper.BasicdataMapper;
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
    private final BasicdataMapper basicdataMapper;

    @Autowired
    public BasicdataRestController(BasicdataServiceImplementation serviceImplementation, BasicdataMapper basicdataMapper) {
        this.serviceImplementation = serviceImplementation;
        this.basicdataMapper = basicdataMapper;
    }

    @GetMapping({"/FAT", "/FAT/"})
    public ResponseEntity<List<Basicdata>> getAll() {
        List<Basicdata> basicdata = serviceImplementation.getAllBasicData();
        return new ResponseEntity<>(basicdata, HttpStatus.OK);
    }

    @GetMapping({"/FAT/{id}", "/FAT/{id}/"})
    public ResponseEntity<Basicdata> getBasicDataById(@PathVariable String id) {
        Basicdata basicdata = serviceImplementation.getBasicDataById(id);
        return new ResponseEntity<>(basicdata, HttpStatus.OK);
    }

    @GetMapping({"/LEAN", "/LEAN/"})
    public ResponseEntity<List<BasicdataDTO>> getAllBasicDatasDTO() {
        List<Basicdata> basicdata = serviceImplementation.getAllBasicData();
        return new ResponseEntity<>(basicdataMapper.toDTOs(basicdata), HttpStatus.OK);
    }

    @GetMapping({"/LEAN/{id}", "/LEAN/{id}/"})
    public ResponseEntity<BasicdataDTO> getBasicDataByIdDTO(@PathVariable String id) {
        Basicdata basicdata = serviceImplementation.getBasicDataById(id);
        return new ResponseEntity<>(basicdataMapper.toDTO(basicdata), HttpStatus.OK);
    }
}
