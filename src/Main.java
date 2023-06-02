import dziennik.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Osoba nauczycielMatematykiFizyki = new Nauczyciel("Daria", "Nowak", LocalDate.parse("1973-06-17"), new Przedmiot("matematyka", 6), new Przedmiot("fizyka", 5));
        Nauczyciel nauczycielPolskiego = new Nauczyciel("Barbara", "Leja", LocalDate.parse("1966-05-16"), new Przedmiot("język polski", 6));
        Nauczyciel nauczycielHistorii = new Nauczyciel("Sławomir", "Podgórski", LocalDate.parse("1970-11-11"), new Przedmiot("historia", 4));
        Klasa klasa = new Klasa("2a", (Nauczyciel) nauczycielMatematykiFizyki, nauczycielPolskiego, nauczycielHistorii);
        klasa.printListaPrzedmiotow();
        Uczen uczen0 = new Uczen("Patryk", "Cygnar", LocalDate.parse("2001-05-19"), klasa);
        Uczen uczen1 = new Uczen("Jakub", "Kucaba", LocalDate.parse("2002-07-12"), klasa);
        Uczen uczen2 = new Uczen("Łukuś", "Królicki", LocalDate.parse("2002-02-27"), klasa);
        Uczen uczen3 = new Uczen("Mikołaj", "Janik", LocalDate.parse("2002-04-15"), klasa);
        Uczen uczen4 = new Uczen("Dawid", "Balon", LocalDate.parse("2002-11-19"), klasa);
        //Dziennik dziennik = new Dziennik((Nauczyciel)nauczyciel);


    }
}