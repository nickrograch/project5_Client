package com.javamentors.DTO;

import com.javamentors.entity.AppUser;

public class AppUserDTO {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String role;
    private String token;

    public AppUserDTO(){}

    public AppUserDTO(AppUser appUser, String token){
        this.id = appUser.getId();
        this.name = appUser.getName();
        this.password = appUser.getPassword();
        this.email = appUser.getEmail();
        this.role = appUser.getRoles().toString().replace("[]", "");
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
