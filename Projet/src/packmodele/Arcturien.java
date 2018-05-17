package packmodele;

public class Arcturien extends Personnage {
    /**
     * @attribute
     */
    private Integer taille;

    /**
     * @attribute
     */
    private static Integer c_forceMax = 100;

    public Arcturien(Integer idp,String nom, Integer taille, Integer force) {
    }

    public Integer getTaille() {
    }

    public static void setC_ForceMax() {
    }

    @Override
    public String presentationDetaille() {
        // TODO Implement this method
        return null;
    }

    @Override
    public String presentationCourte() {
        // TODO Implement this method
        return null;
    }

    @Override
    public void recevoirArme(Arme arme) {
        // TODO Implement this method
    }
}
