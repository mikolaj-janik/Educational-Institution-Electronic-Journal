package dziennik;

import java.time.LocalDate;

public abstract class Osoba {
    protected int wiek;
    protected String imie;
    protected String nazwisko;
    private LocalDate dataUrodzenia;

    public Osoba(String imie, String nazwisko, LocalDate dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        int wiek = LocalDate.now().getYear() - dataUrodzenia.getYear();
        if(LocalDate.now().getDayOfYear() < dataUrodzenia.getDayOfYear())
            wiek -= 1;
        this.wiek = wiek;
    }

    public int getWiek() {
        return wiek;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String toString(){
        return imie + " " + nazwisko + "  wiek: " + wiek;
    }


}
