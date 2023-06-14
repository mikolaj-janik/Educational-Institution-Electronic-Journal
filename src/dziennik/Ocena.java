package dziennik;

import java.io.Serializable;
import java.time.LocalDate;


class Ocena implements Serializable {
    /**
     * To jest klasa odpowiedzialna za ocenę
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * @param waga waga oceny
     * @param ocena wartość liczbowa oceny (double)
     * @param etykieta etykieta oceny
     * @param dataDodania data dodania oceny
     * @param prowadzacy nauczyciel, który dodał ocenę
     */
    private int waga;
    private double ocena;
    private String etykieta;
    private LocalDate dataDodania;
    private Nauczyciel prowadzacy;
    protected Ocena(double ocena, int waga, String etykieta, LocalDate dataDodania, Nauczyciel prowadzacy){
        this.ocena = ocena;
        this.waga = waga;
        this.etykieta = etykieta;
        this.dataDodania = dataDodania;
        this.prowadzacy = prowadzacy;
    }

    /**
     * Metoda zwracająca opis oceny
     * @return zwraca opis oceny (za co jest wystawiona)
     */
    protected String getEtykieta(){
        return etykieta;
    }

    /**
     * Metoda zwracająca wagę oceny
     * @return zwraca wagę oceny
     */
    protected double getWaga(){
        return waga;
    }

    /**
     * Metoda zwracająca wartość liczbową oceny
     * @return zwraca wartość liczbową oceny
     */
    protected double getOcena(){
        return ocena;
    }

    /**
     * Metoda zwracająca słowną reprezentację oceny
     * @return zwraca słowną reprezentację oceny
     */
    @Override
    public String toString(){
        if(ocena == 1.0)
            return "1  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 1.5)
            return "+1  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 1.75)
            return "-2  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 2.0)
            return "2  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 2.5)
            return "+2  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 2.75)
            return "-3  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 3.0)
            return "3  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 3.5)
            return "+3  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 3.75)
            return "-4  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 4.0)
            return "4  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 4.5)
            return "+4  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 4.75)
            return "-5  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 5.0)
            return "5  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 5.5)
            return "+5  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 5.75)
            return "-6  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 6.0)
            return "6  waga: "+waga+ ",  " + etykieta + ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        return null;
    }
}
