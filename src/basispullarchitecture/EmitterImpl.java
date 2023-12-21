package basispullarchitecture;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import other.ListDiscussion;
import other.Message;

public class EmitterImpl extends UnicastRemoteObject implements Emitter {
	
	public String pseudo;
	public ListDiscussion listDiscussions;
	public ArrayList<String> connected_people;
	public Receiver rcv;
	public HashMap<String, Receiver> list_receiver;
	public ArrayList<Message> waiting_messages;
	
	protected EmitterImpl(String pseudo, ListDiscussion listDiscuss, ArrayList<String> connectedPeople, Receiver rcv, HashMap<String, Receiver> list_receiver, ArrayList<Message> waiting_messages) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.pseudo = pseudo;
		this.listDiscussions = listDiscuss;
		this.connected_people = connectedPeople;
		this.rcv = rcv;
		this.list_receiver = list_receiver;
		this.waiting_messages = waiting_messages;
	}
	
	@Override
	public void sendMessage(String to, String message) throws RemoteException {
		Message newMessage = new Message(pseudo, to, message);
		newMessage.send(listDiscussions);
		Receiver receiver = list_receiver.get(to);
		receiver.receive(pseudo, message);
	}
}
