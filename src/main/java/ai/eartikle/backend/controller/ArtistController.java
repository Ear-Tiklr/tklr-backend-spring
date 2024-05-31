package ai.eartikle.backend.controller;

import ai.eartikle.backend.mongo.entity.Artist;
import ai.eartikle.backend.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public Page<Artist> getAllArtists(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
        return artistService.getAllArtists(page, size);
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artistService.getArtistById(id);
    }

    @PostMapping
    @PutMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }


    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
    }

    @GetMapping("/top-artists")
    public Page<Artist> getTopArtists(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return artistService.getTopArtists(page, size);
    }

}