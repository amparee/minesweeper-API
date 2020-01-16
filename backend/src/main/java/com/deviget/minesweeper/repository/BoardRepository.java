package com.deviget.minesweeper.repository;

import com.deviget.minesweeper.entity.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BoardRepository extends MongoRepository<Board, String> {

    public Board save(Board board);
    public Optional<Board> findById(String id);


}


