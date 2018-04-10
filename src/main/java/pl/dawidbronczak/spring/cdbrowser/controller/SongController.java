package pl.dawidbronczak.spring.cdbrowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbronczak.spring.cdbrowser.service.SongService;

@Controller
@RequestMapping("/song")
public class SongController {
	
	@Autowired
	private SongService songService;
	
	@RequestMapping
	public String showSongPage(@RequestParam("id") int songId, Model model){
		model.addAttribute("song",songService.getSongById(songId));
		return "song";
	}
}
