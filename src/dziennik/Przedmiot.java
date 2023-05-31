package dziennik;

public class Przedmiot {
    private String nazwa;
    private Nauczyciel prowadzacy;
    private int iloscOcenDoZaliczenia;

    public Przedmiot(String nazwa, int iloscOcenDoZaliczenia) {
        this.nazwa = nazwa;
        this.iloscOcenDoZaliczenia = iloscOcenDoZaliczenia;
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
