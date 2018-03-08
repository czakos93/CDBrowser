package pl.dawidbronczak.spring.cdbrowser.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dawidbronczak.spring.cdbrowser.domain.Album;

@Repository
public class AlbumDaoImpl implements AlbumDao {
	
	@PersistenceContext 
	EntityManager entityManager;

	@Transactional 
	@Override
	public void addAlbum(Album album) {
		entityManager.persist(album);
	}
	@Transactional 
	@Override
	public void updateAlbum(Album album) {
		entityManager.merge(album);

	}
	
	@Transactional 
	@Override
	public List<Album> listAlbums() {
		TypedQuery<Album> query;
		query = entityManager.createQuery("select a from Album a",Album.class);
		List<Album> listAlbums = query.getResultList();
		return listAlbums;	
	}
	@Transactional 
	@Override
	public void removeAlbum(int id) {
		Query query;
		query = entityManager.createQuery("delete from Album a where a.albumId = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	@Transactional 
	@Override
	public Album getAlbumById(int id) {
		Album tempAlbum;
		Query query;
		query = entityManager.createQuery("select a from Album a where a.albumId = :id", Album.class);
		query.setParameter("id",id);
		tempAlbum = (Album) query.getSingleResult();
		return tempAlbum;
	}
}
