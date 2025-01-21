package org.example.foroalura.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = false)
public class DTOUpdateTopic {

        @NotNull
        private String title;
        @NotNull(message = "El campo no puede estar vacio.")
        @Size(min = 20, max = 255, message = "El mensaje debe ser mas largo de 20 caracteres o menor de 255")
        private String mess;
    @NotNull(message = "El campo no puede estar vacio.")
    private String curseName;
    @NotNull(message = "El campo no puede estar vacio.")
    private String status;

    public DTOUpdateTopic() {
    }

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public @NotNull(message = "El campo no puede estar vacio.") @Size(min = 20, max = 255, message = "El mensaje debe ser mas largo de 20 caracteres o menor de 255") String getMess() {
        return mess;
    }

    public void setMess(@NotNull(message = "El campo no puede estar vacio.") @Size(min = 20, max = 255, message = "El mensaje debe ser mas largo de 20 caracteres o menor de 255") String mess) {
        this.mess = mess;
    }

    public @NotNull(message = "El campo no puede estar vacio.") String getCurseName() {
        return curseName;
    }

    public void setCurseName(@NotNull(message = "El campo no puede estar vacio.") String curseName) {
        this.curseName = curseName;
    }

    public @NotNull(message = "El campo no puede estar vacio.") String getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "El campo no puede estar vacio.") String status) {
        this.status = status;
    }
}
