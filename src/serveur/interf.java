package serveur;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface interf extends Remote{
	 public String getUserName() throws RemoteException;
	 // récupère le nom de l'utilisateur
	 public void send(String msg) throws RemoteException;
	 // permet l'envoi de message
	 public void bindClient(interf c) throws RemoteException;
	 // lie le client au serveur
	 public interf getClient() throws RemoteException;
	 // récupère l'objet du client

}