package pl.dawidbronczak.spring.cdbrowser.dao;

import java.util.List;

import pl.dawidbronczak.spring.cdbrowser.domain.Album;
import pl.dawidbronczak.spring.cdbrowser.domain.Artist;

public interface ArtistDao {
	public void addArtist(Artist artist);
	public void updateArtist(Artist artist);
	public List<Artist> listArtist();
	public void removeArtist(int id);
	public Artist getArtistById(int id);
	public List<Album> listAlbums(int artistId);

}
