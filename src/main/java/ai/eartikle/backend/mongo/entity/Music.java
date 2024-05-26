package ai.eartikle.backend.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "musics")
@Data
public class Music {
    @Id
    private Long id;
    private String name;
    private String src;
    private String artist;
    private String coverImage;
    private String avatar;
    private int playedCount;

}