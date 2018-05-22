package packmodele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Terrien extends Personnage {
   
    private static Integer c_force = 20;
    private String fonction;
    private ArrayList<Arme> armes;
    private static String c_typeTerrien = "Terrien";
    
    public Terrien(Integer idp,String nom, String fonction) {
        super(idp,nom,c_typeTerrien);
        this.armes = new ArrayList<Arme>();
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
    
    public static void setC_TypeTerrien(String type) {
        c_typeTerrien = type;
    }

    @Override
    public String presentationDetaille() {
        String listEnnemis = "[";
        String listArme ="[";
        for(Personnage p : this.getEnnemis()) {
            listEnnemis+= p.getNom() + "  ";
        }
        for(Arme a : this.getArmes()) {
            listArme+= a.getNom() + "  ";
        }
        listEnnemis+="]";
        listArme+="]";
        return this.presentationCourte() + "        Ennemis : " + listEnnemis +" Armes : "+listArme ;
    }

    @Override
    public String presentationCourte() {
        String res = this.getIdp() + "  " + this.getNom() + "     " + this.getClass().getSimpleName() + "        " + this.getForce() + "           " + this.getVie() + "     "+this.getFonction();
        for(int i = 0; i<15 - this.getFonction().length(); i++) {
            res += " ";
        }
        res += this.getArmes().size(); 
        return res;
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
        ArrayList<Arme> res=new ArrayList<Arme>();
        res.addAll(this.armes);
        return res;
    }
}
