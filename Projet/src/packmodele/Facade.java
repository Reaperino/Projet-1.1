package packmodele;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;

public final class Facade
{
 
  //========== actions ===============
  
  public static void initialisations(Integer vieInit,Integer forceMaxArctur, Integer forceTerriens, String typeTerrien, String typeArcturien)
  {//initialise les parametres du jeu (vie initiale, force max des Arcturiens, force de base des Terriens, type affichable des personnages)
      Personnage.setC_VieInit(vieInit);
      Terrien.setC_Force(forceTerriens);
      Arcturien.setC_ForceMax(forceMaxArctur);
      Terrien.setC_TypeTerrien(typeTerrien);
      Arcturien.setC_TypeArcturien(typeArcturien);
  }
  public static void creerJeuDEssai()
  {
      ajouterArcturien("A1", 280, 80);
      ajouterArcturien("A2", 220, 60);
      ajouterArcturien("A3", 315, 70);
      
      
      ajouterTerrien("T1", "chef");
      ajouterTerrien("T2", "géologue");
      ajouterTerrien("T3", "stagiaire");
      
      creerUneArme("désintégrateur", 20);
      creerUneArme("épée-laser", 10);
      creerUneArme("ordinateur", 2);
      
      donnerUneArme(1,4);
      donnerUneArme(2,5);
      donnerUneArme(3,6);
  } 
  public static int ajouterArcturien(String nom, int taille, int force) 
  { 
      int res=GPersonnage.idpMax;
      GPersonnage.ajouterArcturien(nom, taille, force);
      return res;
  }
  public static int ajouterTerrien (String nom, String fonction)
  {//Cree un Terrien avec nom, fonction ; renvoie son identifiant idp
      int res=GPersonnage.idpMax;
      GPersonnage.ajouterTerrien(nom, fonction);
      return res;
  }
  public static int creerUneArme(String nom, int puiss) 
  { //Cree une arme (nom,puissance) ; renvoie son identifiant ida
      int res= GArme.idAMax;
      GArme.creerArme(nom, puiss);
      return res;
  }
  public static void donnerUneArme (int ida, int idp)
  {//Donne l'arme (ida) au personnage (idp)
    GPersonnage.getPers(idp).recevoirArme(GArme.getArme(ida));
  } 
  public static void frapper (int idpAgresseur, int idpVictime)
  {// L'agresseur(idpAgresseur) frappe l'agresse (idpVictime)
      GPersonnage.getPers(idpAgresseur).attaquer(GPersonnage.getPers(idpVictime));
  }
  public static void supprimerPers (int idp)
  {//Supprime le personnage (idp)
      GPersonnage.supprimerPersonnage(idp);
      //suppresion de l'instance du personnage dans la liste des ennemis des autres personnages
      ArrayList<Personnage> p = GPersonnage.listerPersonnages();
      for(Personnage pers : p) {
          for(int i = 0; i<pers.getEnnemis().size(); i++) {
              int ennemi = pers.getEnnemis().get(i).getIdp();
              if( ennemi == idp){
                  pers.agresseur.remove(i);
              }
          }
      }
  }

 //============= informations affichables ================

  public static String descriptionCourte(int idp) 
  {//retourne la description courte du personnage idp
      return GPersonnage.getPers(idp).presentationCourte();
  }
  public static String descriptionDetaillee(int idp)
  { //retourne la description detaillee du personnage idp
      return GPersonnage.getPers(idp).presentationDetaille();
  }
  public static String descriptionArme(int ida)
  { //retourne la description de l'arme ida : id, nom, puissance
      Arme a=GArme.getArme(ida);
      return "Arme " + ida +"  "+a.getNom()+"  "+a.getPuissance();
  }
 //================= les listes ======================
 
  public static Collection<Integer> listerTsPersonnages() 
  {//retourne les idp de tous les personnages crees
      ArrayList<Integer> listIdp = new ArrayList<Integer>();
      for(Personnage p : GPersonnage.listerPersonnages()){
          listIdp.add(p.getIdp());
      }
      return listIdp;
  } 

  public static Collection<Integer> listerTtesArmes() 
  {// retourne les ida de toutes les armes disponibles
  ArrayList<Integer> listIda = new ArrayList<Integer>();
  for(Arme a : GArme.listerArmes()){
      listIda.add(a.getIdA());
  }
  return listIda;
  } 
  
  // =============================================================
  // =============== accesseurs pour les tests unitaires =========
  // =============================================================

  public static Collection<Integer> getArmes(int idp) 
  {//liste des ida des armes du personnage d'identifiant idp
      ArrayList<Integer> listIdArmes = new ArrayList<Integer>();
      for(Arme a : GPersonnage.getPers(idp).getArmes()){
          listIdArmes.add(a.getIdA());
      }
      return listIdArmes;
  } 
																																																																																										
  public static Collection<Integer> getEnnemis(int idp)
  {//liste des idp des ennemis du personnage d'identifiant idp  
    ArrayList<Integer> listIdp = new ArrayList<Integer>();
    for(Personnage p : GPersonnage.getPers(idp).getEnnemis()){
        listIdp.add(p.getIdp());
    }
    return listIdp;
  } 
  
  public static String getNomPersonnage(int idp)
  {
      return GPersonnage.getPers(idp).getNom();
  }
  public static int getForceFrappe(int idp)
  {
      return GPersonnage.getPers(idp).getForce();
  }
  public static int getTaille(int idp) throws IllegalArgumentException
  {
      int res=0;
      Personnage p=GPersonnage.getPers(idp);
      if(p.getType().equals(Arcturien.getC_TypeArcturien())){
          Arcturien a=(Arcturien)p;
          res=a.getTaille();
      }
      else{
          throw new IllegalArgumentException("L'identifiant entré en paramètre n'est pas celui d'un Arcturien.");
      }
      return res;
  }
  public static String getFonction(int idp) throws IllegalArgumentException
  {
      String res="";
      Personnage p=GPersonnage.getPers(idp);
      if(p.getType().equals(Terrien.getC_TypeTerrien())){
          Terrien t=(Terrien)p;
          res=t.getFonction();
      }
      else{
          throw new IllegalArgumentException("L'identifiant entré en paramètre n'est pas celui d'un Terrien.");
      }
      return res;
  } 
  public static int getVie(int idp)
  {
      return GPersonnage.getPers(idp).getVie();
  }
  public static String getNomArme(int ida)
  {
      return GArme.getArme(ida).getNom();
  }
  public static int getPuissance(int ida)
  {
      return GArme.getArme(ida).getPuissance();
  }
   public static String getTypePers(int idp)
  {
       return GPersonnage.getPers(idp).getType();
  }
}
