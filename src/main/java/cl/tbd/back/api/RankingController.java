package cl.tbd.back.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.back.model.Ranking;
import cl.tbd.back.service.RankingService;

@CrossOrigin
@RestController
public class RankingController {

    private final RankingService rankingService;

    @Autowired
    public RankingController(@Valid @NonNull RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @PostMapping("/api/v1/rankings")
    public void insertRanking(@RequestBody Ranking ranking) {
        rankingService.insertRanking(ranking);
    }

    @GetMapping("/api/v1/rankings")
    public List<Ranking> selectAllRankings() {
        return rankingService.selectAllRankings();
    }

    @GetMapping("/api/v1/rankings/{id}")
    public Ranking selectRankingById(@PathVariable("id") UUID id) {
        return rankingService.selectRankingById(id).orElse(null);
    }

    @PutMapping("/api/v1/rankings/score/{id}")
    public void updateRankingScoreById(@PathVariable("id") UUID id, @Valid @NonNull Ranking ranking) {
        rankingService.updateRankingScoreById(id, ranking);
    }

    @PutMapping("/api/v1/rankings/flag/{id}")
    public void updateRankingFlagParticipaById(@PathVariable("id") UUID id, @Valid @NonNull Ranking ranking) {
        rankingService.updateRankingFlagParticipaById(id, ranking);
    }

    @DeleteMapping("/api/v1/rankings/{id}")
    public void deleteRankingById(@PathVariable("id") UUID id) {
        rankingService.deleteRankingById(id);
    }

}