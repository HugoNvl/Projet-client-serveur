package basispullarchitecture;

import java.rmi.Remote;
import java.util.ArrayList;

public interface Receiver extends Remote {
	
	public void receive(String from, String message);
	
	public void initClients(ArrayList<String> connected_people);
	
	public void addClient(String name);

	public void removeClient(String name);
}
