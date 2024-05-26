package ai.eartikle.backend.controller;

import ai.eartikle.backend.mongo.entity.Music;
import ai.eartikle.backend.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/musics")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping
    public Page<Music> getAllMusics(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return musicService.getAllMusics(page, size);
    }

    @GetMapping("/{id}")
    public Music getMusicById(@PathVariable Long id) {
        return musicService.getMusicById(id);
    }

    @PostMapping
    @PutMapping
    public Music createMusic(@RequestBody Music music) {
        return musicService.saveMusic(music);
    }

    @PutMapping("/id")
    public Music updateMusic(@PathVariable Long id, @RequestBody Music music) {
        return musicService.saveMusic(music);
    }

    @DeleteMapping("/{id}")
    public void deleteMusic(@PathVariable Long id) {
        musicService.deleteMusic(id);
    }

    @GetMapping("/top-musics")
    public Page<Music> getTopMusics(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return musicService.getTopMusics(page, size);
    }

    @GetMapping("/trends")
    public Page<Music> getTrends(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return musicService.getTrends(page, size);
    }
}