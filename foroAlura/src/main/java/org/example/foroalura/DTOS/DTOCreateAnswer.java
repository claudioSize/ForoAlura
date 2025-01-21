package org.example.foroalura.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
@JsonIgnoreProperties(ignoreUnknown = false)
public class DTOCreateAnswer {
    @NotNull(message = "El campo no puede estar vacio.")
    private String mess;
    @NotNull(message = "El campo no puede estar vacio.")
    private String solution;
    @NotNull(message = "El campo no puede estar vacio.")
    private String topicName;
    @NotNull(message = "El campo no puede estar vacio.")
    private String userName;

    public DTOCreateAnswer() {
    }

    public @NotNull(message = "El campo no puede estar vacio.") String getMess() {
        return mess;
    }

    public void setMess(@NotNull(message = "El campo no puede estar vacio.") String mess) {
        this.mess = mess;
    }

    public @NotNull(message = "El campo no puede estar vacio.") String getSolution() {
        return solution;
    }

    public void setSolution(@NotNull(message = "El campo no puede estar vacio.") String solution) {
        this.solution = solution;
    }

    public @NotNull(message = "El campo no puede estar vacio.") String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull(message = "El campo no puede estar vacio.") String userName) {
        this.userName = userName;
    }

    public @NotNull(message = "El campo no puede estar vacio.") String getTopicName() {
        return topicName;
    }

    public void setTopicName(@NotNull(message = "El campo no puede estar vacio.") String topicName) {
        this.topicName = topicName;
    }
}
