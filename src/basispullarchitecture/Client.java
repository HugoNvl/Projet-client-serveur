package basispullarchitecture;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import other.Message;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection myConnection;
		
		try {
			//example of a RMI URL used to retrieve a remote reference 
			myConnection = (Connection) Naming.lookup("rmi://localhost:1099/Connection");
			Receiver rcv = new ReceiverImpl();
			}
		catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
