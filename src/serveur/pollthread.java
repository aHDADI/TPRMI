package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class pollthread extends UnicastRemoteObject implements interf {
  public String name;
  public interf client = null;

  public pollthread(String n) throws RemoteException { 
    this.name = n;   
  }
  public String getUserName() throws RemoteException {
    return this.name;
  }

  public void bindClient(interf c){
    client = c;
  }
 
  public interf getClient(){
    return client;
  }
 
  public void send(String s) throws RemoteException{
    System.out.println(s);
  }  
}
