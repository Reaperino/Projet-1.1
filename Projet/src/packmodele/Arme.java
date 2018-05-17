package packmodele;

public class Arme {
   
    private String nom;
    private Integer puissance;
    private Integer idA;

    public Arme(Integer ida, String nom, Integer puissance) {
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
