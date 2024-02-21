package org.example.lottery.controllers;

import lombok.RequiredArgsConstructor;
import org.example.lottery.dto.ParticipantDto;
import org.example.lottery.dto.WinnerDto;
import org.example.lottery.models.Participant;
import org.example.lottery.models.Winner;
import org.example.lottery.service.LotteryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/lottery")
@RequiredArgsConstructor
@RestController
public class LotteryController {

    private final LotteryService service;

    private final ModelMapper modelMapper;
    @PostMapping("/participant")
    void addParticipant(@RequestBody ParticipantDto participantDto) {
        Participant participant = modelMapper.map(participantDto, Participant.class);
        service.addParticipant(participant);
    }

    @GetMapping("/participant")
    List<ParticipantDto> allParticipants() {

        return service.allParticipants()
                .stream()
                .map(participant -> modelMapper.map(participant, ParticipantDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/winners")
    List<WinnerDto> allWinners() {
        return service.allWinners()
                .stream()
                .map(winner -> modelMapper.map(winner, WinnerDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/start")
    WinnerDto start() {

        return modelMapper.map(service.startLottery(), WinnerDto.class);
    }
}
