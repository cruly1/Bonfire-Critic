package hu.unideb.inf.thesis.bonfirecritic.repository.specs.hardware;

import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.CPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CPURepository extends JpaRepository<CPU, Long> {
    Optional<CPU> findByModel(String name);
}
