package com.rpgrealm.rpgrealm.repositories;

import com.rpgrealm.rpgrealm.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Long>{
    // Query methods -> finder methods
    User findByUsername(String username);
}
