import dziennik.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Deserializacja {
    /**\
     * @author Mikołaj Janik, Patryk Cygnar, Marian- Dominik Bereza
     * Klasa odpowiedzialna za sprawdzenie, czy deserializacja została wykonana poprawnie
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream we = new ObjectInputStream(new FileInputStream(".\\uczen.dat"));
        Uczen student = (Uczen) we.readObject();
        Dziennik dziennik2 = new Dziennik(student);
        System.out.println(student);
        we.close();

    }
}
