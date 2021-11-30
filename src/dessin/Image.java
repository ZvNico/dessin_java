package dessin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Image implements Transformation, Calcul, Comparable<Image>, Seuil {
    private final List<Forme> listFormes = new ArrayList();

    public Image() {
    }

    public void ajoutForme(Forme forme) {
        int i = 0;

        boolean found;
        for (found = false; i < this.listFormes.size() && !found; ++i) {
            Forme form = (Forme) this.listFormes.get(i);
            if (form.equals(forme)) {
                found = true;
            }
        }
        if (!found) {
            this.listFormes.add(forme);
        }

    }

    public void removeForme(Forme forme) {
        if (this.listFormes.contains(forme)) {
            this.listFormes.remove(forme);
        }

    }

    public void removeForme(int index) {
        if (index < this.listFormes.size() && index > -1) {
            this.listFormes.remove(index);
        }

    }

    public double surface() {
        double surface = 0.0D;

        for (int i = 0; i < this.listFormes.size(); ++i) {
            Forme f = (Forme) this.listFormes.get(i);
            if (f instanceof FormeCalculable) {
                surface += ((FormeCalculable) f).surface();
            }
        }

        return surface;
    }

    public double perimetre() {
        double perimetre = 0.0D;

        for (int i = 0; i < this.listFormes.size(); ++i) {
            Forme f = (Forme) this.listFormes.get(i);
            if (f instanceof FormeCalculable) {
                perimetre += ((FormeCalculable) f).perimetre();
            }
        }

        return perimetre;
    }

    public void translation(double dx, double dy) {
        for (Forme listForme : this.listFormes) {
            if ((Forme) listForme instanceof FormeCalculable) {
                ((Forme) listForme).translation(dx, dy);
            }
        }

    }

    public void homothetie(double k) {
        for (Forme listForme : this.listFormes) {
            if (listForme instanceof FormeCalculable) {
                listForme.homothetie(k);
            }
        }

    }

    public void rotation(double angle, Point centre) {
        for (int i = 0; i < this.listFormes.size(); ++i) {
            Forme f = (Forme) this.listFormes.get(i);
            if (f instanceof FormeCalculable) {
                f.rotation(angle, centre);
            }
        }

    }

    public void symetrieCentrale(Point centre) {
        for (Forme listForme : this.listFormes) {
            Forme f = (Forme) listForme;
            if (f instanceof FormeCalculable) {
                f.symetrieCentrale(centre);
            }
        }

    }

    public void symetrieAxiale(Ligne ligne) {
        for (int i = 0; i < this.listFormes.size(); ++i) {
            Forme f = (Forme) this.listFormes.get(i);
            if (f instanceof FormeCalculable) {
                f.symetrieAxiale(ligne);
            }
        }

    }

    public int compareTo(Image image) {
        return this.surface() > image.surface() ? 1 : (this.surface() == image.surface() ? 0 : -1);
    }

    public int nbSeuil(double seuil) {
        int count = 0;

        for (int i = 0; i < this.listFormes.size(); ++i) {
            Forme f = (Forme) this.listFormes.get(i);
            if (f instanceof FormeCalculable && ((FormeCalculable) f).perimetre() <= seuil) {
                ++count;
            }
        }

        return count;
    }

    public String toString() {
        return "Image [listFormes=" + this.listFormes + "]";
    }

    public void tri() {
        List<FormeCalculable> listCalculable = new ArrayList();
        List<Forme> reste = new ArrayList();

        for (int i = 0; i < this.listFormes.size(); ++i) {
            Forme f = (Forme) this.listFormes.get(i);
            if (f instanceof FormeCalculable) {
                listCalculable.add((FormeCalculable) f);
            } else {
                reste.add(f);
            }
        }

        Collections.sort(listCalculable);
        this.listFormes.clear();
        this.listFormes.addAll(listCalculable);
        this.listFormes.addAll(reste);
    }
}
