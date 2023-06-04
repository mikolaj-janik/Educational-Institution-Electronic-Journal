package dziennik;

import java.time.LocalDate;

class Ocena {
    private int waga;
    private double ocena;
    private LocalDate dataDodania;
    private Nauczyciel prowadzacy;
    protected Ocena(double ocena, int waga, LocalDate dataDodania, Nauczyciel prowadzacy){
        this.ocena = ocena;
        this.waga = waga;
        this.dataDodania = dataDodania;
        this.prowadzacy = prowadzacy;
    }
    protected double getWaga(){
        return waga;
    }
    protected double getOcena(){
        return ocena;
    }
    @Override
    public String toString(){
        if(ocena == 1.0)
            return "1  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 1.5)
            return "+1  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 1.75)
            return "-2  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 2.0)
            return "2  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 2.5)
            return "+2  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 2.75)
            return "-3  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 3.0)
            return "3  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 3.5)
            return "+3  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 3.75)
            return "-4  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 4.0)
            return "4  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 4.5)
            return "+4  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 4.75)
            return "-5  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 5.0)
            return "5  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 5.5)
            return "+5  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 5.75)
            return "-6  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        else if(ocena == 6.0)
            return "6  waga: "+waga+ ",  data: "+dataDodania +"  dodane przez "+prowadzacy.toString();
        return null;
    }
}
