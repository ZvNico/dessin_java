package dessin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polygone extends FormeCalculable {
    private final List<Point> listPoints;

    public Polygone() {
        this.listPoints = new ArrayList();
    }

    public Polygone(List<Point> listPoints) {
        this.listPoints = listPoints;
    }

    private int voisin_sommet(int n, int i, int di) {
        return i + di > 0 ? (i + di) % n : (i + di + n) % n;
    }

    private double equation_droite(Point P0, Point P1, Point M) {
        return (P1.getX() - P0.getX()) * (M.getY() - P0.getY()) - (P1.getY() - P0.getY()) * (M.getX() - P0.getX());
    }

    private boolean point_dans_triangle(Triangle triangle, Point M) {
        Point P0 = triangle.getPoint1();
        Point P1 = triangle.getPoint2();
        Point P2 = triangle.getPoint3();
        return this.equation_droite(P0, P1, M) > 0.0D && this.equation_droite(P1, P2, M) > 0.0D && this.equation_droite(P2, P0, M) > 0.0D;
    }

    private int sommet_distance_maximale(Polygone polygone, Point P0, Point P1, Point P2, List<Integer> indices) {
        double n = polygone.getPoints().size();
        double distance = 0.0D;
        int j = 0;

        for (int i = 0; (double) i < n; ++i) {
            if (!indices.contains(i)) {
                Point M = polygone.getPoint(i);
                if (this.point_dans_triangle(new Triangle(P0, P1, P2), M)) {
                    double e = this.equation_droite(P1, P2, M);
                    double d = Math.abs(e);
                    if (d > distance) {
                        distance = d;
                        j = i;
                    }
                }
            }
        }

        return j;
    }

    public int sommet_gauche(Polygone polygone) {
        int n = polygone.getPoints().size();
        int j = 0;
        if (n > 0) {
            double x = polygone.getPoint(0).getX();

            for (int i = 1; i < n; ++i) {
                if (polygone.getPoint(i).getX() < x) {
                    x = polygone.getPoint(i).getX();
                    j = i;
                }
            }
        }

        return j;
    }

    private Polygone nouveau_polygone(Polygone polygone, int i_debut, int i_fin) {
        int n = polygone.getPoints().size();
        Polygone p = new Polygone();
        int i = i_debut;

        while (i != i_fin) {
            p.addPoint(polygone.getPoint(i));
            i = this.voisin_sommet(n, i, 1);
            p.addPoint(polygone.getPoint(i_fin));
        }

        return p;
    }

    private List<Triangle> trianguler_polygone_recursif(Polygone polygone, List<Triangle> liste_triangles) {
        int n = polygone.getPoints().size();
        if (n > 0) {
            int j0 = this.sommet_gauche(polygone);
            int j1 = this.voisin_sommet(n, j0, 1);
            int j2 = this.voisin_sommet(n, j0, -1);
            Point P0 = polygone.getPoint(j0);
            Point P1 = polygone.getPoint(j1);
            Point P2 = polygone.getPoint(j2);
            int j = this.sommet_distance_maximale(polygone, P0, P1, P2, Arrays.asList(j0, j1, j2));
            Polygone polygone_1;
            if (j == -1) {
                liste_triangles.add(new Triangle(P0, P1, P2));
                polygone_1 = this.nouveau_polygone(polygone, j1, j2);
                if (polygone_1.getPoints().size() == 3) {
                    liste_triangles.add(new Triangle(polygone_1.getPoint(0), polygone_1.getPoint(1), polygone_1.getPoint(2)));
                } else {
                    this.trianguler_polygone_recursif(polygone_1, liste_triangles);
                }
            } else {
                polygone_1 = this.nouveau_polygone(polygone, j0, j);
                Polygone polygone_2 = this.nouveau_polygone(polygone, j, j0);
                if (polygone_1.getPoints().size() == 3) {
                    liste_triangles.add(new Triangle(polygone_1.getPoint(0), polygone_1.getPoint(1), polygone_1.getPoint(2)));
                } else {
                    this.trianguler_polygone_recursif(polygone_1, liste_triangles);
                }

                if (polygone_2.getPoints().size() == 3) {
                    liste_triangles.add(new Triangle(polygone_2.getPoint(0), polygone_2.getPoint(1), polygone_2.getPoint(2)));
                } else {
                    this.trianguler_polygone_recursif(polygone_2, liste_triangles);
                }
            }
        }

        return liste_triangles;
    }

    private List<Triangle> trianguler_polygone(Polygone polygone) {
        List<Triangle> liste_triangles = new ArrayList();
        this.trianguler_polygone_recursif(polygone, liste_triangles);
        return liste_triangles;
    }

    public void addPoint(Point point) {
        this.listPoints.add(point);
    }

    public void addPoint(double x, double y) {
        this.listPoints.add(new Point(x, y));
    }

    private Point getPoint(int i) {
        return this.listPoints.get(i);
    }

    private List<Point> getPoints() {
        return this.listPoints;
    }

    public double surface() {
        List<Triangle> liste_triangles = this.trianguler_polygone(this);
        double surface = 0.0D;

        for (int i = 0; i < liste_triangles.size(); ++i) {
            surface += liste_triangles.get(i).surface();
        }

        return surface;
    }

    public double perimetre() {
        if (this.listPoints.size() < 2) {
            return 0.0D;
        } else {
            int i = 0;
            double d = 0.0D;

            double total;
            for (total = this.listPoints.get(0).distance(this.listPoints.get(this.listPoints.size() - 1)); i < this.listPoints.size() - 1; ++i) {
                Point point1 = this.listPoints.get(i);
                double x = point1.getX();
                double y = point1.getY();
                Point point2 = this.listPoints.get(i + 1);
                double x1 = point2.getX();
                double y1 = point2.getY();
                d = point1.distance(point2);
                System.out.println(d);
                total += d;
            }

            return total;
        }
    }

    public void translation(double dx, double dy) {
        for (int i = 0; i < this.listPoints.size(); ++i) {
            this.listPoints.get(i).translation(dx, dy);
        }

    }

    public void homothetie(double k) {
        for (int i = 0; i < this.listPoints.size(); ++i) {
            this.listPoints.get(i).homothetie(k);
        }

    }

    public void rotation(double angle, Point centre) {
        for (int i = 0; i < this.listPoints.size(); ++i) {
            this.listPoints.get(i).rotation(angle, centre);
        }

    }

    public void symetrieCentrale(Point centre) {
        for (int i = 0; i < this.listPoints.size(); ++i) {
            this.listPoints.get(i).symetrieCentrale(centre);
        }

    }

    public void symetrieAxiale(Ligne ligne) {
        for (int i = 0; i < this.listPoints.size(); ++i) {
            this.listPoints.get(i).symetrieAxiale(ligne);
        }

    }

    public int hashCode() {
        int prime = 1;
        int res = 1;
        res = 31 * res + (this.listPoints == null ? 0 : this.listPoints.hashCode());
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
            Polygone other = (Polygone) obj;
            if (this.listPoints == null) {
                return other.listPoints == null;
            } else return this.listPoints.equals(other.listPoints);
        }
    }
}
