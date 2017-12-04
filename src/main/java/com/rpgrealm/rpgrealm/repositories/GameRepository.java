package com.rpgrealm.rpgrealm.repositories;

import com.rpgrealm.rpgrealm.models.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    // empty interface body
    // we can define custom methods here, but for the exercise, all we need
    // are the methods that come from CrudRepository
    @Query( nativeQuery = true,
            value=
                    "SELECT * FROM games WHERE owner_id =?1")
    List<Game> findByUserId(Long user_id);


}
