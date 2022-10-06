package model;

public class OrdineBean {
    private int id_ordine;
    private int id_utente;
    private String indirizzo;
    private int civico;
    private int cap;
    private String provincia;
    private String citta;

    public int getId_utente() {
        return id_utente;
    }

    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }

    public int getCivico() {
        return civico;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }



    public int getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }





    @Override
    public String toString() {
        return "Ordine{" +
                "id_ordine=" + id_ordine +
                ", id_utente='" + id_utente +
                ", indirizzo='" + indirizzo + '\'' +
                ", civico='" + civico +
                ", cap='" + cap +
                ", provincia='" + provincia + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
