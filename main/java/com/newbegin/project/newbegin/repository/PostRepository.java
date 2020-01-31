package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Override
    void deleteById(Long id);

    @Override
    Optional<Post> findById(Long aLong);

    List<Post> findByTextContains(String text);


}
