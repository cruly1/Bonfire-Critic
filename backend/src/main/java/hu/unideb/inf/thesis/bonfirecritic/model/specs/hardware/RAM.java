package hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rams")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RAM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int sizeInGB;
}
