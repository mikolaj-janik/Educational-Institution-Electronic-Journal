package dziennik;

import java.time.LocalDate;

public interface DziennikInterfejs {
    void pokazOceny(Uczen uczen);
    void pokazPlanLekcji(Uczen uczen);
    void pokazKalendarzZdarzen(Uczen uczen);
    void pokazUwagi(Uczen uczen);
    void pokazFrekwencje(Uczen uczen);
    void zarzadzajKalendarzem(Nauczyciel nauczyciel);
    void zarzadzajOcenami(Nauczyciel nauczyciel);
    void wpiszUwage(Nauczyciel Nauczyciel);
    void zarzadzajFrekwencja(Nauczyciel nauczyciel);

}
