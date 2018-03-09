package pl.dawidbronczak.spring.cdbrowser.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;



@Entity
@Table(name="albums")
public class Album {
	

	@Id
	@GeneratedValue
	@Column(name="album_id")
	private int albumId;
	private String title;
	private String artist;
	@Transient
	private MultipartFile albumImage;
	
	protected Album(){
		super();
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
	public MultipartFile getAlbumImage() {
		return albumImage;
	}
	public void setAlbumImage(MultipartFile albumImage) {
		this.albumImage = albumImage;
	}
}
