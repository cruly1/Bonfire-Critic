package hu.unideb.inf.thesis.bonfirecritic.repository.specs;

import hu.unideb.inf.thesis.bonfirecritic.model.specs.Specs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecsRepository extends JpaRepository<Specs, Long> {
}
