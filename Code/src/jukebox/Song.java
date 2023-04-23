package jukebox;

public class Song {
    private final String title;
    private final String artist;
    private final String genre;
    private final int year;
    private final int timesPlayed;

    public Song(String t, String a, String g, int y, int tP){
        title=t;
        artist=a;
        genre=g;
        year=y;
        timesPlayed=tP;
    }

    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getGenre(){
        return genre;
    }
    public int getYear(){
        return year;
    }
    public int getTimesPlayed(){
        return timesPlayed;
    }

    public String toString(){
        return title+", "+artist+", " + genre+"\n";
    }
}
