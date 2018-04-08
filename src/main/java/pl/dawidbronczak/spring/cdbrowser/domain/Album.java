package pl.dawidbronczak.spring.cdbrowser.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;



@Entity
@Table(name="albums")
public class Album {
	

	@Id
	@GeneratedValue
	@Column(name="album_id")
	private int id;
	
	private String title;
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	private Artist artist;
	
	@OneToMany(mappedBy="album")
	private List<Song> songs;
	
	private Date releaseDate;	
	
	@Transient
	private MultipartFile cover;
	
	@Transient 
	private List<MultipartFile> images;
	
	public Album(){
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public MultipartFile getCover() {
		return cover;
	}
	public void setCover(MultipartFile image) {
		this.cover = image;
	}


	public List<Song> getSongs() {
		return songs;
	}


	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public List<MultipartFile> getImages() {
		return images;
	}


	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
}
