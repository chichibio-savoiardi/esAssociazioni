package Source;

import java.time.LocalDate;
import java.time.Period;

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

    public int calcolaEta() {// copied from emanuele
        int anno = Integer.parseInt(annoNascita.substring(6, 10));
        int mese = Integer.parseInt(annoNascita.substring(3, 5));
        int giorno = Integer.parseInt(annoNascita.substring(0, 2));

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(anno, mese, giorno);

        Period p = Period.between(birthday, today);

        return p.getYears();
    }

    public void assumi(String nomeAzienda) {
        reddito += 1000;
        assuntoPresso = nomeAzienda;
        assunto = true;
    }

    public void licenzia() {
        reddito -= reddito;
        assuntoPresso = "Empty";
        assunto = false;
    }

    public void sposa(Dipendente dipendenteIn) {

        sposato = true;
        dipendenteIn.setSposato(true);
    }

    public void divorzia(Dipendente dipendenteIn) {
        if (!sposato) {
            System.out.println(nome + " e' gia divorziato");
            return;
        }
        if (!dipendenteIn.isSposato()) {
            System.out.println(dipendenteIn.getNome() + " e' gia divorziato");
            return;
        }
        sposato = false;
        dipendenteIn.setSposato(false);
    }

    public String toString() {
        return "Dipendente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", annoNascita='" + annoNascita + '\'' +
                ", assuntoPresso='" + assuntoPresso + '\'' +
                ", assunto=" + assunto +
                ", reddito=" + reddito +
                ", sposato=" + sposato +
                '}';
    }
}
// fin