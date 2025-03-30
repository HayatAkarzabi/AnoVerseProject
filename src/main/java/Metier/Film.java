package Metier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Film implements Serializable {
    public Film(String actors, String director, String genre, String title, String writer, int year) {
        this.actors = actors;
        this.director = director;
        this.genre = genre;
        this.title = title;
        this.writer = writer;
        this.year = year;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String title;
    private String genre;
    private int year;
    private String director;
    private String actors;
    private String writer;
    public Film(String title,  String writer) {
        this.title = title;
        this.writer = writer;
    }
}