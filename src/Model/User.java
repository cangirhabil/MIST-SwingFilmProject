package Model;

import java.util.ArrayList;
public class User extends Person {

	private ArrayList<FilmList> filmLists;
    private String password;


    public User(String name) {
        super(name);
        this.filmLists = new ArrayList<FilmList>();
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<FilmList> getFilmLists() {
		return filmLists;
	}
	public void setFilmLists(ArrayList<FilmList> filmLists) {
		this.filmLists = filmLists;
	}
	

    
    

}
