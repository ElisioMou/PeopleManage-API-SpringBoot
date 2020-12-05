package one.digitalinnovation.peopleapi.service;

import one.digitalinnovation.peopleapi.dto.request.PeopleDTO;
import one.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.peopleapi.entity.People;
import one.digitalinnovation.peopleapi.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static one.digitalinnovation.peopleapi.utils.PeopleUtils.createFakeDTO;
import static one.digitalinnovation.peopleapi.utils.PeopleUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PeopleServiceTest {

    @Mock
    private PeopleRepository peopleRepository;

    @InjectMocks
    private PeopleService peopleService;
    public String expectedSavedPeopleId;

    @Test
    void testGivenPeopleDTOThenReturnSavedMessage() {
        PeopleDTO peopleDTO = createFakeDTO();
        People expectedSavedPeople = createFakeEntity();

        when(peopleRepository.save(any(People.class))).thenReturn(expectedSavedPeople);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPeople.getId());
        MessageResponseDTO successMessage = peopleService.createPeople(peopleDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
    }

    private MessageResponseDTO createExpectedSuccessMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created people with ID " + id)
                .build();
        }
    }
   
}
