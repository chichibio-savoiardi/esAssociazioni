/*+++++
* Autore: Iuri Antico
* -----
*/
package Source;

import java.util.Scanner;
import Source.javaUtils.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Client client = new Client();
    static Dipendente Dipendente = new Dipendente("bob", "sasso", "17111989");

    public static void main(String[] args) {
        System.out.println(Dipendente.getAnnoNascita());
        System.out.println(Dipendente.calcolaEta());
    }
}
