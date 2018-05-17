package packmodele;

public class Arcturien extends Personnage {
    /**
     * @attribute
     */
    private Integer taille;

    /**
     * @attribute
     */
    private static Integer c_forceMax = 100;

    public Arcturien(Integer idp, String nom, Integer taille, Integer force) throws IllegalArgumentException{
        super(idp,nom);
        this.taille = taille;
        this.force = force;
        if (force > c_forceMax) {
            throw new IllegalArgumentException("Force supérieure au seuil maximal autorisé");
        }
    }

    public Integer getTaille() {
        return this.taille;
    }

    public static void setC_ForceMax(Integer force) {
        c_forceMax = force;
    }

    @Override
    public String presentationDetaille() {
        String listEnnemis = "";
        for(Personnage p : this.getEnnemis()) {
            listEnnemis+= p.getNom() + ", ";
        }
        return this.presentationCourte() + "Mes ennemis sont : " + listEnnemis;
    }

    @Override
    public String presentationCourte() {
        return "Mon identifiant est " + this.getIdp() + ", je m'appelle " + this.getNom() + " et je suis de type " +
               this.getClass().getSimpleName() + ".\nJ'ai une force de " + this.getForce() + ", ma vie est égale à " + 
               this.getVie() + " et enfin ma taille est de " + this.getTaille() + "."; 
    }

    @Override
    public void recevoirArme(Arme arme) {
        //rien ne doit se passe car un Arcturien ne sait pas se servir d'une arme.
    }
}
