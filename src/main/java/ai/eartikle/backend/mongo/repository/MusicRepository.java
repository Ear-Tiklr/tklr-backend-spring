package ai.eartikle.backend.mongo.repository;


import ai.eartikle.backend.mongo.entity.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicRepository extends MongoRepository<Music, Long> {
}