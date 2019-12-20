package com.javamentors.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Role {

    private Long id;

    private String role;

    private Set<AppUser> appUsers = new HashSet<>();

    public Role(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Role role1 = (Role) object;
        return Objects.equals(id, role1.id) &&
                Objects.equals(role, role1.role) &&
                Objects.equals(appUsers, role1.appUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, appUsers);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", appUsers=" + appUsers +
                '}';
    }
}
