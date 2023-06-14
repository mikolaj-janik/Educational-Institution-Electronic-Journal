package dziennik;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Nauczyciel extends Osoba implements Serializable {
    /**
     * To jest klasa odpowiedzialna za nauczyciela
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * @param listaPrzedmiotow lista przedmiotów prowadzonych przez nauczyciela
     * @param listaKlas lista klas które uczy nauczyciel
     * @param klasaPodOpieką klasa, której wychowawcą jest nauczyciel
     */
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

    /**
     * Metoda odpowiedzialna za dodanie klasy do listy klas
     * @param klasa
     */
    protected void dodajKlase(Klasa klasa){
        listaKlas.add(klasa);
    }

    /**
     * Metoda zwracająca dane nauczyciela
     * @return zwraca w formie stringu dane nauczyciela
     */
    public String toString(){
        return "mgr "+imie + " " + nazwisko;
    }

    /**
     * Metoda zwraca wszystkie klasy, które uczy nauczyciel
     */
    public void printListaKlas(){
        for(int i = 0; i < listaKlas.size(); i++)
            System.out.println(listaKlas.get(i).getNazwa());
    }

    /**
     * Metoda odpowiedzialna za ustawienie klasy pod wychowawstwem nauczyciela
     * @param klasaPodOpieką klasa, której wychowawcą ma zostać nauczyciel
     */
    public void setKlasaPodOpieką(Klasa klasaPodOpieką) {
        this.klasaPodOpieką = klasaPodOpieką;
    }
}
