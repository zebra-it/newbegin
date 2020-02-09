package com.newbegin.project.newbegin.service;

import com.newbegin.project.newbegin.model.Post;
import com.newbegin.project.newbegin.model.Tag;
import com.newbegin.project.newbegin.model.User;
import com.newbegin.project.newbegin.repository.PostRepository;
import com.newbegin.project.newbegin.repository.TagRepository;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    public Iterable<Post> showAll() {
        return postRepository.findAll();
    }

    public List<Post> postList() {
        List<Post> posts = new ArrayList<>();
        Iterable<Post> posts1 = showAll();
        posts1.forEach(posts::add);
        return posts;
    }

    @Transactional
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    public boolean addNewPost(Post post, User user, Model model) {

        LocalTime localTime = new LocalTime();
        String date = new LocalDate().toString();
        post.setCreateTime(localTime.getHourOfDay() + ":" + localTime.getMinuteOfHour());
        post.setCreateDate(date);

        post.setAuthor(user);

        model.addAttribute("post", null);

        if (!isTagExists(post.getTags()) && post.getTags() != null) {
            Tag tag = new Tag(post.getTags());
            tag.setCreateDate(date);
            tag.setCreateTime(localTime.getHourOfDay() + ":" + localTime.getMinuteOfHour());
            tagRepository.save(tag);
        }

        postRepository.save(post);
        return true;
    }


    public boolean isTagExists(String textTag) {
        Iterable<Tag> tags = tagRepository.findAll();
        List<Tag> c = new ArrayList<>();
        tags.forEach(c::add);
        List<String> tagsList =
                c.stream().map(Tag::getTextTag)
                        .collect(Collectors.toList());
        return tagsList.contains(textTag);
    }


    public List<Post> findPostByText(String text) {
        List<Post> textContains = postRepository.findByTextContains(text);
        if (textContains.isEmpty()) {
            return postRepository.findByTags(text);
        }

        return textContains;
    }

    public List<Post> findInTags(String text) {
        return postRepository.findByTags(text);
    }

    public List<Post> orderByTime() {

        return null;
    }

    public List<String> toptags() {
        return postRepository.postTag();
    }

    public List<String> findQuery() {
        return postRepository.postTag();
    }


}
