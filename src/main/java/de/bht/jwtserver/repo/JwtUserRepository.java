package de.bht.jwtserver.repo;


import de.bht.jwtserver.model.JwtUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JwtUserRepository extends JpaRepository<JwtUser, Integer> {

    List<JwtUser> findAll();

    JwtUser findByEmail(String email);

    JwtUser findUserByEmail(String email);

}
