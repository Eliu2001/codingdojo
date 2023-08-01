package com.codingdojo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Song;
import com.codingdojo.mvc.services.SongService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	SongService songS;

	@RequestMapping("/")
	public String index() {
		return "views/index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> table = songS.getAllSongs();
		model.addAttribute("table", table);
		return "views/dashboard.jsp";
	}
	@GetMapping("/new")
	public String newsong(Model model) {
	    model.addAttribute("song", new Song());
	    return "views/createSong.jsp";
	}
	@PostMapping("/add")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/error";
		} else {
			if (song.getId() == null || song.getId() == 0) {
				songS.create(song);
			} else {
			}
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Song song = songS.findSong(id);
		if(song == null) {
			return "redirect:/";
		}
		model.addAttribute("song", song);
        return "views/songdetails.jsp";
    }
	
	@RequestMapping(value = "/songs/{id}/delete", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songS.delete(id);
        return "redirect:/dashboard";
	}
	@RequestMapping("topten")
	public String topten(Model model) {
		List<Song> table = songS.findTopTen();
		model.addAttribute("table", table);
		return "views/topten.jsp";
	}
	@GetMapping("/{name}")
    public String searchbytitle(
	@PathVariable("name") String name,
	Model model
    ) {
		String queryName = name+"%";
		List<Song> artistObject = songS.findArtistByName(queryName);
		model.addAttribute("artistObject", artistObject);
		model.addAttribute("name", name);
        return "views/artist.jsp";
	}
	@PostMapping("/songs/searchbytitle")
	public String searchbytitlePost(
	    @RequestParam("artist") String artist,
	    Model model
	) {
	    return "redirect:/" + artist; // Redirecciona sin usar @PathVariable
	}
}
