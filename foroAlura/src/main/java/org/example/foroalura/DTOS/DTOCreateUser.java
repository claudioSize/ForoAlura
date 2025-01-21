package org.example.foroalura.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
@JsonIgnoreProperties(ignoreUnknown = false)
public class DTOCreateUser {
    @NotNull(message = "El campo no puede estar vacio.")
    private String name;
    @NotNull(message = "El campo no puede estar vacio.")
    private String email;
    @NotNull(message = "El campo no puede estar vacio.")
    private String pass;
    @NotNull(message = "El campo no puede estar vacio.")
    private String perfilName;

    public DTOCreateUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPerfilName() {
        return perfilName;
    }

    public void setPerfilName(String perfilName) {
        this.perfilName = perfilName;
    }
}
