package de.bht.jwtserver.dto;

import de.bht.jwtserver.model.JwtScore;


public class ScoreResponse {

    private JwtScore score;

    public JwtScore getScore() {
        return score;
    }

    public void setScore(JwtScore score) {
        this.score = score;
    }

    public ScoreResponse(JwtScore score) {
        this.score = score;
    }

}
