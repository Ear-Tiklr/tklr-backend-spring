package ai.eartikle.backend.controller;

import ai.eartikle.backend.mongo.entity.Music;
import ai.eartikle.backend.mongo.entity.Playlist;
import ai.eartikle.backend.mongo.entity.User;
import ai.eartikle.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Page<User> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        return userService.getAllUsers(page, size);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @PutMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user, null);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.saveUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{userId}/favorite-artists")
    public List<String> getUserFavoriteArtists(@PathVariable Long userId) {
        return userService.getUserFavoriteArtists(userId);
    }

    @GetMapping("/{userId}/favorites")
    public List<Music> getUserFavorites(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return user != null ? user.getFavorite() : null;
    }

    @GetMapping("/{userId}/playlists")
    public List<Playlist> getUserPlaylists(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return user != null ? user.getPlayLists() : null;
    }
}