package jukebox;

import java.util.List;
import java.util.stream.Collectors;

public class Songs {
    public static void main(String[] args) {
        List<Song> songs = List.of(
                new Song("$10", "Hitchhiker", "Electronic", 2016, 183),
                new Song("Havana", "Camila Cabello", "R&B", 2017, 324),
                new Song("Cassidy", "Grateful Dead", "Rock", 1972, 123),
                new Song("50 ways", "Paul Simon", "Soft Rock", 1975, 199),
                new Song("Hurt", "Nine Inch Nails", "Industrial Rock", 1995, 257),
                new Song("Silence", "Delerium", "Electronic", 2010, 155),
                new Song("Hurt", "Johnny Cash", "Soft Rock", 2002, 392),
                new Song("Watercolour", "Pendulum", "Electronic", 2010, 155),
                new Song("The Outsider", "A Perfect Circle", "Alternative Rock", 2004, 312),
                new Song("With a Little Help from My Friends", "The Beatles", "Rock", 1967, 168),
                new Song("Come Together", "The Beatles", "Blues rock", 1968, 173),
                new Song("Come Together", "Ike & Tina Turner", "Rock", 1970, 165),
                new Song("With a Little Help from My Friends", "Joe Cocker", "Rock", 1968, 46),
                new Song("Immigrant Song", "Karen O", "Industrial Rock", 2011, 12),
                new Song("Breathe", "The Progigy", "Electronic", 1996, 337),
                new Song("What's going on", "Gaye", "R&B", 1971, 420),
                new Song("Hallucinate", "Dua Lipa", "Pop", 2020, 75),
                new Song("Walk Me Home", "P!ng", "Pop", 2019, 459),
                new Song("I am not a woman, I'm a god", "Halsey", "Alternative Rock", 2021, 384),
                new Song("Pasos de cero", "Pablo Alboran", "Latin", 2014, 117),
                new Song("Smooth", "Santana", "Latin", 1999, 244),
                new Song("Immigrant Song", "Led Zeppelin", "Rock", 1970, 484)
        );


/*        List<Song> rockSongs = songs.stream()
                                    .filter(s -> s.getGenre().contains("Rock"))
                                    .collect(Collectors.toList());
        List<Song> byTheBeatles = songs.stream()
                                       .filter(s -> s.getArtist().equals("The Beatles"))
                                       .collect(Collectors.toList());
        List<Song> startWithH = songs.stream()
                                       .filter(s -> s.getTitle().startsWith("H"))
                                       .collect(Collectors.toList());
        List<Song>  moreRecentThan1995 = songs.stream()
                                              .filter(s -> s.getYear()>1995)
                                              .collect(Collectors.toList());
        System.out.println("Rock songs ->" + rockSongs);
        System.out.println("The Beatles songs -> " + byTheBeatles);
        System.out.println("Start with H songs -> " + startWithH);
        System.out.println("More Recent than 1995 songs -> " + moreRecentThan1995);*/

        List<String> songGenres = songs.stream()
                                       .map(s -> s.getGenre())
                                       .distinct()
                                       .collect(Collectors.toList());
        System.out.println(songGenres);
    }
}
