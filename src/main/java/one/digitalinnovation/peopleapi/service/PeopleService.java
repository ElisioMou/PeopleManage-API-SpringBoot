package one.digitalinnovation.peopleapi.service;


import one.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.peopleapi.entity.People;
import one.digitalinnovation.peopleapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public MessageResponseDTO createPeople(People people) {
        People savedPeople = peopleRepository.save(people);
        return MessageResponseDTO
                .builder()
                .message("Created people with ID" + savedPeople.getId())
                .build();
    }
}
