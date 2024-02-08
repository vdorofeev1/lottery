package org.example.lottery.models;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Table(name = "participant")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
