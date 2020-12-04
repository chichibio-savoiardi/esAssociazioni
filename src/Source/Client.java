package Source;

import java.util.Scanner;
import Source.javaUtils.*;

public class Client {
    private Scanner clientIn = new Scanner(System.in);
    static Dipendente dipendente;
    static Azienda azienda;

    public Client() {
        dipendente = new Dipendente("bob", "sasso", "17/11/1989");
        azienda = new Azienda("Raytheon Corporation", "S.R.L.");
    }

    public void start() {
        System.out.println(dipendente.toString());
        System.out.println(azienda.toString());
    }
}
