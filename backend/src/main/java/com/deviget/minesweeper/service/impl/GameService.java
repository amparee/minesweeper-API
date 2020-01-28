package com.deviget.minesweeper.service.impl;

import com.deviget.minesweeper.entity.Board;
import com.deviget.minesweeper.repository.BoardRepository;
import com.deviget.minesweeper.service.IGameService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService implements IGameService {

    @Autowired
    private BoardRepository boardRepository;

    private Log log = LogFactory.getLog(GameService.class);

    @Override
    public Board initGame(int size) {

        int cell;
        Random random = new Random();
        boolean inGame = true;
        return null;
    }

    @Override
    public Board markFlag(int posX, int posY) {
        return null;
    }

    @Override
    public Board revealField(int posX, int posY) {
        return new Board(3,3);
    }

    @Override
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }
}
