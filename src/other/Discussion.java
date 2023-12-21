package other;

import java.io.Serializable;

public class Discussion implements Serializable {
	
	public ListMessages discussion;
	public String user1;
	public String user2;
	
	public Discussion(String user1, String user2) {
		this.user1 = user1;
		this.user2 = user2;
		this.discussion = new ListMessages();
	}
	
	public void addMessage(Message message) {
		discussion.addMessage(message);
	}
	
	public ListMessages getListMessages() {
		return discussion;
	}
	
	public String getUser1() {
		return this.user1;
	}
	
	public String getUser2() {
		return this.user2;
	}
}
