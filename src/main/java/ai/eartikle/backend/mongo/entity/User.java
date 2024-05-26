package ai.eartikle.backend.mongo.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Data
public class User {
    @Id
    private Long id;
    private String email;
    private String password;
    private Long birthDate;
    private Long creationDate;
    private Long modificationDate;
    private String profileImage;
    private String userName;
    private List<Music> favorite;
    private List<Music> recent;
    private List<Playlist> playLists;

}