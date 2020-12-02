package client;
import java.rmi.Naming;
import java.util.Scanner;
import serveur.interf;
import serveur.pollthread;
public class Client {
  public static void main (String[] args) {
      try {
          Scanner s = new Scanner(System.in);
          System.out.println("Veuillez saisir votre nom :");
          String name = s.nextLine();                  
          interf client = new pollthread(name);
 
          interf server = (interf)Naming.lookup("rmi://localhost/RmiServer");
          String msg = ""+client.getUserName()+" : S'est connecté";
          server.send(msg);
          System.out.println("Vous êtes prêts a parler !");
          server.bindClient(client);
 
          while(true){
            msg = s.nextLine();
            msg = ""+client.getUserName()+" : " +msg;            
            server.send(msg);
          }
          
 
        }catch (Exception e) {
          e.printStackTrace();
        }
    }
}