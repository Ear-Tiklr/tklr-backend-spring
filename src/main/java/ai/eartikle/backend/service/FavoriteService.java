package ai.eartikle.backend.service;


import ai.eartikle.backend.mongo.entity.Favorite;
import ai.eartikle.backend.mongo.entity.Music;
import ai.eartikle.backend.mongo.entity.User;
import ai.eartikle.backend.mongo.repository.FavoriteRepository;
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
public class FavoriteService {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    public Page<Favorite> getAllFavorites(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return favoriteRepository.findAll(pageable);
    }

    public List<Music> getFavoritesByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.isPresent() ? user.get().getFavorite() : new ArrayList<>();
    }

    public Favorite saveFavorite(Favorite favorite) {
        favorite.setId(sequenceGeneratorService.generateSequence(Favorite.SEQUENCE_NAME));

        return favoriteRepository.save(favorite);
    }

    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }
}