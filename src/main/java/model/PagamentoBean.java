package model;

public class PagamentoBean {
    private int idmetodo;
    private int iban;
    private String scadenza;
    private String cvv;
    private int idutente;

    public int getIdmetodo() {
        return idmetodo;
    }

    public void setIdmetodo(int idmetodo) {
        this.idmetodo = idmetodo;
    }

    public int getIban() {
        return iban;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public String getScadenza() {
        return scadenza;
    }

    public void setScadenza(String scadenza) {
        this.scadenza = scadenza;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getIdutente() {
        return idutente;
    }

    public void setIdutente(int idutente) {
        this.idutente = idutente;
    }

    @Override
    public String toString() {
        return "Metododipagamento{" +
                "idmetodo=" + idmetodo +
                "iban=" + iban +
                ", scadenza='" + scadenza + '\'' +
                ", cvv='" + cvv + '\'' +
                ", idutente='" + idutente +
                '}';
    }
}
