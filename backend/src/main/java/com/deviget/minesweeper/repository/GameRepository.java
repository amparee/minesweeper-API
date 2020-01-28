package com.deviget.minesweeper.repository;

import com.deviget.minesweeper.entity.Game;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    public Game save(Game game);
    public Optional<Game> findById(ObjectId id);
}
