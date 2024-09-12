package com.Synergastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "blog_posts")
public class BlogPost {

    @Id
    private String id; // MongoDB uses String for IDs by default
    private String title;
    private String content;
    private String imageName;

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
    public String getImageUrl() {
        return "https://res.cloudinary.com/dmk4fps6v/image/upload/" + imageName;
    }
    
}
