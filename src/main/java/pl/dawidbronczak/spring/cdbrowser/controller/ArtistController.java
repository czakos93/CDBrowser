package pl.dawidbronczak.spring.cdbrowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbronczak.spring.cdbrowser.service.ArtistService;

@Controller
@RequestMapping("/artists")
public class ArtistController {
	
	@Autowired
	ArtistService artistService;
	
	@RequestMapping
	public String showAllArtists(Model model){
		model.addAttribute("artists",artistService.listArtists());
		return "artists";		
	}
	
	@RequestMapping("/artist")
	public String showArtist(@RequestParam("id") int id, Model model){
		model.addAttribute("artist", artistService.getArtistById(id));
		model.addAttribute("albums", artistService.getAlbums(id));
		return "artist";
	}
}
