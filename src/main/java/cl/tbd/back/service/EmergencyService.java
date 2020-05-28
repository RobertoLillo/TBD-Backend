package cl.tbd.back.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.tbd.back.dao.EmergencyDao;
import cl.tbd.back.model.Emergency;

@Service
public class EmergencyService {
    
    private final EmergencyDao emergencyDao;

    @Autowired
    public EmergencyService(@Qualifier("postgresEmergency") EmergencyDao emergencyDao) {
        this.emergencyDao = emergencyDao;
    }

    public int insertEmergency(Emergency emergency) {
        return emergencyDao.insertEmergency(emergency);
    }

    public List<Emergency> selectAllEmergencies() {
        return emergencyDao.selectAllEmergencies();
    }

    public Optional<Emergency> selectEmergencyById(UUID id) {
        return emergencyDao.selectEmergencyById(id);
    }

    public int updateEmergencyNameById(UUID id, Emergency emergency) {
        return emergencyDao.updateEmergencyNameById(id, emergency);
    }

    public int updateEmergencyDescriptionById(UUID id, Emergency emergency) {
        return emergencyDao.updateEmergencyDescriptionById(id, emergency);
    }

    public int updateEmergencyFinish_dateById(UUID id, Emergency emergency) {
        return emergencyDao.updateEmergencyFinish_dateById(id, emergency);
    }

    public int deleteEmergencyById(UUID id) {
        return emergencyDao.deleteEmergencyById(id);
    }
}