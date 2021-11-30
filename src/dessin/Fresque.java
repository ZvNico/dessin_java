package dessin;

public class Fresque {
    public Fresque() {
    }

    public void main() {
        Polygone polygone = new Polygone();
        Image image = new Image();
        image.ajoutForme(new Cercle(new Point(0.0D, 0.0D), 5.0D));
        image.ajoutForme(new Ligne(new Point(5.0D, 0.0D), new Point(10.0D, 7.0D)));
        image.ajoutForme(new Triangle(new Point(2.0D, 1.0D), new Point(5.0D, 4.0D), new Point(1.0D, 4.0D)));
        Image image2 = new Image();
        image2.ajoutForme(new Cercle(new Point(2.0D, 5.0D), 2.0D));
        Ellipse ellipse = new Ellipse(1.0D, 3.0D, new Point(3.0D, 1.0D));
        new Cercle(new Point(2.0D, 4.0D), 4.0D);
        Dessin dessin = new Dessin();
        dessin.ajoutImage(image);
        dessin.ajoutImage(image2);
        dessin.trier();
        double surface = ellipse.surface();
        double perimetre = ellipse.perimetre();
        double perimetre_polygone = polygone.perimetre();
        ellipse.symetrieCentrale(new Point(2.0D, 5.0D));
        ellipse.rotation(20.0D, new Point(0.0D, 3.0D));
        Ligne ligne = new Ligne(new Point(1.0D, 2.0D), new Point(2.0D, 4.0D));
        ligne.homothetie(6.0D);
        ligne.translation(1.0D, 7.0D);
        image2.ajoutForme(ligne);
        System.out.println(polygone.surface());
        System.out.println(polygone.perimetre());
        System.out.println(ligne);
        ligne.translation(3.0D, 0.0D);
        System.out.println("Translation de (3,0) sur la ligne");
        System.out.println(ligne);
        System.out.println(ligne);
        ligne.homothetie(6.0D);
        System.out.println("homothetie de rapport 6 sur la ligne");
        System.out.println(ligne);
        System.out.println(ligne);
        ligne.rotation(90.0D, new Point(9.0D, 6.0D));
        System.out.println("Rotation de (9,6) d'angle 90 dégré sur la ligne");
        System.out.println(ligne);
        System.out.println(ligne);
        ligne.symetrieCentrale(new Point(5.0D, 3.0D));
        System.out.println("symetrie centrale de centre (5,3) sur la ligne");
        System.out.println(ligne);
        System.out.println(ellipse);
        ellipse.translation(3.0D, 3.0D);
        System.out.println("Translation de (3,3) sur l'ellipse");
        System.out.println(ellipse);
        System.out.println(ellipse);
        ellipse.homothetie(8.0D);
        System.out.println("homothetie de rapport 8 sur l'ellipse");
        System.out.println(ellipse);
        System.out.println(ellipse);
        ellipse.rotation(120.0D, new Point(2.0D, 3.0D));
        System.out.println("Rotation de (2,3) d'angle 120 dégré sur l'ellipse");
        System.out.println(ellipse);
        System.out.println(ellipse);
        ligne.symetrieCentrale(new Point(8.0D, 4.0D));
        System.out.println("symetrie centrale de centre (8,4) sur l'ellipse");
        System.out.println(ellipse);
        System.out.printf("La surface de l'Ellipse %.0f %n", ellipse.surface());
        System.out.printf("La périmetre de l'Ellipse %.0f %n", ellipse.perimetre());
        System.out.println(image);
        image.tri();
        System.out.println("Tri des formes d'une image");
        System.out.println(image);
        System.out.println(dessin);
        dessin.trier();
        System.out.println("Tri des images d'un dessin");
        System.out.println(dessin);
        int nb_image = dessin.nbSeuil(10.0D);
        int nb_forme = image.nbSeuil(20.0D);
        System.out.println("Le nombre de forme dans l'image donc périmètre est inférieur à 10 ");
        System.out.println(nb_forme);
        System.out.println("Le nombre de l'image dans le dessin donc l'aire est inférieur à 20 ");
        System.out.println(nb_image);
    }
}
