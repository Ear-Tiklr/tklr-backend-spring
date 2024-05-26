package ai.eartikle.backend.mongo.repository;

import ai.eartikle.backend.mongo.entity.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Artist, Long> {
}