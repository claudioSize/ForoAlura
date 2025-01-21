package org.example.foroalura.DTOS;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@JsonIgnoreProperties(ignoreUnknown = false)
public class DTOCreateCurse {

    @NotNull(message = "El campo no puede estar vacio.")
    private String name;
    @NotNull(message = "El campo no puede estar vacio.")
    private String category;

    public DTOCreateCurse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
