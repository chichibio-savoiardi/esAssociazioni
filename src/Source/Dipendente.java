package Source;

import java.lang.String;

public class Dipendente {
    private String nome, cognome, annoNascita, assuntoPresso;
    private boolean sposato, assunto;
    private double reddito;

    public Dipendente(String nome, String cognome, String annoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.annoNascita = annoNascita;
        this.sposato = false;
        this.assunto = false;
        this.assuntoPresso = "empty";
        this.reddito = 0.0;
    }

    public String getAnnoNascita() {
        return annoNascita;
    }

    public void setAnnoNascita(String annoNascita) {
        this.annoNascita = annoNascita;
    }

    public boolean isAssunto() {
        return assunto;
    }

    public void setAssunto(boolean assunto) {
        this.assunto = assunto;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getAssuntoPresso() {
        return assuntoPresso;
    }

    public void setAssuntoPresso(String assuntoPresso) {
        this.assuntoPresso = assuntoPresso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getReddito() {
        return reddito;
    }

    public void setReddito(double reddito) {
        this.reddito = reddito;
    }

    public boolean isSposato() {
        return sposato;
    }

    public void setSposato(boolean sposato) {
        this.sposato = sposato;
    }

    public int calcolaEta() {
        int eta = 0, nascita = Integer.parseInt(annoNascita);
        byte sas;
        String temp = annoNascita;
        temp = temp.replaceAll("/", "");
        return eta;
    }
}
// fin