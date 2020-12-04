package Source;

import Source.javaUtils.arrayUtils;

public class Azienda {
    protected String nome;
    protected String tipoAssociazione;
    protected partitaIVA partitaIVA = new partitaIVA();
    private int capitaleSociale;
    private arrayUtils arrayUtils = new arrayUtils();
    private Dipendente[] Dipendente;

    public Azienda(String nome, String tipo, int capitaleSociale) {
        this.capitaleSociale = capitaleSociale;
        this.partitaIVA.paese[0] = 'I';
        this.partitaIVA.paese[1] = 'T';
        arrayUtils.randomFill(partitaIVA.numero, 0, 9);
        this.nome = nome;
        this.tipoAssociazione = tipo;
        Dipendente = new Dipendente[capitaleSociale];
    }

    public int getCapitaleSociale() {
        return capitaleSociale;
    }

    public void setCapitaleSociale(int capitaleSociale) {
        this.capitaleSociale = capitaleSociale;
    }

    public Source.partitaIVA getPartitaIVA() {
        return partitaIVA;
    }

    public void setPartitaIVA(Source.partitaIVA partitaIVA) {
        this.partitaIVA = partitaIVA;
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
        } else if (capitaleSociale >= 50 && capitaleSociale <= 250) {
            return "Media";
        } else if (capitaleSociale > 250) {
            return "Grande";
        }
        return "no";
    }

    public void incCapitaleSociale(int quantita) {
        capitaleSociale += quantita;
    }

    public void decCapitaleSociale(int quantita) {
        capitaleSociale -= quantita;
    }
}
