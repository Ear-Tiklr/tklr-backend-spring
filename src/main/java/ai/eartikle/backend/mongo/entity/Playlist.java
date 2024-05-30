package ai.eartikle.backend.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "playlists")
public class Playlist {
    public static final String SEQUENCE_NAME = "playlist_sequence";

    @Id
    private Long id;
    private Long creationDate;
    private String title;
    private String description;
    private String color;
    private String avatar;
    private List<Music> musics;
}