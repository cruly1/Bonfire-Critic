package hu.unideb.inf.thesis.bonfirecritic.repository;

import hu.unideb.inf.thesis.bonfirecritic.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
    Optional<Platform> findByName(String name);
}
