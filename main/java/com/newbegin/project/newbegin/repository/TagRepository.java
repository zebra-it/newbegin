package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
