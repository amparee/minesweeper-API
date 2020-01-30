package com.deviget.minesweeper.controller;

import com.deviget.minesweeper.entity.Game;
import com.deviget.minesweeper.service.IGameService;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@CrossOrigin()
public class GameController {

    @Autowired
    private IGameService gameService;

    private final Log log = LogFactory.getLog(GameController.class);

    @GetMapping("/health-check")
    public ResponseEntity<String> healthcheck() {
        log.info("Method: Health-check in GameController");
        return ResponseEntity.ok("Health check ok");
    }


    //TODO right click sent to serverside
    @GetMapping("/right-click/{x}/{y}")
    public ResponseEntity<String> rightClick(@PathVariable("x") int x,
                                             @PathVariable("y") int y) {
        log.info("Method: right-click in GameController");
        return ResponseEntity.ok("right-click");
    }


    //TODO left click sent to server side
    @GetMapping("/left-click")
    public ResponseEntity<String> leftClick() {
        log.info("Method: left-click in GameController");
        return ResponseEntity.ok("left-click");
    }


    @GetMapping("/new-game/{x}/{y}/{mines}")
    public String newGame(@PathVariable("x") int x,
                               @PathVariable("y") int y,
                               @PathVariable("mines") int mines) {
        log.info("Method newGame in GameController with params: " +  "X: " + x +
                                                                        "Y: " + y +
                                                                        "Mines " + mines);
        Game game = gameService.newGame(x,y,mines);
        game = gameService.saveGame(game);
        Gson gson = new Gson();
        String json = gson.toJson(game);

        return json;
    }

    @PostMapping("/save-game")
    public ResponseEntity<Game> saveGame(Game game) {
        log.info("Method: saveGame in GameController");
        return new ResponseEntity<Game> (gameService.saveGame(game), HttpStatus.OK);
    }


}
