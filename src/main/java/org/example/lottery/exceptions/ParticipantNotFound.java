package org.example.lottery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ParticipantNotFound extends RuntimeException {
    public ParticipantNotFound(int id) {
        super("Participant with id=%d not found!".formatted(id));
    }

}
