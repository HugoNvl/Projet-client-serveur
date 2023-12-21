package basispullarchitecture;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Connection extends Remote {

	Emitter connect(String pseudo, Receiver rcv) throws RemoteException;

	void disconnect(String pseudo) throws RemoteException;
}
