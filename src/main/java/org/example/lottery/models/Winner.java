package org.example.lottery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Winner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long winnerId;
    private Long id;
    private String name;
    private int age;
    private String city;
    private int winAmount;
    protected Winner() {}

    public Winner(Participant participant, int winAmount) {
        this.id = participant.getId();
        this.name = participant.getName();
        this.age = participant.getAge();
        this.city = participant.getCity();
        this.winAmount = winAmount;
    }
}
