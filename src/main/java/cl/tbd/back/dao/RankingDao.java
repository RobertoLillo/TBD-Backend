package cl.tbd.back.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cl.tbd.back.model.Ranking;

public interface RankingDao {

    int insertRanking(UUID id, Ranking ranking);

    default int insertRanking(Ranking ranking) {
        UUID id = UUID.randomUUID();
        return insertRanking(id, ranking);
    }

    List<Ranking> selectAllRankings();

    Optional<Ranking> selectRankingById(UUID id);

    int updateRankingScoreById(UUID id, Ranking ranking);

    int updateRankingFlagParticipaById(UUID id, Ranking ranking);

    int deleteRankingById(UUID id);
    
}