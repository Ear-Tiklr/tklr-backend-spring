package ai.eartikle.backend.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "musics")
@Data
public class Music {

    @Transient
    public static final String SEQUENCE_NAME = "musics_sequence";

    @Id
    private Long id;
    private String name;
    private String src;
    private String artist;
    @Indexed
    private Long artistId;
    private String coverImage;
    private String avatar;
    @Indexed
    private int playedCount;

}