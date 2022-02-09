package de.bht.jwtserver.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.bht.jwtserver.model.JwtScore;


@Repository
public interface JwtScoreRepository extends JpaRepository<JwtScore, Integer> {
    
    List<JwtScore>findAll();
    
}
