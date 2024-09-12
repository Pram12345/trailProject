package com.Synergastic.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import com.Synergastic.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
