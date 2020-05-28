package cl.tbd.back.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.tbd.back.dao.InstitutionDao;
import cl.tbd.back.model.Institution;

@Service
public class InstitutionService {
    
    private final InstitutionDao institutionDao;

    @Autowired
    public InstitutionService(@Qualifier("postgresInstitution") InstitutionDao institutionDao) {
        this.institutionDao = institutionDao;
    }

    public int insertInstitution(Institution institution) {
        return institutionDao.insertInstitution(institution);
    }

    public List<Institution> selectAllInstitutions() {
        return institutionDao.selectAllInstitutions();
    }

    public Optional<Institution> selectInstitutionById(UUID id) {
        return institutionDao.selectInstitutionById(id);
    }

    public int updateInstitutionNameById(UUID id, Institution institution) {
        return institutionDao.updateInstitutionNameById(id, institution);
    }

    public int deleteInstitution(UUID id) {
        return institutionDao.deleteInstitutionById(id);
    }

}