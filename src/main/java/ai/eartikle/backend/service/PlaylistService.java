package ai.eartikle.backend.service;


import ai.eartikle.backend.mongo.entity.Playlist;
import ai.eartikle.backend.mongo.entity.User;
import ai.eartikle.backend.mongo.repository.PlaylistRepository;
import ai.eartikle.backend.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    public Page<Playlist> getAllPlaylists(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return playlistRepository.findAll(pageable);
    }

    public List<Playlist> getPlaylistsByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.isPresent() ? user.get().getPlayLists() : new ArrayList<>();
    }

    public Playlist getPlaylistById(Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}