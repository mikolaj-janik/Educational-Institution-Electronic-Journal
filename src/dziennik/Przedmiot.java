package dziennik;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Przedmiot implements Serializable {
    private String nazwa;
    private Nauczyciel prowadzacy;
    protected int iloscGodzinTygodniowo;
    protected HashMap<LocalDate, String> kalendarz = new HashMap<>();
    protected LocalDate [] daty = new LocalDate[10];

    public Przedmiot(String nazwa, int iloscGodzinTygodniowo) {
        LocalDate data = LocalDate.now();
        this.nazwa = nazwa;
        this.iloscGodzinTygodniowo = iloscGodzinTygodniowo;
        for(int i = 0; i < 10; i++){
            data = data.plusDays(i + 1);
            if(data.getDayOfWeek().equals("SATURDAY"))
                data = data.plusDays(2);
            else if(data.getDayOfWeek().equals("SUNDAY"))
                data = data.plusDays(1);
            kalendarz.put(data, "null");
        }
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
