package ai.eartikle.backend.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "artists")
@Data
public class Artist {
    @Transient
    public static final String SEQUENCE_NAME = "artist_sequence";
    @Id
    private Long id;
    private String name;
    private String avatar;
    private List<Music> musics;
}