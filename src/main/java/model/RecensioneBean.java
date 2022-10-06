package model;

public class RecensioneBean {
    private int idrecensione;
    private int prodotto;
    private int utente;
    private int voto;
    private String testo;


    public int getIdrecensione() {
        return idrecensione;
    }

    public void setIdrecensione(int idrecensione) {
        this.idrecensione = idrecensione;
    }


    public int getProdotto() {
        return prodotto;
    }

    public void setProdotto(int prodotto) {
        this.prodotto = prodotto;
    }

    public int getUtente() {
        return utente;
    }

    public void setUtente(int utente) {
        this.utente = utente;
    }


    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }


    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    @Override
    public String toString() {
        return "Recensione{" +
                "idrecensione=" + idrecensione +
                ", prodotto='" + prodotto +
                ", utente='" + utente +
                ", voto='" + voto +
                ", testo='" + testo + '\'' +
                '}';
    }
}
