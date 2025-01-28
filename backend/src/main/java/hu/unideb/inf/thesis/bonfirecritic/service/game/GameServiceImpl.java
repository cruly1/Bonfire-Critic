package hu.unideb.inf.thesis.bonfirecritic.service.game;

import hu.unideb.inf.thesis.bonfirecritic.dto.GameDTO;
import hu.unideb.inf.thesis.bonfirecritic.exception.customexceptions.GameNotFoundException;
import hu.unideb.inf.thesis.bonfirecritic.mapper.GameMapper;
import hu.unideb.inf.thesis.bonfirecritic.mapper.SpecsMapper;
import hu.unideb.inf.thesis.bonfirecritic.model.Actor;
import hu.unideb.inf.thesis.bonfirecritic.model.Game;
import hu.unideb.inf.thesis.bonfirecritic.dao.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final SpecsMapper specsMapper;

    @Override
    public GameDTO createGame(GameDTO gameDTO) {
        Game game = gameMapper.toEntity(gameDTO);
        Game savedGame = gameRepository.save(game);
        return gameMapper.toDTO(savedGame);
    }

    @Override
    public GameDTO updateGame(Long id, GameDTO gameDTO) {
        Game existingGame = gameRepository.findById(id).orElseThrow(GameNotFoundException::new);

        existingGame.setTitle(gameDTO.getTitle());
        existingGame.setDeveloper(gameDTO.getDeveloper());
        existingGame.setReleaseDate(gameDTO.getReleaseDate());
        existingGame.setPlatforms(gameDTO.getPlatforms());
        existingGame.setMinSpecs(specsMapper.toEntity(gameDTO.getMinSpecs()));
        existingGame.setRecommendedSpecs(specsMapper.toEntity(gameDTO.getRecommendedSpecs()));
        existingGame.setActors(gameDTO.getActors().stream().map(actor -> Actor.builder().name(actor).build()).collect(Collectors.toSet()));

        Game updatedGame = gameRepository.save(existingGame);
        return gameMapper.toDTO(updatedGame);
    }

    @Override
    public GameDTO getGameById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(
                GameNotFoundException::new
        );
        return gameMapper.toDTO(game);
    }

    @Override
    public List<GameDTO> getAllGames() {
        List<Game> allGames = gameRepository.findAll();
        return allGames.stream()
                .map(gameMapper::toDTO)
                .toList();
    }

    @Override
    public String deleteGameById(Long id) {

        if (gameRepository.existsById(id)) {
            gameRepository.deleteById(id);
            return "Game deleted";
        }

        throw new GameNotFoundException();
    }

    @Override
    public List<GameDTO> searchGames(String keyword) {
        List<Game> searchedGames = gameRepository.findByTitleContainingIgnoreCase(keyword);
        return searchedGames.stream().map(gameMapper::toDTO).toList();
    }
}
