package dziennik;

import java.time.LocalDate;
/**
 * Interfejs dziennika
 * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
 * Metody pokazOceny, pokazPlanLekcji, pokazKalendarzZdarzen, pokazUwagi obsługuje uczeń
 * Metody zarzadzajKalendarzem, zarzadzajOcenami, wpiszUwage obsługuje nauczyciel
 */
public interface DziennikInterfejs {
    void pokazOceny(Uczen uczen);
    void pokazPlanLekcji(Uczen uczen);
    void pokazKalendarzZdarzen(Uczen uczen);
    void pokazUwagi(Uczen uczen);
    void zarzadzajKalendarzem(Nauczyciel nauczyciel);
    void zarzadzajOcenami(Nauczyciel nauczyciel);
    void wpiszUwage(Nauczyciel Nauczyciel);
}
