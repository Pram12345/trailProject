package com.Synergastic.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Synergastic.Repository.BlogRepository;
import com.Synergastic.model.BlogPost;


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<BlogPost> getAllPosts() {
        return blogRepository.findAll();
    }

    public Optional<BlogPost> getPostById(String id) {
        return blogRepository.findById(id);
    }

    public BlogPost savePost(BlogPost post) {
        return blogRepository.save(post);
    }

//    public void deletePost(String id) {
//        blogRepository.deleteById(id);
//    }
}
