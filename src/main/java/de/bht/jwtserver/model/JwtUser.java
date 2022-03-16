package de.bht.jwtserver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * JwtUser
 */
@Entity
@Table(name = "users")
public class JwtUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<JwtScore> scores;


    
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
     * @return List<JwtScore>
     */
    public List<JwtScore> getScores() {
        return scores;
    }

    
    /** 
     * @param score
     */
    public void setScores(List<JwtScore> score) {
        this.scores = score;
    }

    
    /** 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * @return String
     */
    public String getPassword() {
        return password;
    }

    
    /** 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * @param newScore
     */
    public void add(JwtScore newScore) {
        if (this.scores == null) {
            this.scores = new ArrayList<JwtScore>();
        } else {
            this.scores.add(newScore);
        }
    }

    /**
     * Constructor
     * 
     * @param email
     * @param password
     */
    public JwtUser( String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor
     */
    public JwtUser() {
    }

    
    /** 
     * @return String
     */
    @Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + "]";
	}

}
