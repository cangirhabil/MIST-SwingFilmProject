package Interfaces;

import Model.Film;
import Model.FilmList;

public interface FilmListControllerInterface {
	boolean isFilmExist(String filmName);
    Film searchFilm(String filmName);
    Film getFilm(String filmName);
    void addFilm(Film film);
    void removeFilm(Film film);
    void sortFilmListByName();
    void sortFilmListByDate();
    void sortFilmListByIMDBScore();
    void sortFilmListByDuration();
    FilmList getFilmList();
    void setFilmList(FilmList filmList);
}
