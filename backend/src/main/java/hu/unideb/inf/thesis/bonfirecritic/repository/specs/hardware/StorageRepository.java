package hu.unideb.inf.thesis.bonfirecritic.repository.specs.hardware;

import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long>{
    Optional<Storage> findBySizeInGB(long id);
}
