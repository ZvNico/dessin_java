package dessin;

public abstract class FormeCalculable extends Forme implements Calcul, Comparable<FormeCalculable> {
    public FormeCalculable() {
    }

    public int compareTo(FormeCalculable forme) {
        return Double.compare(this.perimetre(), forme.perimetre());
    }
}