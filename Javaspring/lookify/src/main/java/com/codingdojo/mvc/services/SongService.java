package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Song;
import com.codingdojo.mvc.repositories.SongRepository;

@Service
public class SongService {

	private SongRepository songR;
	
	public SongService(SongRepository songR) {
		this.songR = songR;
	}
	public List<Song> allSong(){
		return songR.findAll();
	}
	public Song create(Song s) {
		return songR.save(s);
	}
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songR.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	public Song update(Long id, Song song) {
	    Optional<Song> optionalSong = songR.findById(id);
	    if (optionalSong.isPresent()) {
	        Song song2 = optionalSong.get();
	        song2.setTitle(song.getTitle());
	        song2.setArtist(song.getArtist());
	        song2.setRating(song.getRating());
	        return songR.save(song);
	    } else {
	        throw new IllegalArgumentException("No se encontró ningún lenguaje con el ID proporcionado.");
	    }
	}
	public void delete(Long id) {
		Optional<Song> optionalSong = songR.findById(id);
		if (optionalSong.isPresent()) {
			songR.delete(optionalSong.get());
			}
		else {
			throw new IllegalArgumentException("El libro con ID " + id + " no existe.");
		}
		}
	public List<Song> findTopTen(){
		List<Song> table = songR.findTop10Songs();
		return table;
	}
	public List<Song> findArtistByName(String name){
		List<Song> table = songR.findArtistByName(name);
		return table;
	}
	public List<Song> getAllSongs(){
		List<Song> songs = songR.getAllSongs();
		return songs;
	}
}
