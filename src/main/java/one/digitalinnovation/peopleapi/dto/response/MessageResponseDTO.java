package one.digitalinnovation.peopleapi.dto.response;

import jdk.internal.joptsimple.internal.Messages;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    private String message;

    public MessageResponseDTO(String message) {
        this.message = message;
    }

    public static Messages builder() {
        return null;
    }
}
