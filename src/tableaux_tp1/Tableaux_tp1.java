/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableaux_tp1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ali Hamzah
 * @author 1839821
 */
public class Tableaux_tp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        Tableau tab = new Tableau();
        Tableau grille = new Tableau();
        int tailleTableau, tailleGrille, optionMenu;

        do {

            affichageMenu();
            do {
                optionMenu = choixMenu();
            } while (optionMenu < 1 || optionMenu > 7);

            switch (optionMenu) {
                case 1:

                    tailleTableau = definirtailleTableau(r);
                    tailleGrille = definirtailleGrille(r, tailleTableau);

                    tab.initialiserTableau(tailleTableau);
                    grille.initialiserGrille(tailleGrille);
                    tab.affichage();

                    break;

                case 2:
                    tab.horizontal();
                    tab.affichage();

                    break;
                case 3:
                    tab.vertical();
                    tab.affichage();

                    break;
                case 4:
                    tab.rotationDroite();
                    tab.affichage();

                    break;
                case 5:
                    tab.rotationGauche();
                    tab.affichage();

                    break;
                case 6:
                  
                    break;
                case 7:

                    break;

            }
        } while (optionMenu != 7);

        System.out.println("Vous avez décider de quitter le programme !");

    }

    /**
     * L'affichage du Menu sera généré dans cette méthode
     */
    private static void affichageMenu() {
        System.out.println("Entrez votre option !\n"
                + "\n"
                + "1 - Lecture des information\n"
                + "2 - Effectuer symétrie horizontale du milieu\n"
                + "3 - Effectuer symétrie verticale du milieu\n"
                + "4 - Effectuer rotation à droite\n"
                + "5 - Effectuer rotation à gauche\n"
                + "6 - Affichage des résultats\n"
                + "7 - Quitter le programme");
    }

    /*
     * L'utilisateur devra entrer une valeur pour la taille du tableau qui devra
     * etre comprise entre 2 et 20. La saisi de nouveau sera nécessaire si
     * l'utilisateur ne respecte pas ces conditions et contraint
     *
     * @param r
     * @return la valeur retournera la taille du tableau
     */
    private static int definirtailleTableau(Scanner r) {
        int tailleTableau;

        do {

            System.out.print("Entrez la dimension de votre tableau (valeur entre 2 et 20) :");
            tailleTableau = r.nextInt();

        } while (tailleTableau < 2 || tailleTableau > 20);

        return tailleTableau;
    }

    /**
     * Cette méthode demandera à l'utilisateur de saisir une valeur qui devra
     * etre entre 2 et 20 et doit etre grande que la taille du tableau,la taille
     * de la grille.Un nouveau saisi sera obligatoire,si l'utilisateur ne
     * respecte pas cette instruction.
     *
     * @param r est Scanner @param taille_tableau permettra de définir une taille
     * @return la tailleGrille l'indication retournera la taille de la grille
     */
    private static int definirtailleGrille(Scanner r, int taille_tableau) {
        int tailleGrille; 
        do {
            do {

                System.out.print("Entrez la dimension de votre grille (valeur de 2 à 20) :");
                tailleGrille = r.nextInt();
            } while (tailleGrille < 2 || tailleGrille > 20);
        } while (tailleGrille < taille_tableau);

        return tailleGrille;
    }

    /**
     * L'option du menu sera choisi par l'utilisateur à partir de cette méthode
     * choixMenu.
     
     */
    private static int choixMenu() {
        int option = 2; // initialisé car on aurait besoin dans la boucle
        boolean hamzah = false;

        do {
            System.out.print("Entrez votre choix :");
            Scanner r = new Scanner(System.in);
            try {
                option = r.nextInt();
                hamzah = true; // hamzah = true pour le try catch puisse marcher
            } catch (InputMismatchException h) {
                System.err.println("Erreur! Entre votre choix de nouveau. ");
            }
        } while (!hamzah);

        return option;

    }

}


