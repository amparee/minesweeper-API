package com.deviget.minesweeper.controller;

import com.deviget.minesweeper.entity.Board;
import com.deviget.minesweeper.service.IGameService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/new-game")
    public ResponseEntity<String> newGame() {
        return ResponseEntity.ok("");
    }

    @PostMapping("/save-game")
    public ResponseEntity<String> saveGame(Board board) {
        gameService.saveBoard(board);
        return ResponseEntity.ok("");
    }


}
