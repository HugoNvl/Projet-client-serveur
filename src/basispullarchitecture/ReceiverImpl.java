package basispullarchitecture;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import other.ListDiscussion;

public class ReceiverImpl extends UnicastRemoteObject implements Receiver {
	
	protected ReceiverImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void receive(String from, String message) {
		
	}
	
	public void initClients(ArrayList<String> connected_people) {
		
	}
	
	public void addClient(String name) {
		
	}
	
	public void removeClient(String name) {
		
	}
}
