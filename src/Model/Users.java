package Model;

import java.util.ArrayList;

public class Users {
	public ArrayList<Person> users = new ArrayList<>();
	
	public Person addUser(Person user) {
		users.add(user);
		return user;
	}
	
	public String getUsername(int index) {
		return users.get(index).getName();
	}
	
	public Person getUser(int index) {
		return users.get(index);
	}
	
	public boolean isEmpty() {
		return users.size() == 0;
	}
	
	public int getSize()
	{
		return users.size();
	}
	
}