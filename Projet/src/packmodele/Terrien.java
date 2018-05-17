package packmodele;

import java.util.Collection;
import java.util.Collections;

public class Terrien extends Personnage {
    /**
     * @attribute
     */
    private static Integer c_force = 20;

    /**
     * @attribute
     */
    private String fonction;

    /**
     * @associates <{packmodele.Arme}>
     */
    private Collection arme;

    public Terrien(Integer idp,String nom, String fonction) {
    }

    public static Integer getC_Force() {
    }

    public static void setC_Force() {
    }

    @Override
    public String presentationDetaille() {
        // TODO Implement this method
        return null;
    }

    @Override
    public String presentationCourte() {
        // TODO Implement this method
        return null;
    }

    @Override
    public void recevoirArme(Arme arme) {
        // TODO Implement this method
    }

    @Override
    public Integer getForce() {
        // TODO Implement this method
        return null;
    }

    @Override
    public Collection getArmes() {
        // TODO Implement this method
        return Collections.emptySet();
    }
}
