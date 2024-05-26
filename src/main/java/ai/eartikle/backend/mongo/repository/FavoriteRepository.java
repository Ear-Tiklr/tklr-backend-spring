package ai.eartikle.backend.mongo.repository;

import ai.eartikle.backend.mongo.entity.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FavoriteRepository extends MongoRepository<Favorite, Long> {
}