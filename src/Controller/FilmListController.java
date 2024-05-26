package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Model.Film;
import Model.FilmList;

public class FilmListController {
	private FilmList filmList;
	
	public FilmListController(String nameOfList) {
		this.filmList = new FilmList(nameOfList);
	}

    public boolean isFilmExist(String filmName){
    	for (Film item : filmList.getFilms()) {
    		if(item.getTitle().equalsIgnoreCase(filmName)){
    			return true;
    		}
    	}
		return false;
    }
    
    public Film searchFilm(String filmName){
		return getFilm(filmName);
    	
    }
    
    public Film getFilm(String filmName) {
    	for (Film item : filmList.getFilms()) {
    		if(item.getTitle().equalsIgnoreCase(filmName)){
    			return item;
    		}
    	}
    	return null;
    }
    
    public void addFilm(Film film) {
    	filmList.getFilms().add(film);
    }
    
    public void removeFilm(Film film) {
    	filmList.getFilms().remove(film);
    }
    
    public static void main(String[] args) {
        Sort<Integer> mergeSort = new Sort<>();
        Integer[] arr = {5, 3, 9, 1, 7, 2, 8, 4, 6};
        mergeSort.sort(arr);
        System.out.println("Sıralanmış Dizi:");
        for (int num : arr) {
            System.out.println(num);
        }
    }

	public void sortFilmListByName(FilmList list) {
		Comparator<Film> titleComparator = new Comparator<Film>() {
			public int compare(Film film1, Film film2) {
				return film1.getTitle().compareToIgnoreCase(film2.getTitle());
			}
		};
		Collections.sort(list.getFilms(), titleComparator);
	}

    public void sortFilmListByDate(FilmList list) {
        Comparator<Film> dateComparator = new Comparator<Film>() {
            @Override
            public int compare(Film film1, Film film2) {
            	return film1.getReleaseDate().compareTo(film2.getReleaseDate());
            }
        };
        Collections.sort(list.getFilms(), dateComparator);
    }
    
    
    public void sortFilmListByIMDBScore(FilmList list) {
        Comparator<Film> imdbScoreComparator = new Comparator<Film>() {
            @Override
            public int compare(Film film1, Film film2) {
                return Float.compare(film2.getRate(), film1.getRate());
            }
        };
        Collections.sort(list.getFilms(), imdbScoreComparator);
    }
    
    
    public void sortFilmListByDuration(FilmList list) {
        Comparator<Film> durationComparator = new Comparator<Film>() {
            @Override
            public int compare(Film film1, Film film2) {
                return Integer.compare(film1.getDuration(), film2.getDuration());
            }
        };
        Collections.sort(list.getFilms(), durationComparator);
    }

	public FilmList getFilmList() {
		return filmList;
	}

	public void setFilmList(FilmList filmList) {
		this.filmList = filmList;
	}
}
