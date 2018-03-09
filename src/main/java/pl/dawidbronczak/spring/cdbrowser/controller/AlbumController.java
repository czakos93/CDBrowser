package pl.dawidbronczak.spring.cdbrowser.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.dawidbronczak.spring.cdbrowser.domain.Album;
import pl.dawidbronczak.spring.cdbrowser.service.AlbumService;

@Controller
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping("/albums")
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
	public String showAddAlbumPage(@ModelAttribute("newAlbum") Album newAlbum){
		return "addAlbum";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String procedAddAlbum(@ModelAttribute("newAlbum") Album newAlbum, HttpServletRequest request){
		albumService.addAlbum(newAlbum);
		MultipartFile albumImage = newAlbum.getAlbumImage();
		String rootDir = request.getSession().getServletContext().getRealPath("/");
		if(albumImage!=null && !albumImage.isEmpty()){
			try{
				albumImage.transferTo(new File(rootDir+"resources\\album_images\\"+newAlbum.getAlbumId()+".png"));
			}
			catch (Exception e){
				throw new RuntimeException("Error kurwa error",e);
			}
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
		albumToUpdate.setAlbumId(albumId);
		albumService.updateAlbum(albumToUpdate);
		return "redirect:/albums";		
	}
	
	@RequestMapping("/remove")
	public String deleteAlbum(@RequestParam("id") int albumId){
			albumService.removeAlbum(albumId);
			return "redirect:/albums";
	}
}
