package hu.unideb.inf.thesis.bonfirecritic.service.game;

import hu.unideb.inf.thesis.bonfirecritic.dto.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO createGame(GameDTO gameDTO);
    GameDTO updateGame(Long id, GameDTO gameDTO);
    GameDTO getGameById(Long id);
    List<GameDTO> getAllGames();
    String deleteGameById(Long id);
    List<GameDTO> searchGames(String keyword);
}
