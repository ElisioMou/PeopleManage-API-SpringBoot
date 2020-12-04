package one.digitalinnovation.peopleapi.controller;

import one.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.peopleapi.entity.People;
import one.digitalinnovation.peopleapi.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPeople(@RequestBody People people) {
        return  peopleService.createPeople(people);
    }
}


