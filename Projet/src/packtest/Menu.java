package packtest;

import java.util.Scanner;

import packmodele.Arcturien;
import packmodele.Facade;
import packmodele.Terrien;

public class Menu {
    public static void main(String[] args) {
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
                for (int idp : Facade.listerTsPersonnages())
                System.out.println(Facade.descriptionCourte(idp));
                break;
            case 2:
                System.out.println("IDP à chercher :");
                int idp = sc.nextInt();
                Facade.descriptionDetaillee(idp);
                break;
            case 3:
                for (int idp1 : Facade.listerTsPersonnages())
                System.out.println(Facade.descriptionDetaillee(idp1));
                break;
            case 4:
                
            }
        }

    }
}
