package org.example.lottery.controllers;

import org.example.lottery.service.LotteryService;
import org.example.lottery.models.Participant;
import org.example.lottery.models.Winner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class LotteryController {

    private final LotteryService service;

    LotteryController(LotteryService service) {
        this.service = service;
    }

    @PostMapping("/lottery/participant")
    void addParticipant(@RequestBody Participant participant) {
        service.addParticipant(participant);
    }

    @GetMapping("/lottery/participant")
    List<Participant> allParticipants() {
        return service.allParticipants();
    }

    @GetMapping("/lottery/winners")
    List<Winner> allWinners() { return service.allWinners(); }

    @GetMapping("/lottery/start")
    Participant start() {

        return service.startLottery();
    }
}
