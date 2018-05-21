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
        int index = -1;
        for(int i = 0; i < tsLesPersonnages.size(); i++) {
            if(tsLesPersonnages.get(i).getIdp() == idp) {
                index = i;
            }
            else {
                throw new IllegalArgumentException("Idp inconnu");
            }
        }
        return tsLesPersonnages.get(index);
    }

    public static void ajouterArcturien(String nom, Integer taille, Integer force) {
        Arcturien tmp = new Arcturien(idpMax,nom,taille,force);
        tsLesPersonnages.add(tmp);
        idpMax++;
    }

    public static ArrayList<Personnage> listerPersonnages() {
        ArrayList res=new ArrayList<Personnage>();
        for(Personnage pers: tsLesPersonnages ){
            res.add(pers);
        }
        return res;
    }

    public static void ajouterTerrien(String nom, String fonction) {
        Terrien tmp = new Terrien(idpMax,nom,fonction);
        tsLesPersonnages.add(tmp);
        idpMax++;
    }
}