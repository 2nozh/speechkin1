package com.example.speechkin1.dao;

import com.example.speechkin1.models.Post;
import com.example.speechkin1.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;
import java.util.List;

@Component
public class PostDAO {

    private final PostsRepository postsRepository;

    @Autowired
    public PostDAO(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }


    public List<Post> getAllPosts() {
        return postsRepository.findAll(Sort.by(Sort.Direction.ASC,"date"));
    }


    public Post getPostById(int id) {

        return postsRepository.findAll().stream().filter(post -> post.getId() == id).findAny().orElse(null);
    }

    public void addPost(Post post) {
        post.setDate(Calendar.getInstance().getTime());
        postsRepository.save(post);
    }

    public void addPost(MultipartFile file) {
        FileConvert fileConvert = new FileConvert();
        addPost(fileConvert.getPost(file));
    }
}
