package packmodele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Arcturien extends Personnage {

    private Integer taille;
    private static Integer c_forceMax = 100;
    private static String c_typeArcturien = "Arcturien";

    public Arcturien(Integer idp, String nom, Integer taille, Integer force) throws IllegalArgumentException{
        super(idp,nom,c_typeArcturien);
        this.taille = taille;
        this.force = force;
    }
    
    public Integer getTaille() {
        return this.taille;
    }
    
    public static Integer getC_ForceMax() {
        return c_forceMax;
    }
    public static void setC_ForceMax(Integer force) {
        c_forceMax = force;
    }
    
    public static void setC_TypeArcturien(String type) {
        c_typeArcturien = type;
    }

    @Override
    public String presentationDetaille() {
        String listEnnemis = "[";
        for(Personnage p : this.getEnnemis()) {
            listEnnemis+= p.getNom() + " ";
        }
        listEnnemis+="]";
        return this.presentationCourte() + "        Ennemis : " + listEnnemis;
    }

    @Override
    public String presentationCourte() {
        String res = this.getIdp() + "  " + this.getNom() + "     " + this.getClass().getSimpleName() + "      " + this.getForce() + "           " + this.getVie() + "     " + this.getTaille();
        for(int i =0; i < 15 - getTaille().toString().length(); i++) {
            res += " ";
        }
        res += this.getArmes().size(); 
        return res;
    }

    @Override
    public void recevoirArme(Arme arme) {
        //rien ne doit se passe car un Arcturien ne sait pas se servir d'une arme.
    }
    @Override
    public ArrayList<Arme> getArmes(){
        return new ArrayList<Arme>();
    }

    @Override
    public Integer getForce() {
        return this.force;
    }
}
