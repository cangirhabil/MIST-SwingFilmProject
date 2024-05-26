package Interfaces;

import java.util.ArrayList;

import Model.Director;
import Model.Film;
import Model.Star;

public interface ReadCSVInterface {
    boolean isFilmExist(String name);
    Film searchFilm(String filmName);
    void fetchFilms(ArrayList<Film> films);
    Director getDirector(ArrayList<Director> directors, String name);
    Star getStar(ArrayList<Star> allStars, String name);
}