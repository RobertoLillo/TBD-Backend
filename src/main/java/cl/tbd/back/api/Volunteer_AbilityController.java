package cl.tbd.back.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.back.model.Volunteer_Ability;
import cl.tbd.back.service.Volunteer_AbilityService;

@CrossOrigin
@RestController
public class Volunteer_AbilityController {

    private final Volunteer_AbilityService volunteer_abilityService;

    @Autowired
    public Volunteer_AbilityController(@Valid @NonNull Volunteer_AbilityService volunteer_abilityService) {
        this.volunteer_abilityService = volunteer_abilityService;
    }

    @PostMapping("/api/v1/volunteers_abilities")
    public void insertVolunteer_Ability(@RequestBody Volunteer_Ability volunteer_ability) {
        volunteer_abilityService.insertVolunteer_Ability(volunteer_ability);
    }

    @GetMapping("/api/v1/volunteers_abilities")
    public List<Volunteer_Ability> selectAllVolunteers_Abilities() {
        return volunteer_abilityService.selectAllVolunteers_Abilities();
    }

    @GetMapping("/api/v1/volunteers_abilities/{id}")
    public Volunteer_Ability selectVolunteer_AbilityById(@PathVariable("id") UUID id) {
        return volunteer_abilityService.selectVolunteer_AbilityById(id).orElse(null);
    }

    @DeleteMapping("/api/v1/volunteers_abilities/{id}")
    public void deleteVolunteer_AbilityById(@PathVariable("id") UUID id) {
        volunteer_abilityService.deleteVolunteer_AbilityById(id);
    }

}