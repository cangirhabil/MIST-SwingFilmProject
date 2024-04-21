package Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Film;

public class ReadFile {

	/*
	public static void main(String[] args) {
	
		ArrayList<Film> allFilms = new ArrayList<Film>();
		ReadFile readFile = new ReadFile();
		readFile.fetchFilms(allFilms);
	}*/
	
	
	
	

	
	public void fetchFilms(ArrayList<Film> films) {
		try {
			File filmFile = new File("/Users/admin/Desktop/4. Term/java project/MIST-SwingFilmProject/imdb_top_1000.csv");
			Scanner sc = new Scanner(filmFile); 
			String pass =sc.nextLine();
			//sc.useDelimiter(",");	//delimiter
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
				String director = line[9].toString().toLowerCase().trim();
				String[] stars = {
						line[10].toString().toLowerCase().trim(),
						line[11].toString().toLowerCase().trim(),
						line[12].toString().toLowerCase().trim(),
						line[13].toString().toLowerCase().trim(),};
				int voteCount =(line[14] != "") ?  Integer.parseInt(line[14].toString().toLowerCase().trim()): 0;
				int grossRevenue = 0;
				if(line.length == 16) {
					grossRevenue =Integer.parseInt(line[15].toString().toLowerCase().trim());
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

}
