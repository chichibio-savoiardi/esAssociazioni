package Source;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    // attributi
    private Scanner clientIn;
    private List<Dipendente> dipendenti;
    private List<Azienda> aziende;
    // costruttore
    public Client() {
        clientIn = new Scanner(System.in);
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

    public void start() {
        welcome();
        gestore();
    }

    public void welcome() {
        System.out.println("+-+-+ Benvenuto nel gestore di aziende e dipendenti +-+-+\n");
    }

    public void gestore() {
        System.out.println("""
                        -----
                        Premere 1 per gestire le aziende
                        Premere 2 per gestire i dipendenti
                        Premere 0 per uscire del programma
                        -----""");
        int startSwitchVar = clientIn.nextInt();
        switch (startSwitchVar) {
            case 0 -> {
                System.out.println("Esco dal programma ...");
                System.exit(2);
            }
            case 1 -> {
                gestoreAziende();
            }

            case 2 -> {
                gestoreDipendenti();
            }
            default -> gestore();
        }
        gestore();
    }

    public void gestoreAziende() {
        System.out.println("""
                        -----
                        Premere 1 per vedere tutte le aziende
                        Premere 2 per creare un'azienda
                        Premere 3 per eliminare un'azienda
                        Premere 0 per tornare indietro
                        -----""");
        int gestoreAziendeSwitchVar = clientIn.nextInt();
        switch (gestoreAziendeSwitchVar) {
            case 0 -> {
                gestore();
            }
            case 1 -> {
                printAziende();
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
                printAziende();
                System.out.println("\nInerisci l'indice dell'azienda che vuoi eliminare");
                int aziendaToRemove = clientIn.nextInt();
                try {
                    cancAzienda(aziendaToRemove);
                } catch (Exception e) {
                    System.out.println("Exception!\nL'indice è fuori dalla lista");
                    gestoreAziende();
                }
                System.out.println("Azienda eliminata");
                printAziende();
            }
            default -> gestoreAziende();
        }
        gestoreAziende();
    }

    public void gestoreDipendenti() {
        System.out.println("""
                -----
                Premere 1 per stampare tutte le persone assumibili
                Premere 2 per creare un dipendente
                Premere 3 per rimuovere fisicamente un dipendente
                Premere 4 per XXX
                -----""");
        int gestoreDipendentiSwitchVar = clientIn.nextInt();
        switch (gestoreDipendentiSwitchVar) {
            case 0 -> {
                return;
            }
            case 1 -> printDipendenti();
            case 2 -> {
                System.out.println("Inserire il Nome del dipendente");
                String nome = clientIn.nextLine();
                System.out.println("Inserire il Tipo dell'aziende");
                String cognome = clientIn.nextLine();
                System.out.println("Inserire il Tipo dell'aziende");
                String data = clientIn.nextLine();
                creaDipendente(nome, cognome, data);
                System.out.println("Dipendente creato: ");
                System.out.println(dipendenti.get(dipendenti.size() - 1));
            }
            case 3 -> {
                ///
            }
            default -> gestoreDipendenti();
        }
        gestoreDipendenti();
    }

    public void printAziende() {
        if (aziende.size() == 0) {
            System.out.println("Non ci sono aziende nel database\n");
            return;
        }
        for (int i = 0; i < aziende.size(); i++) {
            System.out.println(i + ": " + aziende.get(i));
        }
    }

    public void printDipendenti() {
        if (dipendenti.size() == 0) {
            System.out.println("Non ci sono dipendenti nel database\n");
            return;
        }
        for (int i = 0; i < dipendenti.size(); i++) {
            System.out.println(i + ": " + dipendenti.get(i));
        }
    }

    public void creaAzienda(String nome, String tipo) {
        aziende.add(new Azienda(nome, tipo));
    }

    public void cancAzienda(int index) {
        aziende.remove(index);
    }

    public void creaDipendente(String nome, String cognome, String annoDiNascita) {
        dipendenti.add(new Dipendente(nome, cognome, annoDiNascita));
    }

    public void cancDipendente(int index) {
        dipendenti.remove(index);
    }

    public void test() {
        System.out.println("Inserire il Nome dell'aziende");
        String nome = clientIn.nextLine();
        System.out.println("Inserire il Tipo dell'aziende");
        String tipo = clientIn.nextLine();
        creaAzienda(nome, tipo);

    }
}
