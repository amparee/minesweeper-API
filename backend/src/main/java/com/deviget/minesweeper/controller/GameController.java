package com.deviget.minesweeper.controller;

import com.deviget.minesweeper.entity.Board;
import com.deviget.minesweeper.entity.Game;
import com.deviget.minesweeper.service.IGameService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private IGameService gameService;

    private final Log log = LogFactory.getLog(GameController.class);

    @GetMapping("/health-check")
    public ResponseEntity<String> healthcheck() {
        log.info("Method: Health-check in GameController");
        return ResponseEntity.ok("Health check ok");
    }


    @GetMapping("/right-click")
    public ResponseEntity<String> rightClick() {
        return ResponseEntity.ok("new Board(8, 3)");
    }


    @GetMapping("/left-click")
    public ResponseEntity<String> leftClick() {
        return ResponseEntity.ok("");
    }


    @GetMapping("/new-game/{x}/{y}/{mines}")
    public ResponseEntity<String> newGame(@PathVariable("x") int x,
                                          @PathVariable("y") int y,
                                          @PathVariable("mines") int mines) {
        log.info("Method newGame in GameController with params: " +  "X: " + x +
                                                                        "Y: " + y +
                                                                        "Mines " + mines);
        Game game = gameService.newGame(x,y,mines);
        return ResponseEntity.ok("New game initialized " + game.toString());
    }

    @PostMapping("/save-game")
    public ResponseEntity<String> saveGame(Game game) {
        gameService.saveGame(game);
        return ResponseEntity.ok("");
    }


}
