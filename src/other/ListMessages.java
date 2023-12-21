package other;

import java.io.Serializable;
import java.util.ArrayList;

public class ListMessages implements Serializable {

	public ArrayList<Message>listMessages;
	
	public ListMessages() {
		this.listMessages = new ArrayList<Message>();
	}
	
	public void addMessage(Message message) {
		listMessages.add(message);
	}
	
	public ArrayList<Message> getMessages() {
		return listMessages;
	}
}
