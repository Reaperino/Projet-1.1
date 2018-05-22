package packmodele;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Personnage {
  
    protected Integer force;
    private Integer vie;
    private String nom;
    private Integer idp;
    private static Integer c_vieInit = 200;
    private ArrayList<Personnage> agresseur;

    public Personnage(Integer idp, String nom) {
        this.idp = idp;
        this.nom = nom;
        this.vie = c_vieInit;
        this.agresseur = new ArrayList<Personnage>();
    }

    public static void setC_VieInit(Integer vie) {
        c_vieInit = vie;
    }

    public void setVie(Integer vie) {
        this.vie = vie;
    }

    public String getNom() {
        return this.nom;
    }
    
    public Integer getVie() {
        return this.vie;
    }

    public ArrayList<Personnage> getEnnemis() {
        ArrayList<Personnage> res = new ArrayList<Personnage>();
        res.addAll(this.agresseur);
        return res;
    }

    public static Integer getC_VieInit() {
        return c_vieInit;
    }

    public abstract Integer getForce(); 

    public Integer getIdp() {
        return this.idp;
    }
    
    public void attaquer(Personnage victime) {
        victime.seFaitAttaquer(this); //demander si this tout court marche
    }

    public void seFaitAttaquer(Personnage agresseur) {
        this.agresseur.add(agresseur);
        this.vie -= agresseur.getForce();
    }
    
    public abstract void recevoirArme(Arme arme);
    
    public abstract String presentationCourte();

    public abstract String presentationDetaille();
    
    public abstract ArrayList<Arme> getArmes();
}
