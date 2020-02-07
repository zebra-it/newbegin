package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    void deleteById(Long id);


    @Query(value = "SELECT * FROM posts",
            nativeQuery = true)
    List<Post> findAllPosts();


    @Query("from Post p where p.tags=:tag")
    List<Post> allTags(@Param("tag") String tag);

    @Query("select p.tags from Post p order by rand()")
    List<String> postTag();



    List<Post> findByTextContains(String text);

    List<Post> OrderByCreateTimeAsc();

    List<Post> findByTags(String tag);


}
