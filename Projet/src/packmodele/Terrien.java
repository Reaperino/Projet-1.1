package packmodele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Terrien extends Personnage {
    /**
     * @attribute
     */
    private static Integer c_force = 20;

    /**
     * @attribute
     */
    private String fonction;

    /**
     * @associates <{packmodele.Arme}>
     */
    private ArrayList<Arme> armes;

    public Terrien(Integer idp,String nom, String fonction) {
        super(idp,nom);
        this.fonction=fonction;
    }

    public static Integer getC_Force() {
        return c_force;
    }
    
    public String getFonction(){
        return this.fonction;
    }

    public static void setC_Force(Integer force) {
        c_force=force;
    }

    @Override
    public String presentationDetaille() {
        String listEnnemis = "";
        String listArme ="";
        for(Personnage p : this.getEnnemis()) {
            listEnnemis+= p.getNom() + ", ";
        }
        for(Arme a : this.getArmes()) {
            listArme+= a.getNom() + ", ";
        }
        return this.presentationCourte() + "Mes ennemis sont : " + listEnnemis +". Mes armes sont : "+listArme ;
    }

    @Override
    public String presentationCourte() {
       
        return "Mon identifiant est " + this.getIdp() + ", je m'appelle " + this.getNom() + " et je suis de type " +
               this.getClass().getSimpleName() + ".\nJ'ai une force de " + this.getForce() + ", ma vie est égale ? " + 
               this.getVie() + "et ma fonction est "+this.getFonction()+"."; 
    }

    @Override
    public void recevoirArme(Arme arme) throws IllegalArgumentException {
        boolean djaPresent=false;
        for(int i=0;i<getArmes().size();i++){
            if(getArmes().get(i).getIdA()== arme.getIdA()){
                djaPresent=true;
            }
                }
        if (djaPresent){
            throw new IllegalArgumentException("Ce personnage poss¨¨de d¨¦j¨¤ cette arme");
        }
        else{
        this.armes.add(arme);
            }
    }

    @Override
    public Integer getForce() {
        Integer res=c_force;
        for(Arme a : getArmes()){
            res+=a.getPuissance();
        }
        return res;
    }


    public ArrayList<Arme> getArmes() {
        ArrayList res=new ArrayList<Arme>();
        res.addAll(this.armes);
        return res;
    }
}
