package packmodele;

public class Arme {
   
    private String nom;
    private Integer puissance;
    private Integer idA;

    public Arme(Integer ida, String nom, Integer puissance) throws IllegalArgumentException{
        if (puissance < 0) {
            throw new IllegalArgumentException("La puissance ne peut pas etre negative");
        }
        if (nom == null || nom.equals("")) {
            throw new IllegalArgumentException("Le nom ne peut être vide");
        }
        this.idA = ida;
        this.nom = nom;
        this.puissance = puissance;
    }

    public String getNom() {
        return this.nom;
    }

    public Integer getPuissance() {
        return this.puissance;
    }

    public Integer getIdA() {
        return this.idA;
    }
}
