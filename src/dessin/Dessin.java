package dessin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dessin implements Transformation, Calcul, Seuil {
    private final List<Image> images = new ArrayList();

    public Dessin() {
    }

    public static Dessin copy(Dessin dessin) {
        Dessin des_copy = new Dessin();

        for (int i = 0; i < dessin.getCountImages(); ++i) {
            Image img = dessin.getImage(i);
            if (img != null) {
                des_copy.ajoutImage(img);
            }
        }

        return des_copy;
    }

    public void ajoutImage(Image image) {
        int i = 0;

        boolean found;
        for (found = false; i < this.images.size() && !found; ++i) {
            Image img = this.images.get(i);
            if (img.equals(image)) {
                found = true;
            }
        }

        if (!found) {
            this.images.add(image);
        }

    }

    public void removeImage(Image image) {
        this.images.remove(image);

    }

    public void removeImage(int index) {
        if (index < this.images.size() && index > -1) {
            this.images.remove(index);
        }

    }

    public double surface() {
        double surface = 0.0D;

        for (int i = 0; i < this.images.size(); ++i) {
            surface += this.images.get(i).surface();
        }

        return surface;
    }

    public double perimetre() {
        double perimetre = 0.0D;

        for (int i = 0; i < this.images.size(); ++i) {
            perimetre += this.images.get(i).perimetre();
        }

        return perimetre;
    }

    public void translation(double dx, double dy) {
        for (int i = 0; i < this.images.size(); ++i) {
            this.images.get(i).translation(dx, dy);
        }

    }

    public void homothetie(double k) {
        for (int i = 0; i < this.images.size(); ++i) {
            this.images.get(i).homothetie(k);
        }

    }

    public void rotation(double angle, Point centre) {
        for (int i = 0; i < this.images.size(); ++i) {
            this.images.get(i).rotation(angle, centre);
        }

    }

    public void symetrieCentrale(Point centre) {
        for (int i = 0; i < this.images.size(); ++i) {
            this.images.get(i).symetrieCentrale(centre);
        }

    }

    public String toString() {
        return "Dessin [images=" + this.images + "]";
    }

    public void symetrieAxiale(Ligne ligne) {
        for (int i = 0; i < this.images.size(); ++i) {
            this.images.get(i).symetrieAxiale(ligne);
        }

    }

    public int hashCode() {
        int prime = 1;
        int res = 1;
        res = 31 * res + (this.images == null ? 0 : this.images.hashCode());
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
            Dessin other = (Dessin) obj;
            if (this.images == null) {
                return other.images == null;
            } else return this.images.equals(other.images);
        }
    }

    public int nbSeuil(double seuil) {
        int count = 0;

        for (int i = 0; i < this.images.size(); ++i) {
            Image f = this.images.get(i);
            if (f.surface() <= seuil) {
                ++count;
            }
        }

        return count;
    }

    private Image getImage(int i) {
        return i < this.getCountImages() ? this.images.get(i) : null;
    }

    private int getCountImages() {
        return this.images.size();
    }

    public void trier() {
        Collections.sort(this.images);
    }
}
