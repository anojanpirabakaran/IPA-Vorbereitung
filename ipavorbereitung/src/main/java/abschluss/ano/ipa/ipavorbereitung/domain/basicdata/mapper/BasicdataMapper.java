package abschluss.ano.ipa.ipavorbereitung.domain.basicdata.mapper;

import abschluss.ano.ipa.ipavorbereitung.domain.basicdata.Basicdata;
import abschluss.ano.ipa.ipavorbereitung.domain.basicdata.BasicdataDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasicdataMapper {

    Basicdata fromDTO(BasicdataDTO basicdataDTO);

    List<Basicdata> fromDTOs(List<BasicdataDTO> basicdataDTOS);

    BasicdataDTO toDTO(Basicdata basicdata);

    List<BasicdataDTO> toDTOs(List<Basicdata> basicdataList);
}
