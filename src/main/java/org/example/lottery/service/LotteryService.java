package org.example.lottery.service;

import org.example.lottery.exceptions.NotEnoughParticipantsException;
import org.example.lottery.models.Participant;
import org.example.lottery.models.Winner;
import org.example.lottery.repository.ParticipantRepository;
import org.example.lottery.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;


@Service
public class LotteryService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private WinnerRepository winnerRepository;

    private static final int MIN_PARTICIPANTS_THRESHOLD = 2;
    private static final int MAX_WIN_AMOUNT = 1000;

    public void addParticipant(Participant participant) {
        participantRepository.save(participant);
    }

    public void addWinner(Winner winner) { winnerRepository.save(winner); }

    public List<Participant> allParticipants() {
        return participantRepository.findAll();
    }

    public List<Winner> allWinners() {
        return winnerRepository.findAll();
    }

    public Winner startLottery() {
        if (enoughParticipants()) {
            Winner winner = getWinner();
            participantRepository.deleteAll();
            addWinner(winner);
            return winner;
        } else {
            throw new NotEnoughParticipantsException();
        }
    }

    private Winner getWinner() {

        final RestTemplate restTemplate = new RestTemplate();
        final int winAmount = Integer.parseInt(restTemplate.getForObject("https://www.random.org/integers/?num=1&min=1&max=" + MAX_WIN_AMOUNT + "&col=1&base=10&format=plain&rnd=new", String.class).
                replaceAll("\\D", ""));
        final int randomId = Integer.parseInt(restTemplate.getForObject("https://www.random.org/integers/?num=1&min=1&max=" + participantRepository.count() + "&col=1&base=10&format=plain&rnd=new", String.class).
                replaceAll("\\D", ""));

        Participant randomParticipant = participantRepository.findById((long) randomId)
                .orElseThrow(() -> new RuntimeException("Participant not found with id" + randomId));
        return new Winner(randomParticipant, winAmount);
    }

    private boolean enoughParticipants() {
        return participantRepository.count() >= MIN_PARTICIPANTS_THRESHOLD;
    }
}
