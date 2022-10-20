package furkan.storeApp.entity;

public class MusicCD extends Product {
    private String artist;

    public MusicCD(int Id, String songName, int expense, String artist, int stock) {
        super(Id, songName, expense, stock);
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
