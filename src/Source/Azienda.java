package Source;

import Source.JavaUtils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Azienda {
    private String nome;
    private String tipoAssociazione;
    private partitaIVA partitaIVA = new partitaIVA();
    private int capitaleSociale;
    private ArrayUtils arrayUtils = new ArrayUtils();
    protected List<Dipendente> dipendentiAzienda;

    public Azienda(String nome, String tipo) {
        this.capitaleSociale = 0;
        this.partitaIVA.paese[0] = 'I';
        this.partitaIVA.paese[1] = 'T';
        arrayUtils.randomFill(partitaIVA.numero, 0, 9);
        this.nome = nome;
        this.tipoAssociazione = tipo;
        dipendentiAzienda = new ArrayList<Dipendente>();
    }

    public int getCapitaleSociale() {
        return capitaleSociale;
    }

    public void setCapitaleSociale(int capitaleSociale) {
        this.capitaleSociale = capitaleSociale;
    }

    public int[] getNumeroIVA() {
        return partitaIVA.numero;
    }

    public void setNumeroIVA(int[] numero) {
        this.partitaIVA.numero = numero;
    }

    public char[] getPaeseIVA() {
        return partitaIVA.paese;
    }

    public void setPaeseIVA(char[] paese) {
        this.partitaIVA.paese = paese;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoAssociazione() {
        return tipoAssociazione;
    }

    public void setTipoAssociazione(String tipoAssociazione) {
        this.tipoAssociazione = tipoAssociazione;
    }

    public String dimensioneImpresa() {
        if (capitaleSociale < 50) {
            return "Piccola";
        } else if (capitaleSociale > 250) {
            return "Grande";
        } else {
            return "Media";
        }
    }

    public void incCapitaleSociale(Dipendente dipendenteIn) {
        if (dipendenteIn.isAssunto()) {
            System.out.println("Error\nDipendente gia assunto");
            return;
        }
        capitaleSociale += 1;
        dipendentiAzienda.add(dipendenteIn);
        dipendenteIn.assumi(nome);
    }

    public void decCapitaleSociale(Dipendente dipendenteIn) {
        if (!dipendenteIn.isAssunto()) {
            System.out.println("Error\nDipendente gia non assunto");
            return;
        }
        capitaleSociale -= 1;
        dipendentiAzienda.remove(dipendenteIn);
        dipendenteIn.licenzia();
    }

    public void printDipendentiAzienda() {
        if (dipendentiAzienda.size() == 0) {
            System.out.println("Non ci sono dipendenti nel database\n");
            return;
        }
        for (int i = 0; i < dipendentiAzienda.size(); i++) {
            System.out.println(i + ": " + dipendentiAzienda.get(i));
        }
    }

    public String toString() {
        return "Azienda{" +
                "nome='" + nome + '\'' +
                ", tipoAssociazione='" + tipoAssociazione + '\'' +
                ", partitaIVA.paese=" + Arrays.toString(partitaIVA.paese) +
                ", partitaIVA.numero=" + Arrays.toString(partitaIVA.numero) +
                ", capitaleSociale=" + capitaleSociale +
                ", dipendentiAzienda=" + dipendentiAzienda +
                '}';
    }
}
