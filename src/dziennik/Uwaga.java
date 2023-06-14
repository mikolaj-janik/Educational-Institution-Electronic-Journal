package dziennik;

import java.io.Serializable;
import java.time.LocalDate;

public class Uwaga implements Serializable {
    /**
     * To jest klasa odpowiedzialna za uwagę
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * @param nauczyciel nauczyciel wstawiający uwagę
     * @param uczen uczeń, który otrzymuje uwagę
     * @param uwaga treść uwagi
     * @param dataDodania data dodania uwagi
     * @param TytulUwagi tytuł uwagi
     */
    private Nauczyciel nauczyciel;
    private Uczen uczen;
    private String uwaga;
    private LocalDate dataDodania;
    private String TytulUwagi;
    protected Uwaga(String uwaga, String TytulUwagi, LocalDate dataDodania, Nauczyciel nauczyciel){
        this.nauczyciel = nauczyciel;
        this.uwaga = uwaga;
        this.TytulUwagi = TytulUwagi;
        this.dataDodania = dataDodania;
    }

    /**
     * Metoda zwracająca nauczyciela, który wystawił uwagę
     * @return zwraca nauczyciela, który wystawił uwagę
     */
    public Nauczyciel getNauczyciel() {
        return nauczyciel;
    }
    /**
     * Metoda zwracająca tytuł uwagi
     * @return zwraca tytuł uwagi
     */
    public String getTytulUwagi() {
        return TytulUwagi;
    }
    /**
     * Metoda zwracająca uwagę jako obiekt typu Uwaga
     * @return zwraca uwagę jako obiekt
     */
    public String getUwaga() {
        return uwaga;
    }
}
