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


    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public List<JwtScore> getScores() {
        return scores;
    }

    public void setScores(List<JwtScore> score) {
        this.scores = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void add(JwtScore newScore) {
        if (this.scores == null) {
            this.scores = new ArrayList<JwtScore>();
        } else {
            this.scores.add(newScore);
        }
    }

    public JwtUser( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public JwtUser() {
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + "]";
	}

}
