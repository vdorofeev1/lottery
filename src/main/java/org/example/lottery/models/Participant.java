package org.example.lottery.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "participant")
@Getter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
