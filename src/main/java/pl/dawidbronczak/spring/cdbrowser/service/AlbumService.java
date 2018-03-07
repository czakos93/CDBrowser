package pl.dawidbronczak.spring.cdbrowser.service;

import java.util.List;

import pl.dawidbronczak.spring.cdbrowser.domain.Album;

public interface AlbumService {
	public void addAlbum(Album album);
	public void updateAlbum(Album album);
	public List<Album> listAlbums();
	public void removeAlbum(int id);
	public Album getAlbumById(int id);
}
