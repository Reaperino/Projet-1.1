package packtest;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import packmodele.Arcturien;
import packmodele.Arme;
import packmodele.Facade;
import packmodele.GArme;
import packmodele.GPersonnage;
import packmodele.Terrien;

public class FacadeTest {
    
    
    @Before
    public void setUp()
    {
        GPersonnage.idpMax=1;
        GPersonnage.tsLesPersonnages.clear();
        GArme.idAMax=1;
        GArme.ttesArmes.clear();
    }
    
    
    //1.a
    @Test
    public void TestIdentifiant1() {
        ArrayList<Integer> p1= new ArrayList<Integer>();
        for(int i=0;i<5;i++){
            p1.add(Facade.ajouterArcturien("A"+i,280,50));
            p1.add(Facade.ajouterTerrien("T"+i,"Beta-Testeur"));
        }
        for(int i=0;i<10;i++){
        assertThat("Facade : idp mal initialis?e", 
                   p1.get(i), is(i+1));
        }
        
    }
    
    
    
    //1.b
    @Test(expected = IllegalArgumentException.class)
    public void testPersonnage1()
    {

        Facade.ajouterArcturien("", 150, 50);
    }
    @Test
    public void testPersonnage2(){
        
    
        int idp = Facade.ajouterArcturien("A1", 150, 50);
        assertThat("Facade : idp mal initialis?e", 
                   idp, is(1));
    }
    
    
    
    //2.a
    @Test
    public void testList1(){
        assertThat("Facade : liste non vide ??", 
                   Facade.listerTsPersonnages().isEmpty(), is(true));
    }
    
    
    
    //2.b
    @Test
    public void testList2(){
        int idp =Facade.ajouterTerrien("bob", "bricoleur");
        ArrayList<Integer> kk=new ArrayList<Integer>(Facade.listerTsPersonnages());
        //On vérifie la taille
        assertThat("Facade : liste pas de taille 1 ??", 
                   Facade.listerTsPersonnages().size(), is(1));
        //On vérifie si le personnage est présent
        assertThat("Facade:Personnage non présent", 
                   Facade.listerTsPersonnages().contains(idp),is(true));
    }
    
    
    
    //2.c
    @Test
    public void testList3(){
        int idp1 =Facade.ajouterTerrien("bob", "bricoleur");
        int idp2 =Facade.ajouterTerrien("bob", "l'éponge");
        //On vérifie la taille
        assertThat("Facade : liste pas de taille 2 ??", 
                   Facade.listerTsPersonnages().size(), is(2));
        //On vérifie si les personnages sont présent
        assertThat("Facade:Personnage  1 non présent", 
                 Facade.listerTsPersonnages().contains(idp1),is(true));
        assertThat("Facade:Personnage  2 non présent", 
                   Facade.listerTsPersonnages().contains(idp2),is(true));
    }
    
    
    
    //3.a
    @Test
    public void testArme1(){
        int idp= Facade.ajouterArcturien("Boule", 180, 50);
        int ida= Facade.creerUneArme("Sabre Laser", 150);
        Facade.donnerUneArme(ida, idp);
        assertThat("Facade : Force de frappe non-correspondante ??", 
                    Facade.getForceFrappe(idp), is(50));
        }
    
    
    //3.b
    @Test
    public void testArme2(){
        int idp = Facade.ajouterTerrien("Billy", "Policier");
        int ida= Facade.creerUneArme("Sabre Laser", 150);
        Facade.donnerUneArme(ida, idp);
        assertThat("Facade : Force de frappe non-correspondante ??", 
                    Facade.getForceFrappe(idp), is(170));
        
        //En donnant une valeur autre qu'ida, nous aurons un message d'erreur
        assertThat("Facade : L'arme n'est pas dans la liste??", 
                    Facade.getArmes(idp).contains(ida), is(true));
        
    }
    
    
    
    //3.c
    @Test
    public void testArme3(){
        int idp = Facade.ajouterTerrien("Billy", "Policier");
        int ida1= Facade.creerUneArme("Sabre Laser", 150);
        int ida2= Facade.creerUneArme("Pistoler Laser", 50);
        Facade.donnerUneArme(ida1, idp);
        Facade.donnerUneArme(ida2, idp);
        assertThat("Facade : Force de frappe non-correspondante ???", 
                    Facade.getForceFrappe(idp), is(220));
        
        //En donnant une valeur autre qu'ida, nous aurons un message d'erreur
        assertThat("Facade : Arme 1 n'est pas dans la liste", 
                    Facade.getArmes(idp).contains(ida1), is(true));
        assertThat("Facade : Arme 2 n'est pas dans la liste", 
                    Facade.getArmes(idp).contains(ida2), is(true));
    }
    
