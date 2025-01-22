package hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "storages")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "size_in_gb")
    private int sizeInGB;
}
