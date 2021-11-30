package dessin;

public interface Transformation {
    void translation(double var1, double var3);

    void homothetie(double var1);

    void rotation(double var1, Point var3);

    void symetrieCentrale(Point var1);

    void symetrieAxiale(Ligne var1);
}

