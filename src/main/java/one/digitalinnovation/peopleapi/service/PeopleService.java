package one.digitalinnovation.peopleapi.service;

import one.digitalinnovation.peopleapi.dto.request.PeopleDTO;
import one.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.peopleapi.entity.People;

import one.digitalinnovation.peopleapi.mapper.PeopleMapper;
import one.digitalinnovation.peopleapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

import static jdk.internal.joptsimple.internal.Messages.message;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;

    private final PeopleMapper peopleMapper = PeopleMapper.INSTANCE;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public MessageResponseDTO createPeople(PeopleDTO peopleDTO) {
        People peopleToSave = peopleMapper.toModel(peopleDTO);

        People savedPeople = peopleRepository.save(peopleToSave);

        /*MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPerson.getId());

        return messageResponse;*/
         /*       .firstName(peopleDTO.getFirstName())
                .lastName(peopleDTO.getLastName())
                .birthDate(peopleDTO.getBirthDate())
                .phones(peopleDTO.getPhones())
                .build();*/

        private MessageResponseDTO createMessageResponse() {
            return MessageResponseDTO
                    .builder()
                    .message()
                    .build();
        }
    }

}
