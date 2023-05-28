import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Album {
    private String title;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Album(String title, String artist, List<Song> songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
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

    public List<Song> getSongs() {
        return songs;
    }
    // there should be a unique song with one name
    private Boolean findSong(Song songToFind){
        for(Song song : songs){
            if(song.getName().equals(songToFind.getName()) && song.getArtist().equals(songToFind.getArtist())){
                return true;
            }
        }
        return false;
    }
    public Boolean findSong(String songName){
        for(Song song : songs){
            if(song.getName().equals(songName)){
                return true;
            }
        }
        return false;
    }


    public String addSong(Song song){
//        if song is already added in album then don't add
        if(this.findSong(song)){
            return "Song already added";
        }
        this.songs.add(song);
        return "Song added";
    }

    public Optional<Song> searchSong(String songName) {
        for(Song song : songs){
            if(song.getName().equals(songName)){
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }
}
