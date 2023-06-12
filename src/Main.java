import dziennik.*;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        /*FileOutputStream fileOut = new FileOutputStream("Serializacja.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);*/
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
        Dziennik dziennik = new Dziennik((Nauczyciel)nauczycielMatematykiFizyki);
        Dziennik dziennik1 = new Dziennik(uczen2);
        /*out.writeObject(nauczycielMatematykiFizyki);
        out.writeObject(nauczycielAngielskiego);
        out.writeObject(nauczycielHistorii);
        out.writeObject(nauczycielPolskiego);
        out.writeObject(nauczycielWF);
        out.writeObject(nauczycielReligii);
        out.writeObject(uczen0);
        out.writeObject(uczen1);
        out.writeObject(uczen2);
        out.writeObject(uczen3);
        out.writeObject(uczen4);
        out.writeObject(uczen5);
        out.writeObject(uczen6);
        out.writeObject(uczen7);
        out.close();
        fileOut.close();*/
    }
}