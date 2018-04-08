package pl.dawidbronczak.spring.cdbrowser.controller;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.dawidbronczak.spring.cdbrowser.domain.Album;
import pl.dawidbronczak.spring.cdbrowser.service.AlbumService;
import pl.dawidbronczak.spring.cdbrowser.service.ArtistService;

@Controller
@RequestMapping("/albums")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ArtistService artistService;
	
	@RequestMapping
	public String showAllAlbumsPage(Model model){
		List<Album> albumList = albumService.listAlbums();
		model.addAttribute("albums",albumList);
		return "albums";
	}
	
	@RequestMapping("/album")
	public String showAlbumByIdPage(@RequestParam("id") int albumId, Model model){
		model.addAttribute("album", albumService.getAlbumById(albumId));
		return "album";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddAlbumPage(@ModelAttribute("newAlbum") Album newAlbum, Model model){
		model.addAttribute("artists",artistService.listArtists());	
		return "addAlbum";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String procedAddAlbum(@ModelAttribute("newAlbum") Album newAlbum, HttpServletRequest request, BindingResult result){

		albumService.addAlbum(newAlbum);	
		
		MultipartFile albumImage = newAlbum.getCover();
		String rootDir = request.getSession().getServletContext().getRealPath("/");		
			try {
				albumImage.transferTo(new File(rootDir+"resources\\album_images\\"+newAlbum.getId()+".png"));
			}
			catch (Exception e){
				throw new RuntimeException("Error kurwa error",e);
			}
		
		return "redirect:/albums";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showEditAlbumPage(@RequestParam("id") int albumId, Model model){
		Album albumToUpdate = albumService.getAlbumById(albumId);
		model.addAttribute("albumToUpdate", albumToUpdate);
		return "editAlbum";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String proccedEditAlbum(@ModelAttribute("albumToUpdate") Album albumToUpdate,@RequestParam("id") int albumId){
		albumToUpdate.setId(albumId);
		albumService.updateAlbum(albumToUpdate);
		return "redirect:/albums";		
	}
	
	@RequestMapping("/remove")
	public String deleteAlbum(@RequestParam("id") int albumId){
			albumService.removeAlbum(albumId);
			return "redirect:/albums";
	}
}
