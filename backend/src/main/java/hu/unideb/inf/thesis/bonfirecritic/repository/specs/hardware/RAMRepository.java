package hu.unideb.inf.thesis.bonfirecritic.repository.specs.hardware;

import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RAMRepository extends JpaRepository<RAM, Long> {
    Optional<RAM> findBySizeInGB(int sizeInGB);
}
