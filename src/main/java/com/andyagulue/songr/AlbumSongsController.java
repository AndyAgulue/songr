package com.andyagulue.songr;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumSongsController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/addSongs")
    public String addAlbum(){
        return "addSongs.html";
    }

    @PostMapping("/addSongs")
    public RedirectView addSongs(String title, int length, int trackNumber, long id){
        Album singleAlbum = albumRepository.getOne(id);
        Song song = new Song(title, singleAlbum, length, trackNumber);
        songRepository.save(song);
        return new RedirectView("/addSongs");
    }
}
