package org.example.lottery.exceptions;

public class ParticipantNotFound extends RuntimeException {
    public ParticipantNotFound(int id) {
        super("Participant with id=" + id + "not found!");
    }

}
