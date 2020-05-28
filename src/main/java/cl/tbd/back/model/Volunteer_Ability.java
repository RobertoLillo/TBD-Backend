package cl.tbd.back.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Volunteer_Ability {

    private final UUID id;

    private final UUID id_volunteer;

    private final UUID id_ability;

    public Volunteer_Ability(@JsonProperty("id") UUID id, @JsonProperty("id_volunteer") UUID id_volunteer, @JsonProperty("id_ability") UUID id_ability) {
        this.id = id;
        this.id_volunteer = id_volunteer;
        this.id_ability = id_ability;
    }

    public UUID getId() {
        return id;
    }

    public UUID getId_volunteer() {
        return id_volunteer;
    }

    public UUID getId_ability() {
        return id_ability;
    }

}