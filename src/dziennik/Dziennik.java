package dziennik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class Dziennik implements DziennikInterfejs{
    private Uczen uczen;
    private Nauczyciel nauczyciel;
    Scanner scanner = new Scanner(System.in);
    public Dziennik(Uczen uczen){
        this.uczen = uczen;
        System.out.println("---Dziennik Pibrus---");
        System.out.println("Uczeń: "+uczen.toString());
        while(true){
            System.out.print("\t1. Pokaż oceny " +
                    "\n\t2. Pokaż plan lekcji" +
                    "\n\t3. Pokaż kalendarz zdarzeń" +
                    "\n\t4. Pokaż uwagi" +
                    "\n\t5. Pokaż frekwencję" +
                    "\n\t6. Wyjście "+
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
                    pokazFrekwencje(uczen);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Taki wybór nie istnieje! ");
                    break;
            }

        }
    }
    public Dziennik(Nauczyciel nauczyciel){
        this.nauczyciel = nauczyciel;
        System.out.println("---Dziennik Pibrus---");
        System.out.println("Nauczyciel: "+nauczyciel.toString());
        while(true){
            System.out.print("\t1. Zarządzaj ocenami " +
                    "\n\t2. Zarządzaj frekwencją" +
                    "\n\t3. Zarządzaj kalendarzem" +
                    "\n\t4. Zarządzaj uwagami" +
                    "\n\t5. Wyjście "+
                    "\nTwój wybór: ");
            int wybor = scanner.nextInt();
            switch(wybor){
                case 1:
                    zarzadzajOcenami(nauczyciel);
                    break;
                case 2:
                    zarzadzajFrekwencja(nauczyciel);
                    break;
                case 3:
                    zarzadzajKalendarzem(nauczyciel);
                    break;
                case 4:
                    wpiszUwage(nauczyciel);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Taki wybór nie istnieje! ");
                    break;
            }

        }
    }
    @Override
    public void pokazOceny(Uczen uczen) {

    }

    @Override
    public void pokazPlanLekcji(Uczen uczen) {

    }

    @Override
    public void pokazKalendarzZdarzen(Uczen uczen) {

    }

    @Override
    public void pokazUwagi(Uczen uczen) {

    }

    @Override
    public void pokazFrekwencje(Uczen uczen) {

    }

    @Override
    public void zarzadzajKalendarzem(Nauczyciel nauczyciel) {

    }

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
    private void zarzadzajOcenami4(Przedmiot przedmiot, Uczen uczen){
        LocalDate data = LocalDate.now();
        while(true){
            System.out.print("Dodaj ocenę: ");
            String ocena = scanner.next();
            if(ocena.equals("-1"))
                return;
            System.out.print("Podaj wagę oceny: ");
            int waga = scanner.nextInt();
            if(waga < 1  && waga > 5){
                System.out.println("Waga musi być pomiędzy 1 a 5! ");
                continue;
            }
            switch(ocena){
                case "1":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(1.0, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę 1 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+1", "1+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(1.5, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę +1 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-2", "2-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(1.75, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę -2 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "2":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(2, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę 2 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+2", "2+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(2.5, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę +2 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-3", "3-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(2.75, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę -3 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "3":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(3, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę 3 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+3", "3+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(3.5, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę +3 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-4", "4-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(3.75, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę -4 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "4":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(4, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę 4 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+4", "4+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(4.5, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę +4 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-5", "5-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(4.75, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę -5 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "5":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(5, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę 5 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "+5", "5+":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(5.5, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę +5 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "-6", "6-":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(5.75, waga, data, nauczyciel));
                    System.out.println("Dodano ocenę -6 o wadze " + waga + "! ");
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                    return;
                case "6":
                    uczen.listaOcen.get(przedmiot).add(new Ocena(6, waga, data, nauczyciel));
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
    @Override
    public void wpiszUwage(Nauczyciel Nauczyciel) {

    }

    @Override
    public void zarzadzajFrekwencja(Nauczyciel nauczyciel) {

    }
}
