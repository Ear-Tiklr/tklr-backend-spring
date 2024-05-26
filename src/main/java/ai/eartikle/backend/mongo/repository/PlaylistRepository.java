package ai.eartikle.backend.mongo.repository;

import ai.eartikle.backend.mongo.entity.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaylistRepository extends MongoRepository<Playlist, Long> {
}
