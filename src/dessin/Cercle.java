package dessin;

public class Cercle extends FormeCalculable {
    private Point centre;
    private double rayon;

    public Cercle(Point p, double rayon) {
        this.centre = p;
        this.rayon = rayon;
    }

    public Cercle() {
    }

    public Point getCentre() {
        return this.centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public double getRayon() {
        return this.rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public String toString() {
        return "Cercle{le point=" + this.centre + ", rayon=" + this.rayon + '}';
    }

    public double surface() {
        return 3.141592653589793D * this.rayon * this.rayon;
    }

    public double perimetre() {
        return 6.283185307179586D * this.rayon;
    }

    public void translation(double dx, double dy) {
        this.centre.translation(dx, dy);
    }

    public void homothetie(double k) {
        this.centre.homothetie(k);
    }

    public void rotation(double angle, Point centre) {
        this.centre.rotation(angle, centre);
    }

    public void symetrieCentrale(Point centre) {
        this.centre.symetrieCentrale(centre);
    }

    public void symetrieAxiale(Ligne ligne) {
        this.centre.symetrieAxiale(ligne);
    }

    public int hashCode() {
        int prime = 1;
        int res = 1;
        res = 31 * res + (this.centre == null ? 0 : this.centre.hashCode());
        long temp = Double.doubleToLongBits(this.rayon);
        res = 31 * res + (int) (temp ^ temp >>> 32);
        return res;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Cercle other = (Cercle) obj;
            if (this.centre == null) {
                if (other.centre != null) {
                    return false;
                }
            } else if (!this.centre.equals(other.centre)) {
                return false;
            }

            return Double.doubleToLongBits(this.rayon) == Double.doubleToLongBits(other.rayon);
        }
    }
}
