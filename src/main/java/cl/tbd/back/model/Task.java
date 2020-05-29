package cl.tbd.back.model;

import java.sql.Date;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    
    private final UUID id;

    @NotBlank
    private final UUID id_emergency;

    @NotBlank
    private final String name;

    private final String description;
    
    @NotBlank
    private final int required_volunteers;

    private final int enrolled_volunteers;

    @NotBlank
    private final Date start_date;

    private final Date finish_date;

    public Task(@JsonProperty("id") UUID id,
                @JsonProperty("id_emergency") UUID id_emergency,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("required_volunteers") int required_volunteers,
                @JsonProperty("enrolled_volunteers") int enrolled_volunteers,
                @JsonProperty("start_date") Date start_date,
                @JsonProperty("finish_date") Date finish_date) {
        this.id = id;
        this.id_emergency = id_emergency;
        this.name = name;
        this.description = description;
        this.required_volunteers = required_volunteers;
        this.enrolled_volunteers = enrolled_volunteers;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdEmergency() {
        return id_emergency;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRequiredVolunteers() {
        return required_volunteers;
    }

    public int getEnrolledVolunteers() {
        return enrolled_volunteers;
    }

    public Date getStartDate() {
        return start_date;
    }

    public Date getFinishDate() {
        return finish_date;
    }

}