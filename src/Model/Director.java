package Model;

import java.util.ArrayList;

public class Director extends Person {

    private ArrayList<Film> films;
	
    public Director(String name) {
		super(name);
		this.films = new ArrayList<Film>();
	}

	public ArrayList<Film> getFilms() {
		return films;
	}
	public void setFilms(ArrayList<Film> films) {
		this.films = films;
	}
}

