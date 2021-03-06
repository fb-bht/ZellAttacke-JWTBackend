package de.bht.jwtserver.service;

import de.bht.jwtserver.model.JwtUser;
import de.bht.jwtserver.repo.JwtUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class JwtUserService implements UserDetailsService {

    @Autowired
    JwtUserRepository jwtUserRepository;

    
    /** 
     * @param email
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        JwtUser jwtUser = jwtUserRepository.findUserByEmail(email);
        if (jwtUser == null) {
            throw new UsernameNotFoundException("email Not found" + email);
        }
        return new User(jwtUser.getEmail(), jwtUser.getPassword(), new ArrayList<>());
    }
    
}
