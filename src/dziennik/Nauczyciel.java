package dziennik;

import java.time.LocalDate;
import java.util.ArrayList;

public class Nauczyciel extends Osoba{
    protected ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();
    protected ArrayList<Klasa> listaKlas = new ArrayList<>();
    private Klasa klasaPodOpieką;


    public Nauczyciel(String imie, String nazwisko, LocalDate dataUrodzenia, Przedmiot prowadzonyPrzedmiot, Przedmiot...wiecejPrzedmiotow) {
        super(imie, nazwisko, dataUrodzenia);
        listaPrzedmiotow.add(prowadzonyPrzedmiot);
        prowadzonyPrzedmiot.setProwadzacy(this);
        for(int i = 0; i < wiecejPrzedmiotow.length; i++) {
            listaPrzedmiotow.add(wiecejPrzedmiotow[i]);
            wiecejPrzedmiotow[i].setProwadzacy(this);
        }
    }
    protected void dodajKlase(Klasa klasa){
        listaKlas.add(klasa);
    }
    public String toString(){
        return "mgr "+imie + " " + nazwisko;
    }
    public void printListaKlas(){
        for(int i = 0; i < listaKlas.size(); i++)
            System.out.println(listaKlas.get(i).getNazwa());
    }

    public void setKlasaPodOpieką(Klasa klasaPodOpieką) {
        this.klasaPodOpieką = klasaPodOpieką;
    }
}
