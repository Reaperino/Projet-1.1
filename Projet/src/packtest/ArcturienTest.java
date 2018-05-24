import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import packmodele.Arcturien;
import packmodele.Arme;
import packmodele.Personnage;

public class ArcturienTest
{
    private Arcturien a1;

    @Before
    public void setUp()
    {
        a1 = new Arcturien(1, "A1", 100, 10);
    }
    
    /**
     * @see Personnage#getIdp()
     */
    @Test
    public void testGetIdp()
    {
        assertThat("Arcturien.getIdp : idp mal initialisée", 
                   a1.getIdp(), is(1));
    }

    /**
     * @see Personnage#getNom()
     */
    @Test
    public void testGetNom()
    {
        assertThat("Arcturien.getNom : nom mal initialisé", 
                   a1.getNom(), is("A1"));
    }

    /**
     * @see Arcturien#getTaille()
     */
    @Test
    public void testGetTaille()
    {
        assertThat("Arcturien.getTaille : taille mal initialisée", 
                   a1.getTaille(), is(100));
    }


    /**
     * @see Arcturien#getForce()
     */
    @Test
    public void testGetForce()
    {
        assertThat("Arcturien.getForce : force mal initialisée", 
                   a1.getForce(), is(10));
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
     * @see Arcturien#getTypePers()
     */
    @Test
    public void testGetTypePers()
    {
        assertThat("Arcturien.getTypePers : type du personnage mal initialisé", 
                   a1.getType(), is(Arcturien.getC_TypeArcturien()));
    }

    /**
     * @see Arcturien#getTypePers()
     */
    @Test
    public void testRecevoirArme()
    {
        Arme arme = new Arme(1, "test unitaire", 100);
        int ancienneForce = a1.getForce();
        a1.recevoirArme(arme);
        assertThat("Arcturien.recevoirArme : la force a été modifiée", 
                   a1.getForce(), is(ancienneForce));       
    }
    
    /**
     * @see Personnage#getMesEnnemis()
     */
    @Test
    public void testGetMesEnnemis()
    {
        assertTrue("Arcturien.MesEnnemis : mesEnnemis n'est pas vide initialement", 
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
        new Arcturien(1, null, 100, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Arcturien.init : Nom vide ne lance pas l'exception IllegalArgumentException"
    public void testArcturien3()
    {
        new Arcturien(1, "", 100, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Arcturien.init : Taille nÃ©gative ne lance pas l'exception IllegalArgumentException"
    public void testArcturien4()
    {
        new Arcturien(1, "A1", -100, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Arcturien.init : Force nÃ©gative ne lance pas l'exception IllegalArgumentException"
    public void testArcturien5()
    {
        new Arcturien(1, "T1", 100, -10);
    }
    
    @Test
    public void testArcturien6()
    {
        try
        {
            a1 = new Arcturien(1, "T1", 100, 
                               Arcturien.getC_ForceMax() + 10);
            if (a1.getForce() != Arcturien.getC_ForceMax())
                fail("La force ne doit pas excéder la force maximale");
            // sinon OK la force est plafonnÃ©e Ã  la force maximale
        }
            catch (IllegalArgumentException e)
            {
                // OK aussi car une exception est lancée pour signaler l'erreur 
            }
    }
}
