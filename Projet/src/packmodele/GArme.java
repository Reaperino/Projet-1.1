package packmodele;

import java.util.ArrayList;
import java.util.Collection;

public class GArme {
   
    private static Integer idAMax = 1;
    private static ArrayList<Arme> ttesArmes;

    public static void creerArme(String nom, Integer puissance) {
        Arme a = new Arme(GArme.idAMax,nom,puissance);
        ttesArmes.add(a);
    }

    public static Collection listerArmes() {
        return ttesArmes;
    }

    public static Arme getArme(Integer idA) throws IllegalArgumentException{
        int index = -1;
        for(int i = 0; i < ttesArmes.size(); i++) {
            if(ttesArmes.get(i).getIdA() == idA) {
                index = i;
            }
            else {
                throw new IllegalArgumentException("Idp inconnu");
            }
        }
        return ttesArmes.get(index);
    }
}
