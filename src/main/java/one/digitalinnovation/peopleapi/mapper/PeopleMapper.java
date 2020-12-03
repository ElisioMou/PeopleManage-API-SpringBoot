package one.digitalinnovation.peopleapi.mapper;

import one.digitalinnovation.peopleapi.dto.request.PeopleDTO;
import one.digitalinnovation.peopleapi.entity.People;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeopleMapper {

    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    People toModel(PeoplenDTO peopleDTO);

    PeopleDTO toDTO(People people);
}
