package dessin;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public Main() {
    }

    public static void main(String[] args) {
        boolean exit = false;
        sc = new Scanner(System.in);
        boolean var2 = true;
        do {
            System.out.println("1- Test Saisie en dur");
            System.out.println("2- Test Aleatoire");
            System.out.println("3- Test Lecture de fichier");
            System.out.println("0- Quitter");
            System.out.print("Selectionner une option:");
            int choix = sc.nextInt();
            System.out.println("\n");
            switch (choix) {
                case 0:
                    break;
                case 1:
                    testSaisieEndur();
                    break;
                case 2:
                    testAleatoire();
                    break;
                case 3:
                    testLectureFichier();
                    break;
                default:
                    System.out.println("Choix non valide veuillez entrer un nombre entre 0 et 3 ");
            }

            exit = choix == 0;
        } while (!exit);

        System.out.println("\n\n Au revoir à bientôt ! ");
    }

    private static void testLectureFichier() {
    }

    private static void testAleatoire() {
    }

    private static void testSaisieEndur() {
        int choix = 0;
        boolean exit = false;

        do {
            System.out.println("1- Test Cercle en Dur");
            System.out.println("2- Test Ligne en Dur");
            System.out.println("3- Test Ellipse En Dur");
            System.out.println("4- Test Polygone En Dur");
            System.out.println("5- Test image En Dur");
            System.out.println("6- Test Dessin En Dur");
            System.out.println("7- Test Fresque En Dur");
            System.out.println("0- Quitter");
            System.out.print("Selectionner une option:");
            choix = sc.nextInt();
            System.out.println("\n");
            switch (choix) {
                case 1:
                    testCercleEnDur();
                    break;
                case 2:
                    testLigneEnDur();
                    break;
                case 3:
                    testEllipseEnDur();
                    break;
                case 4:
                    tesPolygoneEnDur();
                    break;
                case 5:
                    testImageEnDur();
                    break;
                case 6:
                    testDessinEnDur();
                    break;
                case 7:
                    testFresqueEnDur();
                    break;
                default:
                    System.out.println("Choix non valide veuillez entrer un nombre entre 0 et 3 ");
            }

            exit = choix == 0;
        } while (!exit);

    }

    static void testCercleEnDur() {
        Cercle cercle = new Cercle(new Point(2.0D, 4.0D), 4.0D);
        System.out.printf("Le perimetre du %s est de %.2f\nLa surface de ce cercle est de %.2f", cercle, cercle.perimetre(), cercle.surface());
        cercle.translation(2.0D, 4.0D);
        System.out.println("Translation de (2,4) sur le cercle");
        System.out.println(cercle);
        System.out.println(cercle);
        cercle.homothetie(4.0D);
        System.out.println("homothetie de rapport 4 sur le cercle");
        System.out.println(cercle);
        System.out.println(cercle);
        cercle.rotation(60.0D, new Point(2.0D, 4.0D));
        System.out.println("Rotation de (2,4) d'angle 60 dégré sur le cercle");
        System.out.println(cercle);
        System.out.println(cercle);
        cercle.symetrieCentrale(new Point(2.0D, 4.0D));
        System.out.println("symetrie centrale de centre (2,4) sur le cercle");
        System.out.println(cercle);
        System.out.println("Appuyez sur entrer pour continuer ...");

        try {
            System.in.read();
        } catch (IOException var2) {
        }

    }

    static void testLigneEnDur() {
        Ligne ligne = new Ligne(new Point(1.0D, 2.0D), new Point(2.0D, 4.0D));
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
        System.out.println("Appuyez sur entrer pour continuer ...");

        try {
            System.in.read();
        } catch (IOException var2) {
        }

    }

    static void testEllipseEnDur() {
        Ellipse ellipse = new Ellipse(1.0D, 3.0D, new Point(3.0D, 1.0D));
        double surface = ellipse.surface();
        double perimetre = ellipse.perimetre();
        ellipse.symetrieCentrale(new Point(2.0D, 5.0D));
        ellipse.rotation(20.0D, new Point(0.0D, 3.0D));
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
        ellipse.symetrieCentrale(new Point(8.0D, 4.0D));
        System.out.println("symetrie centrale de centre (8,4) sur l'ellipse");
        System.out.println(ellipse);
        System.out.println(String.format("La surface de l'Ellipse %.0f ", ellipse.surface()));
        System.out.println(String.format("La périmetre de l'Ellipse %.0f ", ellipse.perimetre()));
    }

    static void tesPolygoneEnDur() {
        Polygone polygone = new Polygone();
        double perimetre_polygone = polygone.perimetre();
        System.out.println(polygone.surface());
        System.out.println(polygone.perimetre());
    }

    static void testImageEnDur() {
        throw new Error("Unresolved compilation problems: \n\tligne cannot be resolved to a variable\n\tdessin cannot be resolved to a variable\n\tdessin cannot be resolved\n\tdessin cannot be resolved to a variable\n\tdessin cannot be resolved\n");
    }

    static void testDessinEnDur() {
    }

    static void testFresqueEnDur() {
    }

    static void testCercleAleatoire() {
    }

    static void testCercleLectureFichier() {
    }
}

