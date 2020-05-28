package cl.tbd.back.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.back.model.Volunteer;

@Repository("postgresVolunteer")
public class VolunteerDataAccessService implements VolunteerDao{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertVolunteer(UUID id, Volunteer volunteer) {
        final String sql = "INSERT INTO volunteers (id, name) VALUES (:id, :name)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("name", volunteer.getName())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public List<Volunteer> selectAllVolunteers() {
        final String sql = "SELECT id, name FROM volunteers";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .executeAndFetch(Volunteer.class);
        }
    }

    @Override
    public Optional<Volunteer> selectVolunteerById(UUID id) {
        final String sql = "SELECT id, name FROM volunteers WHERE id = :searchId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .addParameter("searchId", id)
                .executeAndFetch(Volunteer.class).stream().findFirst();
        }
    }

    @Override
    public int updateVolunteerNameById(UUID id, Volunteer volunteer) {
        final String sql = "UPDATE volunteers SET name = :name WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("name", volunteer.getName())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int deleteVolunteerById(UUID id) {
        return 0;
    }

}