    //3.d
    @Test
    public void testArme4(){
        int idp = Facade.ajouterTerrien("Billy", "Policier");
        int ida= Facade.creerUneArme("Sabre Laser", 150);
        Facade.donnerUneArme(ida, idp);
        Facade.donnerUneArme(ida, idp);
        assertThat("Facade : Force de frappe non-correspondante ???", 
                    Facade.getForceFrappe(idp), is(170));
        
        //On vérifie qu'il possède l'arme
        assertThat("Facade : L'arme n'est pas dans la liste??", 
                    Facade.getArmes(idp).contains(ida), is(true));
        
        //On vérifie la taille pour être sûr qu'il possède l'arme en un seul exemplaire.
        assertThat("Facade : liste pas de taille 1 ??", 
                    Facade.getArmes(idp).size(), is(1));

    }
    
    //4.a
    @Test public void testFrappe1(){
        int idp1=Facade.ajouterTerrien("Bob", "Policier");
        int ida= Facade.creerUneArme("Canon atomique", 500);
        int idp2=Facade.ajouterArcturien("Brad", 110, 60);
        Facade.donnerUneArme(ida, idp1);
        Facade.frapper(idp1, idp2);
        // On vérifie que le personnage c'est bien fait tapper, et accessoirement si la vie tombe bien sur 0 en cas .
        assertThat("Facade : Vie non correspondante ??", 
                    Facade.getVie(idp2), is(0));
    }
    
    //4.b
    @Test public void testFrappe2(){
        int idp1=Facade.ajouterArcturien("Bob",100,50);
        int idp2=Facade.ajouterArcturien("Brad", 110, 60);
        Facade.frapper(idp2, idp1);
        assertThat("Facade : Personnage 2 n'est pas dans la liste d'ennemis de personnage 1 ??", 
                    Facade.getEnnemis(idp1).contains(idp2), is(true));
        
    }
    
    //4.c
    @Test public void testFrappe3(){
        int idp1=Facade.ajouterArcturien("Bob",100,50);
        int idp2=Facade.ajouterArcturien("Brad", 110, 60);
        Facade.frapper(idp2, idp1);
        Facade.frapper(idp2, idp1);
        
        //On vérifie si les deux coups on bien été porté.
        assertThat("Facade : Vie non correspondante ??", 
                    Facade.getVie(idp1), is(80));
        //On vérifie si l'agresseur est bien dans la liste des ennemis.
        assertThat("Facade : lersonnage 2 n'est pas dans la liste d'ennemis de personnage 1 ??", 
                    Facade.getEnnemis(idp1).contains(idp2), is(true));
        assertThat("Facade : liste pas de taille 1 ??", 
                    Facade.getEnnemis(idp1).size(), is(1)); 
    }
    
    //5.a
    @Test 
    public void testSupprimer1(){
        int idp1=Facade.ajouterArcturien("Bob",100,50);
        int idp2=Facade.ajouterArcturien("Brad", 110, 60);
        assertThat("Facade : liste pas de taille 2 ??", 
                    Facade.listerTsPersonnages().size(), is(2));
        Facade.supprimerPers(idp1);
        assertThat("Facade : liste pas de taille 1 ??", 
                    Facade.listerTsPersonnages().size(), is(1));
        Facade.supprimerPers(idp2);
        assertThat("Facade : liste non-vide ??", 
                    Facade.listerTsPersonnages().isEmpty(), is(true));
    }
    
    //5.b
    @Test 
    public void testSupprimer2(){
        int idp1=Facade.ajouterArcturien("Bob",100,50);
        int idp2=Facade.ajouterArcturien("Brad", 110, 60);
        Facade.frapper(idp2, idp1);
        assertThat("Facade : liste pas de taille 1 ??", 
                    Facade.getEnnemis(idp1).size(), is(1));
        Facade.supprimerPers(idp2);
        assertThat("Facade : liste pas de taille 1 ??", 
                    Facade.getEnnemis(idp1).isEmpty(), is(true));
    }
    
    //Test personnels (pas dans le sujet)
    // ***
    // **
    // *
    
    
    @Test 
    public void testFonction(){
        int idp=Facade.ajouterTerrien("Bob","Pompier");
        assertThat("Facade : liste pas de taille 1 ??", 
                    Facade.getFonction(idp), is("Pompier"));
        
    }
    
    @Test 
    public void testTaille(){
        int idp=Facade.ajouterArcturien("Bob",100,50);
        assertThat("Facade : liste pas de taille 1 ??", 
                    Facade.getTaille(idp), is(100));
        
    }
    
}