package com.deviget.minesweeper.controller;

import com.deviget.minesweeper.entity.Board;
import com.deviget.minesweeper.service.IGameService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private IGameService gameService;

    private final Log log = LogFactory.getLog(GameController.class);

    @GetMapping("/health-check")
    public ResponseEntity<String> healthcheck(){
        return ResponseEntity.ok("Health check ok");
    }


    @GetMapping("/right-click")
    public ResponseEntity<Board> rightClick(){
        return ResponseEntity.ok(new Board(8, 3));
    }


    @GetMapping("/left-click")
    public ResponseEntity<Board> leftClick(){
        return ResponseEntity.ok(new Board(8, 3));
    }


    @GetMapping("/new-game")
    public ResponseEntity<Board> newGame(){
        return ResponseEntity.ok(new Board(8, 3));
    }

    @GetMapping("/save-game")
    public ResponseEntity<Board> saveGame(){
        return ResponseEntity.ok(new Board(8, 3));
    }


}
