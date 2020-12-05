package one.digitalinnovation.peopleapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.peopleapi.dto.request.PeopleDTO;
import one.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.peopleapi.exception.PersonNotFoundException;
import one.digitalinnovation.peopleapi.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPeople(@RequestBody @Valid PeopleDTO peopleDTO) {
        return  peopleService.createPeople(peopleDTO);
    }

    @GetMapping
    public List<PeopleDTO> listAll() {
        return peopleService.lisAll();
    }

    @GetMapping("/{id}")
    public PeopleDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return peopleService.findById(id);
    }

    @PutMapping
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PeopleDTO peopleDTO) throws PersonNotFoundException {
           return peopleService.updateById(id, peopleDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        peopleService.delete(id);
    }
}


