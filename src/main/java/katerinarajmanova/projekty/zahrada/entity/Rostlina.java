package katerinarajmanova.projekty.zahrada.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Rostlina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String latinskyNazev;
    private String ceskyNazev;
    private String popis;
    private String peceJaro;
    private String pecePodzim;
    private LocalDate datumVysadby;

    public Rostlina(Integer id, String latinskyNazev, String ceskyNazev, String popis, String peceJaro, String pecePodzim, LocalDate datumVysadby) {
        this.id = id;
        this.latinskyNazev = latinskyNazev;
        this.ceskyNazev = ceskyNazev;
        this.popis = popis;
        this.peceJaro = peceJaro;
        this.pecePodzim = pecePodzim;
        this.datumVysadby = datumVysadby;
    }

    public Rostlina() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatinskyNazev() {
        return latinskyNazev;
    }

    public void setLatinskyNazev(String latinskyNazev) {
        this.latinskyNazev = latinskyNazev;
    }

    public String getCeskyNazev() {
        return ceskyNazev;
    }

    public void setCeskyNazev(String ceskyNazev) {
        this.ceskyNazev = ceskyNazev;
    }

    public String getPeceJaro() {
        return peceJaro;
    }

    public void setPeceJaro(String peceJaro) {
        this.peceJaro = peceJaro;
    }

    public String getPecePodzim() {
        return pecePodzim;
    }

    public void setPecePodzim(String pecePodzim) {
        this.pecePodzim = pecePodzim;
    }

    public LocalDate getDatumVysadby() {
        return datumVysadby;
    }

    public void setDatumVysadby(LocalDate datumVysadby) {
        this.datumVysadby = datumVysadby;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
}
