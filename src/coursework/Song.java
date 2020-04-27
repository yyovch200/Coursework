/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

/**
 *
 * @author bilka
 */
public class Song {
    private final int trackId;
    private String trackTitle;
    private String artist;
    private int trackLength;
    private String composer;
    private String releaseDate;
    private String album;
    private String genre;

    static int lastIdAllocated = 0;

    public Song() {
        this.trackId = ++lastIdAllocated;
        this.trackTitle = "TBC";
        this.artist = "TBC";
        this.trackLength = 100;
        this.composer = "TBC";
        this.releaseDate = "TBC";
        this.album = "TBC";
        this.genre = "TBC";
    }

    public Song(int trackId, String trackTitle, String artist, int trackLength, String composer, String releaseDate,
            String album, String genre) {
        this.trackId = trackId;
        this.trackTitle = trackTitle;
        this.artist = artist;
        this.trackLength = trackLength;
        this.composer = composer;
        this.releaseDate = releaseDate;
        this.album = album;
        this.genre = genre;
    }

    public Song(String trackTitle) {
        this.trackId = ++lastIdAllocated;
        this.trackTitle = trackTitle;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static int getLastIdAllocated() {
        return lastIdAllocated;
    }

    public static void setLastIdAllocated(int lastIdAllocated) {
        Song.lastIdAllocated = lastIdAllocated;
    }

}

