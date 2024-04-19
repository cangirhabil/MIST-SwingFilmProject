package Model;

import java.util.ArrayList;
import java.util.List;

import Controller.ReadFile;

public class FilmList {
	
	public static ArrayList<Film> allFilms = new ArrayList<Film>();
	
	public FilmList(){
		ReadFile readFile = new ReadFile();
		readFile.fetchFilms(allFilms);
	}
	 	
	private List<Film> filmsInTheList;

    public List<Film> getFilmsInTheList() {	  
    	return filmsInTheList;
	}
    public void setFilmsInTheList(List<Film> filmsInTheList) {
    	this.filmsInTheList = filmsInTheList;
    }
    
    public Film getFilm(String filmName) {
    	for (Film item : allFilms) {
    		if(item.getTitle().equalsIgnoreCase(filmName)){
    			return item;
    		}
    	}
    	return null;
    }
    
    public boolean isFilmExist(String name){
    	for (Film item : allFilms) {
    		if(item.getTitle().equalsIgnoreCase(name)){
    			return true;
    		}
    	}
		return false;
    	
    }
    
    public Film searchFilm(String filmName){
		return getFilm(filmName);
    	
    }

}
