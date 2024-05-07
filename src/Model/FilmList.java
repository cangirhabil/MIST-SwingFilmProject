package Model;

import java.util.ArrayList;

public class FilmList {
	
	private ArrayList<Film> films;
	private String nameOfList; 
	
	
	public FilmList(String nameOfList){
		this.nameOfList = nameOfList;
		this.films = new ArrayList<Film>();
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
    
     
}
