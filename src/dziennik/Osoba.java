package dziennik;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Osoba implements Serializable {
    /**
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * Klasa abstrakcyjna Osoba, która jest wzorem do klas Nauczyciel, oraz Uczen
     * @param wiek jest obliczany na podstawie daty urodzenia
     * @param serialVersionUID parametr odpowiedzialny za serializację
     * @param imie imię w formie tekstowej
     * @param nazwisko nazwisko w formie tekstowej
     * @param dataUrodzenia data urodzenia jako obiekt typu LocalDate
     */
    private static final long serialVersionUID = -7887612267521882048L;
    protected int wiek;
    protected String imie;
    protected String nazwisko;
    private LocalDate dataUrodzenia;

    /**
     * W konstruktorze podawane są dane osoby
     * @param imie imię w formie tekstowej
     * @param nazwisko nazwisko w formie tekstowej
     * @param dataUrodzenia data urodzenia typu LocalDate
     */
    public Osoba(String imie, String nazwisko, LocalDate dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        int wiek = LocalDate.now().getYear() - dataUrodzenia.getYear();
        if(LocalDate.now().getDayOfYear() < dataUrodzenia.getDayOfYear())
            wiek -= 1;
        this.wiek = wiek;
    }

    /**
     * Metoda zwracająca imię w formie tekstowej
     * @return zwraca imię w formie tekstowej
     */
    public String getImie() {
        return imie;
    }
    /**
     * Metoda zwracająca nazwisko w formie tekstowej
     * @return zwraca nazwisko w formie tekstowej
     */
    public String getNazwisko() {
        return nazwisko;
    }
    /**
     * Metoda zwracająca dane osoby w formie tekstowej
     * @return zwraca dane osoby (imię, nazwisko, wiek)
     */
    public String toString(){
        return imie + " " + nazwisko + "  wiek: " + wiek;
    }


}
