package pl.dawidbronczak.spring.cdbrowser.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dawidbronczak.spring.cdbrowser.domain.Song;

@Repository
public class SongDaoImpl implements SongDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void addSong(Song song) {
		entityManager.persist(song);
	}

	@Override
	@Transactional
	public void updateSong(Song song) {
		entityManager.merge(song);
	}

	@Override
	@Transactional
	public void removeSong(int id) {
		Song songToRemove = getSongById(id);
		entityManager.remove(songToRemove);
	}

	@Override
	@Transactional
	public Song getSongById(int id) {
		return entityManager.find(Song.class, id);
	}

}
