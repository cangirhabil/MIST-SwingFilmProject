package swingPackage;

import java.io.File;
import java.util.Scanner;

public class readFile {

	public static void main(String[] args) {
		try {
			File filmFile = new File("IMDB top 1000.csv");
			Scanner sc = new Scanner(filmFile);  
			//sc.useDelimiter(",");	//delimiter
			while (sc.hasNext()) {
				String line = sc.nextLine();
				System.out.println(line);
			}
		}
		catch(Exception e) {
			
		}
	}

}
