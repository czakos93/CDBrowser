package pl.dawidbronczak.spring.cdbrowser.service;

import pl.dawidbronczak.spring.cdbrowser.domain.Song;

public interface SongService {
	public void addSong(Song song);
	public void updateSong(Song song);
	public void removeSong(int id);
	public Song getSongById(int id);
}
