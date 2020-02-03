package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);

    User findByEmail(String email);

    User findByResetCode(String code);
}
