package packtest;
import packmodele.Facade;

public class Test0 {
    public static void main(String[] args) {
        Facade.creerJeuDEssai();
        for (int ida : Facade.listerTtesArmes())
             System.out.println(Facade.descriptionArme(ida));
        System.out.println();
        System.out.printf("%-3s%-8s%-10s%-17s%-7s%-15s%-8s\n", "id", "nom", "type", "forceFrappe", "vie", "taille/fctn",
                          "nbarmes");
        System.out.println("====================================================================");
        for (int idp : Facade.listerTsPersonnages())
            System.out.println(Facade.descriptionCourte(idp));

        Facade.frapper(4, 1);
        Facade.frapper(6, 3);
        Facade.frapper(3, 6);
        
        System.out.println("====================================================================");

        for (int idp : Facade.listerTsPersonnages())
            System.out.println(Facade.descriptionDetaillee(idp));

    }
}