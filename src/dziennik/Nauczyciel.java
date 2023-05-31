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
    public String toString(){
        return imie + " " + nazwisko;
    }

    public void setKlasaPodOpieką(Klasa klasaPodOpieką) {
        this.klasaPodOpieką = klasaPodOpieką;
    }

    public void dodajKlase(Klasa klasa, String nazwaPrzedmiotu){
        listaKlas.add(klasa);
        for(int i = 0; i < klasa.listaPrzedmiotow.size(); i++){
            if(klasa.listaPrzedmiotow.get(i).getNazwa().equals(nazwaPrzedmiotu)){
                if((klasa.listaPrzedmiotow.get(i).getProwadzacy() == null)){
                    klasa.listaPrzedmiotow.get(i).setProwadzacy(this);
                }else
                    System.out.println("Ten przedmiot ma już prowadzącego przypisanego tej klasie!");
            }

        }
    }
}
