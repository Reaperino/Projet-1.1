import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import packmodele.Arcturien;
import packmodele.Personnage;
import packmodele.Terrien;
import packmodele.Arme;

public class TerrienTest
{
    private Terrien a1;

    @Before
    public void setUp()
    {
        a1 = new Terrien(1, "A1", "Fonction de test");
    }
    
    /**
     * @see Personnage#getIdp()
     */
    @Test
    public void testGetIdp()
    {
        assertThat("Terrien.getIdp : idp mal initialisée", 
                   a1.getIdp(), is(1));
    }

    /**
     * @see Personnage#getNom()
     */
    @Test
    public void testGetNom()
    {
        assertThat("Terrien.getNom : nom mal initialisé", 
                   a1.getNom(), is("A1"));
    }


    /**
     * @see Terrien#getFonction()
     */
    @Test
    public void testGetFonction()
    {
        assertThat("Terrien.getFonction : fonction mal initialisée", 
                   a1.getFonction(), is("Fonction de test"));
    }
    
    /**
     * @see Personnage#getVie()
     */
    @Test
    public void testGetVie()
    {
        assertThat("Arcturien.getVie : vie mal initialisée", 
                   a1.getVie(), is(Personnage.getC_VieInit()));
    }


    /**
     * @see Terrien#getTypePers()
     */
    @Test
    public void testGetTypePers()
    {
        assertThat("Arcturien.getTypePers : type du personnage mal initialisé", 
                   a1.getType(), is(Terrien.getC_TypeTerrien()));
    }

    /**
     * @see Terrien#testRecevoirArme()
     */
    @Test
    public void testRecevoirArme()
    {
        Arme arme = new Arme(1, "test unitaire", 100);
        int ancienneForce = a1.getForce();
        a1.recevoirArme(arme);
        int nouvelleForce = a1.getForce();
        assertThat("Terrien.recevoirArme : la force n'a pas été modifiée", 
                   nouvelleForce, is(120));       
    }
    
    /**
     * @see Personnage#getMesEnnemis()
     */
    @Test
    public void testGetMesEnnemis()
    {
        assertTrue("Terrien.MesEnnemis : mesEnnemis n'est pas vide initialement", 
                    a1.getEnnemis().isEmpty());
    }

    /**
     * @see Personnage#presentationCourte()
     */
    @Test
    // @Ignore
    public void testPresentationCourte()
    {
        fail("Ce test est délicat à réaliser car le format exact n'a pas été fixé");
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Arcturien.init : Nom null ne lance pas l'exception IllegalArgumentException"
    public void testArcturien2()
    {
        new Terrien(1, null, "Fonction de test");
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Arcturien.init : Nom vide ne lance pas l'exception IllegalArgumentException"
    public void testArcturien3()
    {
        new Terrien(1, "", "Fonction de test");
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Arcturien.init : Fonction null ne lance pas l'exception IllegalArgumentException"
    public void testArcturien4()
    {
        new Terrien(1, "A1", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    //    "Arcturien.init : Fonction vide ne lance pas l'exception IllegalArgumentException"
    public void testArcturien5()
    {
        new Terrien(1, "A1", "");
    }
}
