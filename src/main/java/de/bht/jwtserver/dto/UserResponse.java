package de.bht.jwtserver.dto;

import de.bht.jwtserver.model.JwtUser;


public class UserResponse {

    private JwtUser user;

    
    /** 
     * @return JwtUser
     */
    public JwtUser getUser() {
        return user;
    }

    
    /** 
     * @param user
     */
    public void setUser(JwtUser user) {
        this.user = user;
    }


    /**
     * Constructor
     * 
     * @param user
     */
    public UserResponse(JwtUser user) {
        this.user = user;
    }
    
}
