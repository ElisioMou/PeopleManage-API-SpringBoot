package one.digitalinnovation.peopleapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.peopleapi.mapper.PeopleMapper;
import one.digitalinnovation.peopleapi.dto.request.PeopleDTO;
import one.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.peopleapi.entity.People;
import one.digitalinnovation.peopleapi.exception.PersonNotFoundException;
import one.digitalinnovation.peopleapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleService {

    private final PeopleRepository peopleRepository;

    private final PeopleMapper peopleMapper = PeopleMapper.INSTANCE;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

        public MessageResponseDTO createPeople(PeopleDTO peopleDTO) {
        People peopleToSave = peopleMapper.toModel(peopleDTO);

        People savedPeople = peopleRepository.save(peopleToSave);
        return createMessageResponse(savedPeople.getId(), "Created person with ID ");
    }

    public List<PeopleDTO> lisAll() {
        List<People> allPeople = peopleRepository.findAll();
        return allPeople.stream()
                .map(peopleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PeopleDTO findById(Long id) throws PersonNotFoundException {
                 People people = verifyIfExists(id);
        //Optional<People> optionalPeople = peopleRepository.findById(id);

        return peopleMapper.toDTO(people);
    }

        public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        peopleRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PeopleDTO peopleDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        People peopleToUpdate = peopleMapper.toModel(peopleDTO);

        People updatedPeople = peopleRepository.save(peopleToUpdate);

        return createMessageResponse(updatedPeople.getId(), "Updated person with ID ");
    }

    private People verifyIfExists(Long id) throws PersonNotFoundException {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String m) {
        String message = MessageResponseDTO
                .builder()
                .message(m + id)
                .build();
        return null;
    }
}
