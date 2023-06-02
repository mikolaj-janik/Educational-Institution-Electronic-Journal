package dziennik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Uczen extends Osoba{
    private Klasa klasa;
    public HashMap<Przedmiot, ArrayList<Ocena>> listaOcen = new HashMap<>();
    public Uczen(String imie, String nazwisko, LocalDate dataUrodzenia, Klasa klasa) {
        super(imie, nazwisko, dataUrodzenia);
        this.klasa = klasa;
        klasa.addStudent(this);
        for(int i = 0; i < klasa.listaPrzedmiotow.size(); i++)
            listaOcen.put(klasa.listaPrzedmiotow.get(i), null);
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
