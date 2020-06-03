package nl.hu.bep.model;

public class Aquarium {
    private String naam;
    private double lengte;
    private double breedte;
    private double hoogte;
    private String bodemsoort;
    private String watersoort;

    public Aquarium(String naam, double lengte, double breedte, double hoogte, String bodemsoort, String watersoort) {
        this.naam = naam;
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.bodemsoort = bodemsoort;
        this.watersoort = watersoort;

    }

    public String getNaam() {
        return naam;
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



}
