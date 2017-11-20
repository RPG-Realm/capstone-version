package com.rpgrealm.rpgrealm.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface RealmRepository extends CrudRepository<Post, Long> {
    // empty interface body
    // we can define custom methods here, but for the exercise, all we need
    // are the methods that come from CrudRepository
}
