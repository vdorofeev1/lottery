package org.example.lottery.exceptions;

public class NotEnoughParticipantsException extends RuntimeException {
    public NotEnoughParticipantsException() {
        super("Not enough participants for the lottery");
    }
}
