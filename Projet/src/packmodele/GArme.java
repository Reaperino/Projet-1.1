package packmodele;

import java.util.Collection;

public class GArme {
   
    private static Integer idAMax = 1;
    private static Collection<Arme> ttesArmes;

    public static void creerArme(String nom, Integer puissance) {
        Arme a = new Arme(GArme.idAMax,nom,puissance);
        ttesArmes.add(a);
    }

    public static Collection listerArmes() {
        return ttesArmes;
    }

    public static Arme getArme(Integer idA) throws IllegalArgumentException{
        Arme res = new Arme(0,"",0);
        boolean test = false;
        for(Arme a : ttesArmes) {
            if (a.getIdA() == idA) {
                res = a;
                test = true;
            }
        }
        if (test == false) {
            throw new IllegalArgumentException("Il n'y a pas d'arme avec cet identifiant");
        }
        return res;
    }
}
