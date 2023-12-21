package basispullarchitecture;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import other.Discussion;
import other.ListDiscussion;

public interface Dialogue extends Remote {

	void sendMessage(String to, String message) throws RemoteException;

	ArrayList<String> getClients() throws RemoteException;

	Discussion getDiscussionWith(String with) throws RemoteException;

	ListDiscussion getDiscussions() throws RemoteException;
}
