package Model;

import java.util.ArrayList;

public class Users {
	private ArrayList<Person> users = new ArrayList<>();
	
	public Person addUser(Person user) {
		users.add(user);
		return user;
	}
	
	public String getUsername(int index) {
		return users.get(index).getName();
	}
	
	public Person getUserByName(String userName) {
		for(int i = 0;i<users.size();i++)
		{
			if(users.get(i).getName().equals(userName)) {
				return users.get(i);
			}
		}
		
		return null;
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
