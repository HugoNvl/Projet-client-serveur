package basispullarchitecture;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.io.*;
import java.lang.*;
import java.util.*;

import other.Discussion;
import other.ListDiscussion;
import other.Message;

public class ConnectionImpl extends UnicastRemoteObject implements Connection {
	
	public ArrayList<String> connected_people;
	public ListDiscussion listDiscuss;
	public HashMap<String, Receiver> list_receiver;
	public ArrayList<Message> waiting_messages;
	
	protected ConnectionImpl(ListDiscussion listDiscussion, ArrayList<String> connectedPeople, HashMap<String, Receiver> list_receiver, ArrayList<Message> waiting_messages) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.listDiscuss = listDiscussion;
		this.connected_people = connectedPeople;
		this.list_receiver = list_receiver;
		this.waiting_messages = waiting_messages;
	}
	
	@Override
	public Emitter connect(String pseudo, Receiver rcv) throws RemoteException {
		// Réception des messages mis en attente quand l'utilisateur était déconnecté
		for(int i = 0; i < waiting_messages.size(); i++) {
			if(waiting_messages.get(i).getTo() == pseudo) {
				rcv.receive(waiting_messages.get(i).getFrom(), waiting_messages.get(i).getMessage());
			}
		}
		
		// Réception de la liste des utilisateurs connectés
		rcv.initClients(connected_people);
		
		// Envoi aux autres utilisateurs connectés d'une notification de connexion
		for(Map.Entry<String, Receiver> e : list_receiver.entrySet()) {
			e.getValue().addClient(pseudo);
		}
		
		// Ajout de l'utilisateur à la liste des utilisateurs connectés, et de son objet Receiver à la HashMap 
		connected_people.add(pseudo);
		list_receiver.put(pseudo, rcv);
		
		// Création de l'Emitter
		return new EmitterImpl(pseudo, listDiscuss, connected_people, rcv, list_receiver, waiting_messages);
	}
	
	@Override
	public void disconnect(String pseudo) throws RemoteException {
		// Suppression de l'utilisateur de la liste des utilisateurs connectés, et de son objet Receiver à la HashMap 
		connected_people.remove(pseudo);
		list_receiver.remove(pseudo);
		
		// Envoi aux autres utilisateurs connectés d'une notification de déconnexion
		for(Map.Entry<String, Receiver> e : list_receiver.entrySet()) {
			e.getValue().removeClient(pseudo);
		}
	}
}
