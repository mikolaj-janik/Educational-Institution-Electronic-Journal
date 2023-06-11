package dziennik;

public class Przedmiot {
    private String nazwa;
    private Nauczyciel prowadzacy;
    protected int iloscGodzinTygodniowo;

    public Przedmiot(String nazwa, int iloscGodzinTygodniowo) {
        this.nazwa = nazwa;
        this.iloscGodzinTygodniowo = iloscGodzinTygodniowo;
    }
    protected Przedmiot(String nazwa){
        this.nazwa = nazwa;
    }
    public void setProwadzacy(Nauczyciel prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public Nauczyciel getProwadzacy() {
        return prowadzacy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String toString(){
        return "Przedmiot: "+ nazwa + ",  Prowadzący: "+ prowadzacy;
    }
}
