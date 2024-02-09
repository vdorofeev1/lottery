package org.example.lottery;

import org.example.lottery.models.Participant;
import org.example.lottery.repository.ParticipantRepository;
import org.example.lottery.repository.WinnerRepository;
import org.example.lottery.service.LotteryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LotteryServiceTest {

    @Mock
    private ParticipantRepository participantRepository;
    @Mock
    private WinnerRepository winnerRepository;
    @InjectMocks
    private LotteryService lotteryService;

    @Test
    public void createParticipantTest() {
        Participant participant = Participant.builder()
                .name("Ivan").age(20).city("Moscow").build();
        when(participantRepository.save(Mockito.any(Participant.class))).thenReturn(participant);

        Participant savedParticipant = lotteryService.addParticipant(participant);
        Assertions.assertNotNull(savedParticipant);
    }

    @Test
    public void startLotteryTest() {
        /* Assertions.assertThrows(NotEnoughParticipantsException.class, () -> lotteryService.startLottery());
        Participant participant = Participant.builder()
                .name("Ivan").age(20).city("Moscow").build();
        lotteryService.addParticipant(participant);
        Assertions.assertThrows(NotEnoughParticipantsException.class, () -> lotteryService.startLottery());

        Participant participant2 = Participant.builder()
                .name("Vlad").age(21).city("Moscow").build();
        lotteryService.addParticipant(participant2);
        Participant participant3 = Participant.builder()
                .name("Vlad").age(221).city("Moscow").build();
        lotteryService.addParticipant(participant3);

        Assertions.assertDoesNotThrow(() -> lotteryService.startLottery());

         */

    }
}
