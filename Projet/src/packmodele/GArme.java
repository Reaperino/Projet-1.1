package packmodele;

import java.util.ArrayList;
import java.util.Collection;

public class GArme {
   
    static Integer idAMax = 1;
    private static ArrayList<Arme> ttesArmes = new ArrayList<Arme>();

    public static void creerArme(String nom, Integer puissance) {
        Arme a = new Arme(GArme.idAMax,nom,puissance);
        ttesArmes.add(a);
        idAMax++;
    }

    public static ArrayList<Arme> listerArmes() {
        ArrayList<Arme> res=new ArrayList<Arme>();
        res.addAll(ttesArmes);
        return res;
    }

    public static Arme getArme(Integer idA) throws IllegalArgumentException{
        int index = -1;
        boolean present = false;
        for(int i = 0; i < ttesArmes.size(); i++) {
            if(ttesArmes.get(i).getIdA() == idA) {
                index = i;
                present = true;
            }
        }
        if (present == false){
               throw new IllegalArgumentException("Ida inconnu");
            }
        return ttesArmes.get(index);
    }
}
