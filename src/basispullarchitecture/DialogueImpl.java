package basispullarchitecture;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.lang.*;
import java.util.*;

import other.Discussion;
import other.ListDiscussion;
import other.Message;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {
	
	public String pseudo;
	public ListDiscussion listDiscussions;
	public ArrayList<String> connected_people;
	
	protected DialogueImpl(String pseudo, ListDiscussion listDiscuss, ArrayList<String> connectedPeople) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.pseudo = pseudo;
		this.listDiscussions = listDiscuss;
		this.connected_people = connectedPeople;
	}
	
	@Override
	public ArrayList<String> getClients() throws RemoteException {
		return connected_people;
	}
	
	@Override
	public void sendMessage(String to, String message) throws RemoteException {
		Message newMessage = new Message(pseudo, to, message);
		newMessage.send(listDiscussions);
	}
	
	@Override
	public ListDiscussion getDiscussions() throws RemoteException {
		ListDiscussion pseudo_discussions = new ListDiscussion();
		for(int i = 0; i < listDiscussions.length(); i++) {
			if(listDiscussions.get(i).getUser1() == pseudo || listDiscussions.get(i).getUser2() == pseudo) {
				pseudo_discussions.addDiscussion(listDiscussions.get(i));
			}
		}
		return pseudo_discussions;
	}
	
	@Override
	public Discussion getDiscussionWith(String with) throws RemoteException {
		return listDiscussions.getDiscussBetween(pseudo, with);
	}
}
