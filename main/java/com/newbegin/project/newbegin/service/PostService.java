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
import java.util.*;
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


    public Iterable<Tag> showTag() {
        return tagRepository.findAll();
    }


    @Transactional
    public void delete(long id) {
        postRepository.deleteById(id);
    }


    public Tag addTags(String textTag) {
        Tag tag = new Tag(textTag);
        tagRepository.save(tag);
        return tag;
    }


    public boolean addNewPost(Post post, User user, Model model) {


        if (!isTagExists(post.getTags()) & post.getTags() != null) {

            tagRepository.save(new Tag(post.getTags()));
        }

        LocalTime localTime = new LocalTime();
        String date = new LocalDate().toString();
        post.setCreateTime(localTime.getHourOfDay() + " : " + localTime.getMinuteOfHour());
        post.setCreateDate(date);
        post.setAuthor(user);

        model.addAttribute("post", null);

        postRepository.save(post);
        return true;
    }


    public Optional<Post> find(long id) {
        return postRepository.findById(id);
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

    private Long getTagId(String textTag) {
        Iterable<Tag> tags = tagRepository.findAll();
        Set<Tag> tagSet = new HashSet<>();
        tags.forEach(tagSet::add);
        List<Long> collect = tagSet.stream()
                .filter(tag -> tag.getTextTag().equals(textTag))
                .map(Tag::getId)
                .collect(Collectors.toList());
        return collect.get(0);
    }

    public List<Post> findPostByText(String text) {
        return postRepository.findByTextContains(text);
    }

    public List<Tag> findInTags(String text) {
        return tagRepository.findByTextTagContains(text);
    }


}
