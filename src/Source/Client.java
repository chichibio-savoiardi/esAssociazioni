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
        System.out.println("+-+-+ Benvenuto nel gestore di aziende e dipendenti +-+-+\n");
        gestore();
    }

    public void gestore() {
        System.out.println("""
                        -+-+-
                        Premere 1 per gestire le aziende
                        Premere 2 per gestire i dipendenti
                        Premere 0 per uscire del programma
                        -+-+-""");
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
                        -+-+-
                        Premere 1 per vedere tutte le aziende
                        Premere 2 per creare un'azienda
                        Premere 3 per eliminare un'azienda
                        Premere 4 per vedere i dipendenti di una azienda
                        Premere 5 per assumere un dipendente in una azienda
                        Premere 6 per licenziare un dipendente da una azienda
                        Premere 0 per tornare indietro
                        -+-+-""");
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
            case 4 -> {
                printAziende();
                System.out.println("Inserisci l'indice della tua azienda");
                int indexAzienda = clientIn.nextInt();
                aziende.get(indexAzienda).printDipendentiAzienda();
            }
            case 5 -> {
                printAziende();
                System.out.println("Inserisci l'indice della tua azienda");
                int indexAzienda = clientIn.nextInt();
                printDipendenti();
                System.out.println("Inserisci l'indice del dipendente da assumere");
                int indexDipendente = clientIn.nextInt();
                try {
                    aziende.get(indexAzienda).incCapitaleSociale(dipendenti.get(indexDipendente));
                } catch (Exception e) {
                    System.out.println("Exception!\nL'indice è fuori dalla lista");
                    gestoreAziende();
                }
                System.out.println("Dipendente assunto");
                aziende.get(indexAzienda).printDipendentiAzienda();
            }
            case 6 -> {
                printAziende();
                System.out.println("Inserisci l'indice della tua azienda");
                int indexAzienda = clientIn.nextInt();
                aziende.get(indexAzienda).printDipendentiAzienda();
                System.out.println("Inserisci l'indice del dipendente da licenziare");
                int indexDipendente = clientIn.nextInt();
                try {
                    aziende.get(indexAzienda).decCapitaleSociale(aziende.get(indexAzienda).dipendentiAzienda.get(indexDipendente));
                } catch (Exception e) {
                    System.out.println("Exception!\nL'indice è fuori dalla lista");
                    gestoreAziende();
                }
                System.out.println("Dipendente licenziato");
                aziende.get(indexAzienda).printDipendentiAzienda();
            }
            default -> gestoreAziende();
        }
        gestoreAziende();
    }

    public void gestoreDipendenti() {
        System.out.println("""
                -+-+-
                Premere 1 per stampare tutte le persone
                Premere 2 per creare un dipendente
                Premere 3 per rimuovere fisicamente un dipendente
                Premere 4 per calcolare l'eta' di un dipendente
                Premere 0 per tornare indietro
                -+-+-""");
        int gestoreDipendentiSwitchVar = clientIn.nextInt();
        switch (gestoreDipendentiSwitchVar) {
            case 0 -> {
                return;
            }
            case 1 -> printDipendenti();
            case 2 -> {
                System.out.println("Inserire il Nome del dipendente");
                String nome = clientIn.nextLine();
                System.out.println("Inserire il Cognome");
                String cognome = clientIn.nextLine();
                System.out.println("Inserire l'anno di nascita");
                String data = clientIn.nextLine();
                creaDipendente(nome, cognome, data);
                System.out.println("Dipendente creato: ");
                System.out.println(dipendenti.get(dipendenti.size() - 1));
            }
            case 3 -> {
                printDipendenti();
                System.out.println("\nInerisci l'indice del dipendente che vuoi eliminare");
                int dipendenteToRemove = clientIn.nextInt();
                try {
                    cancDipendente(dipendenteToRemove);
                } catch (Exception e) {
                    System.out.println("Exception!\nL'indice è fuori dalla lista");
                    gestoreDipendenti();
                }
                System.out.println("Dipendente eliminato");
                printDipendenti();
            }
            case 4 -> {
                printDipendenti();
                System.out.println("Scegli l'indice del dipendente a cui devo calcolare l'eta'");
                int indexDipendente = clientIn.nextInt();
                try {
                    dipendenti.get(indexDipendente).calcolaEta();
                } catch (Exception e) {
                    System.out.println("Exception!\nL'indice è fuori dalla lista");
                    gestoreAziende();
                }
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
