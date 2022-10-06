package model;


import java.util.ArrayList;
import java.util.List;



public class Carrello {

    List<ProdottoBean> prodotti;

    //creazione del carrello
    public Carrello() {
        prodotti = new ArrayList<>();
    }

    public void aggiungiProdotto(ProdottoBean p){
        prodotti.add(p);
    }

    public void rimuoviProdotto(ProdottoBean p){

        for(int i=0;i<prodotti.size();i++){

            if (prodotti.get(i).equals(p)){  //rimuove il primo elemnto uguale ed eesce
                prodotti.remove(i);
                break;
            }
        }
    }


    public List<ProdottoBean> getProdotti() {
        return prodotti;
    }

    public int getTotQuantita(){
        return prodotti.size();
    }

    public double getTotPrezzo(){
        double somma=0;
        for (ProdottoBean prodottoBean : prodotti) {
            somma += prodottoBean.getPrezzo();
        }
        return somma;
    }

    public void rimuoviTutto(){
        prodotti = new ArrayList<>();
    }

}