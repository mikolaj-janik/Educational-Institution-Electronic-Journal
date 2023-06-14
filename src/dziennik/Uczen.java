package dziennik;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Uczen extends Osoba implements Serializable{
    /**
     * Klasa odpowiedzialna za ucznia jako osobę dziedzicząca po abstrakcyjnej klasie Osoba
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * @param serialVersionUID odpowiada za serializację
     * @param klasa obiekt klasy Klasa odpowiada za klasę, do której należy uczeń
     * @param listaOcen HashMapa, która przechowuje przedmioty jako obiekty klasy Przedmiot, które są kluczami
     * i oceny jako obiekty klasy Ocena, które są wartościami
     * @param listaUwag lista przechowująca uwagi, które są obiektami klasy Uwaga
     */
    private static final long serialVersionUID = -7887612267521882048L;
    private Klasa klasa;
    public HashMap<Przedmiot, ArrayList<Ocena>> listaOcen = new HashMap<>();
    protected ArrayList<Uwaga> listaUwag = new ArrayList<>();
    public Uczen(String imie, String nazwisko, LocalDate dataUrodzenia, Klasa klasa) {
        super(imie, nazwisko, dataUrodzenia);
        this.klasa = klasa;
        klasa.addStudent(this);
        for (int i = 0; i < klasa.listaPrzedmiotow.size(); i++)
            listaOcen.put(klasa.listaPrzedmiotow.get(i), new ArrayList<Ocena>());

    }

    /**
     * Metoda obliczająca średnią z danego przedmiotu na podstawie ocen
     * @param przedmiot obiekt klasy Przedmiot
     * @return zwraca średnią z danego przedmiotu, na podstawie wag oraz ilości ocen
     */
    protected double obliczSrednia(Przedmiot przedmiot){
        double wartoscCalkowita = 0;
        int iloscOcen = 0;
        for(int i = 0; i < listaOcen.get(przedmiot).size(); i++){
            wartoscCalkowita += listaOcen.get(przedmiot).get(i).getOcena() * listaOcen.get(przedmiot).get(i).getWaga();
            iloscOcen += listaOcen.get(przedmiot).get(i).getWaga();
        }
        return round((wartoscCalkowita / iloscOcen), 2);
    }

    /**
     * Metoda zaokrąglająca średnią do n miejsc po przecinku
     * @param value wartość
     * @param places ilość miejsc po przecinku
     * @return zwraca tą wartość zaokrągloną
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    /**
     * Metoda zwracająca klasę do której należy uczeń
     * @return zwraca klasę, w której jest uczeń
     */
    public Klasa getKlasa() {
        return klasa;
    }

    /**
     * Metoda zwracająca w formie tekstowej dane ucznia
     * @return zwraca dane ucznia
     */
    public String toString(){
        return imie+" "+nazwisko+" "+klasa.getNazwa();
    }
}
