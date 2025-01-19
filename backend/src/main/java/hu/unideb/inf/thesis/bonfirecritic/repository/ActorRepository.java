package hu.unideb.inf.thesis.bonfirecritic.repository;

import hu.unideb.inf.thesis.bonfirecritic.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long>{
    Optional<Actor> findByName(String name);
}
