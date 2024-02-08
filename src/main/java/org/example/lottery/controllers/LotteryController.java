package org.example.lottery.controllers;

import lombok.RequiredArgsConstructor;
import org.example.lottery.service.LotteryService;
import org.example.lottery.models.Participant;
import org.example.lottery.models.Winner;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/lottery")
@RequiredArgsConstructor
@RestController
public class LotteryController {

    private final LotteryService service;

    @PostMapping("/participant")
    void addParticipant(@RequestBody Participant participant) {
        service.addParticipant(participant);
    }

    @GetMapping("/participant")
    List<Participant> allParticipants() {
        return service.allParticipants();
    }

    @GetMapping("/winners")
    List<Winner> allWinners() { return service.allWinners(); }

    @GetMapping("/start")
    Winner start() {

        return service.startLottery();
    }
}
