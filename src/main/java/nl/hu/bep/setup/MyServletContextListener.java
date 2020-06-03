package nl.hu.bep.setup;

import nl.hu.bep.model.Eigenaar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Applicatie is aan het opstarten!");
        System.out.println("Initialiseer hier objecten, of laad alvast data");
        Eigenaar.createEigenaar("Joost");
    }

    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("appliactie is aan het afsluiten");
        System.out.println("ruim objecten op, of sla data op");
    }

}
