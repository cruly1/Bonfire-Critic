package hu.unideb.inf.thesis.bonfirecritic.model.specs;

import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.CPU;
import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.GPU;
import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.RAM;
import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.Storage;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "specs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cpu_id", nullable = false)
    private CPU cpu;

    @ManyToOne
    @JoinColumn(name = "gpu_id", nullable = false)
    private GPU gpu;

    @ManyToOne
    @JoinColumn(name = "ram_id", nullable = false)
    private RAM ram;

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;
}
