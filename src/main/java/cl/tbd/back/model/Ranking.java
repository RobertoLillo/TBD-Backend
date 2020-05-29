package cl.tbd.back.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ranking {
    
    private final UUID id;

    @NotBlank
    private final UUID id_volunteer;

    @NotBlank
    private final UUID id_task;

    private final int score;

    @NotBlank
    private final boolean flag_invited;

    @NotBlank
    private final boolean flag_participated;

    public Ranking(@JsonProperty("id") UUID id,
                   @JsonProperty("id_volunteer") UUID id_volunteer,
                   @JsonProperty("id_task") UUID id_task,
                   @JsonProperty("score") int score,
                   @JsonProperty("flagInvited") boolean flag_invited,
                   @JsonProperty("flag_participated") boolean flag_participated) {
        this.id = id;
        this.id_volunteer = id_volunteer;
        this.id_task = id_task;
        this.score= score;
        this.flag_invited = flag_invited;
        this.flag_participated = flag_participated;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdVolunteer() {
        return id_volunteer;
    }

    public UUID getIdTask() {
        return id_task;
    }

    public int getScore() {
        return score;
    }

    public boolean getFlagInvited() {
        return flag_invited;
    }

    public boolean getFlagParticipated() {
        return flag_participated;
    }

}