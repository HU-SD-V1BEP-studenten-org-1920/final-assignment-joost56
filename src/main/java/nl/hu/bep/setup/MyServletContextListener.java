package nl.hu.bep.setup;

import nl.hu.bep.model.Aquarium;
import nl.hu.bep.model.Eigenaar;
import nl.hu.bep.security.MyUser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Applicatie is aan het opstarten!");
        System.out.println("Initialiseer hier objecten, of laad alvast data");
        Eigenaar.createEigenaar("joost");
        Eigenaar.createEigenaar("joost");
        Eigenaar.createEigenaar("Casper");
        Aquarium.createAquarium("Nemo", 100, 100, 100, "bodemsoort" ,  "zoutwater");
        new MyUser("joost", "geheim").setAdmin();
        new MyUser("casper", "geheimer");
        new MyUser("floris", "123").setEigenaar();
        Eigenaar.getAlleEigenaren().forEach(System.out::println);
    }

    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("appliactie is aan het afsluiten");
        System.out.println("ruim objecten op, of sla data op");
    }

}
