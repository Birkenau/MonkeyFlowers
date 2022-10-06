package model;

public class UtenteBean {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String via;
    private int civico;
    private int cap;
    private String regione;
    private String provincia;
    private boolean ruolo;

    public UtenteBean() {
        this.ruolo=false;
    }

    public void setRuolo(boolean x){
        this.ruolo=x;
    }

    public boolean getRuolo(){
        return ruolo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCivico() {
        return civico;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }



    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", via='" + via + '\'' +
                ", civico=" + civico +
                ", cap=" + cap +
                ", regione='" + regione + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
