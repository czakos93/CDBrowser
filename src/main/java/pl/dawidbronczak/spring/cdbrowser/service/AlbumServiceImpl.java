package pl.dawidbronczak.spring.cdbrowser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.cdbrowser.dao.AlbumDao;
import pl.dawidbronczak.spring.cdbrowser.domain.Album;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	private AlbumDao albumDao;
	
	@Override
	public void addAlbum(Album album) {
		albumDao.addAlbum(album);
	}

	@Override
	public void updateAlbum(Album album) {
		albumDao.updateAlbum(album);
	}

	@Override
	public List<Album> listAlbums() {
		return albumDao.listAlbums();
	}

	@Override
	public void removeAlbum(int id) {
		albumDao.removeAlbum(id);
		
	}

	@Override
	public Album getAlbumById(int id) {
		return albumDao.getAlbumById(id);
		
	}

}
