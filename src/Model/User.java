package Model;

import java.util.ArrayList;
public class User extends Person {
	private ArrayList<FilmList> filmLists;
	private ArrayList<Film> watchedFilms;
	private ArrayList<String> points;
	
    private String password;

    public User(String name) {
        super(name);
        this.filmLists = new ArrayList<FilmList>();
        this.watchedFilms = new ArrayList<Film>();
        this.points = new ArrayList<String>();
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
    
	public void setFilmLists(ArrayList<FilmList> filmLists) 
	{
		this.filmLists = filmLists;
	}

	public ArrayList<Film> getWatchedFilms() {
		return watchedFilms;
	}

	public void setWatchedFilms(ArrayList<Film> watchedFilms) {
		this.watchedFilms = watchedFilms;
	}

	public ArrayList<String> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<String> pointStrings) {
		this.points = pointStrings;
	}
}
