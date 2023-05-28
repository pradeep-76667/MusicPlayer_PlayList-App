import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Optional;

public class Playlist {
    private String title;
    private List<Song> songs;

    private boolean wasNext = false;

    private ListIterator<Song> itr;

    public Playlist(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
        itr = songs.listIterator();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    // add song from playlist
    public String addSongFromPlaylist(Album album, String songName){
//        Boolean songExists = album.findSong(songName);   // O(N)
//        if(songExists){
//            song = album.searchSong(songName);   // O(N)
//        }
        Optional<Song> songOpt = album.searchSong(songName);
        if(songOpt.isEmpty()){
            return "Song not found";
        }
        Song songInAlbum = songOpt.get();
        this.songs.add(songInAlbum);
        itr = songs.listIterator();
        return "Song Added Successfully";
    }
    public String playNext(){
        if(wasNext){
        }
        if(!wasNext){
            wasNext = true;
            itr.next();
        }
        if(itr.hasNext()){
            wasNext = true;
            Song song = itr.next();
            return "Next Song is " + song;
        }
        return "You have reached the end of playlist.";
    }

    public String playPrevious(){
        if(!wasNext){
        }
        if(wasNext){
            wasNext = false;
            itr.previous();
        }
        if(itr.hasPrevious()){
            wasNext = false;
            Song song = itr.previous();
            return "Previous Song is " + song;
        }
        return "You gave reached the start of playlist.No song before present.";
    }
    public String currentSong(){
        if(wasNext){  // next se aaya hai to previous jana pdega tabhi previous vala milega
            wasNext = false;
            return "Current song is " + itr.previous();
        }
        wasNext = true;  //previous se aaya hai to next ke liye next jana pdega to true
        return "Current song is " + itr.next();
    }
}
