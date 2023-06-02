package dziennik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Dziennik implements DziennikInterfejs{
    private Uczen uczen;
    private Nauczyciel nauczyciel;
    ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public Dziennik(Uczen uczen){
        this.uczen = uczen;
        initPrzedmioty();
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
        initPrzedmioty();
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Taki wybór nie istnieje! ");
                    break;
            }

        }
    }
    protected void initPrzedmioty(){
        listaPrzedmiotow.add(new Przedmiot("matematyka", 6));
        listaPrzedmiotow.add(new Przedmiot("język polski", 6));
        listaPrzedmiotow.add(new Przedmiot("język angielski", 6));
        listaPrzedmiotow.add(new Przedmiot("język niemiecki", 6));
        listaPrzedmiotow.add(new Przedmiot("historia", 4));
        listaPrzedmiotow.add(new Przedmiot("chemia", 4));
        listaPrzedmiotow.add(new Przedmiot("fizyka", 4));
        listaPrzedmiotow.add(new Przedmiot("wiedza o społeczeństwie", 4));
        listaPrzedmiotow.add(new Przedmiot("wychowanie fizyczne", 3));
        listaPrzedmiotow.add(new Przedmiot("religia", 4));
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
                System.out.println("\t"+i + 1+". "+nauczyciel.listaKlas.get(i).getNazwa());
            }
            System.out.println("\t"+nauczyciel.listaKlas.size() + 1+". Wstecz");
            System.out.print("Twój wybór: ");
            int choice = scanner.nextInt();
            if(choice <= nauczyciel.listaKlas.size() && choice >= 0)
                zarzadzajOcenami1(nauczyciel.listaKlas.get(choice - 1));
            else if(choice == nauczyciel.listaKlas.size() + 1)
                return;
            else
                System.out.println("Nie ma takiego wyboru! Spróbuj jeszcze raz. ");

        }
    }
    private void zarzadzajOcenami1(Klasa klasa){

    }

    @Override
    public void wpiszUwage(Nauczyciel Nauczyciel) {

    }

    @Override
    public void zarzadzajFrekwencja(Nauczyciel nauczyciel) {

    }
}
