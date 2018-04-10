package pl.dawidbronczak.spring.cdbrowser.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dawidbronczak.spring.cdbrowser.domain.Album;
import pl.dawidbronczak.spring.cdbrowser.domain.Artist;

@Repository
public class ArtistDaoImpl implements ArtistDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addArtist(Artist artist) {
		entityManager.persist(artist);
	}

	@Override
	@Transactional
	public void updateArtist(Artist artist) {
		entityManager.merge(artist);

	}

	@Override
	@Transactional
	public List<Artist> listArtist() {
		TypedQuery<Artist> query;
		query = entityManager.createQuery("select a from Artist a",Artist.class);
		List<Artist> listAlbums = query.getResultList();
		return listAlbums;	
	}

	@Override
	@Transactional
	public void removeArtist(int id) {
		Artist artistToRemove = getArtistById(id);
		entityManager.remove(artistToRemove);
	}

	@Override
	@Transactional
	public Artist getArtistById(int id) {
		return entityManager.find(Artist.class, id);
	}

	@Override
	@Transactional
	public List<Album> listAlbums(int artistId) {
		TypedQuery<Album> query;
		query = entityManager.createQuery("from Album a where a.artist.id = :id",Album.class);
		query.setParameter("id", artistId);		
		List<Album> listAlbums = query.getResultList();
		return listAlbums;	
	}

}
