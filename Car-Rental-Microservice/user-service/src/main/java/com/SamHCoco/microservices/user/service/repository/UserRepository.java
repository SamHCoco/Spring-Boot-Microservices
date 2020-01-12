package com.SamHCoco.microservices.user.service.repository;

import com.SamHCoco.microservices.user.service.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByuserName(String userName);
    boolean existsByuserName(String userName);
}
