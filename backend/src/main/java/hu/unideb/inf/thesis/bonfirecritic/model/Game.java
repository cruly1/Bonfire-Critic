package hu.unideb.inf.thesis.bonfirecritic.model;

import hu.unideb.inf.thesis.bonfirecritic.model.specs.Specs;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String developer;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @ManyToMany
    @JoinTable(
            name = "game_platforms",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private Set<Platform> platforms = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "min_specs_id")
    private Specs minSpecs;

    @ManyToOne
    @JoinColumn(name = "rec_specs_id")
    private Specs recommendedSpecs;

    @ManyToMany
    @JoinTable(
            name = "game_actors",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors = new HashSet<>();
}
