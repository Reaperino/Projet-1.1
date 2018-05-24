package packtest;

import java.util.InputMismatchException;
import java.util.Scanner;
import packmodele.Facade;

//=====Pense bete=====
//Penser a rajouter le cas ou on entre autre chose qu'un chiffre
//Penser au try catch
//Finir les test

public class Menu {
    public static void main(String[] args) {
        try {
            Integer nb = -1;
            System.out.println("========Menu du jeu========");
            System.out.println("0. Lancer le jeu d'essai initial ci-dessous");
            System.out.println("1. Lister tous les personnages avec leur description courte");
            System.out.println("2. Afficher la description détaillée du personnage d'identifiant idp");
            System.out.println("3. Lister tous les personnages avec leur description détaillée");
            System.out.println("4. Créer un Arcturien avec nom, taille, force ; affiche son identifiant idp");
            System.out.println("5. Créer un Terrien avec nom et fonction ; affiche son identifiant idp");
            System.out.println("6. Créer une arme (nom,puissance) ; affiche son identifiant ida");
            System.out.println("7. Lister les types d’armes disponibles : ida, nom, puissance");
            System.out.println("8. Donner une arme (ida) à un personnage (idp)");
            System.out.println("9. Frapper (idp de l'agresseur, idp de l'agressé)");
            System.out.println("10. Supprimer le personnage (idp)");
            System.out.println("98. Modifier les paramètres initiaux du jeu (vie initiale, force max des Arcturiens, force des Terriens)");
            System.out.println("99. Quitter le jeu\n");
            
            while (nb != 99) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Entrez un nombre :");
                nb = sc.nextInt();
            
            
                switch(nb){
                case 0:
                    Facade.creerJeuDEssai();
                    break;
                case 1:
                    System.out.println("=====Liste de tous les personnages=====");
                    for (int idp : Facade.listerTsPersonnages())
                    System.out.println(Facade.descriptionCourte(idp));
                    break;
                case 2:
                    System.out.println("=====Recherche de personnage=====");
                    System.out.println("IDP à chercher :");
                    int idp = sc.nextInt();
                    System.out.println(Facade.descriptionDetaillee(idp));
                    break;
                case 3:
                    System.out.println("=====Liste de tous les personnages avec desc. détaillée=====");
                    for (int idp1 : Facade.listerTsPersonnages())
                    System.out.println(Facade.descriptionDetaillee(idp1));
                    break;
                case 4:
                    System.out.println("=====Création d'un Arcturien=====");
                    System.out.println("Nom ? ");
                    String nom = sc.next();
                    System.out.println("taille ? ");
                    int taille = sc.nextInt();
                    System.out.println("force ? ");
                    int force = sc.nextInt();
                    int res = Facade.ajouterArcturien(nom, taille, force);
                    System.out.println("IDP : " + res);
                    break;
                case 5:
                    System.out.println("=====Création d'un Terrien=====");
                    System.out.println("nom ? ");
                    String nomT = sc.next();
                    System.out.println("fonction ? ");
                    String fonction = sc.next();
                    int resT = Facade.ajouterTerrien(nomT, fonction);
                    System.out.println("IDP : " + resT);
                    break;
                case 6:
                    System.out.println("=====Création d'une Arme=====");
                    System.out.println("nom ? ");
                    String nomA = sc.next();
                    System.out.println("puissance ? ");
                    int puiss = sc.nextInt();
                    int resA = Facade.creerUneArme(nomA, puiss);
                    System.out.println("IDP : " + resA);
                    break;
                case 7:
                    System.out.println("=====Liste de toutes les armes=====");
                    for (int ida : Facade.listerTtesArmes())
                         System.out.println(Facade.descriptionArme(ida));
                    break;
                case 8:
                    System.out.println("=====Donner une arme à un personnage=====");
                    System.out.println("IDA de l'arme a donner ? ");
                    int idaD = sc.nextInt();
                    System.out.println("IDP du personnage ? ");
                    int idpD = sc.nextInt();
                    Facade.donnerUneArme(idaD, idpD);
                    break;
                case 9:
                    System.out.println("=====Agression d'un personnage A envers un personnage B=====");
                    System.out.println("IDP agresseur ? ");
                    int idpAgresseur = sc.nextInt();
                    System.out.println("IDP agressé ? ");
                    int idpVictime = sc.nextInt();
                    Facade.frapper(idpAgresseur, idpVictime);
                    break;
                case 10:
                    System.out.println("=====Suppression d'un personnage=====");
                    System.out.println("IDP de personnage a supprimer ? ");
                    int idpSuppr = sc.nextInt();
                    Facade.supprimerPers(idpSuppr);
                    break;
                case 98:
                    System.out.println("=====Changement des parametres du jeu=====");
                    System.out.println("Vie initale ? ");
                    int vieInit = sc.nextInt();
                    System.out.println("Force max. des Arcturiens ? ");
                    int forceMaxArctur = sc.nextInt();
                    System.out.println("Force max. des Terriens ? ");
                    int forceTerriens = sc.nextInt();
                    System.out.println("Type des Terriens ? ");
                    String typeTerrien = sc.next();
                    System.out.println("Type des Arcturiens ? ");
                    String typeArcturien = sc.next();
                    Facade.initialisations(vieInit, forceMaxArctur, forceTerriens, typeTerrien, typeArcturien);
                    break;
                case 99:
                    break;    
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Veuillez entrer un chiffre valide");            
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Fin du jeu");
        }
    }
}
