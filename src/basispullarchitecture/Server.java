package basispullarchitecture;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.HashMap;

import other.ListDiscussion;
import other.Message;

public class Server {

	public static ArrayList<String> connectedPeople = new ArrayList<String>();
	public static ListDiscussion listDiscussion = new ListDiscussion();
	public static HashMap<String, Receiver> list_receiver = new HashMap<>();
	public static ArrayList<Message> waiting_messages;
	
	public static void main(String[] args) {
		try {
			// registry creation
			LocateRegistry.createRegistry(1099);
			
			// component instanciation and implicit activation
			ConnectionImpl myComponent = new ConnectionImpl(listDiscussion, connectedPeople, list_receiver, waiting_messages);
			System.out.println(myComponent.getRef().remoteToString());
			
			//publication of component reference in the registry
			Naming.rebind("Connection", myComponent);
			
			System.out.println("Serveur actif");
			
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}