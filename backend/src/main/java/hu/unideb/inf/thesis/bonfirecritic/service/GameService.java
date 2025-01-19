package hu.unideb.inf.thesis.bonfirecritic.service;

import hu.unideb.inf.thesis.bonfirecritic.dto.GameDTO;
import hu.unideb.inf.thesis.bonfirecritic.exception.customexceptions.GameNotFoundException;
import hu.unideb.inf.thesis.bonfirecritic.mapper.GameMapper;
import hu.unideb.inf.thesis.bonfirecritic.model.Actor;
import hu.unideb.inf.thesis.bonfirecritic.model.Game;
import hu.unideb.inf.thesis.bonfirecritic.model.Platform;
import hu.unideb.inf.thesis.bonfirecritic.model.specs.Specs;
import hu.unideb.inf.thesis.bonfirecritic.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GameService {

    // dependencies
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final SpecsService specsService;
    private final ActorService actorService;
    private final PlatformService platformService;

    // get
    public GameDTO getGameById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(
                () -> new GameNotFoundException("Game not found")
        );
        return gameMapper.toDTO(game);
    }

    public List<GameDTO> getAllGames() {
        List<Game> allGames = gameRepository.findAll();
        return allGames.stream().map(gameMapper::toDTO).toList();
    }

    public List<GameDTO> searchGames(String keyword) {
        List<Game> searchedGames = gameRepository.findByTitleContainingIgnoreCase(keyword);
        return searchedGames.stream().map(gameMapper::toDTO).toList();
    }

    // post
    public GameDTO addGame(Game game) {
        Specs minSpecs = specsService.createSpecs(game.getMinSpecs());
        Specs recommendedSpecs = specsService.createSpecs(game.getRecommendedSpecs());

        game.setMinSpecs(minSpecs);
        game.setRecommendedSpecs(recommendedSpecs);

        Set<Actor> actors = new HashSet<>();
        for (Actor current : game.getActors()) {
            Actor actor = actorService.createActor(current.getName());
            actors.add(actor);
        }
        game.setActors(actors);

        Set<Platform> platforms = new HashSet<>();
        for (Platform current : game.getPlatforms()) {
            Platform platform = platformService.createPlatform(current.getName());
            platforms.add(platform);
        }
        game.setPlatforms(platforms);

        gameRepository.save(game);
        return gameMapper.toDTO(game);
    }

    // put
    public Game updateGameById(Long id, Game updatedGame) {
        Game game = gameRepository.findById(id).orElseThrow(
                () -> new GameNotFoundException("Game not found")
        );

        BeanUtils.copyProperties(updatedGame, game, "id");

        Specs minSpecs = specsService.createSpecs(game.getMinSpecs());
        Specs recommendedSpecs = specsService.createSpecs(game.getRecommendedSpecs());

        game.setMinSpecs(minSpecs);
        game.setRecommendedSpecs(recommendedSpecs);

        Set<Actor> actors = new HashSet<>();
        for (Actor current : game.getActors()) {
            Actor actor = actorService.createActor(current.getName());
            actors.add(actor);
        }
        game.setActors(actors);

        Set<Platform> platforms = new HashSet<>();
        for (Platform current : game.getPlatforms()) {
            Platform platform = platformService.createPlatform(current.getName());
            platforms.add(platform);
        }
        game.setPlatforms(platforms);

        return gameRepository.save(game);
    }

    // delete
    public String deleteGameById(Long id) {

        if (gameRepository.existsById(id)) {
            gameRepository.deleteById(id);
            return "Game deleted";
        }

        throw new GameNotFoundException("Game not found");
    }
}
