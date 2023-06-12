package dziennik;

import java.time.LocalDate;

public class Uwaga {
    private Nauczyciel nauczyciel;
    private Uczen uczen;
    private String uwaga;
    private LocalDate dataDodania;
    private String TytulUwagi;

    public Nauczyciel getNauczyciel() {
        return nauczyciel;
    }

    public String getTytulUwagi() {
        return TytulUwagi;
    }

    public void setNauczyciel(Nauczyciel nauczyciel) {
        this.nauczyciel = nauczyciel;
    }

    public String getUwaga() {
        return uwaga;
    }

    public Uczen getUczen() {
        return uczen;
    }

    public void setUczen(Uczen uczen) {
        this.uczen = uczen;
    }
    protected Uwaga(String uwaga, String TytulUwagi, LocalDate dataDodania, Nauczyciel nauczyciel){
        this.nauczyciel = nauczyciel;
        this.uwaga = uwaga;
        this.TytulUwagi = TytulUwagi;
        this.dataDodania = dataDodania;
    }
}
