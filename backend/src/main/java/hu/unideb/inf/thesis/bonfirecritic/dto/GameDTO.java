package hu.unideb.inf.thesis.bonfirecritic.dto;

import hu.unideb.inf.thesis.bonfirecritic.model.specs.Specs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private Long id;
    private String title;
    private String developer;
    private LocalDate releaseDate;
    private Set<PlatformDTO> platformsDTO = new HashSet<>();
    private Specs minSpecs;
    private Specs recommendedSpecs;
    private Set<ActorDTO> actorsDTO = new HashSet<>();
}
