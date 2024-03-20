package org.example.lottery.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "participant")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Integer age;
    public String city;

    public Participant(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }


}
