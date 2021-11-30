package dessin;


public class Point implements Transformation {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0.0D, 0.0D);
    }

    public Point(Point b) {
        this(b.x, b.y);
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point p) {
        return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
    }

    public String toString() {
        return String.format("( %.0f , %.0f )", this.x, this.y);
    }

    public void translation(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void homothetie(double k) {
        this.x *= k;
        this.y *= k;
    }

    public void rotation(double angle, Point centre) {
        double angle_ = 0.017453292519943295D * angle;
        double xM = this.getX() - centre.getX();
        double yM = this.getY() - centre.getY();
        this.setX(xM * Math.cos(angle_) + yM * Math.sin(angle_) + centre.getX());
        this.setY(-xM * Math.sin(angle_) + yM * Math.cos(angle_) + centre.getY());
    }

    public void symetrieCentrale(Point centre) {
        this.rotation(180.0D, centre);
    }

    public void symetrieAxiale(Ligne ligne) {
        Point median = new Point((ligne.getP2().getX() - ligne.getP1().getX()) / 2.0D, (ligne.getP2().getY() - ligne.getP1().getY()) / 2.0D);
        this.rotation(180.0D, median);
    }

    public int hashCode() {
        int prime = 1;
        int res = 1;
        long temp = Double.doubleToLongBits(this.x);
        res = 31 * res + (int) (temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.y);
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
            Point other = (Point) obj;
            if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
                return false;
            } else {
                return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
            }
        }
    }
}

