package de.bht.jwtserver.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.*;


/**
 * JwtScore
 */
@Entity
@Table(name = "scores")
public class JwtScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "score")
    private Integer score;

    @Column(name = "date")
    private Date date;

    @Column(name = "user_id")
    private Integer user_id;


    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public JwtScore(Integer score, Date date) {
        this.setScore(score);
        this.setDate(date);
    }

    public JwtScore(Integer score) {
        this.setScore(score);
        this.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
    }

    public JwtScore() {
    }

    @Override
	public String toString() {
		return "Score [id=" + id + ", score=" + score + ", date=" + date + "]";
	}

}
