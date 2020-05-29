package cl.tbd.back.dao.das;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.back.dao.RankingDao;
import cl.tbd.back.model.Ranking;

@Repository("postgresRanking")
public class RankingDataAccessService implements RankingDao {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertRanking(UUID id, Ranking ranking) {
        String sql1 = "INSERT INTO rankings (id, id_volunteer, id_task, score, flag_invited, flag_participated) ";
        String sql2 = "VALUES (:id, :id_volunteer, :id_task, :score, :flag_invited, :flag_participated)";
        final String sql = sql1 + sql2;
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("id_volunteer", ranking.getIdVolunteer())
                .addParameter("id_task", ranking.getIdTask())
                .addParameter("score", ranking.getScore())
                .addParameter("flag_invited", ranking.getFlagInvited())
                .addParameter("flag_participated", ranking.getFlagParticipated())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public List<Ranking> selectAllRankings() {
        final String sql = "SELECT * FROM rankings";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .executeAndFetch(Ranking.class);
        }
    }

    @Override
    public Optional<Ranking> selectRankingById(UUID id) {
        final String sql = "SELECT * FROM rankings WHERE id = :searchId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .addParameter("searchId", id)
                .executeAndFetch(Ranking.class)
                .stream()
                .findFirst();
        }
    }

    @Override
    public int updateRankingScoreById(UUID id, Ranking ranking) {
        final String sql = "UPDATE rankings SET score = :score WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("score", ranking.getScore())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int updateRankingFlagParticipaById(UUID id, Ranking ranking) {
        final String sql = "UPDATE rankings SET flag_participated = :flag_participated WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("flag_participated", ranking.getFlagParticipated())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public int deleteRankingById(UUID id) {
        return 0;
    }
    
}