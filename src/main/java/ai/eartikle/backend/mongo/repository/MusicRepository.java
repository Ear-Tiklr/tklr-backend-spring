package ai.eartikle.backend.mongo.repository;


import ai.eartikle.backend.mongo.entity.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MusicRepository extends MongoRepository<Music, Long> {

    Page<Music> findByNameContainingIgnoreCase(String name, Pageable pageable);

}