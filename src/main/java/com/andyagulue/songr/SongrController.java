package com.andyagulue.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;


@Controller
public class  SongrController {
    @Autowired
    public AlbumRepository albumRepository;


    static ArrayList<Album> album = new ArrayList<>();
    //(String Artist, String Title, int songCount, int length)
    static {
        album.add(
                new Album("Travis Scott", "ASTROWORLD", 17, 58.42, "https://images.genius.com/4640c40bd4cec077ba11e54347624ac7.1000x563x1.jpg")
        );
        album.add(
                new Album("Quelle Chris", "Innocent Country", 16, 60.3, "http://cdn.shopify.com/s/files/1/0154/0333/products/IMG_0076_1200x1200.jpg?v=1611725537")
        );
        album.add(
                new Album("Noname", "Room 25", 11, 34.48, "https://media.pitchfork.com/photos/5b9939fe2f121f3b5aebae6c/2:1/w_1000/Noname_Room25.jpg")
        );
        System.out.println(album.get(1).title);
    }

    @GetMapping("/hello")
    public String renderHelloPage(Model m){
        m.addAttribute("greeting", "Hello World");
        return "hello-world.html";
    }

    @GetMapping("/capitalize/{var}")
    public String renderCapitalizePage(Model m, @PathVariable String var){
        m.addAttribute("word",var.toUpperCase());
        return "capitalize.html";
    }

    @GetMapping("/album")
    public String viewAlbum(Model m){
        List<Album> library = albumRepository.findAll();
        m.addAttribute("albumList", album);
       // m.addAttribute("albums", albumRepository.findAll());
        return "album.html";
    }

    @GetMapping("/")
    public String showSplash(){
        return "show-splash.html";
    }

    @GetMapping("/addAlbum")
    public String addAlbum(){

        return "addAlbum.html";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(
            String title,
            String artist,
            int songCount,
            double length,
            String imgUrl
    ){
        albumRepository.save(new Album(title, artist, songCount, length, imgUrl));
        return new RedirectView("/album");
    }
}


// Autowired will instantiate the albumRepository
// This is an interface, an instance of JPAREpositoryInteraction that implements AlbumRepository




//AlbumRepository.save() saves to database
//list<albumList> album = albumRepository.findAll();
//modelPotato

