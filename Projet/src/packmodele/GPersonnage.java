package packmodele;

import java.util.ArrayList;
import java.util.Collection;

public class GPersonnage {
    /**
     * @attribute
     */
    static Integer idpMax = 1;

    /**
     * @associates <{packmodele.Personnage}>
     */
    private static ArrayList<Personnage> tsLesPersonnages;

    public static void supprimerPersonnage(Integer id) {
        if (!tsLesPersonnages.isEmpty()){
            tsLesPersonnages.remove(getPers(id));
        }
    }

    public static Personnage getPers(Integer idp) throws IllegalArgumentException {
                
    }

    public static void ajouterArcturien(String nom, Integer taille, Integer force) {
        Arcturien tmp = new Arcturien(idpMax,nom,taille,force);
        tsLesPersonnages.add(tmp);
        idpMax++;
    }

    public static Collection listerPersonnages() {
        return tsLesPersonnages;
    }

    public static void ajouterTerrien(String nom, String fonction) {
        Terrien tmp = new Terrien(idpMax,nom,fonction);
        tsLesPersonnages.add(tmp);
        idpMax++;
    }
}