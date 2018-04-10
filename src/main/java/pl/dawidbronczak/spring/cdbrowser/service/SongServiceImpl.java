package pl.dawidbronczak.spring.cdbrowser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.cdbrowser.dao.SongDao;
import pl.dawidbronczak.spring.cdbrowser.domain.Song;

@Service
public class SongServiceImpl implements SongService {
	
	@Autowired
	private SongDao songDao;
	@Override
	public void addSong(Song song) {
		songDao.addSong(song);
	}

	@Override
	public void updateSong(Song song) {
		songDao.updateSong(song);
	}

	@Override
	public void removeSong(int id) {
		songDao.removeSong(id);
	}

	@Override
	public Song getSongById(int id) {
		return songDao.getSongById(id);
	}

}
