package Source;


import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;
import Model.Director;
import Model.Film;
import Model.Star;

public class ReadCSV {
	
	ArrayList<Film>  allFilms = new ArrayList<Film>();
	
	public ReadCSV(){
		fetchFilms(allFilms);
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
    
    private Film getFilm(String filmName) {
    	for (Film item : allFilms) {
    		if(item.getTitle().equalsIgnoreCase(filmName)){
    			return item;
    		}
    	}
    	return null;
    }
    

	
	public void fetchFilms(ArrayList<Film> films) {
		
		ArrayList<Star> allStars = new ArrayList<Star>(); 
		ArrayList<Director> allDirectors = new ArrayList<Director>();
		try {
			File filmFile = new File("/Users/admin/Desktop/4. Term/java project/MIST-SwingFilmProject/imdb_top_1000.csv");
			Scanner sc = new Scanner(filmFile); 
			String pass =sc.nextLine();// DO NOT DELETE
			while (sc.hasNext()) {
				String[] line = new String[16];
				line = sc.nextLine().split(",&&&,");
				
				String title = line[1].toString().toLowerCase().trim();		

				String releaseDate = line[2].toString().toLowerCase().trim();	
				
				String certificate = line[3].toString().toLowerCase().trim();	
				
				int runtime = (line[4] != "") ? Integer.parseInt(line[4].trim().split(" ")[0]) : 0;
				int duration = runtime;
				
				String genre = line[5].toString().toLowerCase().trim();	
				
				float rate = (line[6] != "") ? Float.parseFloat(line[6].toString().toLowerCase().trim()) : 0;	
				
				int metascore = (line[8] != "") ?  Integer.parseInt(line[8].toString().toLowerCase().trim()): 0;	
				
				String description = line[7].toString().toLowerCase().trim();
				
				
				int voteCount =(line[14] != "") ?  Integer.parseInt(line[14].toString().toLowerCase().trim()): 0;
				int grossRevenue = 0;
				if(line.length == 16) {
					grossRevenue =Integer.parseInt(line[15].toString().toLowerCase().trim());
				}
				
				
				//to add films of directors in films one by one
				Director director = null;
				if(line[9].toString().toLowerCase().trim() != "") {
					Director d = getDirector(allDirectors, line[9].toString().toLowerCase().trim());
					if(	d == null) {
						Film tempFilm = new Film(title,releaseDate,certificate,duration,genre,rate,metascore,description,null,null,voteCount,grossRevenue);
						director = new Director(line[9].toString().toLowerCase().trim());
						director.setFilms(new ArrayList<Film>());
						director.getFilms().add(tempFilm);
						allDirectors.add(director);
					}else {
						boolean flage = false;
						for(Film f : d.getFilms()) {
							if(f.getTitle().equalsIgnoreCase(title)) {
								flage = true;
								break;
							}
						}
						if(!flage) {
							Film tempFilm = new Film(title,releaseDate,certificate,duration,genre,rate,metascore,description,null,null,voteCount,grossRevenue);
							d.getFilms().add(tempFilm);
						}
						director = d;
					}
				}
				
				// to add film of stars by one by to films
				ArrayList<Star> stars = new ArrayList<Star>();
				for(int a = 0; a < 4 ; a++) {
					Star s0 = null;
					if(line[10 + a].toString().toLowerCase().trim() != "") {
						Star s = getStar(allStars, line[10 + a].toString().toLowerCase().trim());
						if(	s == null) {
							Film tempFilm = new Film(title,releaseDate,certificate,duration,genre,rate,metascore,description,null,null,voteCount,grossRevenue);
							s0 = new Star(line[10 + a].toString().toLowerCase().trim());
							s0.setFilms(new ArrayList<Film>());
							s0.getFilms().add(tempFilm);
							allStars.add(s0);
						}else {
							boolean flage = false;
							for(Film f : s.getFilms()) {
								if(f.getTitle().equalsIgnoreCase(title)) {
									flage = true;
									break;
								}
							}
							if(!flage) {
								Film tempFilm = new Film(title,releaseDate,certificate,duration,genre,rate,metascore,description,null,null,voteCount,grossRevenue);
								s.getFilms().add(tempFilm);
							}
							s0 = s;
						}
					}
					if(s0 != null) {stars.add(s0);}
				}
					
				
				
				Film film = new Film(title,releaseDate,certificate,duration,genre,rate,metascore,description,director,stars,voteCount,grossRevenue);			
				
				films.add(film);
				
				for (String item : line) {
				    System.out.print(item + "****");
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Director getDirector(ArrayList<Director> directors, String name) {
		for (Director d : directors) {
			if(d.getName().equalsIgnoreCase(name)) {
				return d;
			}
		}
		return null;
	}
	
	public Star getStar(ArrayList<Star> allStars, String name) {
		for (Star s : allStars) {
			if(s.getName().equalsIgnoreCase(name)) {
				return s;
			}
		}
		return null;
	}
    
    

	public static void main(String[] args) {
	
		ArrayList<Film> allFilms = new ArrayList<Film>();
		ReadCSV readFile = new ReadCSV();
		readFile.fetchFilms(allFilms);
		System.out.print("1");
	}
	
	
	
	


}
