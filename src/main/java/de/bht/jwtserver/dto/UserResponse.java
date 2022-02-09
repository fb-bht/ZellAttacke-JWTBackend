package de.bht.jwtserver.dto;

import de.bht.jwtserver.model.JwtUser;


public class UserResponse {

    private JwtUser user;

    public JwtUser getUser() {
        return user;
    }

    public void setUser(JwtUser user) {
        this.user = user;
    }

    public UserResponse(JwtUser user) {
        this.user = user;
    }
    
}
