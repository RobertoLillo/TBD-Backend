package cl.tbd.back.dao.das;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.back.dao.EmergencyDao;
import cl.tbd.back.model.Emergency;

@Repository("postgresEmergency")
public class EmergencyDataAccessService implements EmergencyDao {
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertEmergency(UUID id, Emergency emergency) {
        String sql1 = "INSERT INTO emergencies (id, id_institution, name, description, start_date, finish_date) ";
        String sql2 = "VALUES (:id, :id_institution, :name, :description, :start_date, :finish_date)";
        final String sql = sql1 + sql2;
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("id_institution", emergency.getIdInstitution())
                .addParameter("name", emergency.getName())
                .addParameter("description", emergency.getDescription())
                .addParameter("start_date", emergency.getStartDate())
                .addParameter("finish_date", emergency.getFinishDate())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public List<Emergency> selectAllEmergencies() {
        final String sql = "SELECT id, id_institution, name, description, start_date, finish_date FROM emergencies";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Emergency.class);
        }
    }

    @Override
    public Optional<Emergency> selectEmergencyById(UUID id) {
        String sql1 = "SELECT id, id_institution, name, description, start_date, finish_date FROM emergencies ";
        String sql2 = "WHERE id = :searchId";
        final String sql = sql1 + sql2;
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("searchId", id).executeAndFetch(Emergency.class).stream()
                    .findFirst();
        }
    }

    @Override
    public int updateEmergencyNameById(UUID id, Emergency emergency) {
        final String sql = "UPDATE emergencies SET name = :name WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", id).addParameter("name", emergency.getName())
                    // .addParameter("description", emergency.getDescription())
                    // .addParameter("start_date", emergency.getStart_date())
                    // .addParameter("finish_date", emergency.getFinish_date())
                    // .addParameter("id_institution", emergency.getId_institution())
                    .executeUpdate();
            return 0;
        }
    }

    @Override
    public int updateEmergencyDescriptionById(UUID id, Emergency emergency) {
        final String sql = "UPDATE emergencies SET description = :description WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", id)
                    // .addParameter("name", emergency.getName())
                    .addParameter("description", emergency.getDescription())
                    // .addParameter("start_date", emergency.getStart_date())
                    // .addParameter("finish_date", emergency.getFinish_date())
                    // .addParameter("id_institution", emergency.getId_institution())
                    .executeUpdate();
            return 0;
        }
    }

    @Override
    public int updateEmergencyFinishDateById(UUID id, Emergency emergency) {
        final String sql = "UPDATE emergencies SET finish_date = :finish_date WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", id)
                    // .addParameter("name", emergency.getName())
                    // .addParameter("description", emergency.getDescription())
                    // .addParameter("start_date", emergency.getStart_date())
                    .addParameter("finish_date", emergency
                            .getFinishDate())
                //.addParameter("id_institution", emergency.getId_institution())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int deleteEmergencyById(UUID id) {
        return 0;
    }
}