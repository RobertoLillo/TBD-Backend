package cl.tbd.back.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Emergency {

    private final UUID id;

    @NotBlank
    private final UUID idInstitution;

    @NotBlank
    private final String name;

    private final String description;

    @NotBlank
    private final Timestamp startDate;

    private final Timestamp finishDate;

    public Emergency(@JsonProperty("id") UUID id,
                     @JsonProperty("id_institution") UUID idInstitution,
                     @JsonProperty("name") String name,
                     @JsonProperty("description") String description,
                     @JsonProperty("startDate") Timestamp startDate,
                     @JsonProperty("finishDate") Timestamp finishDate) {
        this.id = id;
        this.idInstitution = idInstitution;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getFinishDate() {
        return finishDate;
    }

    public UUID getIdInstitution() {
        return idInstitution;
    }
}