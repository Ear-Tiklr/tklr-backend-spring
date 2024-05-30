package ai.eartikle.backend.service;

import ai.eartikle.backend.mongo.entity.Artist;
import ai.eartikle.backend.mongo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private ArtistRepository artistRepository;

    public Page<Artist> getAllArtists(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return artistRepository.findAll(pageable);
    }

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    public Artist saveArtist(Artist artist) {
        artist.setId(sequenceGeneratorService.generateSequence(Artist.SEQUENCE_NAME));
        return artistRepository.save(artist);
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

    public Page<Artist> getTopArtists(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "musics.playedCount"));
        return artistRepository.findAll(pageable);
    }
}