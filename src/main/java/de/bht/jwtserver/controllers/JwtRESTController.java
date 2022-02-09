package de.bht.jwtserver.controllers;

import de.bht.jwtserver.dto.*;
import de.bht.jwtserver.model.JwtScore;
import de.bht.jwtserver.model.JwtUser;
import de.bht.jwtserver.repo.JwtScoreRepository;
import de.bht.jwtserver.repo.JwtUserRepository;
import de.bht.jwtserver.service.JwtUserService;
import de.bht.jwtserver.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;


/**
 * JwtUserController
 * 
 * @author Fredi Benko
 */
@RestController
public class JwtRESTController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUserService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    JwtUserRepository userRepository;

    @Autowired
    JwtScoreRepository scoreRepository;


    @GetMapping("/hello")
    public String hello() {
        // For testing: text is send back if authenticated else 403 Forbidden error
        return  "Hello if you are authorized!";
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        // authenticate the received jwt token and find corresponding user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtUser jwtUser = userRepository.findUserByEmail(authentication.getName());
        // return user informations saved in the database
        return ResponseEntity.ok(new UserResponse(jwtUser));
    }

    @PostMapping("/score")
    public ResponseEntity<?> addScore(@RequestBody AddScoreRequest addScoreRequest) {
        // authenticate the received jwt token and find corresponding user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtUser jwtUser = userRepository.findUserByEmail(authentication.getName());
        // save the received score in the database for the corresponding user
        jwtUser.add(new JwtScore(addScoreRequest.getScore()));
        userRepository.save(jwtUser);
        return ResponseEntity.ok(new ApiResponse(true, "score saved successfully"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        // authenticate received user credetials 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsernameOrEmail());
        // generate jwt token for user
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        // check if the received email already exists
        if(userRepository.findUserByEmail(signUpRequest.getEmail()) != null) {
            return new ResponseEntity<>(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        // create a user and store him in the database
        JwtUser jwtUser = new JwtUser();
        jwtUser.setEmail(signUpRequest.getEmail());
        jwtUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userRepository.save(jwtUser);
        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
    }

    @GetMapping("/highscore")
    public ResponseEntity<?> getHighscore() {
        // find highest score
        List<JwtScore> body = scoreRepository.findAll();
        Collections.sort(body, Collections.reverseOrder(new Comparator<JwtScore>() {
            @Override
            public int compare(JwtScore arg0, JwtScore arg1) {
                return Integer.compare(arg0.getScore() , arg1.getScore()); 
            }
        }));
        // return highscore with corresponding user
        return ResponseEntity.ok(new ScoreResponse(body.get(0)));
    }
}
