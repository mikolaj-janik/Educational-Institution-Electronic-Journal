package dziennik;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Przedmiot implements Serializable {
    /**
     * Klasa odpowiedzialna za przedmiot
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * @param nazwa nazwa przedmiotu w formie tekstowej np "matematyka"
     * @param prowadzacy nauczyciel prowadzący przedmiot jako obiekt klasy Nauczyciel
     * @param iloscGodzinTygodniowo ilość godzin lekcyjnych w tygodniu z danego przedmiotu, jaka ma się pojawić w planie lekcji
     * @param kalendarz HashMapa odpowiedzialna za kalendarz. Jako klucze posiada datę, a wartość to wydarzenie w formie tekstowej,
     * np sprawdzian
     * @param daty odpowiada za 10 dat do przodu (cały kalendarz jest układany na 10 dni roboczych do przodu
     */
    private String nazwa;
    private Nauczyciel prowadzacy;
    protected int iloscGodzinTygodniowo;
    protected HashMap<LocalDate, String> kalendarz = new HashMap<>();
    protected LocalDate [] daty = new LocalDate[10];

    /**
     * Konstruktor klasy Przedmiot
     * @param nazwa nazwa przedmiotu, np "matematyka"
     * @param iloscGodzinTygodniowo ilość godzin w tygodniu
     */
    public Przedmiot(String nazwa, int iloscGodzinTygodniowo) {
        LocalDate data = LocalDate.now();
        this.nazwa = nazwa;
        this.iloscGodzinTygodniowo = iloscGodzinTygodniowo;
        for(int i = 0; i < 10; i++){
            data = data.plusDays(i + 1);
            if(data.getDayOfWeek().equals("SATURDAY"))
                data = data.plusDays(2);
            else if(data.getDayOfWeek().equals("SUNDAY"))
                data = data.plusDays(1);
            kalendarz.put(data, "null");
        }
    }

    /**
     * Metoda ustawiająca nazwę przedmiotu
     * @param nazwa nazwa przedmiotu w formie tekstowej
     */
    protected Przedmiot(String nazwa){
        this.nazwa = nazwa;
    }

    /**
     * Metoda ustawiająca nauczyciela prowadzącego przedmiot
     * @param prowadzacy obiekt klasy Nauczyciel
     */
    public void setProwadzacy(Nauczyciel prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    /**
     * Metoda zwracająca nauczyciela uczącego przedmiot (obiekt klasy Nauczyciel)
     * @return obiekt klasy Nauczyciel
     */
    public Nauczyciel getProwadzacy() {
        return prowadzacy;
    }

    /**
     * Metoda zwracająca tekstową nazwę przedmiotu
     * @return nazwa przedmiotu, np "matematyka"
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * Metoda zwracająca dane przedmiotu, jako nazwę oraz dane prowadzącego
     * @return dane przedmiotu w formie tekstowej
     */
    public String toString(){
        return "Przedmiot: "+ nazwa + ",  Prowadzący: "+ prowadzacy;
    }
}
