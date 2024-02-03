package org.example.lottery.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String city;

    public Participant(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }


}
