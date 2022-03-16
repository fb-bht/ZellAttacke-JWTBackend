package de.bht.jwtserver.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.*;


/**
 * JwtScore
 * 
 * @author Fredi Benko
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


    
    /** 
     * @param user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    
    /** 
     * @return Integer
     */
    public Integer getUser_id() {
        return user_id;
    }

    
    /** 
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    
    /** 
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    
    /** 
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    
    /** 
     * @return Integer
     */
    public Integer getScore() {
        return score;
    }

    
    /** 
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * Constructor
     * 
     * @param score
     * @param date
     */
    public JwtScore(Integer score, Date date) {
        this.setScore(score);
        this.setDate(date);
    }

    /**
     * Constructor
     * 
     * @param score
     */
    public JwtScore(Integer score) {
        this.setScore(score);
        this.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
    }

    /**
     * Constructor
     */
    public JwtScore() {
    }

    
    /** 
     * @return String
     */
    @Override
	public String toString() {
		return "Score [id=" + id + ", score=" + score + ", date=" + date + "]";
	}

}
