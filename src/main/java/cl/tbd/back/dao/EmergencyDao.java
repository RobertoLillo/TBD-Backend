package cl.tbd.back.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cl.tbd.back.model.Emergency;

public interface EmergencyDao {
    
    int insertEmergency(UUID id, Emergency emergency);

    default int insertEmergency(Emergency emergency) {
        UUID id = UUID.randomUUID();
        return insertEmergency(id, emergency);
    }

    List<Emergency> selectAllEmergencies();

    Optional<Emergency> selectEmergencyById(UUID id);

    int updateEmergencyNameById(UUID id, Emergency emergency);

    int updateEmergencyDescriptionById(UUID id, Emergency emergency);

    int updateEmergencyFinish_dateById(UUID id, Emergency emergency);

    int deleteEmergencyById(UUID id);

}