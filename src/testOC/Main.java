package testOC;

import java.io.IOException;
import java.util.Scanner;

import testOC.Ftp;

public class Main {

   public static void main(String[] args) {

      try {
         Scanner sc = new Scanner(System.in);
         //Ftp ftp = new Ftp("cysboy");
         Ftp ftp = new Ftp("stockage.univ-brest.fr", 21, "e21502323");
         System.out.println("Connexion au FTP");

         ftp.connect();
         ftp.debugMode(true);
         
         System.out.println("-------------------------------------------------------");
         System.out.println("Vous êtes maintenant connecté au FTP");
         System.out.println("Vous avez le droit aux commandes PWD, CWD, LIST et QUIT");
         System.out.println("-------------------------------------------------------\n\n");
         String reponse = "";
         boolean encore = true;
         while (encore) {
            reponse = sc.nextLine().toUpperCase();

            switch (reponse) {
            case "PWD":
               System.out.println(ftp.pwd());
               break;
            case "CWD":
               System.out.println(">> Saisissez le nom du répertoire où vous voulez aller : ");
               String dir = sc.nextLine();
               System.out.println(ftp.cwd(dir));
               break;
            case "LIST":
               String list = ftp.list();
               System.out.println(list);
               break;
            case "QUIT":
               ftp.quit();
               encore = false;
               break;
             default : 
                System.err.println("Commande inconnue !");
                break;
            }

         }
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(0);
      }
      
      System.out.println("Ciao ! ");
   }
}