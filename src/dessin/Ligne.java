package dessin;

public class Ligne extends Forme {
    private Point p1;
    private Point p2;

    public Ligne(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String toString() {
        return "Ligne [p1=" + this.p1 + ", p2=" + this.p2 + "]";
    }

    public Point getP1() {
        return this.p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return this.p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void translation(double dx, double dy) {
        this.p1.translation(dx, dy);
        this.p2.translation(dx, dy);
    }

    public void homothetie(double k) {
        this.p1.homothetie(k);
        this.p2.homothetie(k);
    }

    public void rotation(double angle, Point centre) {
        this.p1.rotation(angle, centre);
        this.p2.rotation(angle, centre);
    }

    public void symetrieCentrale(Point centre) {
        this.p1.symetrieCentrale(centre);
        this.p2.symetrieCentrale(centre);
    }

    public void symetrieAxiale(Ligne ligne) {
        this.p1.symetrieAxiale(ligne);
        this.p2.symetrieAxiale(ligne);
    }

    public int hashCode() {
        int prime = 1;
        int res = 1;
        res = 31 * res + (this.p1 == null ? 0 : this.p1.hashCode());
        res = 31 * res + (this.p2 == null ? 0 : this.p2.hashCode());
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
            Ligne other = (Ligne) obj;
            if (this.p1 == null) {
                if (other.p1 != null) {
                    return false;
                }
            } else if (!this.p1.equals(other.p1)) {
                return false;
            }

            if (this.p2 == null) {
                return other.p2 == null;
            } else return this.p2.equals(other.p2);
        }
    }
}

