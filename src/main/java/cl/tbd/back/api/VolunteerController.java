package cl.tbd.back.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.back.model.Volunteer;
import cl.tbd.back.service.VolunteerService;

@RequestMapping("api/v1/volunteers")
@RestController
public class VolunteerController {

    private final VolunteerService volunteerService;

    @Autowired
    public VolunteerController(@Valid @NonNull VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @PostMapping
    public void insertVolunteer(@RequestBody Volunteer volunteer) {
        volunteerService.insertVolunteer(volunteer);
    }

    @GetMapping
    public List<Volunteer> selectAllVolunteer() {
        return volunteerService.selectAllVolunteers();
    }

    @GetMapping(path = "{id}")
    public Volunteer selectVolunteerById(@PathVariable("id") UUID id) {
        return volunteerService.selectVolunteerById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateVolunteerNameById(@PathVariable("id") UUID id, @Valid @NonNull Volunteer volunteer) {
        volunteerService.updateVolunteerNameById(id, volunteer);
    }

    @DeleteMapping(path = "{id}")
    public void deleteVolunteerById(@PathVariable("id") UUID id) {
        volunteerService.deleteVolunteer(id);
    }

}