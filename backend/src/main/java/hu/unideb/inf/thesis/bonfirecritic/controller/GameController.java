package hu.unideb.inf.thesis.bonfirecritic.controller;

import hu.unideb.inf.thesis.bonfirecritic.dto.GameDTO;
import hu.unideb.inf.thesis.bonfirecritic.service.game.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/createGame")
    public ResponseEntity<GameDTO> createGame(@Valid @RequestBody GameDTO gameDTO) {
        GameDTO createdGame = gameService.createGame(gameDTO);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    @GetMapping("/getGameById/search")
    public ResponseEntity<GameDTO> getGameById(@RequestParam("id") Long id) {
        GameDTO gameDTO = gameService.getGameById(id);
        return ResponseEntity.ok(gameDTO);
    }

    @GetMapping("/getAllGames")
    public ResponseEntity<List<GameDTO>> getAllGames() {
        List<GameDTO> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @PutMapping("/updateGame/search")
    public ResponseEntity<GameDTO> updateGame(@RequestParam("id") Long id, @Valid @RequestBody GameDTO gameDTO) {
        GameDTO updatedGame = gameService.updateGame(id, gameDTO);
        return ResponseEntity.ok(updatedGame);
    }

    @DeleteMapping("/deleteGameById/search")
    public ResponseEntity<String> deleteGameById(@RequestParam("id") Long id) {
        String response = gameService.deleteGameById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/searchGames/search")
    public ResponseEntity<List<GameDTO>> searchGames(@RequestParam("wd") String keyword) {
        List<GameDTO> gameDTOList = gameService.searchGames(keyword);
        return ResponseEntity.ok(gameDTOList.size() > 5 ? gameDTOList.subList(0, 5) : gameDTOList);
    }
}
