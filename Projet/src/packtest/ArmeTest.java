import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import packmodele.Arcturien;
import packmodele.Arme;

public class ArmeTest
{
    private Arme a1;

    @Before
    public void setUp()
    {
        a1 = new Arme(1, "A1", 10);
    }
    
    /**
     * @see Arme#getIda()
     */
    @Test
    public void testGetIda()
    {
        assertThat("Arme.getIda : ida mal initialisée", 
                   a1.getIdA(), is(1));
    }

    /**
     * @see Arme#getNom()
     */
    @Test
    public void testGetNom()
    {
        assertThat("Arcturien.getNom : nom mal initialisé", 
                   a1.getNom(), is("A1"));
    }

    /**
     * @see Arme#getForce()
     */
    @Test
    public void testGetPuissance()
    {
        assertThat("Arcturien.getForce : force mal initialisée", 
                   a1.getPuissance(), is(10));
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : Nom null ne lance pas l'exception IllegalArgumentException"
    public void testArme2()
    {
        new Arme(1, null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : Nom vide ne lance pas l'exception IllegalArgumentException"
    public void testArme3()
    {
        new Arme(1, "", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    //    "Arme.init : Taille négative ne lance pas l'exception IllegalArgumentException"
    public void testArme4()
    {
        new Arme(1, "A1", -10);
    }
}
