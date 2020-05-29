package cl.tbd.back.model;

import java.sql.Date;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Emergency {

    private final UUID id;

    @NotBlank
    private final UUID id_institution;

    @NotBlank
    private final String name;

    private final String description;

    private final Date start_date;

    private final Date finish_date;

    public Emergency(@JsonProperty("id") UUID id,
                     @JsonProperty("id_institution") UUID id_institution,
                     @JsonProperty("name") String name,
                     @JsonProperty("description") String description,
                     @JsonProperty("start_date") Date start_date,
                     @JsonProperty("finish_date") Date finish_date) {
        this.id = id;
        this.id_institution = id_institution;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdInstitution() {
        return id_institution;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return start_date;
    }

    public Date getFinishDate() {
        return finish_date;
    }
    
}