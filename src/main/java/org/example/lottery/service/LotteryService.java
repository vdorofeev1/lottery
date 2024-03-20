package org.example.lottery.service;


import lombok.RequiredArgsConstructor;
import org.example.lottery.exceptions.NotEnoughParticipantsException;
import org.example.lottery.exceptions.ParticipantNotFound;
import org.example.lottery.models.Participant;
import org.example.lottery.models.Winner;
import org.example.lottery.repository.ParticipantRepository;
import org.example.lottery.repository.WinnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LotteryService {

    private final ParticipantRepository participantRepository;

    private final WinnerRepository winnerRepository;

    private static final int MIN_PARTICIPANTS_THRESHOLD = 2;
    private static final int MAX_WIN_AMOUNT = 1000;

    public Participant addParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Winner addWinner(Winner winner) { return winnerRepository.save(winner); }

    public List<Participant> allParticipants() {
        return participantRepository.findAll();
    }

    public List<Winner> allWinners() {
        return winnerRepository.findAll();
    }

    public Winner startLottery() {
        if (!enoughParticipants()) {
            throw new NotEnoughParticipantsException();
        }
        Winner winner = getWinner();
        participantRepository.deleteAll();
        participantRepository.resetIdCounter();
        addWinner(winner);
        return winner;
    }

    private Winner getWinner() {

        RestTemplate restTemplate = new RestTemplate();
        int winAmount = Integer.parseInt(restTemplate.getForObject("https://www.random.org/integers/?num=1&min=1&max=" + MAX_WIN_AMOUNT + "&col=1&base=10&format=plain&rnd=new", String.class).
                replaceAll("\\D", ""));
        int randomId = Integer.parseInt(restTemplate.getForObject("https://www.random.org/integers/?num=1&min=1&max=" + participantRepository.count() + "&col=1&base=10&format=plain&rnd=new", String.class).
                replaceAll("\\D", ""));

        Participant randomParticipant = participantRepository.findById((long) randomId)
                .orElseThrow(() -> new ParticipantNotFound(randomId));
        return new Winner(randomParticipant, winAmount);
    }

    private boolean enoughParticipants() {
        return participantRepository.count() >= MIN_PARTICIPANTS_THRESHOLD;
    }
}
