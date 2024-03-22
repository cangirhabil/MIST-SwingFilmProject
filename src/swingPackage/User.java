package swingPackage;

public class User extends Person{

	String password;
	private Film[] filmsInTheList;
	
	public User(String name) {
		super(name);
		filmsInTheList = new Film[10];
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Film[] getFilmsInTheList() {
		return filmsInTheList;
	}

	public void setFilmsInTheList(Film[] filmsInTheList) {
		this.filmsInTheList = filmsInTheList;
	}
}
