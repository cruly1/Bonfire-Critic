package hu.unideb.inf.thesis.bonfirecritic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.unideb.inf.thesis.bonfirecritic.model.Platform;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameDTO {
    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Developer is mandatory")
    private String developer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private Set<Platform> platforms;
    private SpecsDTO minSpecs;
    private SpecsDTO recommendedSpecs;
    private Set<String> actors;
}
