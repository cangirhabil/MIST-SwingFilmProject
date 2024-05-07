package Model;

import java.util.ArrayList;

public class Star extends Person {
    private ArrayList<Film> films;
	
    public Star(String name) {
		super(name);
	}
    
	public ArrayList<Film> getFilms() {
		return films;
	}
	public void setFilms(ArrayList<Film> films) {
		this.films = films;
	}
	
}

