package dziennik;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Klasa implements Serializable {
    /**
     * To jest klasa odpowiedzialna za Klasę
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * @param listaUczniow lista uczniów należących do klasy
     * @param listaNauczycieli lista nauczycieli uczących klasę
     * @param listaPrzedmiotow lista przedmiotów, które są uczone w klasie
     * @param tydzien lista dni tygodnia użytych do planu lekcji
     * @param nazwa nazwa klasy, np "3F"
     */
    public ArrayList<Uczen> listaUczniow = new ArrayList<>();
    public ArrayList<Nauczyciel> listaNauczycieli = new ArrayList<>();
    public ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();
    protected ArrayList<DzienTygodnia> tydzien = new ArrayList<>();
    private final Nauczyciel wychowawca;
    private final String nazwa;
    private Random rand = new Random();

    /**
     * Konstruktor automatycznie dopasowuje plan lekcji
     * na podstawie ilości godzin w tygodniu podanej w konstruktorze
     * klasy Przedmiot. Plan lekcji nie pozwala na okienka pomiędzy
     * lekcjami oraz nie ma możliwości 3 lub więcej lekcji danego
     * przedmiotu z rzędu.
     * @param nazwa nazwa klasy, np "3F"
     * @param wychowawca wychowawca klasy podawany jako obiekt klasy Nauczyciel
     * @param nauczyciele lista pozostałych nauczycieli uczących daną klasę, podawanych jako obiekty klasy Nauczyciel
     */
    public Klasa(String nazwa, Nauczyciel wychowawca, Nauczyciel...nauczyciele){
        tydzien.add(new DzienTygodnia("poniedziałek"));
        tydzien.add(new DzienTygodnia("wtorek"));
        tydzien.add(new DzienTygodnia("środa"));
        tydzien.add(new DzienTygodnia("czwartek"));
        tydzien.add(new DzienTygodnia("piątek"));
        this.wychowawca = wychowawca;
        this.wychowawca.setKlasaPodOpieką(this);
        this.wychowawca.dodajKlase(this);
        int dniDoOdhaczenia;
        if(wychowawca.listaPrzedmiotow.get(0).iloscGodzinTygodniowo >= tydzien.size())
            dniDoOdhaczenia = tydzien.size();
        else
            dniDoOdhaczenia = wychowawca.listaPrzedmiotow.get(0).iloscGodzinTygodniowo;
        process : while(wychowawca.listaPrzedmiotow.get(0).iloscGodzinTygodniowo > 0){
            int dzienTygodnia = rand.nextInt(tydzien.size());
            for(int i = 0; i < tydzien.get(dzienTygodnia).godzinaLekcyjna.length; i++){
                if(tydzien.get(dzienTygodnia).godzinaLekcyjna[i].equals(wychowawca.listaPrzedmiotow.get(0))){
                    continue process;
                }
            }
            if(wychowawca.listaPrzedmiotow.get(0).iloscGodzinTygodniowo > dniDoOdhaczenia){
                int randGodzina = rand.nextInt(tydzien.get(dzienTygodnia).godzinaLekcyjna.length);
                tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina] = wychowawca.listaPrzedmiotow.get(0);
                if(randGodzina < tydzien.get(dzienTygodnia).godzinaLekcyjna.length - 1)
                    tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina + 1] = wychowawca.listaPrzedmiotow.get(0);
                else
                    tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina - 1] = wychowawca.listaPrzedmiotow.get(0);
                wychowawca.listaPrzedmiotow.get(0).iloscGodzinTygodniowo -= 2;
                dniDoOdhaczenia--;
            } else {
                int randGodzina = rand.nextInt(tydzien.get(dzienTygodnia).godzinaLekcyjna.length);
                tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina] = wychowawca.listaPrzedmiotow.get(0);
                wychowawca.listaPrzedmiotow.get(0).iloscGodzinTygodniowo--;
                dniDoOdhaczenia--;
            }
        }
        for(int i = 1; i < wychowawca.listaPrzedmiotow.size(); i++){
            if(wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo >= tydzien.size())
                dniDoOdhaczenia = tydzien.size();
            else
                dniDoOdhaczenia = wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo;
            process : while(wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo > 0){
                int dzienTygodnia = rand.nextInt(tydzien.size());
                for(int j = 0; j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length; j++){
                    if(tydzien.get(dzienTygodnia).godzinaLekcyjna[j].equals(wychowawca.listaPrzedmiotow.get(i)))
                        continue process;
                }
                if(wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo > dniDoOdhaczenia){
                    if(isEmpty(tydzien.get(dzienTygodnia))){
                        int randGodzina = rand.nextInt(tydzien.get(dzienTygodnia).godzinaLekcyjna.length);
                        if(randGodzina < tydzien.size()){
                            tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina] = wychowawca.listaPrzedmiotow.get(i);
                            tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina + 1] = wychowawca.listaPrzedmiotow.get(i);
                            dniDoOdhaczenia--;
                            wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo -= 2;
                        } else {
                            tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina] = wychowawca.listaPrzedmiotow.get(i);
                            tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina - 1] = wychowawca.listaPrzedmiotow.get(i);
                            dniDoOdhaczenia--;
                            wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo -= 2;
                        }
                    } else {
                        for(int j = 0; j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length; j++){
                            if(j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length - 2 && tydzien.get(dzienTygodnia).godzinaLekcyjna[j].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1].getNazwa().equals("null") && !tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 2].getNazwa().equals("null")){
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[j] = wychowawca.listaPrzedmiotow.get(i);
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1] = wychowawca.listaPrzedmiotow.get(i);
                                dniDoOdhaczenia--;
                                wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo -= 2;
                                continue process;
                            } else if(j > 0 && !tydzien.get(dzienTygodnia).godzinaLekcyjna[j - 1].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1].getNazwa().equals("null")){
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[j] = wychowawca.listaPrzedmiotow.get(i);
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1] = wychowawca.listaPrzedmiotow.get(i);
                                dniDoOdhaczenia--;
                                wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo -= 2;
                                continue process;
                            }
                        }
                    }
                } else {
                    if(isEmpty(tydzien.get(dzienTygodnia))){
                        int randGodzina = rand.nextInt(tydzien.get(dzienTygodnia).godzinaLekcyjna.length);
                            tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina] = wychowawca.listaPrzedmiotow.get(i);
                            dniDoOdhaczenia--;
                            wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo--;
                    } else {
                        for(int j = 0; j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length; j++){
                            if(j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length - 1 && !tydzien.get(dzienTygodnia).godzinaLekcyjna[j].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1].getNazwa().equals("null")){
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1] = wychowawca.listaPrzedmiotow.get(i);
                                dniDoOdhaczenia--;
                                wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo--;
                                continue process;
                            } else if(j > 0 && !tydzien.get(dzienTygodnia).godzinaLekcyjna[j].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j - 1].getNazwa().equals("null")){
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[j - 1] = wychowawca.listaPrzedmiotow.get(i);
                                dniDoOdhaczenia--;
                                wychowawca.listaPrzedmiotow.get(i).iloscGodzinTygodniowo--;
                                continue process;
                            }
                        }
                    }
                }
            }
        }
        listaNauczycieli.add(wychowawca);
        for (Nauczyciel nauczyciel : nauczyciele) {
            for(int i = 0; i < nauczyciel.listaPrzedmiotow.size(); i++){
                if(nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo >= tydzien.size())
                    dniDoOdhaczenia = tydzien.size();
                else
                    dniDoOdhaczenia = nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo;
                process : while(nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo > 0){
                    int dzienTygodnia = rand.nextInt(tydzien.size());
                    for(int j = 0; j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length; j++){
                        if(tydzien.get(dzienTygodnia).godzinaLekcyjna[j].equals(nauczyciel.listaPrzedmiotow.get(i)))
                            continue process;
                    }
                    if(nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo > dniDoOdhaczenia){
                        if(isEmpty(tydzien.get(dzienTygodnia))){
                            int randGodzina = rand.nextInt(tydzien.get(dzienTygodnia).godzinaLekcyjna.length);
                            if(randGodzina < tydzien.size()){
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina] = nauczyciel.listaPrzedmiotow.get(i);
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina + 1] = nauczyciel.listaPrzedmiotow.get(i);
                                dniDoOdhaczenia--;
                                nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo -= 2;
                            } else {
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina] = nauczyciel.listaPrzedmiotow.get(i);
                                tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina - 1] = nauczyciel.listaPrzedmiotow.get(i);
                                dniDoOdhaczenia--;
                                nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo -= 2;
                            }
                        } else {
                            for(int j = 0; j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length; j++){
                                if(j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length - 2 && tydzien.get(dzienTygodnia).godzinaLekcyjna[j].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1].getNazwa().equals("null") && !tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 2].getNazwa().equals("null")){
                                    tydzien.get(dzienTygodnia).godzinaLekcyjna[j] = nauczyciel.listaPrzedmiotow.get(i);
                                    tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1] = nauczyciel.listaPrzedmiotow.get(i);
                                    dniDoOdhaczenia--;
                                    nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo -= 2;
                                    continue process;
                                } else if(j > 0 && !tydzien.get(dzienTygodnia).godzinaLekcyjna[j - 1].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1].getNazwa().equals("null")){
                                    tydzien.get(dzienTygodnia).godzinaLekcyjna[j] = nauczyciel.listaPrzedmiotow.get(i);
                                    tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1] = nauczyciel.listaPrzedmiotow.get(i);
                                    dniDoOdhaczenia--;
                                    nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo -= 2;
                                    continue process;
                                }
                            }
                        }
                    } else {
                        if(isEmpty(tydzien.get(dzienTygodnia))){
                            int randGodzina = rand.nextInt(tydzien.get(dzienTygodnia).godzinaLekcyjna.length);
                            tydzien.get(dzienTygodnia).godzinaLekcyjna[randGodzina] = nauczyciel.listaPrzedmiotow.get(i);
                            dniDoOdhaczenia--;
                            nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo--;
                        } else {
                            for(int j = 0; j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length; j++){
                                if(j < tydzien.get(dzienTygodnia).godzinaLekcyjna.length - 1 && !tydzien.get(dzienTygodnia).godzinaLekcyjna[j].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1].getNazwa().equals("null")){
                                    tydzien.get(dzienTygodnia).godzinaLekcyjna[j + 1] = nauczyciel.listaPrzedmiotow.get(i);
                                    dniDoOdhaczenia--;
                                    nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo--;
                                    continue process;
                                } else if(j > 0 && !tydzien.get(dzienTygodnia).godzinaLekcyjna[j].getNazwa().equals("null") && tydzien.get(dzienTygodnia).godzinaLekcyjna[j - 1].getNazwa().equals("null")){
                                    tydzien.get(dzienTygodnia).godzinaLekcyjna[j - 1] = nauczyciel.listaPrzedmiotow.get(i);
                                    dniDoOdhaczenia--;
                                    nauczyciel.listaPrzedmiotow.get(i).iloscGodzinTygodniowo--;
                                    continue process;
                                }
                            }
                        }
                    }
                }
            }
            nauczyciel.dodajKlase(this);
            listaNauczycieli.add(nauczyciel);
        }
        for (Nauczyciel nauczyciel : listaNauczycieli) {
            listaPrzedmiotow.addAll(nauczyciel.listaPrzedmiotow);
        }
        this.nazwa = nazwa;
    }

    /**
     * Metoda sprawdzająca, czy dany dzień tygodnia jest pusty.
     * Używana w konstruktorze przy generacji planu lekcji
     * @param dzienTygodnia
     * @return zwraca prawdę jeżeli w danym dniu nie ma jeszcze dodanej żadnej lekcji,
     * w przeciwnym przypadku zwraca fałsz
     */
    private static Boolean isEmpty(DzienTygodnia dzienTygodnia){
        for(int i = 0; i < dzienTygodnia.godzinaLekcyjna.length; i++){
            if(!dzienTygodnia.godzinaLekcyjna[i].getNazwa().equals("null"))
                return false;
        }
        return true;
    }

    /**
     * Metoda dodająca ucznia do klasy w kolejności alfabetycznej
     * @param uczen obiekt klasy Uczen, którego chcemy dodać do klasy
     */
    public void addStudent(Uczen uczen){
        if(listaUczniow.isEmpty())
            listaUczniow.add(uczen);
        else{
            int i = 0;
            while(true){
                if(listaUczniow.get(i).getNazwisko().compareTo(uczen.getNazwisko()) < 0 && i == listaUczniow.size() - 1) {
                    listaUczniow.add(uczen);
                    break;
                }else if(listaUczniow.get(i).getNazwisko().compareTo(uczen.getNazwisko()) < 0)
                    i++;
                else {
                    listaUczniow.add(i, uczen);
                    break;
                }
            }
        }
    }

    /**
     * Metoda zwracająca nazwę klasy
     * @return zwraca nazwę klasy w formie tekstowej, np "3F"
     */
    public String getNazwa() {
        return nazwa;
    }
}
