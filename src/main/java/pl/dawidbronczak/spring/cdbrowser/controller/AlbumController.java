package pl.dawidbronczak.spring.cdbrowser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbronczak.spring.cdbrowser.domain.Album;
import pl.dawidbronczak.spring.cdbrowser.service.AlbumService;

@Controller
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping("/albums")
	public String showAllAlbums(Model model){
		List<Album> albumList = albumService.listAlbums();
		model.addAttribute("albums",albumList);
		return "albums";
	}
	
	@RequestMapping("/album")
	public String showAlbumById(@RequestParam("id") int albumId, Model model){
		model.addAttribute("album", albumService.getAlbumById(albumId));
		return "album";
	}
	@RequestMapping("/add")
	public String showAddAlbum(){
		return "addAlbum";
	}
}
