package PPJ_01.Z18;

class Song {
    private String singer, title;
    public Song(String singer, String title) {this.singer = singer; this.title = title;}
    public String getSinger() {return singer;}
    public String getTitle() {return title;}
}
class Album {
    private String title;
    private Song[] songs;
    public Album(String title, Song[] songs) {this.title = title; this.songs = songs;}
    public String getTitle() {return title;}
    public Song[] getSong() {return songs;}
}
public class Shelf {
    private Album[] albums;
    public Shelf(Album[] albums) {this.albums = albums;}
    public Album[] getAlbum() {return albums;}
    public String findAlbumBySong(String sTitle) {
        for (int i = 0; i < albums.length; i++)
            for (int j = 0; j < albums[i].getSong().length; j++)
                if (albums[i].getSong()[j].getTitle() == sTitle) return albums[i].getTitle();
        return "Title is not found";
    }
    public static void main(String[] args) {
        Album alb1 = new Album("Loving You",
                new Song[]{new Song("Elvis", "Party"), new Song("Elvis", "Hot Dog")});
        Album alb2 = new Album("Ella & Louis",
                new Song[]{new Song("Armstrong", "A Foggy Day"), new Song("Fitzgerald", "Cheek to Cheek")});
        Shelf shelf = new Shelf(new Album[]{alb1, alb2});
        System.out.println("Song from album: " + shelf.findAlbumBySong("Cheek to Cheek"));
    }
}


