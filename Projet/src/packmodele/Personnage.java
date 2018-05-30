package packmodele;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Personnage {
  
    protected Integer force;
    private Integer vie;
    private String nom;
    private Integer idp;
    private String type;
    private static Integer c_vieInit = 200;
    protected ArrayList<Personnage> agresseur;

    public Personnage(Integer idp, String nom, String type) {
        this.idp = idp;
        this.nom = nom;
        this.type = type;
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
    
    public String getType(){
        return this.type;
    }
    
    public void attaquer(Personnage victime) {
        victime.seFaitAttaquer(this); //demander si this tout court marche
    }

    public void seFaitAttaquer(Personnage agresseur) {
            boolean djaPresent=false;
            for(int i=0;i<getEnnemis().size();i++){
                if(getEnnemis().get(i).getIdp()== agresseur.getIdp()){
                    djaPresent=true;
                }
                    }
            if (djaPresent){  
            }
            else{
            this.agresseur.add(agresseur);
                }
            
            this.setVie(this.getVie()-agresseur.getForce()) ;
            if(this.vie < 0) { //pour éviter que la vie passe sous 0
                this.setVie(0);
            }
        }
    
    public abstract void recevoirArme(Arme arme);
    
    public abstract String presentationCourte();

    public abstract String presentationDetaille();
    
    public abstract ArrayList<Arme> getArmes();
}
