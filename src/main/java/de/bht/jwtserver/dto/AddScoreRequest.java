package de.bht.jwtserver.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;


public class AddScoreRequest {
    
    @NotBlank
    private int score;

    @NotBlank
    private Date date;

    public Date getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
