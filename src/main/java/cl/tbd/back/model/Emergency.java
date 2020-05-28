package cl.tbd.back.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Emergency {

    private final UUID id;

    private final UUID id_institution;

    @NotBlank
    private final String name;

    private final String description;

    private final Timestamp start_date;

    private final Timestamp finish_date;

    public Emergency(@JsonProperty("id") UUID id,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("start_date") Timestamp start_date,
        @JsonProperty("finish_date") Timestamp finish_date,
        @JsonProperty("id_institution") UUID id_institution) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.id_institution = id_institution;
    }

    public UUID getID() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public Timestamp getFinish_date() {
        return finish_date;
    }

    public UUID getId_institution() {
        return id_institution;
    }
}