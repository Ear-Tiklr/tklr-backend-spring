package ai.eartikle.backend.mongo.repository;

import ai.eartikle.backend.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}