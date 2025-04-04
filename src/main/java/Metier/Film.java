package Metier;

import jakarta.persistence.*;
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
    private Long id;
    private String title;
    private String genre;
    private int year;
    private String director;
    private String actors;
    private String writer;
    @Column(length = 1000)
    private String description;
    private String imageUrl;

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
        description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public Long getId() {
        return id;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Film(String title, String genre, int year, String director, String actors, String writer, String description, String imageUrl) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.director = director;
        this.actors = actors;
        this.writer = writer;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
