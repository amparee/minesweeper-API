package com.deviget.minesweeper.repository;

import com.deviget.minesweeper.entity.Board;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends MongoRepository<Board, String> {
    public Board save(Board board);

    public Optional<Board> findById(ObjectId id);
}


