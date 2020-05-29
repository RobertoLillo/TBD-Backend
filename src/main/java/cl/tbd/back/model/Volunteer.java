package cl.tbd.back.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Volunteer {

    private final UUID id;

    @NotBlank
    private final String name;

    public Volunteer(@JsonProperty("id") UUID id,
                     @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}