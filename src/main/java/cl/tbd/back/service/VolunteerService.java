package cl.tbd.back.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.tbd.back.dao.VolunteerDao;
import cl.tbd.back.model.Volunteer;

@Service
public class VolunteerService {

    private final VolunteerDao volunteerDao;

    @Autowired
    public VolunteerService(@Qualifier("postgres") VolunteerDao volunteerDao) {
        this.volunteerDao = volunteerDao;
    }

    public int addVolunteer(Volunteer volunteer) {
        return volunteerDao.insertVolunteer(volunteer);
    }

    public List<Volunteer> getAllVolunteers() {
        return volunteerDao.selectAllVolunteers();
    }

    public Optional<Volunteer> getVolunteerById(UUID id) {
        return volunteerDao.selectVolunteerById(id);
    }

    public int updateVolunteerNameById(UUID id, Volunteer volunteer) {
        return volunteerDao.updateVolunteerNameById(id, volunteer);
    }

    public int deleteVolunteer(UUID id) {
        return volunteerDao.deleteVolunteerById(id);
    }

}