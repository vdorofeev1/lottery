package org.example.lottery;


import org.example.lottery.models.Participant;
import org.example.lottery.repository.ParticipantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ParticipantRepositoryTest {

    @Autowired
    private ParticipantRepository participantRepository;

    @Test
    public void saveParticipantTest() {
        Participant participant = Participant.builder()
                .name("Ivan").age(20).city("Moscow").build();
        Participant savedParticipant = participantRepository.save(participant);

        assertNotNull(savedParticipant);
        Assertions.assertThat(savedParticipant.getId()).isGreaterThan(0);
        assertEquals(savedParticipant.getName(), "Ivan");
        assertEquals(savedParticipant.getAge(), 20);
        assertEquals(savedParticipant.getCity(), "Moscow");
    }

    @Test
    public void saveManyParticipantsTest() {
        Participant participant1 =Participant.builder()
                .name("Ivan").age(20).city("Moscow").build();
        Participant participant2 =Participant.builder()
                .name("Vlad").age(21).city("Ufa").build();

        participantRepository.save(participant1);
        participantRepository.save(participant2);

        Assertions.assertThat(participantRepository.count()).isGreaterThan(1);

    }
}
