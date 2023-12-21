package other;

import java.io.Serializable;

public class Message implements Serializable {
	
	public String from;
	public String to;
	public String message;
	
	public Message(String from, String to, String message) {
		this.from = from;
		this.to = to;
		this.message = message;
	}
	
	public void send(ListDiscussion listDiscussion) {
		int exists = listDiscussion.existsDiscussion(from, to);
		if(exists == -1) {
			Discussion discussion = new Discussion(from, to);
			discussion.addMessage(this);
			listDiscussion.addDiscussion(discussion);
		} else {
			listDiscussion.get(exists).addMessage(this);
		}
	}
	
	public String getFrom() {
		return from;
	}
	
	public String getTo() {
		return to;
	}
	
	public String getMessage() {
		return message;
	}
}
