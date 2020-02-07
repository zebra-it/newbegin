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
        LocalTime localTime = new LocalTime();
        String date = new LocalDate().toString();
        post.setCreateTime(localTime.getHourOfDay() + " : " + localTime.getMinuteOfHour());
        post.setCreateDate(date);
        post.setAuthor(user);

        model.addAttribute("post", null);

        postRepository.save(post);
        if (!isTagExists(post.getTags()) && post.getTags() != null) {
            Tag tag = new Tag(post.getTags());
            tagRepository.save(tag);
        }
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
        List<Post> posts = postRepository.OrderByCreateTimeAsc();
        return posts;
    }

    public List<String> toptags() {
        List<Post> posts = (List<Post>) showAll();
        List<String> tags = posts.stream().map(Post::getTags).collect(Collectors.toList());
        HashMap<String, Integer> tagTop = new HashMap<>();

        List<String> text = getTagsText(tags, tagTop);
        List<String> textTag = new ArrayList<>();

        for (int j = text.size() - 1; j >= 0; j--) {
            textTag.add(text.get(j));
        }
        return textTag;
    }

    public List<String> findQuery() {
        return postRepository.postTag();
    }



    private List<String> getTagsText(List<String> tags, HashMap<String, Integer> tagTop) {
        int i = 0;
        for (int n = 0; n < tags.size(); n = 0) {
            String st = tags.get(n);
            Iterator<String> iter = tags.iterator();
            while (iter.hasNext()) {
                String str = iter.next();
                if (st.equals(str)) {
                    i++;
                    iter.remove();
                }
            }
            tagTop.put(st, i);
            i = 0;
        }
        Map<String, Integer> result = tagTop.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<String> text = new ArrayList<>();
        Set<Map.Entry<String, Integer>> set = result.entrySet();
        for (Map.Entry<String, Integer> me : set) {
            if (me.getValue() >= 2) {
                text.add(me.getKey());
            }
        }
        return text;
    }


}
