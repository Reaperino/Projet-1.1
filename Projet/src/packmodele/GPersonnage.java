package packmodele;

import java.util.ArrayList;
import java.util.Collection;

public class GPersonnage {
   
    static Integer idpMax = 1;
    private static ArrayList<Personnage> tsLesPersonnages = new ArrayList<Personnage>();

    public static void supprimerPersonnage(Integer id) {
        tsLesPersonnages.remove(getPers(id));
    }

    public static Personnage getPers(Integer idp) throws IllegalArgumentException {
        int index = -1;
        boolean present = false;
        for(int i = 0; i < tsLesPersonnages.size(); i++) {
            if(tsLesPersonnages.get(i).getIdp() == idp) {
                index = i;
                present = true;
            }
        }
        if (present == false){
            throw new IllegalArgumentException("Idp inconnu");
        }
        return tsLesPersonnages.get(index);
    }

    public static void ajouterArcturien(String nom, Integer taille, Integer force) throws IllegalArgumentException{
        if (taille < 0) {
            throw new IllegalArgumentException("La taille ne peut pas etre negative");
        }
        if (force < 0) {
            throw new IllegalArgumentException("La force ne peut pas etre negative");
        }
        else if (force > Arcturien.getC_ForceMax()) {
            throw new IllegalArgumentException("Force supérieure au seuil maximal autorisé");
        }
        Arcturien tmp = new Arcturien(idpMax,nom,taille,force);
        tsLesPersonnages.add(tmp);
        idpMax++;
    }

    public static ArrayList<Personnage> listerPersonnages() {
        ArrayList<Personnage> res=new ArrayList<Personnage>();
        for(Personnage pers: tsLesPersonnages ){
            res.add(pers);
        }
        return res;
    }

    public static void ajouterTerrien(String nom, String fonction) {
        if (fonction.isEmpty()) {
            throw new IllegalArgumentException("La fonction doit etre precisee");
        }
        Terrien tmp = new Terrien(idpMax,nom,fonction);
        tsLesPersonnages.add(tmp);
        idpMax++;
    }
}