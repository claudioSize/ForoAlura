package org.example.foroalura.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

@JsonIgnoreProperties(ignoreUnknown = false)
public class DTOCreateTopics {
    @NotNull
    private String title;
    @NotNull(message = "El campo no puede estar vacio.")
    @Size(min = 20, max = 255, message = "El mensaje debe ser mas largo de 20 caracteres o menor de 255")
    private String mess;
    @NotNull(message = "El campo no puede estar vacio.")
    private String authorName;
    @NotNull(message = "El campo no puede estar vacio.")
    private String curseName;

    public DTOCreateTopics() {
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


    public @NotNull(message = "El campo no puede estar vacio.") String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(@NotNull(message = "El campo no puede estar vacio.") String authorName) {
        this.authorName = authorName;
    }

    public @NotNull(message = "El campo no puede estar vacio.") String getCurseName() {
        return curseName;
    }

    public void setCurseName(@NotNull(message = "El campo no puede estar vacio.") String curseName) {
        this.curseName = curseName;
    }
}
