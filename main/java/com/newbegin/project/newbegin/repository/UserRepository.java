package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByActivationCode(String code);

    User findByEmail(String email);

    void deleteById(long id);

    @Query("select u.email from User u where u.email = :email")
    String getEmail(@Param("email") String email);
}
