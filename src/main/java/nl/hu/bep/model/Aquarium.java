package nl.hu.bep.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aquarium {
    private String naam;
    private double lengte;
    private double breedte;
    private double hoogte;
    private String bodemsoort;
    private String watersoort;
    private static List<Aquarium> eigenAquaria = new ArrayList<>();
    private static List<Aquarium> alleAquaria = new ArrayList<>();
    private int id;
    private static int numAquaria = 0;

    private Aquarium(String nm){
        this.naam = nm;
        id = ++numAquaria;
    }

    public Aquarium(String naam, double lengte, double breedte, double hoogte, String bodemsoort, String watersoort, int id) {
        this.naam = naam;
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.bodemsoort = bodemsoort;
        this.watersoort = watersoort;
        this.id = id;
        alleAquaria.add(this);

    }

    public static Aquarium createAquarium(String naam,double lengte, double breedte, double hoogte, String bodemsoort, String watersoort) {
        if (alleAquaria.stream().noneMatch(e -> e.getNaam().equals(naam))) {
            Aquarium newAquarium = new Aquarium(naam);
            alleAquaria.add(newAquarium);
            return newAquarium;
        }
        else return null;
    }

    public static List<Aquarium> getAlleAquaria(){
        return alleAquaria;
    }

    public static boolean removeAquarium(int id){
        if (id>0) return alleAquaria.remove(alleAquaria.indexOf(Aquarium.getAquarium(id))) != null;
        return false;
    }

    public static Aquarium getAquarium(int id){
        return alleAquaria.stream().filter(e->e.id==id).findFirst().orElse(null);
    }

    public int getId() {
        return id;
    }

    public static Aquarium getAquariumById(int id){
        return alleAquaria.stream().filter(e->e.id==id).findFirst().orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aquarium aquarium = (Aquarium) o;
        return naam.equals(aquarium.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, id);
    }








    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public double getBreedte() {
        return breedte;
    }

    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    public double getHoogte() {
        return hoogte;
    }

    public void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }

    public String getBodemsoort() {
        return bodemsoort;
    }

    public void setBodemsoort(String bodemsoort) {
        this.bodemsoort = bodemsoort;
    }

    public String getWatersoort() {
        return watersoort;
    }

    public void setWatersoort(String watersoort) {
        this.watersoort = watersoort;
    }

    public String getNaam() {
        return naam;
    }
}
