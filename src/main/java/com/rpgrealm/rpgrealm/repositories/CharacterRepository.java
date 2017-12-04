package com.rpgrealm.rpgrealm.repositories;

import com.rpgrealm.rpgrealm.models.Character;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
  // empty interface body
  // we can define custom methods here, but for the exercise, all we need
  // are the methods that come from CrudRepository

//    @Query( nativeQuery = true,
//            value=
//            "SELECT * FROM characters WHERE user_id =?1")
//    List<Character> findByUserId(Long user_id);

    @Query( nativeQuery = true,
            value=
            "SELECT * FROM characters WHERE user_id=?")
    List<Character> findByUserId(Long user_id);

    // where name =?1 and description = ?2 or typ = ?3
    List<Character> findByNameAndDescriptionOrType(String name, String description, String type);
    @Query( nativeQuery = true,
            value=
                    "SELECT * FROM characters c JOIN characters_in_games cg on cg.character_id = c.id WHERE user_id =?1 AND game_id =?2"
    )
    List<Character> findByUserAndGame(Long user_id, Long game_id);
}
