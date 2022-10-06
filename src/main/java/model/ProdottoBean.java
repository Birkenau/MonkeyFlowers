package model;

import java.util.Objects;

public class ProdottoBean {
    private int id_prodotto;
    private String nome_prodotto;
    private String img;
    private int quantita;
    private String tipo;
    private double prezzo;
    private String descrizione;


    public ProdottoBean(){}

    public int getQuantita(){ return quantita;}
    public int getId_prodotto() {
        return id_prodotto;
    }
    public String getNome_prodotto() {
        return nome_prodotto;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public String getImg() {
        return img;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public String getTipo() {
        return tipo;
    }


    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setQuantita(int quantita){this.quantita = quantita;}
    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }
    public void setNome_prodotto(String nome_prodotto) {
        this.nome_prodotto = nome_prodotto;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public void setImg(String img) {this.img = img;}
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ProdottoBean{" +
                "id_prodotto=" + id_prodotto +
                ", nome_prodotto=" + nome_prodotto + '\'' +
                ", prezzo=" + prezzo +
                ", img=" + img + '\'' +
                ", descrizione=" + descrizione + '\'' +
                ", tipo=" + tipo + '\'' +
                ", quantita=" + quantita +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdottoBean)) return false;
        ProdottoBean that = (ProdottoBean) o;
        return getId_prodotto() == that.getId_prodotto() && getQuantita() == that.getQuantita() && Double.compare(that.getPrezzo(), getPrezzo()) == 0 && getNome_prodotto().equals(that.getNome_prodotto()) && getImg().equals(that.getImg()) && getTipo().equals(that.getTipo()) && getDescrizione().equals(that.getDescrizione());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_prodotto(), getNome_prodotto(), getImg(), getQuantita(), getTipo(), getPrezzo(), getDescrizione());
    }
}
