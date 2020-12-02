package serveur;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
 
public class Serveur extends UnicastRemoteObject{
	private static final long serialVersionUID = 1L;
	public Serveur() throws RemoteException{
	super(0);
	}
public static void main (String[] args) {
    try {
    	LocateRegistry.createRegistry(1099); 
        Scanner s = new Scanner(System.in);
        System.out.println("Veuillez saisir votre nom :");
        String name=s.nextLine();
 
        pollthread server = new pollthread(name);  
 
        Naming.rebind("rmi://localhost/RmiServer", server);
 
        System.out.println("Vous êtes prêt a parler");
 
        while(true){
          String msg = s.nextLine();
          if (server.getClient() != null){
            interf client = server.getClient();
            msg = ""+server.getUserName()+" : " +msg;
            client.send(msg);
          }
        }

      }catch (Exception e) {
        e.printStackTrace();
      }
  }
}
