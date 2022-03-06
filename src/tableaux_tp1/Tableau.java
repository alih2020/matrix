/*
 * To change this license header, choose License Headers in Project Propertities.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableaux_tp1;

import java.util.Random;

/**
 * Ali Hamzah
 * @author 1839821
 */
class Tableau {

    private int dimension;
    private int[][] Tableau;

    public Tableau() {

        Tableau = new int[dimension][dimension];
    }

    /**
     * la taille du tableau sera données par cette méthode initialserTableau les
     * valeurs dans le case seront initialisés aléatoirement entre 1 et 10.
     *  @param tab parametre table sera utiliser dans cette methode ci
     *
     * @return il faut retourner la valeur de la case initialisé aleatoirement
     */
    public int[][] initialiserTableau(int tab) { // taille du tableau
        Random rng = new Random();
        int valeurAleatoire;

        Tableau = new int[tab][tab]; // taille du tableau
        for (int i = 0; i < Tableau.length; ++i) {
            System.out.print("\n");
            for (int j = 0; j < Tableau[i].length; j++) {
                valeurAleatoire = rng.nextInt(10);
                Tableau[i][j] = valeurAleatoire;
                System.out.println("=====================================");
            }

        }

        return Tableau;
    }

    /**
     * La taille de la grille sera donnée par cette méthode initialiser grille
     * l'utilisateur) et de la remplir avec des zeros.
     *
     * @param grille parametre permettant de generer une grille
     * @return : il faut retourner la taille de la grille
     */
    public int[][] initialiserGrille(int grille) { //taille de la grille

        Tableau = new int[grille][grille]; // taille de la grille
        for (int i = 0; i < Tableau.length; ++i) {
            System.out.print("\n");
            for (int j = 0; j < Tableau[i].length; j++) {
                Tableau[i][j] = 0;

            }

        }

        return Tableau;
    }

    /**
     * À chaque fois que le programme demande une modification sur le tableau, à
     * ce moment là que la méthode sera utilisée
     */
    public void affichage() {
        for (int i = 0; i < Tableau.length; i++) {
            for (int j = 0; j < Tableau[i].length; j++) {

                System.out.printf("%6d", Tableau[i][j]); // formatage
            }
            System.out.println("");
        }

    }

    /**
     * une symétrie horizontale du muleu est effectué par cette méthode La
     * symétrie utilisera des valeurs temporaires
     */
    public void horizontal() {
        int min = 0, max = Tableau.length - 1, a, b;

        for (int i = 0; i < Tableau.length / 2; i++) {

            for (int j = 0; j < Tableau[i].length; j++) {

                a = Tableau[min][j]; // Des valeurs temporaires
                b = Tableau[max][j];
                Tableau[max][j] = a;
                Tableau[min][j] = b;

            }
            min++; // minimum
            max--; // maximum
        }

    }

    /**
     * La symétrie verticale du milieu serair fait par cette méthode La symétrie
     * vertical utilisera des valeurs temporaires pour arrriver à ses fins
     */
    public void vertical() {

        int i = 0;

        for (; i < Tableau.length; i++) {

            int min = 0, max = Tableau[i].length - 1, a, b;

            for (int j = 0; j < Tableau[i].length / 2; j++) {

                a = Tableau[i][min];
                b = Tableau[i][max];
                Tableau[i][max] = a;
                Tableau[i][min] = b;

                min++; // maximum
                max--; // minimum

            }

        }

    }

    /**
     * Utilisation d'un tableau temporaire sera nécessaire pour permettre la
     * rotation a droite du tableau.
     */
    public void rotationDroite() {

// Création d'un tableau temporaire
        int[][] temp = new int[Tableau.length][Tableau.length];
        int max = Tableau.length - 1, min = 0;
        int j = 0, i = 0;

// Rotation a droite dans le tableau temporaire
        for (i = 0; i < Tableau.length; i++) {
            for (j = 0; j < Tableau.length; j++) {

                temp[j][max] = Tableau[min][j];
            }
            max--;
            min++;
        }

// Assignation des valeurs dans le tableau original
        for (int k = 0; k < Tableau.length; k++) {
            for (int l = 0; l < Tableau.length; l++) {
                Tableau[k][l] = temp[k][l];
            }
        }

    }

    /**
     * Cette methode permet la rotation a gauche du tableau en faisant usage
     * d'un tableau temporaire.
     */
    public void rotationGauche() {

// Creation d'un tableau temporaire
        int[][] temp = new int[Tableau.length][Tableau.length];
        int max = Tableau.length - 1, min = 0;
        int j = 0, i = 0;

// Rotation a gauche dans le tableau temporaire
        for (i = 0; i < Tableau.length; i++) {
            for (j = 0; j < Tableau.length; j++) {

                temp[max][j] = Tableau[j][min];
            }
            max--; // maximum
            min++; // minimum
        }

// Assignation des valeurs dans le tableau original
        for (int k = 0; k < Tableau.length; k++) {
            for (int l = 0; l < Tableau.length; l++) {
                Tableau[k][l] = temp[k][l];
            }
        }

    }

    public void affichageGrille(int[][] grille) { // affichage de la grille

        System.out.printf("%4s", "");

        for (int i = 0; i < grille.length; i++) {
            System.out.printf("%6d", i + 1);
        }

        System.out.println();

        System.out.printf("%4s", "");

        for (int i = 0; i < grille.length; i++) {
            System.out.printf("%6s", "------");
        }

        System.out.println();
        for (int i = 0; i < grille.length; i++) {
            System.out.printf("%4s", i + 1 + " |");
            for (int j = 0; j < grille.length; j++) {
                System.out.printf("%6d", grille[i][j]);
            }
            System.out.println();
        }
    }

}
