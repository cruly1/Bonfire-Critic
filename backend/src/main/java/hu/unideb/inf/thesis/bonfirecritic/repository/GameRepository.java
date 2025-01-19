package hu.unideb.inf.thesis.bonfirecritic.repository;

import hu.unideb.inf.thesis.bonfirecritic.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
    List<Game> findByTitleContainingIgnoreCase(String name);
}
