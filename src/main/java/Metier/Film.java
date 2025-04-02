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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;
    private int year;
    private String director;
    private String actors;
    private String writer;
    private String Discription;
    private String Photo;
    public Film(String title,  String writer) {
        this.title = title;
        this.writer = writer;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getActors() {
        return actors;
    }

    public String getDirector() {
        return director;
    }

    public String getDiscription() {
        return Discription;
    }

    public String getGenre() {
        return genre;
    }

    public int getId() {
        return id;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public int getYear() {
        return year;
    }

    public Film(String title, String genre, String director, String actors, String writer, String Discription , int year, String Photo) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.writer = writer;
        this.year = year;
        this.Discription = Discription;
        this.Photo = Photo;
    }
}
