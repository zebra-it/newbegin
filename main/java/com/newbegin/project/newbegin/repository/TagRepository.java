package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    @Override
    Optional<Tag> findById(Long aLong);

    List<Tag> findByTextTagContains(String text);

}
