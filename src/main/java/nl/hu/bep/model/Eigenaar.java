package nl.hu.bep.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Eigenaar {
    private String name;
    private int id;
    private static List<Eigenaar> alleEigenaren = new ArrayList<>();
    private static int numCustomers = 0;
    private static List<Aquarium> eigenAquaria = new ArrayList<>();

    private Eigenaar(String nm) {
        name = nm;
        id = ++numCustomers;
        alleEigenaren.add(this);
    }

//    public Eigenaar(String nm, int id) {
//        this.name = nm;
//        this.id = id;
//    }

    public static List<Eigenaar> getAlleEigenaren(){
        return alleEigenaren;
    }

//    public static void setAlleEigenaren(List<Eigenaar> alleEigenaren) {
//        Eigenaar.alleEigenaren = alleEigenaren;
//    }

    public static Eigenaar getEigenaar(int id){
        return alleEigenaren.stream().filter(e->e.id==id).findFirst().orElse(null);
    }

    public static Eigenaar createEigenaar(String name) {
            if (alleEigenaren.stream().noneMatch(e -> e.getname().equals(name))) {
                return new Eigenaar(name);
            }
            return null;
    }

//    public static Eigenaar updateEigenaarName(int id, String name){
//        Eigenaar found = Eigenaar.getEigenaar(id);
//        if (found!=null) {
//            found.setname(name != null ? name : "");
//        }
//        return found;
//    }

//    public static Eigenaar updateEigenaar(Eigenaar newEigenaar){
//        return alleEigenaren.set(alleEigenaren.indexOf(Eigenaar.getEigenaar(newEigenaar.getId())),newEigenaar);
//    }

    public static boolean removeEigenaar(int id){
        if (id>0) return alleEigenaren.remove(alleEigenaren.indexOf(Eigenaar.getEigenaar(id))) != null;
        return false;
    }

//    public void setname(String nm) {
//        this.name = nm;
//    }


    public String getname() {
        return name;
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
        return name.equals(eigenaar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }


}
