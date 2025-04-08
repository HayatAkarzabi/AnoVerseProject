package Metier;


import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SeanceDTO {
    private long id;
    private LocalDateTime date;
    private int  placesDisponibles;



    public SeanceDTO(Seance seance) {
        this.id = seance.getId();
        this.date = seance.getDate();
    }


    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public void setPlacesDisponibles(int placesDisponibles) {
        this.placesDisponibles = placesDisponibles;
    }




    public void setId(long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }






    public String getFormattedDate() {
        if (date == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return date.format(formatter);
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }


}

