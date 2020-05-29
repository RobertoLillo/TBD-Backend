package cl.tbd.back.dao.das;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.back.dao.InstitutionDao;
import cl.tbd.back.model.Institution;

@Repository("postgresInstitution")
public class InstitutionDataAccessService implements InstitutionDao{
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertInstitution(UUID id, Institution institution) {
        final String sql = "INSERT INTO institutions (id, name) VALUES (:id, :name)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("name", institution.getName())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public List<Institution> selectAllInstitutions() {
        final String sql = "SELECT * FROM institutions";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .executeAndFetch(Institution.class);
        }
    }

    @Override
    public Optional<Institution> selectInstitutionById(UUID id) {
        final String sql = "SELECT * FROM institutions WHERE id = :searchId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .addParameter("searchId", id)
                .executeAndFetch(Institution.class)
                .stream()
                .findFirst();
        }
    }

    @Override
    public int updateInstitutionNameById(UUID id, Institution institution) {
        final String sql = "UPDATE institutions SET name = :name WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("name", institution.getName())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int deleteInstitutionById(UUID id) {
        final String sql = "DELETE FROM institutions WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .executeUpdate();
            return 0;
        }
    }

}