package katerinarajmanova.projekty.zahrada.controller;

import katerinarajmanova.projekty.zahrada.entity.Prace;
import katerinarajmanova.projekty.zahrada.entity.Rostlina;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.EnumSet;

public class RostlinaForm {

    @NotBlank
    private String latinskyNazev;
    @NotBlank
    private String ceskyNazev;
    @NotBlank
    private String popis;

//    private String peceJaro;
//    private String pecePodzim;

    @NotNull
    @DateTimeFormat
    private LocalDate datumVysadby;
    @NotNull
    private EnumSet<Prace> zvolenePraceJaro = EnumSet.noneOf(Prace.class);
    private EnumSet<Prace> zvolenePracePodzim = EnumSet.noneOf(Prace.class);

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

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public LocalDate getDatumVysadby() {
        return datumVysadby;
    }

    public void setDatumVysadby(LocalDate datumVysadby) {
        this.datumVysadby = datumVysadby;
    }

    public EnumSet<Prace> getZvolenePraceJaro() {
        return zvolenePraceJaro;
    }

    public void setZvolenePraceJaro(EnumSet<Prace> zvolenePraceJaro) {
        this.zvolenePraceJaro = zvolenePraceJaro;
    }

    public EnumSet<Prace> getZvolenePracePodzim() {
        return zvolenePracePodzim;
    }

    public void setZvolenePracePodzim(EnumSet<Prace> zvolenePracePodzim) {
        this.zvolenePracePodzim = zvolenePracePodzim;
    }
}
