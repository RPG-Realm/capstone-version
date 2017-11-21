package com.rpgrealm.rpgrealm.repositories;

import com.rpgrealm.rpgrealm.models.AppFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppFileRepository extends CrudRepository<AppFile, String> {
  // empty interface body
  // we can define custom methods here, but for the exercise, all we need
  // are the methods that come from CrudRepository
}