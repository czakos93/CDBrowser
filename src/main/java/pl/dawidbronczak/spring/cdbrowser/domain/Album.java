package pl.dawidbronczak.spring.cdbrowser.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="albums")
public class Album {
	
	@Id
	@GeneratedValue
	@Column(name="album_id")
	private int albumId;
	private String title;
	private String artist;
	
	protected Album(){
		super();
	}
	public Album(int id,String title,String artist){
		albumId = id;
		this.title = title;
		this.artist = artist;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
}
