package dziennik;

public class Uwaga {
    private Nauczyciel nauczyciel;
    private Uczen uczen;
    protected Uwaga(Nauczyciel nauczyciel, Uczen uczen){
        this.nauczyciel = nauczyciel;
        this.uczen = uczen;
    }
}
