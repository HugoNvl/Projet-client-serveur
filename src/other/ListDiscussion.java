package other;

import java.io.Serializable;
import java.util.ArrayList;

public class ListDiscussion implements Serializable {
	
	public ArrayList<Discussion>listDiscussion;
	
	public ListDiscussion() {
		this.listDiscussion = new ArrayList<Discussion>();
	}
	
	public void createDiscussion(String user1, String user2) {
		Discussion newDiscussion = new Discussion(user1, user2);
		addDiscussion(newDiscussion);
	}
	
	public void addDiscussion(Discussion discussion) {
		listDiscussion.add(discussion);
	}
	
	public int existsDiscussion(String user1, String user2) {
		for(int i = 0; i < listDiscussion.size(); i++) {
			if( (listDiscussion.get(i).getUser1().equals(user1)) & (listDiscussion.get(i).getUser2().equals(user2)) ) {
				return i;
			} else if( (listDiscussion.get(i).getUser1().equals(user2)) & (listDiscussion.get(i).getUser2().equals(user1)) ) {
				return i;
			}
		}
		return -1;
	}
	
	public Discussion get(int index) {
		return listDiscussion.get(index);
	}

	public Discussion getDiscussBetween(String user1, String user2) {
		int idx = existsDiscussion(user1, user2);
		if(idx == -1) {
			createDiscussion(user1, user2);
			return get(length()-1);
		} else {
			return get(idx);
		}
	}
	
	public int length() {
		return this.length();
	}
}
