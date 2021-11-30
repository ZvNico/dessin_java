package dessin;

public class Triangle extends FormeCalculable {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Point getPoint1() {
        return this.point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return this.point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return this.point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public double surface() {
        double a = this.point1.distance(this.point2);
        double b = this.point1.distance(this.point3);
        double c = this.point2.distance(this.point3);
        double s = (a + b + c) * 1.0D / 2.0D;
        double A = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return A;
    }

    public double perimetre() {
        double a = this.point1.distance(this.point2);
        double b = this.point1.distance(this.point3);
        double c = this.point2.distance(this.point3);
        return a + b + c;
    }

    public void translation(double dx, double dy) {
        this.point1.translation(dx, dy);
        this.point2.translation(dx, dy);
        this.point3.translation(dx, dy);
    }

    public void homothetie(double k) {
        this.point1.homothetie(k);
        this.point2.homothetie(k);
        this.point3.homothetie(k);
    }

    public void rotation(double angle, Point centre) {
        this.point1.rotation(angle, centre);
        this.point2.rotation(angle, centre);
        this.point3.rotation(angle, centre);
    }

    public void symetrieCentrale(Point centre) {
        this.point1.symetrieCentrale(centre);
        this.point2.symetrieCentrale(centre);
        this.point3.symetrieCentrale(centre);
    }

    public void symetrieAxiale(Ligne ligne) {
        this.point1.symetrieAxiale(ligne);
        this.point2.symetrieAxiale(ligne);
        this.point3.symetrieAxiale(ligne);
    }

    public String toString() {
        return "Triangle [point1=" + this.point1 + ", point2=" + this.point2 + ", point3=" + this.point3 + "]";
    }

    public int hashCode() {
        int prime = 1;
        int res = 1;
        res = 31 * res + (this.point1 == null ? 0 : this.point1.hashCode());
        res = 31 * res + (this.point2 == null ? 0 : this.point2.hashCode());
        res = 31 * res + (this.point3 == null ? 0 : this.point3.hashCode());
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
            Triangle other = (Triangle) obj;
            if (this.point1 == null) {
                if (other.point1 != null) {
                    return false;
                }
            } else if (!this.point1.equals(other.point1)) {
                return false;
            }

            if (this.point2 == null) {
                if (other.point2 != null) {
                    return false;
                }
            } else if (!this.point2.equals(other.point2)) {
                return false;
            }

            if (this.point3 == null) {
                if (other.point3 != null) {
                    return false;
                }
            } else if (!this.point3.equals(other.point3)) {
                return false;
            }

            return true;
        }
    }
}

