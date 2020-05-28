package cl.tbd.back.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cl.tbd.back.model.Institution;

public interface InstitutionDao {
    
    int insertInstitution(UUID id, Institution institution);

    default int insertInstitution(Institution institution) {
        UUID id = UUID.randomUUID();
        return insertInstitution(id, institution);
    }

    List<Institution> selectAllInstitutions();

    Optional<Institution> selectInstitutionById(UUID id);

    int updateInstitutionNameById(UUID id, Institution institution);

    int deleteInstitutionById(UUID id);

}