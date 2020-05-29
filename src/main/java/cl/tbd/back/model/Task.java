package cl.tbd.back.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    
    private final UUID id;

    @NotBlank
    private final UUID idEmergency;

    @NotBlank
    private final String name;

    private final String description;
    
    @NotBlank
    private final int requiredVolunteers;

    private final int enrolledVolunteers;

    @NotBlank
    private final Timestamp startDate;

    private final Timestamp finishDate;

    public Task(@JsonProperty("id") UUID id,
                @JsonProperty("idEmergency") UUID idEmergency,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("requiredVolunteers") int requiredVolunteers,
                @JsonProperty("enrolledVolunteers") int enrolledVolunteers,
                @JsonProperty("startDate") Timestamp startDate,
                @JsonProperty("finishDate") Timestamp finishDate) {
        this.id = id;
        this.idEmergency = idEmergency;
        this.name = name;
        this.description = description;
        this.requiredVolunteers = requiredVolunteers;
        this.enrolledVolunteers = enrolledVolunteers;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdEmergency() {
        return idEmergency;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRequiredVolunteers() {
        return requiredVolunteers;
    }

    public int getEnrolledVolunteers() {
        return enrolledVolunteers;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getFinishDate() {
        return finishDate;
    }

}