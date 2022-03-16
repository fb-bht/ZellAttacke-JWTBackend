package de.bht.jwtserver.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;


/**
 * @author Fredi Benko
 */
public class AddScoreRequest {
    
    @NotBlank
    private int score;

    @NotBlank
    private Date date;

    
    /** 
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    
    /** 
     * @return int
     */
    public int getScore() {
        return score;
    }

    
    /** 
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    
    /** 
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
