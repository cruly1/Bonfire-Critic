package hu.unideb.inf.thesis.bonfirecritic.model;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String developer;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @ElementCollection(targetClass = Platform.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "game_platforms", joinColumns = @JoinColumn(name = "game_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "platform")
    private Set<Platform> platforms = new HashSet<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cpu", column = @Column(name = "min_processor")),
            @AttributeOverride(name = "ram", column = @Column(name = "min_ram")),
            @AttributeOverride(name = "gpu", column = @Column(name = "min_graphics_card")),
            @AttributeOverride(name = "storage", column = @Column(name = "min_storage"))
    })
    private Specs minSpecs;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "processor", column = @Column(name = "rec_processor")),
            @AttributeOverride(name = "ram", column = @Column(name = "rec_ram")),
            @AttributeOverride(name = "graphicsCard", column = @Column(name = "rec_graphics_card")),
            @AttributeOverride(name = "storage", column = @Column(name = "rec_storage"))
    })
    private Specs recommendedSpecs;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "game_actor",
        joinColumns = @JoinColumn(name = "game_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new HashSet<>();
}
