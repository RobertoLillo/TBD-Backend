package cl.tbd.back.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cl.tbd.back.model.Volunteer_Ability;

public interface Volunteer_AbilityDao {

    int insertVolunteer_Ability(UUID id, Volunteer_Ability volunteer_ability);

    default int insertVolunteer_Ability(Volunteer_Ability volunteer_ability) {
        UUID id = UUID.randomUUID();
        return insertVolunteer_Ability(id, volunteer_ability);
    }

    List<Volunteer_Ability> selectAllVolunteers_Abilities();

    Optional<Volunteer_Ability> selectVolunteer_AbilityById(UUID id);

    int deleteVolunteer_AbilityById(UUID id);

}