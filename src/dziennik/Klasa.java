package dziennik;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Klasa implements Serializable {
    public ArrayList<Uczen> listaUczniow = new ArrayList<>();
    public ArrayList<Nauczyciel> listaNauczycieli = new ArrayList<>();
    public ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();
    protected ArrayList<DzienTygodnia> tydzien = new ArrayList<>();
    protected HashMap<LocalDate, Przedmiot> kalendarz = new HashMap<>();
    private final Nauczyciel wychowawca;
    private final String nazwa;
    private Random rand = new Random();
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
    private static Boolean isEmpty(DzienTygodnia dzienTygodnia){
        for(int i = 0; i < dzienTygodnia.godzinaLekcyjna.length; i++){
            if(!dzienTygodnia.godzinaLekcyjna[i].getNazwa().equals("null"))
                return false;
        }
        return true;
    }
    public void addStudent(Uczen uczen){ //ta metoda dodaje uczniów alfafbetycznie do dziennika
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
    public void getListaUczniow(){
        for(int i = 0; i < listaUczniow.size(); i++)
            System.out.println(i + 1 + ". " + listaUczniow.get(i));
    }

    public Nauczyciel getWychowawca() {
        return wychowawca;
    }
    public void printListaPrzedmiotow(){
        for(int i = 0; i < listaPrzedmiotow.size(); i++)
            System.out.println(i+1+". "+listaPrzedmiotow.get(i).getNazwa());
    }
    public String getNazwa() {
        return nazwa;
    }
}
