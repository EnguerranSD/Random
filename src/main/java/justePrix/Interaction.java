package justePrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interaction {

    public static int demanderNombre(){
        int resultat = 0;
        while ( resultat==0) {
            System.out.println("Veuillez saisir un nombre entre 1 et 100 : ");
            Scanner sc = new Scanner(System.in);
            try {
                resultat = sc.nextInt();
                if (resultat < 1 || resultat > 100) {
                    System.out.println("Vous devez saisir un chiffre entre 1 et 100 compris !");
                    resultat = 0;
                } else {
                    System.out.println("Vous avez saisi : "+resultat+"\n");
                    System.out.println("------------------------------------");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vous n'avez pas saisi un chiffre entier ! ");
            }
        }
        return resultat;
    }
}