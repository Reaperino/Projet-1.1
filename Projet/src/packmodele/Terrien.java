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
        if (nom == null || nom == "") {
            throw new IllegalArgumentException("Le nom ne peut être vide");
        }
        if (fonction == null || fonction == "") {
            throw new IllegalArgumentException();
        }
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
            String res="";
            if(this.getVie()>0){
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
            res=this.presentationCourte() + "        Ennemis : " + listEnnemis +" Armes : "+listArme ;
            }
            else{
                res=this.presentationCourte();
            }
            return res;
        }

        @Override
        public String presentationCourte() {
            String res="";
            if(this.getVie()>0){
            res = this.getIdp() + "  " + this.getNom() + "     " + this.getClass().getSimpleName() + "        " + this.getForce() + "           " + this.getVie() + "     "+this.getFonction();
            for(int i = 0; i<15 - this.getFonction().length(); i++) {
                res += " ";
            }
            res += this.getArmes().size(); 
            }
            else  {
                res=this.getIdp() + "  " + this.getNom() + " : Cet individu est mort, il ne peut pas se présenter.";
            }
                    
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
            throw new IllegalArgumentException("Ce personnage possède déjà cette arme");
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

    @Override
    public ArrayList<Arme> getArmes() {
        ArrayList<Arme> res=new ArrayList<Arme>();
        res.addAll(this.armes);
        return res;
    }
    
    public static String getC_TypeTerrien(){
        return c_typeTerrien;
    }
}
