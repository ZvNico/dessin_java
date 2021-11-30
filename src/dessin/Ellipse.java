package dessin;

public class Ellipse extends FormeCalculable {
    private double rayonMin;
    private double rayonMax;
    private Point centre;

    public Ellipse(double rayonMin, double rayonMax, Point centre) {
        this.rayonMin = rayonMin;
        this.rayonMax = rayonMax;
        this.centre = centre;
    }

    public double getRayonMin() {
        return this.rayonMin;
    }

    public void setRayonMin(double rayonMin) {
        this.rayonMin = rayonMin;
    }

    public double getRayonMax() {
        return this.rayonMax;
    }

    public void setRayonMax(double rayonMax) {
        this.rayonMax = rayonMax;
    }

    public Point getCentre() {
        return this.centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public double surface() {
        return 3.141592653589793D * this.rayonMax * this.rayonMin;
    }

    public double perimetre() {
        return 6.283185307179586D * Math.sqrt((this.rayonMin * this.rayonMin + this.rayonMax * this.rayonMax) / 2.0D);
    }

    public void translation(double dx, double dy) {
        this.centre.translation(dx, dy);
    }

    public void homothetie(double k) {
        this.centre.homothetie(k);
    }

    public String toString() {
        return "Ellipse [rayonMin=" + this.rayonMin + ", rayonMax=" + this.rayonMax + ", centre=" + this.centre + "]";
    }

    public void rotation(double angle, Point centre) {
        centre.rotation(angle, centre);
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
        long temp = Double.doubleToLongBits(this.rayonMax);
        res = 31 * res + (int) (temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.rayonMin);
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
            Ellipse other = (Ellipse) obj;
            if (this.centre == null) {
                if (other.centre != null) {
                    return false;
                }
            } else if (!this.centre.equals(other.centre)) {
                return false;
            }

            if (Double.doubleToLongBits(this.rayonMax) != Double.doubleToLongBits(other.rayonMax)) {
                return false;
            } else {
                return Double.doubleToLongBits(this.rayonMin) == Double.doubleToLongBits(other.rayonMin);
            }
        }
    }
}
