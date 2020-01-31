package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserReposiroty extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
