package abschluss.ano.ipa.ipavorbereitung.domain.basicdata;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BasicdataGraphQLController {
    private final BasicdataRepository basicdataRepository;

    public BasicdataGraphQLController(BasicdataRepository basicdataRepository) {
        this.basicdataRepository = basicdataRepository;
    }

    @QueryMapping
    Iterable<Basicdata> basicData(){
        return basicdataRepository.findAll();
    }
}
