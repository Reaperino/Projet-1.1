package packmodele;

import java.util.Collection;

public abstract class Personnage {
    /**
     * @attribute
     */
    private Integer force;

    /**
     * @attribute
     * @associates <{packmodele.Personnage}>
     */
    private Collection personnages;

    /**
     * @attribute
     */
    private Integer vie;

    /**
     * @attribute
     */
    private String nom;

    /**
     * @attribute
     */
    private Integer idp;

    /**
     * @attribute
     */
    private static Integer c_vieInit = 200;

    /**
     * @associates <{packmodele.Personnage}>
     */
    private Collection agresseur;

    public Personnage(Integer idp, String nom) {
    }

    public static void setC_VieInit() {
    }

    public void setVie() {
    }

    public String getNom() {
    }

    public abstract String presentationDetaille();

    public void seFaitAttaquer(Personnage agresseur) {
    }

    public Integer getVie() {
    }

    public Collection getEnnemis() {
    }

    public static Integer getC_VieInit() {
    }

    public abstract String presentationCourte();

    public Integer getForce() {
    }

    public Collection getArmes() {
    }

    public Integer getIdp() {
    }

    public abstract void recevoirArme(Arme arme);

    public void attaquer(Personnage victime) {
    }
}
