package packtest;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import packmodele.Arcturien;
import packmodele.Arme;
import packmodele.Facade;
import packmodele.GArme;
import packmodele.GPersonnage;
import packmodele.Personnage;
import packmodele.Terrien;

public class Test0Auto {
    @Test
    public void InitialisationTests() {
        Facade.creerJeuDEssai();
    }
    
    @Test
    public void testArcturien1()
    {
        Arcturien pers = (Arcturien)GPersonnage.listerPersonnages().get(0);
        assertThat("Arcturien.getIdp : idp mal initialisé ", 
                   pers.getIdp(), is(1));
        assertThat("Arcturien.getNom : nom mal initialisé ", 
                   pers.getNom(), is("A1"));
        assertThat("Arcturien.getTaille : taille mal initialisée ", 
                   pers.getTaille(), is(280));
        assertThat("Arcturien.getForce : force mal initialisée ", 
                   pers.getForce(), is(80));
    }
    @Test
    public void testArcturien2()
    {
        Arcturien pers = (Arcturien)GPersonnage.listerPersonnages().get(1);
        assertThat("Arcturien.getIdp : idp mal initialisé ", 
                   pers.getIdp(), is(2));
        assertThat("Arcturien.getNom : nom mal initialisé ", 
                   pers.getNom(), is("A2"));
        assertThat("Arcturien.getTaille : taille mal initialisée ", 
                   pers.getTaille(), is(220));
        assertThat("Arcturien.getForce : force mal initialisée ", 
                   pers.getForce(), is(60));
    }
    @Test
    public void testArcturien3()
    {
        Arcturien pers = (Arcturien)GPersonnage.listerPersonnages().get(2);
        assertThat("Arcturien.getIdp : idp mal initialisé ", 
                   pers.getIdp(), is(3));
        assertThat("Arcturien.getNom : nom mal initialisé ", 
                   pers.getNom(), is("A3"));
        assertThat("Arcturien.getTaille : taille mal initialisée ", 
                   pers.getTaille(), is(315));
        assertThat("Arcturien.getForce : force mal initialisée ", 
                   pers.getForce(), is(70));
    }
    @Test
    public void testTerrien1()
    {
        Terrien pers = (Terrien)GPersonnage.listerPersonnages().get(3);
        assertThat("Terrien.getIdp : idp mal initialisé ", 
                   pers.getIdp(), is(4));
        assertThat("Terrien.getNom : nom mal initialisé ", 
                   pers.getNom(), is("T1"));
        assertThat("Terrien.getFonction : fonction mal initialisée ", 
                   pers.getFonction(), is("chef"));
    }
    @Test
    public void testTerrien2()
    {
        Terrien pers = (Terrien)GPersonnage.listerPersonnages().get(4);
        assertThat("Terrien.getIdp : idp mal initialisé ", 
                   pers.getIdp(), is(5));
        assertThat("Terrien.getNom : nom mal initialisé ", 
                   pers.getNom(), is("T2"));
        assertThat("Terrien.getFonction : fonction mal initialisée ", 
                   pers.getFonction(), is("géologue"));
    }
    @Test
    public void testTerrien3()
    {
        Terrien pers = (Terrien)GPersonnage.listerPersonnages().get(5);
        assertThat("Terrien.getIdp : idp mal initialisé ", 
                   pers.getIdp(), is(6));
        assertThat("Terrien.getNom : nom mal initialisé ", 
                   pers.getNom(), is("T3"));
        assertThat("Terrien.getFonction : fonction mal initialisée ", 
                   pers.getFonction(), is("stagiaire"));
    }
    @Test
    public void creerArme1(){
        Arme arme = GArme.listerArmes().get(0);
        assertThat("Arme.getIdA : ida mal initialisé ",
                   arme.getIdA(), is(1));
        assertThat("Arme.getNom : nom mal initialisé ",
                   arme.getNom(), is("désintégrateur"));
        assertThat("Arme.getPuissance : puissance mal initialisée ",
                   arme.getPuissance(), is(20));
    }
    @Test
    public void creerArme2(){
        Arme arme = GArme.listerArmes().get(1);
        assertThat("Arme.getIdA : ida mal initialisé ",
                   arme.getIdA(), is(2));
        assertThat("Arme.getNom : nom mal initialisé ",
                   arme.getNom(), is("épée-laser"));
        assertThat("Arme.getPuissance : puissance mal initialisée ",
                   arme.getPuissance(), is(10));
    }
    @Test
    public void creerArme3(){
        Arme arme = GArme.listerArmes().get(2);
        assertThat("Arme.getIdA : ida mal initialisé ",
                   arme.getIdA(), is(3));
        assertThat("Arme.getNom : nom mal initialisé ",
                   arme.getNom(), is("ordinateur"));
        assertThat("Arme.getPuissance : puissance mal initialisée ",
                   arme.getPuissance(), is(2));
    }
    @Test
    public void testDonnerArme1(){
        Terrien terr = (Terrien)GPersonnage.getPers(4);
        int puissanceArme = GArme.getArme(1).getPuissance();
        int forceDeBaseTerrien = Terrien.getC_Force();
        assertThat("donnerUneArme : Puissance du personnage differente de celle attendue ",
            terr.getForce(), is(forceDeBaseTerrien + puissanceArme));
    }
    @Test
    public void testDonnerArme2(){
        Terrien terr = (Terrien)GPersonnage.getPers(5);
        int puissanceArme = GArme.getArme(2).getPuissance();
        int forceDeBaseTerrien = Terrien.getC_Force();
        assertThat("donnerUneArme : Puissance du personnage differente de celle attendue ",
            terr.getForce(), is(forceDeBaseTerrien + puissanceArme));
    }
    @Test
    public void testDonnerArme3(){
        Terrien terr = (Terrien)GPersonnage.getPers(6);
        int puissanceArme = GArme.getArme(3).getPuissance();
        int forceDeBaseTerrien = Terrien.getC_Force();
        assertThat("donnerUneArme : Puissance du personnage differente de celle attendue ",
            terr.getForce(), is(forceDeBaseTerrien + puissanceArme));
    }
    @Test
    public void frapper1(){
        Facade.frapper(4, 1);
        assertThat("frapper1 : La vie du personnage n'est pas celle attendue",
            GPersonnage.getPers(1).getVie(), is(160));
    }
    @Test
    public void frapper3(){
        Facade.frapper(6, 3);
        assertThat("frapper1 : La vie du personnage n'est pas celle attendue",
            GPersonnage.getPers(3).getVie(), is(178));
    }
    @Test
    public void frapper6(){
        Facade.frapper(3, 6);
        assertThat("frapper1 : La vie du personnage n'est pas celle attendue",
            GPersonnage.getPers(6).getVie(), is(130));
    }
}
