package dziennik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Dziennik implements DziennikInterfejs, Serializable {
    /**
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * Klasa Dziennik łącząca wszytkie elementy w jedną całość
     * @param uczen obiekt typu Uczen, z perspektywy którego jest
     * możliwe otworzenie dziennika
     * @param uczen obiekt typu Nauczyciel, z perspektywy którego również
     * jest możliwe otworzenie dziennika
     * @param scanner obiekt typu Scanner służący do pobierania danych z klawiatury
     */
    private Uczen uczen;
    private Nauczyciel nauczyciel;
    Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor uruchamiający dziennik z perspektywy ucznia
     * @param uczen obiekt typu Uczen przekazywany do konstruktora
     */
    public Dziennik(Uczen uczen){
        this.uczen = uczen;
        System.out.println("---Dziennik Pibrus---");
        while(true){
            System.out.println("Uczeń: "+uczen.toString());
            System.out.print("\t1. Pokaż oceny " +
                    "\n\t2. Pokaż plan lekcji" +
                    "\n\t3. Pokaż kalendarz zdarzeń" +
                    "\n\t4. Pokaż uwagi" +
                    "\n\t5. Wyjście "+
                    "\nTwój wybór: ");
            int wybor = scanner.nextInt();
            switch(wybor){
                case 1:
                    pokazOceny(uczen);
                    break;
                case 2:
                    pokazPlanLekcji(uczen);
                    break;
                case 3:
                    pokazKalendarzZdarzen(uczen);
                    break;
                case 4:
                    pokazUwagi(uczen);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Taki wybór nie istnieje! ");
                    break;
            }

        }
    }
    /**
     * Konstruktor uruchamiający dziennik z perspektywy nauczyciela
     * @param nauczyciel obiekt typu Uczen przekazywany do konstruktora
     */
    public Dziennik(Nauczyciel nauczyciel){
        this.nauczyciel = nauczyciel;
        System.out.println("---Dziennik Pibrus---");
        System.out.println("Nauczyciel: "+nauczyciel.toString());
        while(true){
            System.out.print("\t1. Zarządzaj ocenami " +
                    "\n\t2. Zarządzaj kalendarzem" +
                    "\n\t3. Zarządzaj uwagami" +
                    "\n\t4. Wyjście "+
                    "\nTwój wybór: ");
            int wybor = scanner.nextInt();
            switch(wybor){
                case 1:
                    zarzadzajOcenami(nauczyciel);
                    break;
                case 2:
                    zarzadzajKalendarzem(nauczyciel);
                    break;
                case 3:
                    wpiszUwage(nauczyciel);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Taki wybór nie istnieje! ");
                    break;
            }

        }
    }
    /**
     * Metoda pokazująca oceny możliwa do uruchomienia tylko z perspektywy ucznia
     * @param uczen obiekt typu Uczen
     */
    @Override
    public void pokazOceny(Uczen uczen) {
        while(true){
            System.out.println("---" + uczen.getImie() + " " + uczen.getNazwisko() + " " + uczen.getKlasa().getNazwa() + " oceny---");
            for(int i = 0; i < uczen.getKlasa().listaPrzedmiotow.size(); i++) {
                int nr = i + 1;
                System.out.println("\t" + nr + ". " + uczen.getKlasa().listaPrzedmiotow.get(i).getNazwa());
            }
            int back = uczen.getKlasa().listaPrzedmiotow.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            if(wybor > 0 && wybor < uczen.getKlasa().listaPrzedmiotow.size() + 1)
                pokazOceny1(uczen, uczen.getKlasa().listaPrzedmiotow.get(wybor - 1));
            else if(wybor == back)
                return;
            else {
                System.out.println("Taki wybór nie istnieje! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Metoda pomocnicza rozszerzająca metodę pokazOceny()
     * @param uczen obiekt typu Uczen przekazywany z poprzedniej metody PokazOceny()
     * @param przedmiot obiekt typu Nauczyciel przekazywany z poprzedniej metody PokazOceny()
     */
    private void pokazOceny1(Uczen uczen, Przedmiot przedmiot){
        while(true){
            System.out.println("---" + uczen.toString() + "---");
            if(!uczen.listaOcen.get(przedmiot).isEmpty()) {
                System.out.println(przedmiot.getNazwa() + " - średnia ważona: " + uczen.obliczSrednia(przedmiot));
                System.out.println("Lista ocen: ");
            }
            else
                System.out.println("Brak ocen! ");
            for(int i = 0; i < uczen.listaOcen.get(przedmiot).size(); i++){
                if(uczen.listaOcen.get(przedmiot).get(i).getOcena() % 1 != 0)
                    System.out.println(uczen.listaOcen.get(przedmiot).get(i).toString());
                else
                    System.out.println(" " + uczen.listaOcen.get(przedmiot).get(i).toString());
            }
            System.out.print("Wybierz 1 aby powrócić: ");
            int wybor = scanner.nextInt();
            if(wybor == 1)
                return;
            else{
                System.out.println("Taki wybór nie istnieje! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Metoda pokazująca plan lekcji możliwa do uruchomienia tylko z perspektywy ucznia
     * @param uczen obiekt typu Uczen
     */
    @Override
    public void pokazPlanLekcji(Uczen uczen) {
        while(true){
            System.out.print("\t1. poniedziałek" +
                    "\n\t2. wtorek" +
                    "\n\t3. środa" +
                    "\n\t4. czwartek" +
                    "\n\t5. piątek" +
                    "\n\t6. Wstecz" +
                    "\nTwój wybór: ");
            int wybor = scanner.nextInt();
            switch(wybor){
                case 1:
                    pokazPlanLekcji1(uczen.getKlasa().tydzien.get(0), uczen);
                    break;
                case 2:
                    pokazPlanLekcji1(uczen.getKlasa().tydzien.get(1), uczen);
                    break;
                case 3:
                    pokazPlanLekcji1(uczen.getKlasa().tydzien.get(2), uczen);
                    break;
                case 4:
                    pokazPlanLekcji1(uczen.getKlasa().tydzien.get(3), uczen);
                    break;
                case 5:
                    pokazPlanLekcji1(uczen.getKlasa().tydzien.get(4), uczen);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Takiej opcji nie ma! Wpisz jeszcze raz! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    break;
            }
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę pokazPlanLekcji()
     * @param uczen obiekt typu Uczen przekazywany z poprzedniej metody PokazPlanLekcji()
     * @param dzienTygodnia obiekt typu DzienTygodnia przekazywany z poprzedniej metody PokazPlanLekcji()
     */
    private void pokazPlanLekcji1(DzienTygodnia dzienTygodnia, Uczen uczen){
        while(true){
            System.out.println("---Plan lekcji " + uczen.getKlasa().getNazwa() + " " + dzienTygodnia.getNazwa() + "---");
            for(int i = 0; i < dzienTygodnia.godzinaLekcyjna.length; i++){
                int nr = i + 1;
                if(!dzienTygodnia.godzinaLekcyjna[i].getNazwa().equals("null"))
                    System.out.println(nr + ". " + dzienTygodnia.godzinaLekcyjna[i].getNazwa() + "(" + dzienTygodnia.godzinyLekcyjne[i] + ")");
                else
                    System.out.println(nr + ". ---------- (" + dzienTygodnia.godzinyLekcyjne[i] + ")");
            }
            System.out.print("Wybierz 1 aby powrócić: ");
            int wybor = scanner.nextInt();
            if (wybor == 1) {
                return;
            } else {
                System.out.println("Wybrana opcja jest różna od 1! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Metoda pokazująca kalendarz możliwa do uruchomienia tylko z perspektywy ucznia
     * @param uczen obiekt typu Uczen
     */
    @Override
    public void pokazKalendarzZdarzen(Uczen uczen) {
        while(true) {
            System.out.println("---" + uczen.toString() + "---");
            System.out.println("Wybierz przedmiot: ");
            for (int i = 0; i < uczen.getKlasa().listaPrzedmiotow.size(); i++) {
                int nr = i + 1;
                System.out.println("\t" + nr + ". " + uczen.getKlasa().listaPrzedmiotow.get(i).getNazwa());
            }
            int back = uczen.getKlasa().listaPrzedmiotow.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            if (wybor > 0 && wybor <= uczen.getKlasa().listaPrzedmiotow.size())
                pokazKalendarzZdarzen1(uczen, uczen.getKlasa().listaPrzedmiotow.get(wybor - 1));
            else if (wybor == back)
                return;
            else {
                System.out.println("Nie ma takiej opcji! Spróbuj jeszcze raz! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    /**
     * Metoda pokazująca pozwalająca nauczycielowi na wpisanie uwagi możliwa do uruchomienia
     * tylko z perspektywy nauczyciela
     * @param nauczyciel obiekt klasy Nauczyciel
     */
    public void wpiszUwage(Nauczyciel nauczyciel) {

        while(true){
            System.out.println("Wybierz klasę: ");
            for(int i = 0; i < nauczyciel.listaKlas.size(); i++){
                int nr = i + 1;
                System.out.println("\t" + nr + ". " + nauczyciel.listaKlas.get(i).getNazwa());
            }
            int back = nauczyciel.listaKlas.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int choice = scanner.nextInt();
            if(choice <= nauczyciel.listaKlas.size() && choice > 0)
                WpiszUwage1(nauczyciel.listaKlas.get(choice - 1));
            else if(choice == nauczyciel.listaKlas.size() + 1)
                return;
            else
                System.out.println("Nie ma takiego wyboru! Spróbuj jeszcze raz. ");

        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę wpiszUwage()
     * @param klasa obiekt typu Klasa przekazywany z poprzeniej metody wpiszUwage()
     */
    private void WpiszUwage1(Klasa klasa){
        ArrayList<Przedmiot> tymczasowaListaPrzedmiotow = new ArrayList<>();
        for(int i = 0; i < klasa.listaPrzedmiotow.size(); i++){
            for(int j = 0; j < nauczyciel.listaPrzedmiotow.size(); j++){
                if(klasa.listaPrzedmiotow.get(i).equals(nauczyciel.listaPrzedmiotow.get(j)))
                    tymczasowaListaPrzedmiotow.add(klasa.listaPrzedmiotow.get(i));
            }
        }
        while(true){
            System.out.println("Wybierz przedmiot: ");
            for(int i = 0; i < tymczasowaListaPrzedmiotow.size(); i++) {
                int nr = i + 1;
                System.out.println("\t"+ nr + ". " + tymczasowaListaPrzedmiotow.get(i).getNazwa());
            }
            int back = tymczasowaListaPrzedmiotow.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int numer = scanner.nextInt();
            if(numer > 0 && numer <= tymczasowaListaPrzedmiotow.size())
                WpiszUwage2(klasa, tymczasowaListaPrzedmiotow.get(numer - 1));
            else if(numer == tymczasowaListaPrzedmiotow.size() + 1)
                return;
            else
                System.out.println("Nie ma takiego wyboru! Spróbuj jeszcze raz! ");
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę wpiszUwage1()
     * @param klasa obiekt typu Klasa przekazywany z poprzeniej metody wpiszUwage1()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody wpiszUwage1()
     */
    private void WpiszUwage2(Klasa klasa, Przedmiot przedmiot){
        while(true){
            System.out.println("---Klasa " + klasa.getNazwa() + "---");
            System.out.println("Wybierz ucznia: ");
            for(int i = 0; i < klasa.listaUczniow.size(); i++) {
                int nr = i + 1;
                System.out.println("\t" + nr + ". "+ klasa.listaUczniow.get(i).getImie() + " " + klasa.listaUczniow.get(i).getNazwisko());
            }
            int back = klasa.listaUczniow.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            if(wybor > 0 && wybor <= klasa.listaUczniow.size())
                WpiszUwage3(przedmiot, klasa.listaUczniow.get(wybor - 1));
            else if(wybor == klasa.listaUczniow.size() + 1)
                return;
            else
                System.out.println("Nie ma takiego wyboru! Spróbuj jeszcze raz! ");
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę wpiszUwage2()
     * @param uczen obiekt typu Uczen przekazywany z poprzeniej metody wpiszUwage2()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody wpiszUwage2()
     */
    private void WpiszUwage3(Przedmiot przedmiot, Uczen uczen){
        while(true){
            System.out.println("---" + uczen.toString() + "---");
            System.out.println("\tUwagi:");

            if(!uczen.listaUwag.isEmpty()){
                for(int i = 0; i < uczen.listaUwag.size(); i++) {
                    System.out.println("\t*" + uczen.listaUwag.get(i).getTytulUwagi() + "*\t" + uczen.listaUwag.get(i).getUwaga());
                }
                System.out.println();
            }
            else{
                System.out.println("Brak Uwag!");
                System.out.println();
            }
            System.out.println("\t1. Dodaj uwage" +
                    "\n\t2. Usuń uwage" +
                    "\n\t3. Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1:
                    WpiszUwage4(przedmiot, uczen);
                    break;
                case 2:
                    if(uczen.listaUwag.isEmpty())
                        System.out.println("Brak uwag!!!");
                    else
                        usunUwage(przedmiot, uczen);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nie ma takiej opcji! Wybierz jeszcze raz! ");
                    break;
            }
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę wpiszUwage3()
     * @param uczen obiekt typu Uczen przekazywany z poprzeniej metody wpiszUwage3()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody wpiszUwage3()
     */
    private void WpiszUwage4(Przedmiot przedmiot, Uczen uczen) {
        LocalDate data = LocalDate.now();
        while (true) {
            System.out.print("Dodaj Tresc uwagi: ");
            scanner.nextLine();
            String uwaga = scanner.nextLine();
            if (uwaga.equals("-1"))
                return;
            String TytulUwagi = "";
            System.out.print("Podaj Tytul Uwagi: ");
            TytulUwagi = scanner.nextLine();
            uczen.listaUwag.add(new Uwaga(uwaga, TytulUwagi, data, przedmiot.getProwadzacy()));
            System.out.println("Dodano uwage: " + TytulUwagi + "! ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            return;
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę pokazKalendarzZdarzen()
     * @param uczen obiekt typu Uczen przekazywany z poprzeniej metody pokazKalendarzZdarzen()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody pokazKalendarzZdarzen()
     */
    private void pokazKalendarzZdarzen1(Uczen uczen, Przedmiot przedmiot){
        while(true){
            System.out.println("---" + uczen.toString() + "---");
            System.out.println("---Kalendarz (10 dni roboczych do przodu)---");
            for(int i = 0; i < przedmiot.daty.length; i++){
                if(przedmiot.kalendarz.get(przedmiot.daty[i]).equals("null"))
                    System.out.println("\t. " + getDzienTygodnia(przedmiot.daty[i]) + " (" + przedmiot.daty[i] + ") " + "----------");
                else {
                    String zdarzenie = przedmiot.kalendarz.get(przedmiot.daty[i]);
                    System.out.println("\t. " + getDzienTygodnia(przedmiot.daty[i]) + " (" + przedmiot.daty[i] + "): " + zdarzenie);
                }
            }
            System.out.print("Wpisz 1 aby powrócić: ");
            int wybor = scanner.nextInt();
            if(wybor == 1)
                return;
            else{
                System.out.println("Nie ma takiej opcji! Spróbuj jeszcze raz! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę wpiszUwage3()
     * @param uczen obiekt typu Uczen przekazywany z poprzeniej metody wpiszUwage3()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody wpiszUwage3()
     */
    private void usunUwage(Przedmiot przedmiot, Uczen uczen){
        while(true){
            System.out.println("---" + uczen.toString() + "---");
            for(int i = 0; i < uczen.listaUwag.size(); i++){
                int nr = i + 1;
                System.out.println("\t" + nr + ".  " + uczen.listaUwag.get(i).getTytulUwagi());
            }
            int back = uczen.listaUwag.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            if(wybor > 0 && wybor <= uczen.listaUwag.size()) {
                System.out.println("Usunięto wskazaną Uwage! ");
                uczen.listaUwag.remove(wybor - 1);
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    System.err.println(e.getMessage());
                }
            }
            else if(wybor == back)
                return;
            else
                System.out.println("Nie ma takiej opcji! Spróbuj jeszcze raz! ");
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę pokazUwagi()
     * @param uczen obiekt typu Uczen przekazywany z poprzeniej metody pokazUwagi()
     */
    @Override
    public void pokazUwagi(Uczen uczen) {
        while(true){
            System.out.println("---" + uczen.getImie() + " " + uczen.getNazwisko() + " " + uczen.getKlasa().getNazwa() + " uwagi---");
            if(uczen.listaUwag.isEmpty())
                System.out.println(uczen.getImie() + " jest grzeczny, dlatego póki co nie posiada uwag ;)");
            else {
                for (int i = 0; i < uczen.listaUwag.size(); i++)
                    System.out.println("\t" + "-" + uczen.listaUwag.get(i).getTytulUwagi() + ": " + uczen.listaUwag.get(i).getUwaga());
            }
            System.out.print("Naciśnij 1 aby powrócić: ");
            int wybor = scanner.nextInt();
            if(wybor == 1)
                return;
            else{
                System.out.println("Taki wybór nie istnieje! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    /**
     * Metoda zarządzająca kalendarzem z perspektywy nauczyciela
     * @param nauczyciel obiekt typu Nauczyciel
     */
    @Override
    public void zarzadzajKalendarzem(Nauczyciel nauczyciel) {
        while(true){
            System.out.println("---Nauczyciel: " + nauczyciel.toString() + "---");
            System.out.println("Wybierz klasę: ");
            for(int i = 0; i < nauczyciel.listaKlas.size(); i++){
                int nr = i + 1;
                System.out.println("\t" + nr + ". " + nauczyciel.listaKlas.get(i).getNazwa());
            }
            int back = nauczyciel.listaKlas.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            if(wybor > 0 && wybor <= nauczyciel.listaKlas.size())
                zarzadzajKalendarzem1(nauczyciel, nauczyciel.listaKlas.get(wybor - 1));
            else if(wybor == back)
                return;
            else{
                System.out.println("Nie ma takiej opcji! Spróbuj jeszcze raz! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę zarzadzajKalendarzem()
     * @param klasa obiekt typu Klasa przekazywany z poprzeniej metody zarzadzajKalendarzem()
     * @param nauczyciel obiekt typu Nauczyciel przekazywany z poprzeniej metody zarzadzajKalendarzem()
     */
    private void zarzadzajKalendarzem1(Nauczyciel nauczyciel, Klasa klasa){
        while(true){
            System.out.println("---Nauczyciel: " + nauczyciel.toString() + "---");
            System.out.println("Wybierz przedmiot: ");
                for(int i = 0; i < nauczyciel.listaPrzedmiotow.size(); i++){
                    int nr = i + 1;
                    System.out.println("\t" + nr + ". " + nauczyciel.listaPrzedmiotow.get(i).getNazwa());
                }
                int back = nauczyciel.listaPrzedmiotow.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            if(wybor > 0 && wybor <= nauczyciel.listaPrzedmiotow.size())
                zarzadzajKalendarzem2(nauczyciel, klasa, nauczyciel.listaPrzedmiotow.get(wybor - 1));
            else if(wybor == back)
                return;
            else{
                System.out.println("Nie ma takiej opcji! Spróbuj jeszcze raz! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Metoda zwracająca dzień tygodnia w zależności od podanej daty
     * @param data obiekt typu LocalDate
     * @return zwraca dzień tygodnia w formie tekstowej
     */
    private static String getDzienTygodnia(LocalDate data){
        switch(data.getDayOfWeek().toString()){
            case "MONDAY":
                return "poniedziałek";
            case "TUESDAY":
                return "wtorek";
            case "WEDNESDAY":
                return "środa";
            case "THURSDAY":
                return "czwartek";
            case "FRIDAY":
                return "piątek";
            case "SATURDAY":
                return "sobota";
            case "SUNDAY":
                return "niedziela";
        }
        return null;
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę zarzadzajKalendarzem1()
     * @param klasa obiekt typu Klasa przekazywany z poprzeniej metody zarzadzajKalendarzem1()
     * @param nauczyciel obiekt typu Nauczyciel przekazywany z poprzeniej metody zarzadzajKalendarzem1()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody zarzadzajKalendarzem1()
     */
    private void zarzadzajKalendarzem2(Nauczyciel nauczyciel, Klasa klasa, Przedmiot przedmiot){
        LocalDate data = LocalDate.now();
        for(int i = 0; i < przedmiot.daty.length; i++){
            data = data.plusDays(1);
            data = switch (data.getDayOfWeek().toString()) {
                case "SATURDAY" -> data.plusDays(2);
                case "SUNDAY" -> data.plusDays(1);
                default -> data;
            };
            przedmiot.daty[i] = data;
            przedmiot.kalendarz.putIfAbsent(data, "null");
        }
        while(true){
            System.out.println("---Nauczyciel: " + nauczyciel.toString() + "---");
            System.out.println("---Kalendarz (10 dni roboczych do przodu)---");
            for(int i = 0; i < przedmiot.daty.length; i++){
                int nr = i + 1;
                if(przedmiot.kalendarz.get(przedmiot.daty[i]).equals("null"))
                    System.out.println("\t" + nr + ". " + getDzienTygodnia(przedmiot.daty[i]) + " (" + przedmiot.daty[i] + ") " + "----------");
                else {
                    String zdarzenie = przedmiot.kalendarz.get(przedmiot.daty[i]);
                    System.out.println("\t" + nr + ". " + getDzienTygodnia(przedmiot.daty[i]) + " (" + przedmiot.daty[i] + "): " + zdarzenie);
                }
            }
            int back = przedmiot.daty.length + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            if(wybor > 0 && wybor <= przedmiot.daty.length)
                zarzadzajKalendarzem3(przedmiot.daty[wybor - 1], przedmiot, klasa);
            else if(wybor == back)
                return;
            else{
                System.out.println("Taka opcja nie istnieje! Spróbuj jeszcze raz! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę zarzadzajKalendarzem2()
     * @param klasa obiekt typu Klasa przekazywany z poprzeniej metody zarzadzajKalendarzem2()
     * @param data obiekt typu LocalDate przekazywany z poprzeniej metody zarzadzajKalendarzem2()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody zarzadzajKalendarzem2()
     */
    private void zarzadzajKalendarzem3(LocalDate data, Przedmiot przedmiot, Klasa klasa){
        Scanner scanner1 = new Scanner(System.in);
        while(true){
            System.out.println("---Nauczyciel: " + nauczyciel.toString() + " " + klasa.getNazwa() + " " + przedmiot.getNazwa() + "---");
            System.out.print("Wpisz zdarzenie jakie chcesz dodać, wpisz -1 aby powrócić lub wpisz null aby usunąć zdarzenie: ");
            String zdarzenie = scanner1.nextLine();
            if(zdarzenie.equals("-1"))
                return;
            else{
                przedmiot.kalendarz.put(data, zdarzenie);
                System.out.println("Dodano wydarzenie! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                return;
            }
        }
    }

    /**
     * Metoda pozwalająca wstawiać i usuwać oceny z perspektywy nauczyciela
     * @param nauczyciel jako argumant jest podawany obiekt typu Nauczyciel
     */
    @Override
    public void zarzadzajOcenami(Nauczyciel nauczyciel) {
        while(true){
            System.out.println("Wybierz klasę: ");
            for(int i = 0; i < nauczyciel.listaKlas.size(); i++){
                int nr = i + 1;
                System.out.println("\t"+nr+". "+nauczyciel.listaKlas.get(i).getNazwa());
            }
            int back = nauczyciel.listaKlas.size() + 1;
            System.out.println("\t"+ back +". Wstecz");
            System.out.print("Twój wybór: ");
            int choice = scanner.nextInt();
            if(choice <= nauczyciel.listaKlas.size() && choice > 0)
                zarzadzajOcenami1(nauczyciel.listaKlas.get(choice - 1));
            else if(choice == nauczyciel.listaKlas.size() + 1)
                return;
            else
                System.out.println("Nie ma takiego wyboru! Spróbuj jeszcze raz. ");
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę zarzadzajOcenami()
     * @param klasa obiekt typu Klasa przekazywany z poprzeniej metody zarzadzajOcenami()
     */
    private void zarzadzajOcenami1(Klasa klasa){
        ArrayList<Przedmiot> tymczasowaListaPrzedmiotow = new ArrayList<>();
        for(int i = 0; i < klasa.listaPrzedmiotow.size(); i++){
            for(int j = 0; j < nauczyciel.listaPrzedmiotow.size(); j++){
                if(klasa.listaPrzedmiotow.get(i).equals(nauczyciel.listaPrzedmiotow.get(j)))
                    tymczasowaListaPrzedmiotow.add(klasa.listaPrzedmiotow.get(i));
            }
        }
        while(true){
            System.out.println("Wybierz przedmiot: ");
            for(int i = 0; i < tymczasowaListaPrzedmiotow.size(); i++) {
                int nr = i + 1;
                System.out.println("\t"+ nr + ". " + tymczasowaListaPrzedmiotow.get(i).getNazwa());
            }
            int back = tymczasowaListaPrzedmiotow.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int numer = scanner.nextInt();
            if(numer > 0 && numer <= tymczasowaListaPrzedmiotow.size())
                zarzadzajOcenami2(klasa, tymczasowaListaPrzedmiotow.get(numer - 1));
            else if(numer == tymczasowaListaPrzedmiotow.size() + 1)
                return;
            else
                System.out.println("Nie ma takiego wyboru! Spróbuj jeszcze raz! ");
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę zarzadzajOcenami1()
     * @param klasa obiekt typu Klasa przekazywany z poprzeniej metody zarzadzajOcenami1()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody zarzadzajOcenami1()
     */
    private void zarzadzajOcenami2(Klasa klasa, Przedmiot przedmiot){
        while(true){
            System.out.println("---Klasa " + klasa.getNazwa() + "---");
            System.out.println("Wybierz ucznia: ");
            for(int i = 0; i < klasa.listaUczniow.size(); i++) {
                int nr = i + 1;
                System.out.println("\t" + nr + ". "+ klasa.listaUczniow.get(i).getImie() + " " + klasa.listaUczniow.get(i).getNazwisko());
            }
            int back = klasa.listaUczniow.size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            if(wybor > 0 && wybor <= klasa.listaUczniow.size())
                zarzadzajOcenami3(przedmiot, klasa.listaUczniow.get(wybor - 1));
            else if(wybor == klasa.listaUczniow.size() + 1)
                return;
            else
                System.out.println("Nie ma takiego wyboru! Spróbuj jeszcze raz! ");
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę zarzadzajOcenami2()
     * @param uczen obiekt typu Uczen przekazywany z poprzeniej metody zarzadzajOcenami2()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody zarzadzajOcenami2()
     */
    private void zarzadzajOcenami3(Przedmiot przedmiot, Uczen uczen){
        while(true){
            System.out.println("---" + uczen.toString() + "---");
            if(!uczen.listaOcen.get(przedmiot).isEmpty()) {
                System.out.println(przedmiot.getNazwa() + " - średnia ważona: " + uczen.obliczSrednia(przedmiot));
                System.out.println("Lista ocen: ");
            }
            else
                System.out.println("Brak ocen! ");
            for(int i = 0; i < uczen.listaOcen.get(przedmiot).size(); i++) {
                if(uczen.listaOcen.get(przedmiot).get(i).getOcena() % 1 != 0)
                    System.out.println(uczen.listaOcen.get(przedmiot).get(i).toString());
                else
                    System.out.println(" " + uczen.listaOcen.get(przedmiot).get(i).toString());
            }
            System.out.println("\t1. Dodaj ocenę" +
                    "\n\t2. Usuń ocenę" +
                    "\n\t3. Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1:
                    zarzadzajOcenami4(przedmiot, uczen);
                    break;
                case 2:
                    if(uczen.listaOcen.get(przedmiot).isEmpty())
                        System.out.println("Brak ocen!!!");
                    else
                        usunOcene(przedmiot, uczen);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nie ma takiej opcji! Wybierz jeszcze raz! ");
                    break;
            }
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę zarzadzajOcenami3()
     * @param uczen obiekt typu Uczen przekazywany z poprzeniej metody zarzadzajOcenami3()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody zarzadzajOcenami3()
     */
    private void usunOcene(Przedmiot przedmiot, Uczen uczen){
        while(true){
            System.out.println("---" + uczen.toString() + "---");
            for(int i = 0; i < uczen.listaOcen.get(przedmiot).size(); i++){
                int nr = i + 1;
                if(uczen.listaOcen.get(przedmiot).get(i).getOcena() % 1 == 0)
                    System.out.println("\t" + nr + ".  " + uczen.listaOcen.get(przedmiot).get(i).toString());
                else
                    System.out.println("\t" + nr + ". " + uczen.listaOcen.get(przedmiot).get(i).toString());
            }
            int back = uczen.listaOcen.get(przedmiot).size() + 1;
            System.out.println("\t" + back + ". Wstecz");
            System.out.print("Twój wybór: ");
            int wybor = scanner.nextInt();
            if(wybor > 0 && wybor <= uczen.listaOcen.get(przedmiot).size()) {
                System.out.println("Usunięto wskazaną ocenę! ");
                uczen.listaOcen.get(przedmiot).remove(wybor - 1);
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    System.err.println(e.getMessage());
                }
            }
            else if(wybor == back)
                return;
            else
                System.out.println("Nie ma takiej opcji! Spróbuj jeszcze raz! ");
        }
    }
    /**
     * Metoda pomocnicza rozszerzająca metodę zarzadzajOcenami3()
     * @param uczen obiekt typu Uczen przekazywany z poprzeniej metody zarzadzajOcenami3()
     * @param przedmiot obiekt typu Przedmiot przekazywany z poprzeniej metody zarzadzajOcenami3()
     */
    private void zarzadzajOcenami4(Przedmiot przedmiot, Uczen uczen){
        LocalDate data = LocalDate.now();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.print("Dodaj ocenę: ");
            scanner.nextLine();
            String ocena = scanner.nextLine();
            if(ocena.equals("-1"))
                return;
            System.out.print("Podaj wagę oceny: ");
            int waga = scanner.nextInt();
            String etykieta = "";
            if(waga < 1  && waga > 5){
                System.out.println("Waga musi być pomiędzy 1 a 5! ");
                continue;
            } else{
                System.out.print("Podaj etykietę: ");
                scanner.nextLine();
                etykieta = scanner.nextLine();
            }
            switch(ocena){
                case "1":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(1.0, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę 1 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+1", "1+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(1.5, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę +1 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-2", "2-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(1.75, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę -2 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "2":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(2, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę 2 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+2", "2+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(2.5, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę +2 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-3", "3-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(2.75, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę -3 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "3":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(3, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę 3 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+3", "3+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(3.5, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę +3 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-4", "4-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(3.75, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę -4 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "4":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(4, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę 4 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+4", "4+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(4.5, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę +4 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-5", "5-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(4.75, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę -5 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "5":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(5, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę 5 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+5", "5+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(5.5, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę +5 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-6", "6-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(5.75, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę -6 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "6":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(6, waga, etykieta, data, nauczyciel));
                    System.out.println("Dodano ocenę 6 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                default:
                    System.out.println("Nie ma takiej oceny! Wpisz jeszcze raz lub wpisz -1 aby powrócić. ");
                    break;
            }
        }
    }
}
