package one.digitalinnovation.peopleapi.service;

import one.digitalinnovation.peopleapi.exception.PersonNotFoundException;
import one.digitalinnovation.peopleapi.mapper.PeopleMapper;
import one.digitalinnovation.peopleapi.dto.request.PeopleDTO;
import one.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.peopleapi.entity.People;

import one.digitalinnovation.peopleapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    private final PeopleMapper peopleMapper = PeopleMapper.INSTANCE;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public MessageResponseDTO createPeople(PeopleDTO peopleDTO) {
        People peopleToSave = peopleMapper.toModel(peopleDTO);

        People savedPeople = peopleRepository.save(peopleToSave);

        MessageResponseDTO messageResponse =
                createMessageResponse("Person successfully created with ID ", savedPeople.getId());

        return messageResponse;
         /*       .firstName(peopleDTO.getFirstName())
                .lastName(peopleDTO.getLastName())
                .birthDate(peopleDTO.getBirthDate())
                .phones(peopleDTO.getPhones())
                .build();*/

            return MessageResponseDTO
                    .builder()
                    .message("Created people with ID" + savedPeople.getId())
                    .build();

    }

    public List<PeopleDTO> lisAll() {
        List<People> allPeople = peopleRepository.findAll();
        return allPeople.stream()
                .map(peopleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PeopleDTO findById(Long id) throws PersonNotFoundException {
                 People people = peopleRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        //Optional<People> optionalPeople = peopleRepository.findById(id);

        return peopleMapper.toDTO(people);
    }
}
