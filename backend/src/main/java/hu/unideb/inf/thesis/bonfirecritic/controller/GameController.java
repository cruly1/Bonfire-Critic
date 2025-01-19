package hu.unideb.inf.thesis.bonfirecritic.controller;

import hu.unideb.inf.thesis.bonfirecritic.dto.GameDTO;
import hu.unideb.inf.thesis.bonfirecritic.model.Game;
import hu.unideb.inf.thesis.bonfirecritic.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/games/")
@RequiredArgsConstructor
public class GameController {

    // Dependencies
    private final GameService gameService;

    // Get
    @GetMapping("getGameById/search")
    public ResponseEntity<GameDTO> getGameById(@RequestParam("id") Long id) {
        GameDTO gameDTO = gameService.getGameById(id);
        return ResponseEntity.ok(gameDTO);
    }

    @GetMapping("getAllGames")
    public ResponseEntity<List<GameDTO>> getAllGames() {
        List<GameDTO> gameDTOList = gameService.getAllGames();
        return ResponseEntity.ok(gameDTOList);
    }

    @GetMapping("searchGames/search")
    public ResponseEntity<List<GameDTO>> searchGames(@RequestParam("word") String keyword) {
        List<GameDTO> gameDTOList = gameService.searchGames(keyword);
        return ResponseEntity.ok(gameDTOList.size() > 5 ? gameDTOList.subList(0, 5) : gameDTOList);
    }

    // Post
    @PostMapping("addGame")
    public ResponseEntity<GameDTO> addGame(@RequestBody Game game) {
        GameDTO gameDTO = gameService.addGame(game);
        return new ResponseEntity<>(gameDTO, HttpStatus.CREATED);
    }

    // Put
    @PutMapping("updateGame/search")
    public ResponseEntity<Game> updateGameById(@RequestParam("id") Long id, @RequestBody Game updatedGame) {
        Game game = gameService.updateGameById(id, updatedGame);
        return new ResponseEntity<>(game, HttpStatus.ACCEPTED);
    }

    // Delete
    @DeleteMapping("deleteGameById/search")
    public ResponseEntity<String> deleteGameById(@RequestParam("id") Long id) {
        String response = gameService.deleteGameById(id);
        return ResponseEntity.ok(response);
    }
}
