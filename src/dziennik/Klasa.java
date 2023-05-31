package dziennik;

import java.util.ArrayList;

public class Klasa {
    public ArrayList<Uczen> listaUczniow = new ArrayList<>();
    public ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();
    private Nauczyciel wychowawca;
    private String nazwa;
    public Klasa(String nazwa, Nauczyciel wychowawca, Przedmiot nazwaPrzedmiotu, Przedmiot...nazwyPrzedmiotow){
        listaPrzedmiotow.add(nazwaPrzedmiotu);
        for(int i = 0; i < nazwyPrzedmiotow.length; i++)
            listaPrzedmiotow.add(nazwyPrzedmiotow[i]);
        this.wychowawca = wychowawca;
        this.wychowawca.setKlasaPodOpieką(this);
        this.nazwa = nazwa;
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

    public String getNazwa() {
        return nazwa;
    }
}
