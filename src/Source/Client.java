package Source;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Source.JavaUtils.*;

public class Client {
    // attributi
    private Scanner clientIn = new Scanner(System.in);
    private List<Dipendente> dipendenti;
    private List<Azienda> aziende;
    // costruttore
    public Client() {
        dipendenti = new ArrayList<Dipendente>();
        aziende = new ArrayList<Azienda>();
    }

    //+++++ getter/setter +++++

    public List<Azienda> getAziende() {
        return aziende;
    }

    public void setAziende(List<Azienda> aziende) {
        this.aziende = aziende;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    //----- end getter/setter -----

    public void welcome() {
        System.out.println("+-+-+ Benvenuto nel gestore di aziende e dipendenti +-+-+\n");
    }

    public void start() {
        System.out.println(
                """
                        Premere 1 per gestire le aziende\s
                        Premere 2 per gestire i dipendenti\s
                        Premere 0 per uscire del programma""");
        int startSwitchVar = clientIn.nextInt();
        switch (startSwitchVar) {
            case 0 -> {
                System.out.println("Esco dal programma ...");
                System.exit(1);
            }
            case 1 -> {
                gestoreAziende();
            }

            case 2 -> {
                gestoreDipendenti();
            }
            default -> start();
        }
        start();
    }

    public void gestoreAziende() {
        System.out.println(
                """
                        Premere 1 per vedere tutte le aziende
                        Premere 2 per creare un'azienda
                        Premere 3 per eliminare un'azienda
                        Premere 0 per tornare indietro""");
        int gestoreAziendeSwitchVar = clientIn.nextInt();
        switch (gestoreAziendeSwitchVar) {
            case 0 -> {
                return;
            }
            case 1 -> {
                for (int i = 0; i < aziende.size(); i++) {
                    System.out.println(aziende.get(i));
                }
            }
            case 2 -> {
                System.out.println("Inserire il Nome dell'aziende");
                String nome = clientIn.nextLine();
                System.out.println("Inserire il Tipo dell'aziende");
                String tipo = clientIn.nextLine();
                creaAzienda(nome, tipo);
                System.out.println("Azienda creata: ");
                System.out.println(aziende.get(aziende.size() - 1));
            }
            case 3 -> {
                ///
            }
            default -> gestoreAziende();
        }
        gestoreAziende();
    }

    public void gestoreDipendenti() {
        //todo
    }

    public void creaAzienda(String nome, String tipo) {
        aziende.add(new Azienda(nome, tipo));
    }

    public void cancAzienda(Azienda azienda) {
        aziende.remove(azienda);
    }

    public void creaDipendente(String nome, String cognome, String annoDiNascita) {
        dipendenti.add(new Dipendente(nome, cognome, annoDiNascita));
    }

    public void cancDipendente(Dipendente dipendente) {
        dipendenti.remove(dipendente);
    }

    public void test() {
        System.out.println("Inserire il Nome dell'aziende");
        String nome = clientIn.nextLine();
        System.out.println("Inserire il Tipo dell'aziende");
        String tipo = clientIn.nextLine();
        creaAzienda(nome, tipo);

    }
}
