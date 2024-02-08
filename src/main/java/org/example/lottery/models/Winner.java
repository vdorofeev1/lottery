package org.example.lottery.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "winner")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Winner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long winnerId;
    
    private Long id;
    private String name;
    private int age;
    private String city;
    private int winAmount;
    public Winner(Participant participant, int winAmount) {
        this.id = participant.id;
        this.name = participant.name;
        this.age = participant.age;
        this.city = participant.city;
        this.winAmount = winAmount;
    }

}
