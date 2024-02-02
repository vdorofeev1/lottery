package org.example.lottery.models;

import jakarta.persistence.Entity;

@Entity
public class Winner extends Participant {
    private int winAmount;
    protected Winner() {}

    public Winner(Participant participant, int winAmount) {
        super(participant.getName(), participant.getAge(), participant.getCity());
        this.winAmount = winAmount;
    }

    public Winner(String name, Integer age, String city, Integer winAmount) {
        super(name, age, city);
        this.winAmount = winAmount;
    }

    public Integer getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(Integer winAmount) {
        this.winAmount = winAmount;
    }
}
