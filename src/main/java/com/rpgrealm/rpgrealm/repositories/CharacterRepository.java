package com.rpgrealm.rpgrealm.repositories;

import com.rpgrealm.rpgrealm.models.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
  // empty interface body
  // we can define custom methods here, but for the exercise, all we need
  // are the methods that come from CrudRepository
}
