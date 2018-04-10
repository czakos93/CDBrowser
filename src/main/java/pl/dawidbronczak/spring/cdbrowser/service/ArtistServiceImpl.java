package pl.dawidbronczak.spring.cdbrowser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.cdbrowser.dao.ArtistDao;
import pl.dawidbronczak.spring.cdbrowser.domain.Album;
import pl.dawidbronczak.spring.cdbrowser.domain.Artist;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	private ArtistDao artistDao;
	

	
	@Override
	public List<Artist> listArtists() {
		return artistDao.listArtist();
	}

	@Override
	public void addArtist(Artist artist) {
		artistDao.addArtist(artist);
	}

	@Override
	public void updateArtist(Artist artist) {
		artistDao.updateArtist(artist);
		
	}

	@Override
	public void removeArtist(int id) {
		artistDao.removeArtist(id);
	}

	@Override
	public Artist getArtistById(int id) {
		return artistDao.getArtistById(id);
	}

	@Override
	public List<Album> getAlbums(int id) {
		return artistDao.listAlbums(id);
	}

}
