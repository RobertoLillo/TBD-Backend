package cl.tbd.back.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.tbd.back.dao.RankingDao;
import cl.tbd.back.model.Ranking;

@Service
public class RankingService {

    private final RankingDao rankingDao;

    @Autowired
    public RankingService(@Qualifier("postgresRanking") RankingDao rankingDao) {
        this.rankingDao = rankingDao;
    }

    public int insertRanking(Ranking ranking) {
        return rankingDao.insertRanking(ranking);
    }

    public List<Ranking> selectAllRankings() {
        return rankingDao.selectAllRankings();
    }

    public Optional<Ranking> selectRankingById(UUID id) {
        return rankingDao.selectRankingById(id);
    }

    public int updateRankingScoreById(UUID id, Ranking ranking) {
        return rankingDao.updateRankingScoreById(id, ranking);
    }

    public int updateRankingFlagParticipaById(UUID id, Ranking ranking) {
        return rankingDao.updateRankingFlagParticipaById(id, ranking);
    }

    public int deleteRankingById(UUID id) {
        return rankingDao.deleteRankingById(id);
    }
 
    
}