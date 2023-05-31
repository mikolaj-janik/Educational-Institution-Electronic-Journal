package dziennik;

import java.time.LocalDate;
import java.util.ArrayList;

public class Uczen extends Osoba{
    private Klasa klasa;
    protected ArrayList<Ocena> listaOcen = new ArrayList<>();
    public Uczen(String imie, String nazwisko, LocalDate dataUrodzenia, Klasa klasa) {
        super(imie, nazwisko, dataUrodzenia);
        this.klasa = klasa;
        klasa.addStudent(this);
    }

    public Klasa getKlasa() {
        return klasa;
    }

    public void setKlasa(Klasa klasa) {
        this.klasa = klasa;
    }
    public String toString(){
        return imie+" "+nazwisko+" "+klasa.getNazwa();
    }
}
