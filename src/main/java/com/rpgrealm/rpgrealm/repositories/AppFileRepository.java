package com.rpgrealm.rpgrealm.repositories;

import com.rpgrealm.rpgrealm.models.AppFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppFileRepository extends CrudRepository<AppFile, String> {
  // empty interface body
  // we can define custom methods here, but for the exercise, all we need
  // are the methods that come from CrudRepository
//   Code to select based of of old file structure
//    SELECT *
//    FROM characters c
//    JOIN app_files af on af.character_id = c.id
//    WHERE af.user_id = ?1;
}