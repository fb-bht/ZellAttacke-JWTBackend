package de.bht.jwtserver.dto;

import de.bht.jwtserver.model.JwtScore;

/**
 * @author Fredi Benko
 */
public class ScoreResponse {

    private JwtScore score;

    
    /** 
     * @return JwtScore
     */
    public JwtScore getScore() {
        return score;
    }

    
    /** 
     * @param score
     */
    public void setScore(JwtScore score) {
        this.score = score;
    }


    /**
     * Constructor
     */
    public ScoreResponse(JwtScore score) {
        this.score = score;
    }

}
