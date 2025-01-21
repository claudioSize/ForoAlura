package org.example.foroalura.DTOS;

import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class DTOLogin {
    @NotNull(message = "El campo no puede estar vacio.")
    private String userName;
    @NotNull(message = "El campo no puede estar vacio.")
    private String password;

    public @NotNull(message = "El campo no puede estar vacio.") String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull(message = "El campo no puede estar vacio.") String userName) {
        this.userName = userName;
    }

    public @NotNull(message = "El campo no puede estar vacio.") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "El campo no puede estar vacio.") String password) {
        this.password = password;
    }
}
