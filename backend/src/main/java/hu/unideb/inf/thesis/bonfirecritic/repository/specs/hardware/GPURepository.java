package hu.unideb.inf.thesis.bonfirecritic.repository.specs.hardware;

import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.GPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GPURepository extends JpaRepository<GPU, Long> {
    Optional<GPU> findByModel(String name);
}
