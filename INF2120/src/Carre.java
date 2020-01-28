public class Carre implements Forme2D {
    protected double cote;
    public Carre(double cote) {
        this.cote = cote;
    }

    @Override
    public double aire() {
        return cote * cote;
    }
}
