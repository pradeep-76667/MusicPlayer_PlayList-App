public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("Gloria","Sam Smith");
        album1.addSong(new Song("Unholy","Sam Smith",2));
        album1.addSong(new Song("Perfect","Sam Smith",3));
        album1.addSong(new Song("Gloria","Sam Smith",2));

        Album album2 = new Album("Honestly,Nevermind","Drake");
        album2.addSong(new Song("Her Loss","Drake",2));
        album2.addSong(new Song("Views","Drake",1));
        album2.addSong(new Song("Take Care","Drake",2));

        Playlist myPlayList = new Playlist("myPlayList");
        myPlayList.addSongFromPlaylist(album1,"Unholy");
        myPlayList.addSongFromPlaylist(album1,"Gloria");
        myPlayList.addSongFromPlaylist(album2,"Her Loss");
        myPlayList.addSongFromPlaylist(album2,"Take Care");

        System.out.println(myPlayList.currentSong());  // Unholy

        System.out.println(myPlayList.playPrevious());  // Nothing to play

        System.out.println(myPlayList.playNext()); // Gloria

        System.out.println(myPlayList.playNext());  // Her Loss

        System.out.println(myPlayList.playPrevious()); // Gloria

        System.out.println(myPlayList.playNext()); // Her Loss

        System.out.println(myPlayList.currentSong()); // Her Loss

    }
}