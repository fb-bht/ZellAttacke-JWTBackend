package de.bht.jwtserver.dto;


public class AuthenticationResponse {

    private String jwt;

    
    /** 
     * @return String
     */
    public String getJwt() {
        return jwt;
    }

    
    /** 
     * @param jwt
     */
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    
    /**
     * Constructor
     * 
     * @param jwt
     */
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
    
}
