package com.Synergastic.controller;

import com.Synergastic.Service.BlogService;
import com.Synergastic.model.BlogPost;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private BlogService blogService; // Service to handle business logic

    @Autowired
    private Cloudinary cloudinary; // Cloudinary bean for handling uploads

    @GetMapping
    public String listPosts(Model model) {
        model.addAttribute("PostsTitle","Synergistic - Consultancy | IT Services | Digital Transformation | Personal Growth | Posts");
        model.addAttribute("posts", blogService.getAllPosts());
        return "posts"; // Template to display all posts
    }

    @GetMapping("/{id}")
    public String getPost(@PathVariable String id, Model model) {
        Optional<BlogPost> post = blogService.getPostById(id);
        if (post.isPresent()) {
            model.addAttribute("PostDetail","Synergistic - Consultancy | IT Services | Digital Transformation | Personal Growth | PostDetails");
            model.addAttribute("post", post.get());
            return "post"; // Template to display a single post
        }
        model.addAttribute("errorMessage", "Post not found");
        return "error"; // Template to display errors
    }

    @GetMapping("/new")
    public String createPostForm(Model model) {
        model.addAttribute("post", new BlogPost());
        return "create_post"; // Template for creating a new post
    }

    @PostMapping
    public String savePost(@ModelAttribute BlogPost post, BindingResult result,
                           @RequestParam("image") MultipartFile imageFile, Model model) {
        if (result.hasErrors()) {
            return "create_post"; // Return to form if there are validation errors
        }

        if (!imageFile.isEmpty()) {
            try {
                @SuppressWarnings("unchecked")
                Map<String, Object> uploadResult = cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                String publicId = (String) uploadResult.get("public_id");
                post.setImageName(publicId); // Save the public ID in the post
            } catch (IOException e) {
                model.addAttribute("errorMessage", "Error uploading file: " + e.getMessage());
                return "create_post"; // Return to form on file upload error
            }
        }

        blogService.savePost(post); // Save the post
        return "redirect:/posts"; // Redirect to the list of posts
    }

}
