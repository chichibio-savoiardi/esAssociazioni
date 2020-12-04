/*+++++
* Autore: Iuri Antico
* -----
* non sono riuscito a finirlo in tempo
* non sono riuscito a commentarlo
* +++++
*/
package Source;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    static Client client = new Client();

    public static void main(String[] args) {
        generatore();
        client.start();
    }

    public static void generatore() {
        client.creaAzienda("Raytheon", "srl");
        client.creaAzienda("Boeing", "sas");
        client.creaAzienda("Leonardo", "corp");
        client.creaAzienda("Alphabet", "cong");
        client.creaAzienda("Apple", "ss");
        client.creaDipendente("John", "Browning", "17/12/1896");
        client.creaDipendente("Mark", "Serbu", "03/11/1923");
        client.creaDipendente("Donald", "Trump", "02/05/2001");
        client.creaDipendente("Joe", "Biden", "27/09/1984");
        client.creaDipendente("Jo", "Jorgensen", "01/02/1903");
    }
}
//fin