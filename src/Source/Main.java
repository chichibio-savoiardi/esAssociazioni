/*+++++
* Autore: Iuri Antico
* -----
* non sono riuscito a finirlo in tempo
* +++++
*/
package Source;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    static Client client = new Client();

    public static void main(String[] args) {
        client.creaAzienda("raytheon", "srl");
        client.creaAzienda("lockheed", "sas");
        client.creaAzienda("leonardo", "corp");
        client.start();
    }
}
//fin