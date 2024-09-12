package com.Synergastic.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.Synergastic.model.BlogPost;

public interface BlogRepository extends MongoRepository<BlogPost, String> {
}