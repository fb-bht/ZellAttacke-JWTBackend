package de.bht.jwtserver.dto;

import javax.validation.constraints.NotBlank;


public class LoginRequest {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

    
    /** 
     * @return String
     */
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    
    /** 
     * @param usernameOrEmail
     */
    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
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
    
}
