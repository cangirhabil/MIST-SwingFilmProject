package Model;

import java.util.ArrayList;

public class FilmList {
	
	private ArrayList<Film> films;
	private String nameOfList; 
	private ArrayList<String> dates; // "MovieName/MM-DD"
	
	public FilmList(String nameOfList){
		this.nameOfList = nameOfList;
		this.films = new ArrayList<Film>();
		this.dates = new ArrayList<String>();
	}

    public String getNameOfList() {
		return nameOfList;
	}

	public void setNameOfList(String nameOfList) {
		this.nameOfList = nameOfList;
	}

	public ArrayList<Film> getFilms() {	  
    	return films;
	}
	
    public void setFilms(ArrayList<Film> films) {
    	this.films = films;
    }

	public ArrayList<String> getDates() {
		return dates;
	}

	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
	}
}
