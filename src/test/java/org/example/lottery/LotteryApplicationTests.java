package org.example.lottery;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.lottery.models.Participant;
import org.example.lottery.service.LotteryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class LotteryApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LotteryService lotteryService;


    @Test
    void contextLoads() {
    }

    @Test
    void postParticipantTest() throws Exception {
        Participant participant = new Participant("Ivan", 20, "Moscow");
        String jsonPayload = objectMapper.writeValueAsString(participant);

        mockMvc.perform(post("/lottery/participant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void getParticipantsTest() throws Exception {
        Participant participant1 = new Participant("Ivan", 20, "Moscow");
        String jsonPayload = objectMapper.writeValueAsString(participant1);

        mockMvc.perform(post("/lottery/participant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload));

        Participant participant2 = new Participant("Andrey", 20, "Moscow");
        jsonPayload = objectMapper.writeValueAsString(participant2);

        mockMvc.perform(post("/lottery/participant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload));

        mockMvc.perform(get("/lottery/participant"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Ivan")))
                .andExpect(content().string(containsString("Andrey")));
    }

    @Test
    void startLotteryTest() throws Exception {
        Participant participant1 = new Participant("Ivan", 20, "Moscow");
        String jsonPayload = objectMapper.writeValueAsString(participant1);

        mockMvc.perform(post("/lottery/participant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        Participant participant2 = new Participant("Andrey", 20, "Moscow");
        jsonPayload = objectMapper.writeValueAsString(participant2);

        mockMvc.perform(post("/lottery/participant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(get("/lottery/start"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void startLotteryFailsTest() throws Exception {
        mockMvc.perform(get("/lottery/start"))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    @Test
    void getWinnersTest() throws Exception {
        Participant participant1 = new Participant("Ivan", 20, "Moscow");
        String jsonPayload = objectMapper.writeValueAsString(participant1);

        mockMvc.perform(post("/lottery/participant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        Participant participant2 = new Participant("Andrey", 20, "Moscow");
        jsonPayload = objectMapper.writeValueAsString(participant2);

        mockMvc.perform(post("/lottery/participant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload));

        mockMvc.perform(get("/lottery/start"))
                .andDo(print());

        mockMvc.perform(get("/lottery/winners"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
