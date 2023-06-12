package dziennik;

import java.io.Serializable;

public class DzienTygodnia implements Serializable {
    protected Przedmiot [] godzinaLekcyjna = new Przedmiot[8];
    protected String [] godzinyLekcyjne = new String[8];
    protected String nazwa;
    protected DzienTygodnia(String nazwa){
        this.nazwa = nazwa;
        for(int i = 0; i < godzinaLekcyjna.length; i++)
            godzinaLekcyjna[i] = new Przedmiot("null");
        godzinyLekcyjne[0] = "8:00 - 8:45";
        godzinyLekcyjne[1] = "8:55 - 9:40";
        godzinyLekcyjne[2] = "9:50 - 10:35";
        godzinyLekcyjne[3] = "10:45 - 11:30";
        godzinyLekcyjne[4] = "11:40 - 12:25";
        godzinyLekcyjne[5] = "12:45 - 13:30";
        godzinyLekcyjne[6] = "13:40 - 14:25";
        godzinyLekcyjne[7] = "14:35 - 15:20";
    }
    protected String getNazwa(){
        return nazwa;
    }
}
