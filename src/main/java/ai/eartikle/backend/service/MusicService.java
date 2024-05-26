package ai.eartikle.backend.service;

import ai.eartikle.backend.mongo.entity.Music;
import ai.eartikle.backend.mongo.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MusicService {


    @Autowired
    private MusicRepository musicRepository;

    public Page<Music> getAllMusics(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return musicRepository.findAll(pageable);
    }

    public Music getMusicById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }

    public Music saveMusic(Music music) {
        return musicRepository.save(music);
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
