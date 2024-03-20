package org.example.lottery.dto;

import lombok.Data;

@Data
public class WinnerDto {
    private String name;
    private Integer age;
    private String city;
    private Integer winAmount;
}
