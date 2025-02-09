package com.onlineauctionSystem.AuctionSystem.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.onlineauctionSystem.AuctionSystem.component.GrantedAuthorityDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Document(collection = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    private String id;
    private String username;
    private String password;

    @JsonDeserialize(using = GrantedAuthorityDeserializer.class)
    private List<GrantedAuthority> authorities;

    // Constructors, getters, and setters

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       /* List<GrantedAuthority> authorities=   List.of(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "USER";
            }
        });*/
        return authorities;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
