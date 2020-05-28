package cl.tbd.back.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.tbd.back.dao.Volunteer_AbilityDao;
import cl.tbd.back.model.Volunteer_Ability;

@Service
public class Volunteer_AbilityService {

    private final Volunteer_AbilityDao volunteer_abilityDao;

    @Autowired
    public Volunteer_AbilityService(@Qualifier("postgresVolunteer_Ability") Volunteer_AbilityDao volunteer_abilityDao) {
        this.volunteer_abilityDao = volunteer_abilityDao;
    }

    public int insertVolunteer_Ability(Volunteer_Ability volunteer_ability) {
        return volunteer_abilityDao.insertVolunteer_Ability(volunteer_ability);
    }

    public List<Volunteer_Ability> selectAllVolunteers_Abilities() {
        return volunteer_abilityDao.selectAllVolunteers_Abilities();
    }

    public Optional<Volunteer_Ability> selectVolunteer_AbilityById(UUID id) {
        return volunteer_abilityDao.selectVolunteer_AbilityById(id);
    }

    public int deleteVolunteer_AbilityById(UUID id) {
        return volunteer_abilityDao.deleteVolunteer_AbilityById(id);
    }

	public void inse(Volunteer_Ability volunteer_ability) {
	}
 
}