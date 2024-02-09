package org.example.lottery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

public class NotEnoughParticipantsException extends RuntimeException {
    public NotEnoughParticipantsException() {
        super("Not enough participants for the lottery");
    }
}
