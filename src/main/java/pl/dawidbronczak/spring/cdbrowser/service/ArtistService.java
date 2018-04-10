package pl.dawidbronczak.spring.cdbrowser.service;

import java.util.List;

import pl.dawidbronczak.spring.cdbrowser.domain.Album;
import pl.dawidbronczak.spring.cdbrowser.domain.Artist;

public interface ArtistService {
	List<Artist> listArtists();
	public void addArtist(Artist artist);
	public void updateArtist(Artist artist);
	public void removeArtist(int id);
	public Artist getArtistById(int id);
	public List<Album> getAlbums(int id);
}
