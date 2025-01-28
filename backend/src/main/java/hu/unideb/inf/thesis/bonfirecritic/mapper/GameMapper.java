package hu.unideb.inf.thesis.bonfirecritic.mapper;

import hu.unideb.inf.thesis.bonfirecritic.dto.GameDTO;
import hu.unideb.inf.thesis.bonfirecritic.model.Actor;
import hu.unideb.inf.thesis.bonfirecritic.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GameMapper {

    private final SpecsMapper specsMapper;

    public GameDTO toDTO(Game game) {
        return GameDTO.builder()
                .title(game.getTitle())
                .developer(game.getDeveloper())
                .releaseDate(game.getReleaseDate())
                .platforms(game.getPlatforms())
                .minSpecs(specsMapper.toDTO(game.getMinSpecs()))
                .recommendedSpecs(specsMapper.toDTO(game.getRecommendedSpecs()))
                .actors(game.getActors().stream().map(Actor::getName).collect(Collectors.toSet()))
                .build();
    }

    public Game toEntity(GameDTO gameDTO) {
        return Game.builder()
                .title(gameDTO.getTitle())
                .developer(gameDTO.getDeveloper())
                .releaseDate(gameDTO.getReleaseDate())
                .platforms(gameDTO.getPlatforms())
                .minSpecs(specsMapper.toEntity(gameDTO.getMinSpecs()))
                .recommendedSpecs(specsMapper.toEntity(gameDTO.getRecommendedSpecs()))
                .actors(gameDTO.getActors().stream().map(actor -> Actor.builder().name(actor).build()).collect(Collectors.toSet()))
                .build();
    }
}
