package pl.dawidbronczak.spring.cdbrowser.dao;

import java.util.List;

import pl.dawidbronczak.spring.cdbrowser.domain.Album;

public interface AlbumDao {
	public void addAlbum(Album album);
	public void updateAlbum(Album album);
	public List<Album> listAlbums();
	public void removeAlbum(int id);
	public Album getAlbumById(int id);
}
