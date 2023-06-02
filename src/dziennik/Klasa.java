package dziennik;

import java.util.ArrayList;

public class Klasa {
    public ArrayList<Uczen> listaUczniow = new ArrayList<>();
    public ArrayList<Nauczyciel> listaNauczycieli = new ArrayList<>();
    public ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();
    private Nauczyciel wychowawca;
    private String nazwa;
    public Klasa(String nazwa, Nauczyciel wychowawca, Nauczyciel...nauczyciele){
        this.wychowawca = wychowawca;
        this.wychowawca.setKlasaPodOpieką(this);
        listaNauczycieli.add(wychowawca);
        for(int i = 0; i < nauczyciele.length; i++)
            listaNauczycieli.add(nauczyciele[i]);
        this.nazwa = nazwa;
        for(int i = 0; i < listaNauczycieli.size(); i++){
            for(int j = 0; j < listaNauczycieli.get(i).listaPrzedmiotow.size(); j++)
                listaPrzedmiotow.add(listaNauczycieli.get(i).listaPrzedmiotow.get(j));
        }
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
