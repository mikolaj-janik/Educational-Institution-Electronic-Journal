import dziennik.*;

import java.io.*;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    /**
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * Klasa testująca poprawność działania projektu. Tworzone są obiekty nauczycieli prowadzących dane przedmioty
     * (w konstruktorach nauczycieli są zawarte przedmioty, których uczą), tworzony jest również obiekt klasy Klasa,
     * a następnie obiekty klasy Uczen, które reprezentują uczniów należących do klasy. Na koniec jest tworzony obiekt
     * klasy Dziennik z perspektywy nauczyciela, a potem ucznia. Po wszystkim zostaje wykonana serializacja obiektu uczen
     */
    public static void main(String[] args) throws IOException{
        Osoba nauczycielMatematykiFizyki = new Nauczyciel("Daria", "Nowak", LocalDate.parse("1973-06-17"), new Przedmiot("matematyka", 8), new Przedmiot("fizyka", 4));
        Nauczyciel nauczycielPolskiego = new Nauczyciel("Barbara", "Leja", LocalDate.parse("1966-05-16"), new Przedmiot("język polski", 5));
        Nauczyciel nauczycielHistorii = new Nauczyciel("Sławomir", "Podgórski", LocalDate.parse("1970-11-11"), new Przedmiot("historia", 2));
        Nauczyciel nauczycielAngielskiego = new Nauczyciel("Jan", "Kowalski", LocalDate.parse("1979-04-23"), new Przedmiot("język angielski", 6), new Przedmiot("język niemiecki", 2));
        Nauczyciel nauczycielReligii = new Nauczyciel("Maciej", "Półtorak", LocalDate.parse("1978-08-18"), new Przedmiot("religia", 2));
        Nauczyciel nauczycielWF = new Nauczyciel("Edyta", "Daszkiewicz", LocalDate.parse("1972-12-12"), new Przedmiot("wychowanie fizyczne", 3));
        Klasa klasa = new Klasa("2a", (Nauczyciel) nauczycielMatematykiFizyki, nauczycielAngielskiego, nauczycielPolskiego, nauczycielHistorii, nauczycielWF, nauczycielReligii);
        Uczen uczen0 = new Uczen("Patryk", "Cygnar", LocalDate.parse("2001-05-19"), klasa);
        Uczen uczen1 = new Uczen("Jakub", "Kucaba", LocalDate.parse("2002-06-01"), klasa);
        Uczen uczen2 = new Uczen("Łukasz", "Królicki", LocalDate.parse("2002-02-27"), klasa);
        Uczen uczen3 = new Uczen("Mikołaj", "Janik", LocalDate.parse("2002-04-15"), klasa);
        Uczen uczen4 = new Uczen("Dawid", "Balon", LocalDate.parse("2002-11-19"), klasa);
        Uczen uczen5 = new Uczen("Marian", "Bereza", LocalDate.parse("2004-08-01"), klasa);
        Uczen uczen6 = new Uczen("Rafał", "Ciołek", LocalDate.parse("2002-06-10"), klasa);
        Uczen uczen7 = new Uczen("Amadeusz", "Duźniak", LocalDate.parse("2009-06-10"), klasa);
       // Dziennik dziennik1 = new Dziennik(uczen3);
        Dziennik dziennik = new Dziennik((Nauczyciel)nauczycielMatematykiFizyki);
        Dziennik dziennik2 = new Dziennik(uczen3);
        ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream(".\\uczen.dat"));
        wy.writeObject(uczen2);
        wy.close();
    }
}