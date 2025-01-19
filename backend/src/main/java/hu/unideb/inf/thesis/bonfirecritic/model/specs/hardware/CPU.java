package hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cpus")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String model;
}
