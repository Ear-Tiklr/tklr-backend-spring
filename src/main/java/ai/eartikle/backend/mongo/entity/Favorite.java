package ai.eartikle.backend.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "favorites")
@Data
public class Favorite {
    public static final String SEQUENCE_NAME = "favorite_sequence";

    @Id
    private Long id;
    private Long userId; // assuming a userId field to track which user favorited the music
    private Long musicId;
}