package cl.tbd.back.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.back.model.Emergency;

@Repository("postgresEmergency")
public class EmergencyDataAccessService implements EmergencyDao{
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertEmergency(UUID id, Emergency emergency) {
        final String sql = "INSERT INTO emergencies (id, name, description, start_date, finish_date, id_institution) VALUES (:id, :name, :description, :start_date, :finish_date, :id_institution)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("name", emergency.getName())
                .addParameter("description", emergency.getDescription())
                .addParameter("start_date", emergency.getStart_date())
                .addParameter("finish_date", emergency.getFinish_date())
                .addParameter("id_institution", emergency.getId_institution())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public List<Emergency> selectAllEmergencies() {
        final String sql = "SELECT id, name, description, start_date, finish_date, id_institution FROM emergencies";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .executeAndFetch(Emergency.class);
        }
    }

    @Override
    public Optional<Emergency> selectEmergencyById(UUID id) {
        final String sql = "SELECT id, name, description, start_date, finish_date, id_institution FROM emergencies WHERE id = :searchId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .addParameter("searchId", id)
                .executeAndFetch(Emergency.class).stream().findFirst();
        }
    }

    @Override
    public int updateEmergencyNameById(UUID id, Emergency emergency) {
        final String sql = "UPDATE emergencies SET name = :name WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("name", emergency.getName())
                //.addParameter("description", emergency.getDescription())
                //.addParameter("start_date", emergency.getStart_date())
                //.addParameter("finish_date", emergency.getFinish_date())
                //.addParameter("id_institution", emergency.getId_institution())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int updateEmergencyDescriptionById(UUID id, Emergency emergency) {
        final String sql = "UPDATE emergencies SET description = :description WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                //.addParameter("name", emergency.getName())
                .addParameter("description", emergency.getDescription())
                //.addParameter("start_date", emergency.getStart_date())
                //.addParameter("finish_date", emergency.getFinish_date())
                //.addParameter("id_institution", emergency.getId_institution())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int updateEmergencyFinish_dateById(UUID id, Emergency emergency) {
        final String sql = "UPDATE emergencies SET finish_date = :finish_date WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                //.addParameter("name", emergency.getName())
                //.addParameter("description", emergency.getDescription())
                //.addParameter("start_date", emergency.getStart_date())
                .addParameter("finish_date", emergency.getFinish_date())
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