package nl.hu.bep.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Eigenaar {
    private String naam;
    private int id;
    private static List<Eigenaar> alleEigenaren = new ArrayList<>();
    private static int numCustomers = 0;

    private Eigenaar(String nm) {
        naam = nm;
        id = ++numCustomers;
    }

    public Eigenaar(String naam, int id) {
        this.naam = naam;
        this.id = id;
    }

    public static List<Eigenaar> getAlleEigenaren(){
        return alleEigenaren;
    }

    public static void setAlleEigenaren(List<Eigenaar> alleEigenaren) {
        Eigenaar.alleEigenaren = alleEigenaren;
    }
    public static Eigenaar getEigenaar(int id){
        return alleEigenaren.stream().filter(e->e.id==id).findFirst().orElse(null);
    }

    public static Eigenaar createEigenaar(String naam) {
        if (alleEigenaren.stream().noneMatch(e -> e.getnaam().equals(naam))) {
            return new Eigenaar(naam);
        }
        return null;
    }
    public static Eigenaar updateEigenaarNaam(int id, String naam){
        Eigenaar found = Eigenaar.getEigenaar(id);
        if (found!=null) {
            found.setnaam(naam != null ? naam : "");
        }
        return found;
    }

    public static Eigenaar updateEigenaar(Eigenaar newEigenaar){
        return alleEigenaren.set(alleEigenaren.indexOf(Eigenaar.getEigenaar(newEigenaar.getId())),newEigenaar);
    }

    public static boolean removeEigenaar(int id){
        if (id>0) return alleEigenaren.remove(alleEigenaren.indexOf(Eigenaar.getEigenaar(id))) != null;
        return false;
    }

    public void setnaam(String voornaam) {
        this.naam = naam;
    }


    public String getnaam() {
        return naam;
    }

    public int getId() {
        return id;
    }


    public static Eigenaar getEigenaarById(int id){
        return alleEigenaren.stream().filter(e->e.id==id).findFirst().orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eigenaar eigenaar = (Eigenaar) o;
        return id == eigenaar.id &&
                naam.equals(eigenaar.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, id);
    }


}
