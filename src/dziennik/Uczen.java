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
            listaOcen.put(klasa.listaPrzedmiotow.get(i), new ArrayList<Ocena>());
    }
    protected double obliczSrednia(Przedmiot przedmiot){
        double wartoscCalkowita = 0;
        int iloscOcen = 0;
        for(int i = 0; i < listaOcen.get(przedmiot).size(); i++){
            wartoscCalkowita += listaOcen.get(przedmiot).get(i).getOcena() * listaOcen.get(przedmiot).get(i).getWaga();
            iloscOcen += listaOcen.get(przedmiot).get(i).getWaga();
        }
        return round((wartoscCalkowita / iloscOcen), 2);
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
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
