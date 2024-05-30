package ai.eartikle.backend.service;

import ai.eartikle.backend.mongo.entity.Artist;
import ai.eartikle.backend.mongo.entity.Music;
import ai.eartikle.backend.mongo.repository.ArtistRepository;
import ai.eartikle.backend.mongo.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicService {


    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @Autowired
    private ArtistRepository artistRepository;

    public Page<Music> getAllMusics(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return musicRepository.findAll(pageable);
    }

    public Music getMusicById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }

    public Music saveMusic(Music music) {
        Optional<Artist> byId = artistRepository.findById(music.getArtistId());
        if(byId.isEmpty()) throw new RuntimeException("Artist not found");
        Artist artist = byId.get();
        music.setId(sequenceGeneratorService.generateSequence(Music.SEQUENCE_NAME));
        Music saved = musicRepository.save(music);
        artist.getMusics().add(saved);
        artistRepository.save(artist);
        return saved;
    }

    public void deleteMusic(Long id) {
        musicRepository.deleteById(id);
    }

    public Page<Music> getTopMusics(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "playedCount"));
        return musicRepository.findAll(pageable);
    }

    public Page<Music> getTrends(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "playedCount"));
        return musicRepository.findAll(pageable);
    }
}
